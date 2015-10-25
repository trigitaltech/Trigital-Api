package com.trigital.cm.domain;

public class IPDetails {
	
	private String ip_Address;
	private String name;
	private String cmts_make;
	
	
	
	public IPDetails() {
		
	}

	public IPDetails(String ip_Address, String name, String cmts_make) {
		this.ip_Address = ip_Address;
		this.name = name;
		this.cmts_make = cmts_make;
	}
	
	public String getIp_Address() {
		return ip_Address;
	}
	public void setIp_Address(String ip_Address) {
		this.ip_Address = ip_Address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCmts_make() {
		return cmts_make;
	}
	public void setCmts_make(String cmts_make) {
		this.cmts_make = cmts_make;
	}
	
	
}
