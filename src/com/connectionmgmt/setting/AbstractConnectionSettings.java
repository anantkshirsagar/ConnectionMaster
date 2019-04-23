package com.connectionmgmt.setting;

import java.sql.Connection;

import com.connectionmgmt.util.AbstractProperty;

/**
 * 
 * @author ANANT
 *
 */
public abstract class AbstractConnectionSettings implements IConnectionSettings {
	protected AbstractProperty abstractProperty;
	protected Connection connection;
}
