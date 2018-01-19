package org.vigneshb.restaurants.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.vigneshb.restaurants.constants.SQLConstants;

public class Connectivity {

	public static Connection connect(Connection connection) throws SQLException {// connects to the database
		if(connection == null) {
		connection = DriverManager.getConnection(SQLConstants.CONNECTION_STRING, SQLConstants.USER_NAME, SQLConstants.PASSWORD);
		}
		return connection;
	}
	
	public static Connection close(Connection connection,ResultSet resultSet,PreparedStatement statement,PreparedStatement statement1) throws SQLException {// closes the database
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (statement1 != null) {
			statement1.close();
		}
		if (connection != null) {
			connection.close();
			connection = null;
		}
		return connection;
	}
}
