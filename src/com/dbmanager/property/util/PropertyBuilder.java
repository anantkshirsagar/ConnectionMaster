package com.dbmanager.property.util;

/**
 * 
 * @author ANANT
 *
 */
public class PropertyBuilder extends AbstractProperty {
	@Override
	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public void setDriverUrl(String driverUrl) {
		this.driverUrl = driverUrl;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	@Override
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	@Override
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public int getPort() {
		return this.port;
	}

	@Override
	public String getDriverUrl() {
		return this.driverUrl;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getJdbcUrl() {
		return this.jdbcUrl;
	}

	@Override
	public String getDatabaseName() {
		return this.databaseName;
	}

	@Override
	public String getHost() {
		return this.host;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropertyBuilder [port=").append(port).append(", driverUrl=").append(driverUrl)
				.append(", username=").append(username).append(", password=").append(password).append(", jdbcUrl=")
				.append(jdbcUrl).append(", host=").append(host).append(", databaseName=").append(databaseName)
				.append("]");
		return builder.toString();
	}
}
