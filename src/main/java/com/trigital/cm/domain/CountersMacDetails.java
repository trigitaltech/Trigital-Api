package com.trigital.cm.domain;

public class CountersMacDetails {
	
	private String mac_Address;
	private String us_packets;
	private String us_bytes;
	private String ds_packets;
	private String ds_bytes;
	
	public CountersMacDetails(String mac_Address, String us_packets,
			String us_bytes, String ds_packets, String ds_bytes) {
		super();
		this.mac_Address = mac_Address;
		this.us_packets = us_packets;
		this.us_bytes = us_bytes;
		this.ds_packets = ds_packets;
		this.ds_bytes = ds_bytes;
	}
	
	public String getMac_Address() {
		return mac_Address;
	}
	public void setMac_Address(String mac_Address) {
		this.mac_Address = mac_Address;
	}
	public String getUs_packets() {
		return us_packets;
	}
	public void setUs_packets(String us_packets) {
		this.us_packets = us_packets;
	}
	public String getUs_bytes() {
		return us_bytes;
	}
	public void setUs_bytes(String us_bytes) {
		this.us_bytes = us_bytes;
	}
	public String getDs_packets() {
		return ds_packets;
	}
	public void setDs_packets(String ds_packets) {
		this.ds_packets = ds_packets;
	}
	public String getDs_bytes() {
		return ds_bytes;
	}
	public void setDs_bytes(String ds_bytes) {
		this.ds_bytes = ds_bytes;
	}
	
	

}
