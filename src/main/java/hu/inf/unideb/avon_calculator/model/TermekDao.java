package hu.inf.unideb.avon_calculator.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A termékhez kapcsolódó adatbázisműveleteket tartalmazó osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class TermekDao {

	/**
	 * Egy rendeléshez tartozó termékek lekérdezését végzi az adatbázisból.
	 * 
	 * @param rendeles Rendelés
	 * @return Termék lista
	 */
	public List<Termek> lekerdezTermekekRendeleshez(Rendeles rendeles) {
		List<Termek> termekek = new ArrayList<>();
		String selectSQL = "SELECT * FROM TERMEK WHERE Rendeles_ID = ?";
		Connection dbKapcsolat = AdatbazisKezelo.getDbKapcsolat();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = dbKapcsolat.prepareStatement(selectSQL);
			preparedStatement.setInt(1, rendeles.getId());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int termekId = rs.getInt("Termek_ID");
				int cikkszam = rs.getInt("Cikkszam");
				String nev = rs.getString("Nev");
				int ar = rs.getInt("Ar");
				int darabszam = rs.getInt("Darabszam");
				int avonKedvezmeny = rs.getInt("Avon_kedvezmeny");
				Termek termek = new Termek(cikkszam, nev, ar, darabszam, avonKedvezmeny);
				termek.setId(termekId);
				termekek.add(termek);
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
		return termekek;
	}
	
	/**
	 * Egy rendeléshez kapcsolódó terméket adja hozzá az adatbázishoz.
	 * 
	 * @param termek Termék
	 * @param rendeles Rendelés
	 */
	public void hozzaAdTermeket(Termek termek, Rendeles rendeles){
		try {
			String tablaHozzaadas = "INSERT INTO termek(Cikkszam, Nev, Ar, Darabszam, Avon_kedvezmeny, Rendeles_ID) "
					+ "VALUES(?, ?, ?, ?, ?, ? );";
			Connection dbKapcsolat = AdatbazisKezelo.getDbKapcsolat();
			PreparedStatement preparedStatement = dbKapcsolat.prepareStatement(tablaHozzaadas);
			preparedStatement.setInt(1, termek.getCikkszam());
			preparedStatement.setString(2, termek.getNev());
			preparedStatement.setInt(3, termek.getAr());
			preparedStatement.setInt(4, termek.getDarabszam());
			preparedStatement.setInt(5, termek.getAvonKedvezmeny());
			preparedStatement.setInt(6, rendeles.getId());
			
			preparedStatement.executeUpdate();
			AdatbazisKezelo.lezarDbKapcsolat(dbKapcsolat);
			AdatbazisKezelo.lezarPreparedStatement(preparedStatement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
