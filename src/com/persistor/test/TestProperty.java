package com.persistor.test;

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
	}

	public static void main(String[] args) {

	}
}
