package com.bus.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BusConnection {

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bus", "postgres", "postgres");
	}

}
