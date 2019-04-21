package com.persistor.service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;

import com.persistor.mapper.AbstractMapper;
import com.persistor.setting.PropertySettings;

public class PersistanceService<T> extends AbstractPersistanceService<T> {
	public PersistanceService(PropertySettings propertySettings) {
		super(propertySettings);
	}

	@Override
	public void persist(AbstractMapper abstractMapper, Class<T> className) throws Exception {
		propertySettings.build();
		PreparedStatement ps = null;
		String sql = null;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(abstractMapper.getObject());
		oos.flush();
		oos.close();
		bos.close();

		byte[] object = bos.toByteArray();
		ps = propertySettings.getConnection().prepareStatement(abstractMapper.getQuery());
		ps.setObject(1, object);
		ps.executeUpdate();
		propertySettings.closeConnection();
	}

	@Override
	public void delete(AbstractMapper abstratMapper) throws Exception {

	}

	@Override
	public Object find(AbstractMapper abstratMapper) throws Exception {
		return null;
	}

	@Override
	public void update(AbstractMapper abstratMapper) throws Exception {

	}
}
