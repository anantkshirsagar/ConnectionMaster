package com.dbmanager.connection.setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.dbmanager.property.util.AbstractProperty;

/**
 * ConnectionSettings is used manage connection operations
 * 
 * @author Anant Kshirsagar
 *
 */
public class ConnectionSettings extends AbstractConnectionSettings {
	private Logger logger = Logger.getLogger(ConnectionSettings.class.getName());

	public ConnectionSettings(AbstractProperty abstractProperty) {
		this.abstractProperty = abstractProperty;
	}

	@Override
	public void build() throws ClassNotFoundException, SQLException {
		Class.forName(abstractProperty.getDriverUrl());
		connection = DriverManager.getConnection(abstractProperty.getJdbcUrl(), abstractProperty.getUsername(),
				abstractProperty.getPassword());
		logger.info("Connection build");
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Connection getConnection() {
		return this.connection;
	}

	@Override
	public void closeConnection() throws SQLException  {
		this.connection.close();
		logger.info("Connection closed");
	}
}
