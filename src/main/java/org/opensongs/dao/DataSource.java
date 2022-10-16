package org.opensongs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private String hostname;
	private String username;
	private String password;
	private String database;
	private String port;
	private Connection connection;
	
	public DataSource() {
		try {
			this.hostname="localhost";
			this.username="root";
			this.password="root";
			this.database="opensongsdb";
			this.port="3306";
			
			String URL="jdbc:mysql://"+this.hostname+":"+this.port+"/"+this.database;
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			this.connection=DriverManager.getConnection(URL,this.username,this.password);
			System.out.println("\n\tConectado ao banco de dados com sucesso!");
		}catch(SQLException e) {
			System.out.println("\n\tErro ao conectar -->"+e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}
