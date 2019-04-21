package com.persistor.setting;

import java.sql.Connection;

import com.persistor.util.AbstractProperty;

public abstract class AbstractPropertySettings {
	protected AbstractProperty abstractProperty;
	protected Connection connection;

	public abstract void setConnection(Connection connection);
	public abstract Connection getConnection();
	public abstract void closeConnection() throws Exception;
	public abstract void build() throws Exception;
}
