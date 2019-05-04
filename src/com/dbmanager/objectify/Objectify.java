package com.dbmanager.objectify;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Objectify is used to serialize and deserialize objects 
 * @author Anant Kshirsagar
 *
 */
public class Objectify {

	private static final Logger LOG = Logger.getLogger(Objectify.class.getName());

	/**
	 * This method takes object as input parameter and convert into byte[].
	 * @param object
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] serialize(Object object) throws IOException {
		if (!(object instanceof Serializable)) {
			throw new NotSerializableException(Object.class.getName());
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeObject(object);
		oos.flush();
		oos.close();
		bos.close();

		byte[] data = bos.toByteArray();
		LOG.info("Object serialized");
		return data;
	}

	/**
	 * 
	 * @param data
	 * @return Object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais;
		ObjectInputStream ins;
		Object object = null;
		bais = new ByteArrayInputStream(data);
		ins = new ObjectInputStream(bais);
		object = ins.readObject();
		ins.close();
		LOG.info("Object deserialized");
		return object;
	}
}
