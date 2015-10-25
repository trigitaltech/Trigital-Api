package com.trigital.cm.domain;

import java.util.List;

public class MACDetails {

	private String mac_Address;
	private IPDetails ipDetails;
	private String command;
	
	private DefaultMACDetails defaultMACDetails;
	private CPEMacDetails cpeMacDetails;
	private PHYMacDetails phyMacDetails;
	private List<QOSMacDetails> listofQosMacDetails;
	private WidebandMacDetails widebandMacDetails;
	private CountersMacDetails countersMacDetails;

	public MACDetails() {

	}


	public MACDetails(String mac_Address, IPDetails ipDetails, String command) {
		super();
		this.mac_Address = mac_Address;
		this.ipDetails = ipDetails;
		this.command = command;
	}



	public MACDetails(DefaultMACDetails defaultMACDetails,
			CPEMacDetails cpeMacDetails, PHYMacDetails phyMacDetails,
			List<QOSMacDetails> listofQosMacDetails,
			WidebandMacDetails widebandMacDetails,
			CountersMacDetails countersMacDetails) {
		super();
		this.defaultMACDetails = defaultMACDetails;
		this.cpeMacDetails = cpeMacDetails;
		this.phyMacDetails = phyMacDetails;
		this.listofQosMacDetails = listofQosMacDetails;
		this.widebandMacDetails = widebandMacDetails;
		this.countersMacDetails = countersMacDetails;
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

	public DefaultMACDetails getDefaultMACDetails() {
		return defaultMACDetails;
	}

	public void setDefaultMACDetails(DefaultMACDetails defaultMACDetails) {
		this.defaultMACDetails = defaultMACDetails;
	}

	public CPEMacDetails getCpeMacDetails() {
		return cpeMacDetails;
	}

	public void setCpeMacDetails(CPEMacDetails cpeMacDetails) {
		this.cpeMacDetails = cpeMacDetails;
	}

	public PHYMacDetails getPhyMacDetails() {
		return phyMacDetails;
	}

	public void setPhyMacDetails(PHYMacDetails phyMacDetails) {
		this.phyMacDetails = phyMacDetails;
	}

	public List<QOSMacDetails> getListofQosMacDetails() {
		return listofQosMacDetails;
	}

	public void setListofQosMacDetails(List<QOSMacDetails> listofQosMacDetails) {
		this.listofQosMacDetails = listofQosMacDetails;
	}

	public WidebandMacDetails getWidebandMacDetails() {
		return widebandMacDetails;
	}

	public void setWidebandMacDetails(WidebandMacDetails widebandMacDetails) {
		this.widebandMacDetails = widebandMacDetails;
	}

	public CountersMacDetails getCountersMacDetails() {
		return countersMacDetails;
	}

	public void setCountersMacDetails(CountersMacDetails countersMacDetails) {
		this.countersMacDetails = countersMacDetails;
	}

	
}
