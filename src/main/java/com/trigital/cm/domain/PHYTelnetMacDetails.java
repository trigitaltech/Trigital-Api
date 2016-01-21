package com.trigital.cm.domain;

public class PHYTelnetMacDetails {
	
	private String mac_Address;
	private String us_if;
	private String ds_if;
	private String sid;
	private String uspwr; 
	private String ussnr;
	private String microReflec;
	private String dspwr;
	private String dssnr;
	private String mode;
	
	
	public PHYTelnetMacDetails(String mac_Address, String us_if, String ds_if,
			String sid, String uspwr, String ussnr, String microReflec,
			String dspwr, String dssnr, String mode) {
		super();
		this.mac_Address = mac_Address;
		this.us_if = us_if;
		this.ds_if = ds_if;
		this.sid = sid;
		this.uspwr = uspwr;
		this.ussnr = ussnr;
		this.microReflec = microReflec;
		this.dspwr = dspwr;
		this.dssnr = dssnr;
		this.mode = mode;
	}
	
	
	public String getMac_Address() {
		return mac_Address;
	}
	public void setMac_Address(String mac_Address) {
		this.mac_Address = mac_Address;
	}
	public String getUs_if() {
		return us_if;
	}
	public void setUs_if(String us_if) {
		this.us_if = us_if;
	}
	public String getDs_if() {
		return ds_if;
	}
	public void setDs_if(String ds_if) {
		this.ds_if = ds_if;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getUspwr() {
		return uspwr;
	}
	public void setUspwr(String uspwr) {
		this.uspwr = uspwr;
	}
	public String getUssnr() {
		return ussnr;
	}
	public void setUssnr(String ussnr) {
		this.ussnr = ussnr;
	}
	public String getMicroReflec() {
		return microReflec;
	}
	public void setMicroReflec(String microReflec) {
		this.microReflec = microReflec;
	}
	public String getDspwr() {
		return dspwr;
	}
	public void setDspwr(String dspwr) {
		this.dspwr = dspwr;
	}
	public String getDssnr() {
		return dssnr;
	}
	public void setDssnr(String dssnr) {
		this.dssnr = dssnr;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	

}
