package com.dbmanager.connection.setting;

import java.sql.Connection;

/**
 * IConnectionSettings contains connection management methods.
 * 
 * @author ANANT
 *
 */
public interface IConnectionSettings {

	public abstract void setConnection(Connection connection);

	public abstract Connection getConnection();

	public abstract void closeConnection() throws Exception;

	/**
	 * This method is used to set connection properties and build connection
	 * @return void
	 * @throws Exception
	 * 
	 */
	public abstract void build() throws Exception;
}
