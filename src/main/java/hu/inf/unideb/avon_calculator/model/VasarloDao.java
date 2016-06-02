package hu.inf.unideb.avon_calculator.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A vásárlóhoz kapcsolódó adatbázisműveleteket tartalmazó osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class VasarloDao {

	/**
	 * Lekérdezi az adatbázisból a vásárlókat.
	 * 
	 * @return vasarlokat Vásárlókat tartalmazó lista {@link Vasarlo}
	 */
	public List<Vasarlo> lekerdezVasarlok() {
		List<Vasarlo> vasarlok = new ArrayList<>();
		String selectSQL = "SELECT * FROM VASARLO";
		Connection dbKapcsolat = AdatbazisKezelo.getDbKapcsolat();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = dbKapcsolat.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int vasarloId = rs.getInt("Vasarlo_ID");
				String vezetekNev = rs.getString("Vezetek_nev");
				String keresztNev = rs.getString("Kereszt_nev");
				String telefonszam = rs.getString("Telefon_szam");
				String email = rs.getString("E_mail");
				int vKedvezmeny = rs.getInt("Vasarlo_kedvezmeny");
				Vasarlo vasarlo = new Vasarlo(vezetekNev, keresztNev, telefonszam, email, vKedvezmeny);
				vasarlo.setId(vasarloId);
				vasarlok.add(vasarlo );
			}
			if(rs != null){
				AdatbazisKezelo.lezarResultSet(rs);
			}
			if(preparedStatement != null){
				AdatbazisKezelo.lezarPreparedStatement(preparedStatement);
			}
			if (dbKapcsolat != null) {
				dbKapcsolat.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vasarlok;
	}
	
	/**
	 * Hozzáad vásárlót az adatbázishoz.
	 * 
	 * @param vasarlo Vásárló {@link Vasarlo}
	 */
	public void hozzaAdVasarlot(Vasarlo vasarlo){
		try {
			String tablaHozzaadas = "INSERT INTO vasarlo(Vezetek_nev, Kereszt_nev, Telefon_szam, E_mail, Vasarlo_kedvezmeny) "
					+ "VALUES(?, ?, ?, ?, ? );";
			Connection dbKapcsolat = AdatbazisKezelo.getDbKapcsolat();
			PreparedStatement preparedStatement = dbKapcsolat.prepareStatement(tablaHozzaadas);
			preparedStatement.setString(1, vasarlo.getVezetekNev());
			preparedStatement.setString(2, vasarlo.getKeresztNev());
			preparedStatement.setString(3, vasarlo.getTelefonszam());
			preparedStatement.setString(4, vasarlo.getEmail());
			preparedStatement.setInt(5, vasarlo.getVasarloKedvezmeny());
			
			preparedStatement.executeUpdate();
			AdatbazisKezelo.lezarDbKapcsolat(dbKapcsolat);
			AdatbazisKezelo.lezarPreparedStatement(preparedStatement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
