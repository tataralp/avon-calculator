package hu.inf.unideb.avon_calculator.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class RendelesDao {

	public void hozzaAdRendelest(Rendeles rendeles) {
		try {
			String tablaHozzaadas = "INSERT INTO rendeles(kampany, vasarlo_ID, idopont) " + "VALUES(?, ?, ? );";
			Connection dbKapcsolat = AdatbazisKezelo.getDbKapcsolat();
			PreparedStatement preparedStatement = dbKapcsolat.prepareStatement(tablaHozzaadas,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, rendeles.getKampany());
			preparedStatement.setInt(2, rendeles.getVasarlo().getId());
			preparedStatement.setDate(3, Date.valueOf(rendeles.getIdopont()));
			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				rendeles.setId(generatedKeys.getInt(1));
			}

			for (Termek termek : rendeles.getVasarloiRendeles()) {
				TermekDao termekDao = new TermekDao();
				termekDao.hozzaAdTermeket(termek, rendeles);
			}
			AdatbazisKezelo.lezarDbKapcsolat(dbKapcsolat);
			AdatbazisKezelo.lezarPreparedStatement(preparedStatement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Rendeles> lekerdezRendelesek() {
		List<Rendeles> rendelesek = new ArrayList<>();
		String selectSQL = "SELECT * FROM RENDELES";
		Connection dbKapcsolat = AdatbazisKezelo.getDbKapcsolat();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = dbKapcsolat.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			VasarloDao vasarloDao = new VasarloDao();
			List<Vasarlo> vasarlok = new ArrayList<>();
			vasarlok.addAll(vasarloDao.lekerdezVasarlok());
			
			TermekDao termekDao = new TermekDao();
			
			while (rs.next()) {
				int rendelesId = rs.getInt("Rendeles_ID");
				String kampany = rs.getString("Kampany");
				int vasarloID = rs.getInt("Vasarlo_ID");
				
				Vasarlo vasarlom = getVasarlo(vasarlok, vasarloID);
				LocalDate idopont = rs.getDate("Idopont").toLocalDate();
				
				Rendeles rendeles = new Rendeles();
				rendeles.setKampany(kampany);
				rendeles.setVasarlo(vasarlom);
				rendeles.setId(rendelesId);
				rendeles.setIdopont(idopont);
				
				for (Termek termek : termekDao.lekerdezTermekekRendeleshez(rendeles)) {
					rendeles.addTermek(termek);
				}
				
				rendelesek.add(rendeles);
			}
			if (rs != null) {
				AdatbazisKezelo.lezarResultSet(rs);
			}
			if (preparedStatement != null) {
				AdatbazisKezelo.lezarPreparedStatement(preparedStatement);
			}
			if (dbKapcsolat != null) {
				dbKapcsolat.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rendelesek;
	}
	
	private Vasarlo getVasarlo(List<Vasarlo> vasarlok, int vasarloID){
		Vasarlo vasarlom = new Vasarlo();
		for (Vasarlo vasarlo : vasarlok) {
			if(vasarlo.getId() == vasarloID){
				vasarlom = vasarlo;
			}
		}
		return vasarlom;
	}

}
