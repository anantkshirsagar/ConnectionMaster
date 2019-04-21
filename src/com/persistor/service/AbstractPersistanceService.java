package com.persistor.service;

import com.persistor.setting.PropertySettings;

public abstract class AbstractPersistanceService<T> implements IDBManipulator<T> {
	protected PropertySettings propertySettings;

	public AbstractPersistanceService(PropertySettings propertySettings) {
		this.propertySettings = propertySettings;
	}
}
