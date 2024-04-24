package com.mlvn.crud_users.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {

	@SuppressWarnings("deprecation")
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/struts?autoReconnect=true&useSSL=false", "root", "Luong2001@");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
