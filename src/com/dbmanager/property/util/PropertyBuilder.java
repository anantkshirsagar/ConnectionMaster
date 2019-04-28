package com.dbmanager.property.util;

/**
 * 
 * @author ANANT
 *
 */
public class PropertyBuilder extends AbstractProperty {

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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropertyBuilder [driverUrl=").append(driverUrl).append(", username=").append(username)
				.append(", password=").append(password).append(", jdbcUrl=").append(jdbcUrl).append("]");
		return builder.toString();
	}
}
