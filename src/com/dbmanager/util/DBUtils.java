package com.dbmanager.util;

import java.io.File;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.dbmanager.connection.setting.AbstractConnectionSettings;
import com.dbmanager.connection.setting.ConnectionSettings;
import com.dbmanager.property.util.PropertyReader;

/**
 * This class is used for retrieving of meta data information of the database
 * 
 * @author Anant Kshirsagar
 *
 */
public final class DBUtils {
	private static final Logger LOG = Logger.getLogger(DBUtils.class.getName());
	private static PropertyReader propertyReader;
	private static AbstractConnectionSettings connectionSettings;

	private DBUtils() {
	}

	public static void setResource(String propertyFilePath) throws IOException {
		propertyReader = new PropertyReader(new File(propertyFilePath));
		connectionSettings = new ConnectionSettings(propertyReader.propertiesReader());
	}

	public static List<String> getDatabases() throws Exception {
		LOG.info("Loading catalogs...");
		connectionSettings.build();
		DatabaseMetaData metaData = connectionSettings.getConnection().getMetaData();
		if (metaData == null) {
			return null;
		}
		List<String> databaseList = new ArrayList<String>();
		ResultSet catalogs = metaData.getCatalogs();
		while (catalogs.next()) {
			String databaseName = catalogs.getString(1);
			if (databaseName != null) {
				databaseList.add(databaseName);
			}
		}
		connectionSettings.closeConnection();
		return databaseList;
	}

	public static List<String> getTables() throws Exception {
		LOG.info("Loading catalogs...");
		connectionSettings.build();
		List<String> tableNames = new ArrayList<String>();
		DatabaseMetaData metaData = connectionSettings.getConnection().getMetaData();
		if (metaData == null) {
			return null;
		}
		ResultSet resultSet = null;
		resultSet = metaData.getTables(null, null, null, new String[] { "TABLE" });

		while (resultSet.next()) {
			String tableName = resultSet.getString("TABLE_NAME");
			tableNames.add(tableName);
		}
		connectionSettings.closeConnection();
		return tableNames;
	}
}
