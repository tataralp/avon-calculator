package hu.inf.unideb.avon_calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdatbazisKezelo {

	private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
	private static final String DB_URL = "jdbc:hsqldb:mem:avon";

	static{
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getDbKapcsolat() {
		Connection dbKapcsolat = null;
		try {
			dbKapcsolat = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbKapcsolat;
	}
	
	public static void lezarDbKapcsolat(Connection dbKapcsolat) {
		try {
			dbKapcsolat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void lezarResultSet(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void lezarPreparedStatement(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
}
