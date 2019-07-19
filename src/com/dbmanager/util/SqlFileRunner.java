package com.dbmanager.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.dbmanager.connection.setting.AbstractConnectionSettings;
import com.dbmanager.connection.setting.ConnectionSettings;
import com.dbmanager.property.util.PropertyReader;
import com.ibatis.common.jdbc.ScriptRunner;

/**
 * This class is used to run the sql script file
 * 
 * @author Anant Kshirsagar
 *
 */
public class SqlFileRunner {
	private static final Logger LOG = Logger.getLogger(PropertyReader.class.getName());
	private final String sqlFileResource;
	private PropertyReader propertyReader;
	private AbstractConnectionSettings connectionSettings;

	public SqlFileRunner(String dbProperties, String sqlFileResource) throws IOException {
		LOG.info("Load and set sql properties");
		this.sqlFileResource = sqlFileResource;
		propertyReader = new PropertyReader(new File(dbProperties));
		connectionSettings = new ConnectionSettings(propertyReader.propertiesReader());

	}

	public void runScript() throws ClassNotFoundException, SQLException, IOException {
		LOG.info("Sql script running...");
		connectionSettings.build();
		ScriptRunner sr = new ScriptRunner(connectionSettings.getConnection(), false, false);
		Reader reader = new BufferedReader(new FileReader(this.sqlFileResource));
		sr.runScript(reader);
		connectionSettings.closeConnection();
		LOG.info("Script run success!");
	}
}
