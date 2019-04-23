package com.connectionmgmt.util;

/**
 * 
 * @author ANANT
 *
 */
public abstract class AbstractProperty implements IProperty{
	protected int port;
	protected String driverUrl;
	protected String username;
	protected String password;
	protected String jdbcUrl;
	protected String host;
	protected String databaseName;
}
