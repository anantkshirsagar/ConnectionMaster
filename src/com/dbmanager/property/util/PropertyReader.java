package com.dbmanager.property.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * PropertyReader reads database properties from .properties files
 * 
 * @author Anant Kshirsagar
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
		abstractProperty.setDriverUrl(properties.getProperty("db.driverURL"));
		abstractProperty.setUsername(properties.getProperty("db.username"));
		abstractProperty.setPassword(properties.getProperty("db.password"));
		abstractProperty.setJdbcUrl(properties.getProperty("db.jdbcURL"));
		LOG.info(abstractProperty.toString());
		return abstractProperty;
	}
}
