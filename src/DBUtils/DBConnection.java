package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection mainConnection = null;
	static boolean connected = false;

	public static void initConnection() {
		try {
			// Note: Change the connection parameters accordingly.
			String hostName = "codersmingle.cf8zay6x4oqw.us-west-2.rds.amazonaws.com";
			String dbName = "codersmingle";
			String userName = "root";
			String password = "codersmingle";
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			Connection conn = DriverManager.getConnection(connectionURL, userName, password);
			connected = true;
			DBConnection.mainConnection = conn;
		}
		catch(Exception e) {
			System.out.println("Exception when init_connection.");
		}
		return;
	}

	public static Connection getConnection() {
		return mainConnection;
	}
	
	public static boolean isConnected() {
		return connected;
	}
	
	public static void closeMainConnection() {
		try {
			mainConnection.close();
			mainConnection = null;
			connected = false;
		} 
		catch (Exception e) {
			//This shouldnt happen
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} 
		catch (Exception e) {
			// Do Nothiung
		}
	}
}
