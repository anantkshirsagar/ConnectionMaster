package com.dbmanager.property.util;

/**
 * 
 * @author Anant Kshirsagar
 *
 */
public interface IProperty {

	public abstract void setDriverUrl(String driverUrl);

	public abstract void setUsername(String username);

	public abstract void setPassword(String password);

	public abstract void setJdbcUrl(String jdbcUrl);

	public abstract String getDriverUrl();

	public abstract String getUsername();

	public abstract String getPassword();

	public abstract String getJdbcUrl();
}
