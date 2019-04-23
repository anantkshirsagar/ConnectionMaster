package com.connectionmgmt.util;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectUtils {
	public static Object objectify(Object object) {
		try {
			if(object instanceof Serializable) {
				
			}
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			oos.writeObject(object);
			oos.flush();
			oos.close();
			bos.close();

			byte[] data = bos.toByteArray();
			Object newObject = data;
		} catch (Exception e) {
			
		}
		return newObject;
	}
}
