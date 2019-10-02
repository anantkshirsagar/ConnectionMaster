package com.dbmanager.property.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
	private InputStream inputStream;
	private static final Logger LOG = Logger.getLogger(PropertyReader.class.getName());

	public PropertyReader(File file) {
		this.file = file;
	}

	public PropertyReader(InputStream inputStream) {
		this.inputStream = inputStream;
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

	/**
	 * This method is used to read properties from input stream
	 * 
	 * @return AbstractProperty
	 * @throws IOException
	 */
	public AbstractProperty readProperties() throws IOException {
		LOG.info("File inputstream reading...");
		AbstractProperty abstractProperty = new PropertyBuilder();
		Properties properties = new Properties();
		properties.load(this.inputStream);
		abstractProperty.setDriverUrl(properties.getProperty("db.driverURL"));
		abstractProperty.setUsername(properties.getProperty("db.username"));
		abstractProperty.setPassword(properties.getProperty("db.password"));
		abstractProperty.setJdbcUrl(properties.getProperty("db.jdbcURL"));
		LOG.info(abstractProperty.toString());
		return abstractProperty;
	}

}
