package com.persistor.service;

import com.persistor.mapper.AbstractMapper;

public interface IDBManipulator<T> {
	public abstract void persist(AbstractMapper abstractMapper, Class<T> className) throws Exception;
	public abstract void delete(AbstractMapper abstratMapper) throws Exception;
	public abstract Object find(AbstractMapper abstratMapper) throws Exception;
	public abstract void update(AbstractMapper abstratMapper) throws Exception;
}
