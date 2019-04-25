package com.connectionmgmt.test;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbmanager.connection.setting.AbstractConnectionSettings;
import com.dbmanager.connection.setting.ConnectionSettings;
import com.dbmanager.objectify.Objectify;
import com.dbmanager.property.util.AbstractProperty;
import com.dbmanager.property.util.PropertyReader;

public class DatabaseService {

	private static AbstractProperty property;
	private static AbstractConnectionSettings connectionSettings;

	static {
		PropertyReader propertyReader = new PropertyReader(new File("src\\com\\resources\\database.properties"));
		try {
			property = propertyReader.propertiesReader();
			connectionSettings = new ConnectionSettings(property);
		} catch (Exception e) {
			System.out.println(" Exception: " + e);
		}
	}

	public void save(Object object) throws Exception {
		// AbstractConnectionSettings propertySettings = new
		// ConnectionSettings(property);
		connectionSettings.build();
		String sql = "insert into javaobject (javaObject) values(?)";
		PreparedStatement prepareStatement = connectionSettings.getConnection().prepareStatement(sql);
		byte[] data = Objectify.serialize(object);
		prepareStatement.setObject(1, data);
		prepareStatement.execute();
		System.out.println("Object saved success");
		connectionSettings.closeConnection();
	}

	public Object find(int id) throws Exception {
		Object object = null;
		connectionSettings.build();
		String sql = "select * from javaobject where id=" + id + "";
		PreparedStatement prepareStatement = connectionSettings.getConnection().prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		if(rs.next()) {
			byte[] data = rs.getBytes("javaObject");
			object = Objectify.deserialize(data);
		}
		connectionSettings.closeConnection();
		System.out.println(" Object retreived");
		return object;
	}

	public static void main(String[] args) throws Exception {
		DatabaseService databaseService = new DatabaseService();
		Student student = new Student();
		student.setPercentage(90);
		student.setRollNo(101);
		student.setName("Anant Kshirsagar");
		
		databaseService.save(student);
		Student find = (Student)databaseService.find(3);
		System.out.println(find);
		
	}
}
