package com.persistor.mapper;

public abstract class AbstractMapper {
	protected int id;
	protected String query;
	protected Object object;

	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getQuery();

	public abstract void setQuery(String query);

	public abstract Object getObject();

	public abstract void setObject(Object object);
}
