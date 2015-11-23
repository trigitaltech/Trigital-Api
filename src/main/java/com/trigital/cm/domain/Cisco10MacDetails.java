package com.trigital.cm.domain;

import java.util.List;

public class Cisco10MacDetails {
	
	DefaultMACDetails defaultMACDetails;
	CPEMacDetails cpeMacDetails;
	List<QOSMacDetails> listOfQOSMacDetails;
	WidebandMacDetails widebandMacDetails;
	PHYMacDetails phyMacDetails;
	CountersMacDetails countersMacDetails;
	
	public Cisco10MacDetails(DefaultMACDetails defaultMACDetails,
			CPEMacDetails cpeMacDetails,
			List<QOSMacDetails> listOfQOSMacDetails,
			WidebandMacDetails widebandMacDetails, PHYMacDetails phyMacDetails,
			CountersMacDetails countersMacDetails) {
		super();
		this.defaultMACDetails = defaultMACDetails;
		this.cpeMacDetails = cpeMacDetails;
		this.listOfQOSMacDetails = listOfQOSMacDetails;
		this.widebandMacDetails = widebandMacDetails;
		this.phyMacDetails = phyMacDetails;
		this.countersMacDetails = countersMacDetails;
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

	public List<QOSMacDetails> getListOfQOSMacDetails() {
		return listOfQOSMacDetails;
	}

	public void setListOfQOSMacDetails(List<QOSMacDetails> listOfQOSMacDetails) {
		this.listOfQOSMacDetails = listOfQOSMacDetails;
	}

	public WidebandMacDetails getWidebandMacDetails() {
		return widebandMacDetails;
	}

	public void setWidebandMacDetails(WidebandMacDetails widebandMacDetails) {
		this.widebandMacDetails = widebandMacDetails;
	}

	public PHYMacDetails getPhyMacDetails() {
		return phyMacDetails;
	}

	public void setPhyMacDetails(PHYMacDetails phyMacDetails) {
		this.phyMacDetails = phyMacDetails;
	}

	public CountersMacDetails getCountersMacDetails() {
		return countersMacDetails;
	}

	public void setCountersMacDetails(CountersMacDetails countersMacDetails) {
		this.countersMacDetails = countersMacDetails;
	}
	
	

}
