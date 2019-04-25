package com.dbmanager.connection.setting;

import java.sql.Connection;

import com.dbmanager.property.util.AbstractProperty;

/**
 * 
 * @author ANANT
 *
 */
public abstract class AbstractConnectionSettings implements IConnectionSettings {
	protected AbstractProperty abstractProperty;
	protected Connection connection;
}
