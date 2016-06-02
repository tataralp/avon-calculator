package hu.inf.unideb.avon_calculator.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Az adatbázis kezelését végző osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class AdatbazisKezelo {

	/**
	 * Az adatbázis drivere. (Az adatbázis műveleteket ezen keresztül lehet
	 * elérni.)
	 */
	private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";

	/**
	 * Az adatbázis elérési útvonala.
	 */
//	private static final String DB_URL = "jdbc:hsqldb:mem:avon";
	private static final String DB_URL = "jdbc:hsqldb:file:avon.db";

	/**
	 * Statikus inicializáló blokk az adatbázis driverének betöltéséhez. (Az
	 * osztály első elérésekor lefut.)
	 */
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Az adatbázishoz való kapcsolódás, kapcsolat létrehozása.
	 * 
	 * @return Kapcsolat
	 */
	public static Connection getDbKapcsolat() {
		Connection dbKapcsolat = null;
		try {
			dbKapcsolat = DriverManager.getConnection(DB_URL, "SA", "");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbKapcsolat;
	}

	/**
	 * Az adatbázissal folyamatban lévő kapcsolat lezárása.
	 * 
	 * @param dbKapcsolat Kapcsolat
	 */
	public static void lezarDbKapcsolat(Connection dbKapcsolat) {
		try {
			dbKapcsolat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Ez resultset lezárása.
	 * 
	 * @param resultSet ResultSet
	 */
	public static void lezarResultSet(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * A preparedstatement lezárása.
	 * 
	 * @param preparedStatement PreparedStatement
	 */
	public static void lezarPreparedStatement(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
