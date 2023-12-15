package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		// DbConnection db= new DbConnection();
		// System.out.println(db.name);
		System.out.println(DbConnection.getDb());
		
	}
	
	public static Connection getDb() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("no connection");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			System.out.println("no driver");
			e.printStackTrace();
		}

		return conn;
	}
}
