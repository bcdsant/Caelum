package br.com.caelum.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/bcdsant", "bcdsant", "admin");
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}
