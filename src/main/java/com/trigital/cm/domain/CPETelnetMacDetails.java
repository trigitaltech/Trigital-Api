package com.trigital.cm.domain;

public class CPETelnetMacDetails {
	
	private String cpe_ip_Address;
	private String method;
	private String cpe_mac_Address;
	private String cm_ip_Address;
	private String cm_mac_Address;
	
	public CPETelnetMacDetails(String cpe_ip_Address, String method,
			String cpe_mac_Address, String cm_ip_Address, String cm_mac_Address) {
		
		this.cpe_ip_Address = cpe_ip_Address;
		this.method = method;
		this.cpe_mac_Address = cpe_mac_Address;
		this.cm_ip_Address = cm_ip_Address;
		this.cm_mac_Address = cm_mac_Address;
		
	}
	public String getCpe_ip_Address() {
		return cpe_ip_Address;
	}
	public void setCpe_ip_Address(String cpe_ip_Address) {
		this.cpe_ip_Address = cpe_ip_Address;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getCpe_mac_Address() {
		return cpe_mac_Address;
	}
	public void setCpe_mac_Address(String cpe_mac_Address) {
		this.cpe_mac_Address = cpe_mac_Address;
	}
	public String getCm_ip_Address() {
		return cm_ip_Address;
	}
	public void setCm_ip_Address(String cm_ip_Address) {
		this.cm_ip_Address = cm_ip_Address;
	}
	public String getCm_mac_Address() {
		return cm_mac_Address;
	}
	public void setCm_mac_Address(String cm_mac_Address) {
		this.cm_mac_Address = cm_mac_Address;
	}
	
	
}