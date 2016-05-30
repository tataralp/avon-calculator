package hu.inf.unideb.avon_calculator.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RendelesDao {

	public void hozzaAdRendelest(Rendeles rendeles) {
		try {
			String tablaHozzaadas = "INSERT INTO rendeles(kampany, vasarlo_ID, idopont) " + "VALUES(?, ?, ? );";
			Connection dbKapcsolat = AdatbazisKezelo.getDbKapcsolat();
			PreparedStatement preparedStatement = dbKapcsolat.prepareStatement(tablaHozzaadas, Statement.RETURN_GENERATED_KEYS);
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

//	 public List<Rendeles> lekerdezRendelesek() {
//	 List<Rendeles> rendeles = new ArrayList<>();
//	 String selectSQL = "SELECT * FROM RENDELES";
//	 Connection dbKapcsolat = AdatbazisKezelo.getDbKapcsolat();
//	 PreparedStatement preparedStatement = null;
//	 try {
//	 preparedStatement = dbKapcsolat.prepareStatement(selectSQL);
//	 ResultSet rs = preparedStatement.executeQuery();
//	 while (rs.next()) {
//	 int renelesId = rs.getInt("Rendeles_ID");
//	 String kampany = rs.getString("Kampany");
//	 Vasarlo vasarloID = rs.getString("Vasarlo_ID");
//	
//	 LocalDateTime idopont = rs.getString("Idopont");
//	 Rendeles rendeles = new Rendeles(kampany, vasarloID, idopont);
//	 rendeles.setId(rendelesId);
//	 rendeles.add(rendeles);
//	 }
//	 if(rs != null){
//	 AdatbazisKezelo.lezarResultSet(rs);
//	 }
//	 if(preparedStatement != null){
//	 AdatbazisKezelo.lezarPreparedStatement(preparedStatement);
//	 }
//	 if (dbKapcsolat != null) {
//	 dbKapcsolat.close();
//	 }
//	 } catch (SQLException e) {
//	 // TODO Auto-generated catch block
//	 e.printStackTrace();
//	 }
//	
//	 return rendeles;
//	 }

}
