package com.dbmanager.property.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * PropertyReader reads database properties from .properties files
 * 
 * @author ANANT
 *
 */
public class PropertyReader {
	private File file;
	private static final Logger LOG = Logger.getLogger(PropertyReader.class.getName());

	public PropertyReader(File file) {
		this.file = file;
	}

	/**
	 * This method is used to read database properties from .properties file
	 * 
	 * @return AbstractProperty
	 * @throws IOException
	 */
	public AbstractProperty propertiesReader() throws IOException {
		AbstractProperty abstractProperty = new PropertyBuilder();
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		LOG.info("Properties file loading...");
		abstractProperty.setPort(Integer.parseInt(properties.getProperty("db.port")));
		abstractProperty.setDriverUrl(properties.getProperty("db.driverURL"));
		abstractProperty.setHost(properties.getProperty("db.host"));
		abstractProperty.setUsername(properties.getProperty("db.username"));
		abstractProperty.setPassword(properties.getProperty("db.password"));
		abstractProperty.setDatabaseName(properties.getProperty("db.databaseName"));
		StringBuilder url = new StringBuilder(properties.getProperty("db.jdbcURL"));
		StringBuilder jdbcURL = url.append(abstractProperty.getHost()).append(":")
				.append(String.valueOf(abstractProperty.getPort())).append("/")
				.append(abstractProperty.getDatabaseName());
		abstractProperty.setJdbcUrl(jdbcURL.toString());
		LOG.info(abstractProperty.toString());
		return abstractProperty;
	}
}
