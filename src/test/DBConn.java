package test;
import java.sql.*;

public class DBConn {
	static final String DB_NAME = "test";
	static final String DB_PORT = "3306";
	static final String DB_HOST = "localhost";
	static final String DB_USERNAME = "root";
	static final String DB_PASSWORD = "onClipEvent";
	
	static final String CONN_STR = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
	
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.err.println("Unable to load MySQL JDBC driver");
		}
	}

	public static Connection get() throws SQLException {
		return DriverManager.getConnection(CONN_STR, DB_USERNAME, DB_PASSWORD);
	}
}
