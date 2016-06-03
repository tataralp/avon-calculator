package hu.inf.unideb.avoncalculator.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Az adatbázis kezelését végző osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class AdatbazisKezelo {

	/**
     * A naplózó példánya.
     */
	private final static Logger logger = LoggerFactory.getLogger(AdatbazisKezelo.class);
	
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
			logger.error("Adatbázis driver nem található! " +  e.getMessage());
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
			logger.error("Adatbázis kapcsolódási hiba! " +  e.getMessage());
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
			logger.error("Adatbázis lezárási hiba! " +  e.getMessage());
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
			logger.error("Resultset lezárási hiba! " +  e.getMessage());
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
			logger.error("Preparedstatement lezárási hiba! " +  e.getMessage());
		}
	}

}
