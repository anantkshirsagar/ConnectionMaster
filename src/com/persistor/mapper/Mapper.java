package com.persistor.mapper;

public class Mapper extends AbstractMapper{
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getQuery() {
		return this.query;
	}

	@Override
	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public Object getObject() {
		return this.object;
	}

	@Override
	public void setObject(Object object) {
		this.object = object;
	}
}
