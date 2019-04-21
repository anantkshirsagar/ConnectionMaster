package com.persistor.setting;

import java.sql.Connection;
import java.sql.DriverManager;

import com.persistor.util.AbstractProperty;

public class PropertySettings extends AbstractPropertySettings {

	public PropertySettings(AbstractProperty abstractProperty) {
		this.abstractProperty = abstractProperty;
	}

	@Override
	public void build() throws Exception {
		Class.forName(abstractProperty.getDriverUrl());
		connection = DriverManager.getConnection(abstractProperty.getJdbcUrl(), abstractProperty.getUsername(),
				abstractProperty.getPassword());
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
	public void closeConnection() throws Exception {
		this.connection.close();
	}
}
