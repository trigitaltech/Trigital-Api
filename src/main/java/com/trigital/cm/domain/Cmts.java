package com.trigital.cm.domain;

public class Cmts {
	
	private String name;
	private String ipAddress;
	private String make;
	
	
	public Cmts(String name, String ipAddress, String make) {
		super();
		this.name = name;
		this.ipAddress = ipAddress;
		this.make = make;
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
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	
	
	

}
