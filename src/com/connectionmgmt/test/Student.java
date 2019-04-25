package com.connectionmgmt.test;

import java.io.Serializable;

public class Student implements Serializable{
	private int rollNo;
	private String name;
	private float percentage;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	public String toString() {
		return " Roll No: " +rollNo+ " Name: " +name+ " Percentage:" +percentage;
	}
}
