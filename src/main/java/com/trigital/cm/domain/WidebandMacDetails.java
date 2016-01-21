package com.trigital.cm.domain;

public class WidebandMacDetails {
	
	private String mac_Address;
	private String ip_Address;
	private String I_F;
	private String mac_State;
	private String dSxUS;
	private String primary_wb;
	
	public WidebandMacDetails(String mac_Address, String ip_Address,
			String i_F, String mac_State, String dSxUS, String primary_wb) {
		super();
		this.mac_Address = mac_Address;
		this.ip_Address = ip_Address;
		I_F = i_F;
		this.mac_State = mac_State;
		this.dSxUS = dSxUS;
		this.primary_wb = primary_wb;
	}

	public String getMac_Address() {
		return mac_Address;
	}

	public void setMac_Address(String mac_Address) {
		this.mac_Address = mac_Address;
	}

	public String getIp_Address() {
		return ip_Address;
	}

	public void setIp_Address(String ip_Address) {
		this.ip_Address = ip_Address;
	}

	public String getI_F() {
		return I_F;
	}

	public void setI_F(String i_F) {
		I_F = i_F;
	}

	public String getMac_State() {
		return mac_State;
	}

	public void setMac_State(String mac_State) {
		this.mac_State = mac_State;
	}

	public String getdSxUS() {
		return dSxUS;
	}

	public void setdSxUS(String dSxUS) {
		this.dSxUS = dSxUS;
	}

	public String getPrimary_wb() {
		return primary_wb;
	}

	public void setPrimary_wb(String primary_wb) {
		this.primary_wb = primary_wb;
	}
	
	
}
