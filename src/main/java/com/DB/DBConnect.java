package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection con;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/User";

			con = DriverManager.getConnection(url, "root", "PFH#23kgrw9");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
