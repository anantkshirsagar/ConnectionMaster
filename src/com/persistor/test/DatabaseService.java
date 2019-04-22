package com.persistor.test;

import java.io.File;

import com.persistor.setting.PropertySettings;
import com.persistor.util.AbstractProperty;
import com.persistor.util.PropertyReader;

public class DatabaseService {
	
	private static AbstractProperty property;
	
	static {
		PropertyReader propertyReader = new PropertyReader(new File("src\\com\\resources\\database.properties"));
		try {
			property = propertyReader.propertiesReader();
		} catch (Exception e) {
			System.out.println(" Exception: " +e);
		}
	}

	public void save() throws Exception {
		PropertySettings propertySettings = new PropertySettings(property);
		propertySettings.build();
		propertySettings.getConnection();
		propertySettings.closeConnection();
	}
	
	public static void main(String[] args) {
		System.out.println(property);
	}
}
