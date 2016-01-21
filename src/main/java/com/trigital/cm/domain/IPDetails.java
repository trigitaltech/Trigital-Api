package com.trigital.cm.domain;

public class IPDetails {
	
	private String ipAddress;
	private String name;
	private String model;
	
	
	
	public IPDetails() {
		
	}


	

	public IPDetails(String ipAddress, String name, String model) {
		super();
		this.ipAddress = ipAddress;
		this.name = name;
		this.model = model;
	}




	public String getIpAddress() {
		return ipAddress;
	}



	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}

	
	
}
