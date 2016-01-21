package com.trigital.cm.domain;

public class PHYMacDetails {
	
	private String mac_Address;
	private String I_F;
	private String sid;
	private String uspwr; 
	private String usmer;
	private String timing_offset;
	private String dspwr;
	private String dsmer;
	private String mode;
	private String docsis;
	
	public PHYMacDetails(String mac_Address, String i_F, String sid,
			String uspwr, String usmer, String timing_offset, String dspwr,
			String dsmer, String mode, String docsis) {
		super();
		this.mac_Address = mac_Address;
		I_F = i_F;
		this.sid = sid;
		this.uspwr = uspwr;
		this.usmer = usmer;
		this.timing_offset = timing_offset;
		this.dspwr = dspwr;
		this.dsmer = dsmer;
		this.mode = mode;
		this.docsis = docsis;
	}

	public String getMac_Address() {
		return mac_Address;
	}

	public void setMac_Address(String mac_Address) {
		this.mac_Address = mac_Address;
	}

	public String getI_F() {
		return I_F;
	}

	public void setI_F(String i_F) {
		I_F = i_F;
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

	public String getUsmer() {
		return usmer;
	}

	public void setUsmer(String usmer) {
		this.usmer = usmer;
	}

	public String getTiming_offset() {
		return timing_offset;
	}

	public void setTiming_offset(String timing_offset) {
		this.timing_offset = timing_offset;
	}

	public String getDspwr() {
		return dspwr;
	}

	public void setDspwr(String dspwr) {
		this.dspwr = dspwr;
	}

	public String getDsmer() {
		return dsmer;
	}

	public void setDsmer(String dsmer) {
		this.dsmer = dsmer;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getDocsis() {
		return docsis;
	}

	public void setDocsis(String docsis) {
		this.docsis = docsis;
	}

}
