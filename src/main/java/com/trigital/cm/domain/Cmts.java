package com.trigital.cm.domain;

public class Cmts {
	
	private String name;
	private String ipAddress;
	private String model;
	
	
	public Cmts(String name, String ipAddress, String model) {
		super();
		this.name = name;
		this.ipAddress = ipAddress;
		this.model = model;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
