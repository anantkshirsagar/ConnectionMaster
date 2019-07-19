package com.dbmanager.connection.setting;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * IConnectionSettings contains connection management methods.
 * 
 * @author Anant Kshirsagar
 *
 */
public interface IConnectionSettings {

	public abstract void setConnection(Connection connection);

	public abstract Connection getConnection();

	public abstract void closeConnection() throws SQLException;

	/**
	 * This method is used to set connection properties and build connection
	 * @return void
	 * @throws Exception
	 * 
	 */
	public abstract void build() throws ClassNotFoundException, SQLException;
}
