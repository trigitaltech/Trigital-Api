package com.trigital.cm.domain;

import java.util.List;

public class MACDetails {

	private String mac_Address;
	private IPDetails ipDetails;
	private String command;
	private Cisco10MacDetails cisco10MacDetails;
	private CasaMacDetails casaMacDetails;

	/*
	 * private DefaultMACDetails defaultMACDetails; private CPEMacDetails
	 * cpeMacDetails; private PHYMacDetails phyMacDetails; private
	 * List<QOSMacDetails> listofQosMacDetails; private WidebandMacDetails
	 * widebandMacDetails; private CountersMacDetails countersMacDetails;
	 * 
	 * private DefaultTelnetMACDetails defaultTelnetMACDetails; private
	 * CPETelnetMacDetails cpeTelnetMacDetails; private PHYTelnetMacDetails
	 * phyTelnetMacDetails; private List<QOSMacDetails>
	 * listofTelnetQosMacDetails; //private WidebandMacDetails
	 * widebandMacDetails; private CountersMacDetails countersTelnetMacDetails;
	 */

	public MACDetails() {

	}

	public MACDetails(String mac_Address, IPDetails ipDetails, String command,
			Cisco10MacDetails cisco10MacDetails, CasaMacDetails casaMacDetails) {
		super();
		this.mac_Address = mac_Address;
		this.ipDetails = ipDetails;
		this.command = command;
		this.cisco10MacDetails = cisco10MacDetails;
		this.casaMacDetails = casaMacDetails;
	}

	public MACDetails(String mac_Address, IPDetails ipDetails, String command) {
		super();
		this.mac_Address = mac_Address;
		this.ipDetails = ipDetails;
		this.command = command;
	}

	public String getMac_Address() {
		return mac_Address;
	}

	public void setMac_Address(String mac_Address) {
		this.mac_Address = mac_Address;
	}

	public IPDetails getIpDetails() {
		return ipDetails;
	}

	public void setIpDetails(IPDetails ipDetails) {
		this.ipDetails = ipDetails;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Cisco10MacDetails getCisco10MacDetails() {
		return cisco10MacDetails;
	}

	public void setCisco10MacDetails(Cisco10MacDetails cisco10MacDetails) {
		this.cisco10MacDetails = cisco10MacDetails;
	}

	public CasaMacDetails getCasaMacDetails() {
		return casaMacDetails;
	}

	public void setCasaMacDetails(CasaMacDetails casaMacDetails) {
		this.casaMacDetails = casaMacDetails;
	}
	
	

	/*
	 * public MACDetails(String mac_Address, IPDetails ipDetails, String
	 * command) { super(); this.mac_Address = mac_Address; this.ipDetails =
	 * ipDetails; this.command = command; }
	 * 
	 * 
	 * 
	 * public MACDetails(DefaultMACDetails defaultMACDetails, CPEMacDetails
	 * cpeMacDetails, PHYMacDetails phyMacDetails, List<QOSMacDetails>
	 * listofQosMacDetails, WidebandMacDetails widebandMacDetails,
	 * CountersMacDetails countersMacDetails) { super(); this.defaultMACDetails
	 * = defaultMACDetails; this.cpeMacDetails = cpeMacDetails;
	 * this.phyMacDetails = phyMacDetails; this.listofQosMacDetails =
	 * listofQosMacDetails; this.widebandMacDetails = widebandMacDetails;
	 * this.countersMacDetails = countersMacDetails; }
	 * 
	 * public String getMac_Address() { return mac_Address; }
	 * 
	 * public void setMac_Address(String mac_Address) { this.mac_Address =
	 * mac_Address; }
	 * 
	 * 
	 * public IPDetails getIpDetails() { return ipDetails; }
	 * 
	 * 
	 * public void setIpDetails(IPDetails ipDetails) { this.ipDetails =
	 * ipDetails; }
	 * 
	 * 
	 * 
	 * public String getCommand() { return command; }
	 * 
	 * public void setCommand(String command) { this.command = command; }
	 * 
	 * public DefaultMACDetails getDefaultMACDetails() { return
	 * defaultMACDetails; }
	 * 
	 * public void setDefaultMACDetails(DefaultMACDetails defaultMACDetails) {
	 * this.defaultMACDetails = defaultMACDetails; }
	 * 
	 * public CPEMacDetails getCpeMacDetails() { return cpeMacDetails; }
	 * 
	 * public void setCpeMacDetails(CPEMacDetails cpeMacDetails) {
	 * this.cpeMacDetails = cpeMacDetails; }
	 * 
	 * public PHYMacDetails getPhyMacDetails() { return phyMacDetails; }
	 * 
	 * public void setPhyMacDetails(PHYMacDetails phyMacDetails) {
	 * this.phyMacDetails = phyMacDetails; }
	 * 
	 * public List<QOSMacDetails> getListofQosMacDetails() { return
	 * listofQosMacDetails; }
	 * 
	 * public void setListofQosMacDetails(List<QOSMacDetails>
	 * listofQosMacDetails) { this.listofQosMacDetails = listofQosMacDetails; }
	 * 
	 * public WidebandMacDetails getWidebandMacDetails() { return
	 * widebandMacDetails; }
	 * 
	 * public void setWidebandMacDetails(WidebandMacDetails widebandMacDetails)
	 * { this.widebandMacDetails = widebandMacDetails; }
	 * 
	 * public CountersMacDetails getCountersMacDetails() { return
	 * countersMacDetails; }
	 * 
	 * public void setCountersMacDetails(CountersMacDetails countersMacDetails)
	 * { this.countersMacDetails = countersMacDetails; }
	 * 
	 * 
	 * public DefaultTelnetMACDetails getDefaultTelnetMACDetails() { return
	 * defaultTelnetMACDetails; }
	 * 
	 * 
	 * public void setDefaultTelnetMACDetails( DefaultTelnetMACDetails
	 * defaultTelnetMACDetails) { this.defaultTelnetMACDetails =
	 * defaultTelnetMACDetails; }
	 * 
	 * 
	 * public CPETelnetMacDetails getCpeTelnetMacDetails() { return
	 * cpeTelnetMacDetails; }
	 * 
	 * 
	 * public void setCpeTelnetMacDetails(CPETelnetMacDetails
	 * cpeTelnetMacDetails) { this.cpeTelnetMacDetails = cpeTelnetMacDetails; }
	 * 
	 * 
	 * public PHYTelnetMacDetails getPhyTelnetMacDetails() { return
	 * phyTelnetMacDetails; }
	 * 
	 * 
	 * public void setPhyTelnetMacDetails(PHYTelnetMacDetails
	 * phyTelnetMacDetails) { this.phyTelnetMacDetails = phyTelnetMacDetails; }
	 * 
	 * 
	 * public List<QOSMacDetails> getListofTelnetQosMacDetails() { return
	 * listofTelnetQosMacDetails; }
	 * 
	 * 
	 * public void setListofTelnetQosMacDetails( List<QOSMacDetails>
	 * listofTelnetQosMacDetails) { this.listofTelnetQosMacDetails =
	 * listofTelnetQosMacDetails; }
	 * 
	 * 
	 * public CountersMacDetails getCountersTelnetMacDetails() { return
	 * countersTelnetMacDetails; }
	 * 
	 * 
	 * public void setCountersTelnetMacDetails( CountersMacDetails
	 * countersTelnetMacDetails) { this.countersTelnetMacDetails =
	 * countersTelnetMacDetails; }
	 */

}
