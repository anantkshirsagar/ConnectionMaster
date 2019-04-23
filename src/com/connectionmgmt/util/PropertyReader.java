package com.connectionmgmt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 
 * @author ANANT
 *
 */
public class PropertyReader {
	private File file;
	private Logger logger = Logger.getLogger(PropertyReader.class.getName());

	public PropertyReader(File file) {
		this.file = file;
	}

	public AbstractProperty propertiesReader() throws IOException {
		AbstractProperty abstractProperty = new PropertyBuilder();
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		logger.info("Properties file loading...");
		abstractProperty.setPort(Integer.parseInt(properties.getProperty("db.port")));
		abstractProperty.setDriverUrl(properties.getProperty("db.driverURL"));
		abstractProperty.setHost(properties.getProperty("db.host"));
		abstractProperty.setUsername(properties.getProperty("db.username"));
		abstractProperty.setPassword(properties.getProperty("db.password"));
		abstractProperty.setDatabaseName(properties.getProperty("db.databaseName"));
		String jdbcURL = properties.getProperty("db.jdbcURL").concat(abstractProperty.getHost()).concat(":")
				.concat(String.valueOf(abstractProperty.getPort())).concat(abstractProperty.getDatabaseName());
		abstractProperty.setJdbcUrl(jdbcURL);
		logger.info(abstractProperty.toString());
		return abstractProperty;
	}
}
