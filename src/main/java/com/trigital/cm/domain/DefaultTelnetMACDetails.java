package com.trigital.cm.domain;

public class DefaultTelnetMACDetails {

	private String mac_Address;
	private String ip_Address;
	private String us_intf;
	private String ds_intf;
	private String mac_status;
	private String prim_Sid;
	private String rxpwr;
	private String timing_Offset;
	private String num_CPE;
	private String DIP;
	private String bpi_enb;
	
	public DefaultTelnetMACDetails() {

	}
	
	
	
	
	public DefaultTelnetMACDetails(String mac_Address, String ip_Address,
			String us_intf, String ds_intf, String mac_status, String prim_Sid,
			String rxpwr, String timing_Offset, String num_CPE, String dIP,
			String bpi_enb) {
		
		this.mac_Address = mac_Address;
		this.ip_Address = ip_Address;
		this.us_intf = us_intf;
		this.ds_intf = ds_intf;
		this.mac_status = mac_status;
		this.prim_Sid = prim_Sid;
		this.rxpwr = rxpwr;
		this.timing_Offset = timing_Offset;
		this.num_CPE = num_CPE;
		this.DIP = dIP;
		this.bpi_enb = bpi_enb;
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

	public String getUs_intf() {
		return us_intf;
	}

	public void setUs_intf(String us_intf) {
		this.us_intf = us_intf;
	}

	public String getDs_intf() {
		return ds_intf;
	}

	public void setDs_intf(String ds_intf) {
		this.ds_intf = ds_intf;
	}

	public String getMac_status() {
		return mac_status;
	}

	public void setMac_status(String mac_status) {
		this.mac_status = mac_status;
	}

	public String getPrim_Sid() {
		return prim_Sid;
	}

	public void setPrim_Sid(String prim_Sid) {
		this.prim_Sid = prim_Sid;
	}

	public String getRxpwr() {
		return rxpwr;
	}

	public void setRxpwr(String rxpwr) {
		this.rxpwr = rxpwr;
	}

	public String getTiming_Offset() {
		return timing_Offset;
	}

	public void setTiming_Offset(String timing_Offset) {
		this.timing_Offset = timing_Offset;
	}

	public String getNum_CPE() {
		return num_CPE;
	}

	public void setNum_CPE(String num_CPE) {
		this.num_CPE = num_CPE;
	}

	public String getDIP() {
		return DIP;
	}

	public void setDIP(String dIP) {
		DIP = dIP;
	}

	public String getBpi_enb() {
		return bpi_enb;
	}

	public void setBpi_enb(String bpi_enb) {
		this.bpi_enb = bpi_enb;
	}
	
}
