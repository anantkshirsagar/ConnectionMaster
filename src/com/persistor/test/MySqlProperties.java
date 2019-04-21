package com.persistor.test;

public interface MySqlProperties {
	public int PORT = 3306;
	public String DRIVER_URL = "com.mysql.jdbc.Driver";
	public String USERNAME = "root";
	public String PASSWORD = "root";
	public String HOST = "localhost";
	public String DATABASE_NAME = "storeobjectdb";
	public String JDBC_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;
}
