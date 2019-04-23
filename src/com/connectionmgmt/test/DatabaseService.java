package com.connectionmgmt.test;

import java.io.File;

import com.connectionmgmt.setting.AbstractConnectionSettings;
import com.connectionmgmt.setting.ConnectionSettings;
import com.connectionmgmt.util.AbstractProperty;
import com.connectionmgmt.util.PropertyReader;

public class DatabaseService {

	private static AbstractProperty property;

	static {
		PropertyReader propertyReader = new PropertyReader(new File("src\\com\\resources\\database.properties"));
		try {
			property = propertyReader.propertiesReader();
		} catch (Exception e) {
			System.out.println(" Exception: " + e);
		}
	}

	public void save() throws Exception {
		AbstractConnectionSettings propertySettings = new ConnectionSettings(property);
		propertySettings.build();
		propertySettings.getConnection();
		propertySettings.closeConnection();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(property);
	}
}
