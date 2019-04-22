package com.persistor.test;

import java.sql.Connection;
import java.sql.Statement;

import com.persistor.setting.PropertySettings;
import com.persistor.util.AbstractProperty;
import com.persistor.util.PropertyBuilder;

public class TestProperty {
	private static AbstractProperty property = null;
	static {
		property = new PropertyBuilder();
		property.setDatabaseName(MySqlProperties.DATABASE_NAME);
		property.setDriverUrl(MySqlProperties.DRIVER_URL);
		property.setPort(MySqlProperties.PORT);
		property.setUsername(MySqlProperties.USERNAME);
		property.setPassword(MySqlProperties.PASSWORD);
		property.setJdbcUrl(MySqlProperties.JDBC_URL);
		
		PropertySettings propertySettings = new PropertySettings(property);
		try {
			propertySettings.build();
			Statement stmt = propertySettings.getConnection().createStatement();
			stmt.executeQuery("");
			propertySettings.closeConnection();
		} catch (Exception e) {
			System.out.println(" Exception: " +e);
		}
	}

	public static void main(String[] args) {
		
	}
}
