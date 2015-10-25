package com.trigital.cm.domain;

public class CPEMacDetails {
	
	private String ip_Address;
	private String mac_Address;
	private String dual_ip;
	private String device_Class;
	
	public CPEMacDetails(String ip_Address, String mac_Address, String dual_ip,String device_Class) {
		
		this.ip_Address = ip_Address;
		this.mac_Address = mac_Address;
		this.dual_ip = dual_ip;
		this.device_Class = device_Class;
	}
	
	public String getIp_Address() {
		return ip_Address;
	}
	public void setIp_Address(String ip_Address) {
		this.ip_Address = ip_Address;
	}
	public String getMac_Address() {
		return mac_Address;
	}
	public void setMac_Address(String mac_Address) {
		this.mac_Address = mac_Address;
	}
	public String getDual_ip() {
		return dual_ip;
	}
	public void setDual_ip(String dual_ip) {
		this.dual_ip = dual_ip;
	}
	public String getDevice_Class() {
		return device_Class;
	}
	public void setDevice_Class(String device_Class) {
		this.device_Class = device_Class;
	}
}