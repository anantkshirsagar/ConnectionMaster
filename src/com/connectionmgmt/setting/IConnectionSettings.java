package com.connectionmgmt.setting;

import java.sql.Connection;

/**
 * 
 * @author ANANT
 *
 */
public interface IConnectionSettings {

	public abstract void setConnection(Connection connection);

	public abstract Connection getConnection();

	public abstract void closeConnection() throws Exception;

	public abstract void build() throws Exception;
}
