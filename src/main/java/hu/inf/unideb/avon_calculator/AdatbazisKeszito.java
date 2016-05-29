package hu.inf.unideb.avon_calculator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdatbazisKeszito {

	public static void adatbazisKeszites() {
		Connection dbKapcsolat = null;

		String createTableVasarloSQL = "CREATE TABLE vasarlo" + "("
				+ "Vasarlo_ID int NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1),"
				+ "Vezetek_nev varchar(255)," + "Kereszt_nev varchar(255)," + "Telefon_szam varchar(255),"
				+ "E_mail varchar(255)," + "Vasarlo_kedvezmeny int," + "PRIMARY KEY (Vasarlo_ID)" + ")";
		String createTableRendelesSQL = "CREATE TABLE rendeles" + "("
				+ "Rendeles_ID int NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1)," + "Kampany varchar(255),"
				+ "Vasarlo_ID int," + "Idopont date," + "PRIMARY KEY (Rendeles_ID),"
				+ "FOREIGN KEY (Vasarlo_ID) REFERENCES vasarlo (Vasarlo_ID)" + ")";
		String createTableTermekSQL = "CREATE TABLE termek" + "("
				+ "Termek_ID int NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1)," + "Cikkszam int,"
				+ "Nev varchar(255)," + "Ar int," + "Darabszam int," + "Avon_kedvezmeny int," + "Rendeles_ID int,"
				+ "PRIMARY KEY (Termek_ID)," + "FOREIGN KEY (Rendeles_ID) REFERENCES rendeles (Rendeles_ID)" + ")";
		String insertVasarloSQL = "INSERT INTO vasarlo(Vezetek_nev, Kereszt_nev, Telefon_szam, E_mail, Vasarlo_kedvezmeny) "
				+ "VALUES('Tatár', 'Zsu', '70es', 'susanlpfan', 25 );";
		try {
			dbKapcsolat = AdatbazisKezelo.getDbKapcsolat();
			sqlFuttato(dbKapcsolat, createTableVasarloSQL);
			sqlFuttato(dbKapcsolat, createTableRendelesSQL);
			sqlFuttato(dbKapcsolat, createTableTermekSQL);
			sqlFuttato(dbKapcsolat, insertVasarloSQL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (dbKapcsolat != null) {
				AdatbazisKezelo.lezarDbKapcsolat(dbKapcsolat);
			}
		}
	}
	
	private static void sqlFuttato(Connection dbKapcsolat, String createTableVasarloSQL) throws SQLException {
		PreparedStatement preparedStatement;
		// előkészíti az sql-t
		preparedStatement = dbKapcsolat.prepareStatement(createTableVasarloSQL);
		System.out.println(createTableVasarloSQL);
		// lefuttatja az sql-t
		preparedStatement.executeUpdate();
		System.out.println("Tábla kész!");
		AdatbazisKezelo.lezarPreparedStatement(preparedStatement);
	}
	
}
