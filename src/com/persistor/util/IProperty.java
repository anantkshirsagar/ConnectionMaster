package com.persistor.util;

public interface IProperty {
	public abstract void setPort(int port);
	public abstract void setDriverUrl(String driverUrl);
	public abstract void setUsername(String username);
	public abstract void setPassword(String password);
	public abstract void setJdbcUrl(String jdbcUrl);
	public abstract void setDatabaseName(String databaseName);
	public abstract void setHost(String host);
	
	public abstract int getPort();
	public abstract String getDriverUrl();
	public abstract String getUsername();
	public abstract String getPassword();
	public abstract String getJdbcUrl();
	public abstract String getDatabaseName();
	public abstract String getHost();
}
