package com.trigital.cm.domain;

import java.util.List;

public class CasaMacDetails {
	
	DefaultTelnetMACDetails defaultTelnetMACDetails;
	
	CPETelnetMacDetails cpeTelnetMacDetails;
	
	List<QOSMacDetails> listOfQOSTelnetMacDetails;
	
	PHYTelnetMacDetails phyTelnetMacDetails;
	
	CountersMacDetails countersTelnetMacDetails;

	public CasaMacDetails(DefaultTelnetMACDetails defaultTelnetMACDetails,
			CPETelnetMacDetails cpeTelnetMacDetails,
			List<QOSMacDetails> listOfQOSTelnetMacDetails,
			PHYTelnetMacDetails phyTelnetMacDetails,
			CountersMacDetails countersTelnetMacDetails) {
		super();
		this.defaultTelnetMACDetails = defaultTelnetMACDetails;
		this.cpeTelnetMacDetails = cpeTelnetMacDetails;
		this.listOfQOSTelnetMacDetails = listOfQOSTelnetMacDetails;
		this.phyTelnetMacDetails = phyTelnetMacDetails;
		this.countersTelnetMacDetails = countersTelnetMacDetails;
	}

	public DefaultTelnetMACDetails getDefaultTelnetMACDetails() {
		return defaultTelnetMACDetails;
	}

	public void setDefaultTelnetMACDetails(
			DefaultTelnetMACDetails defaultTelnetMACDetails) {
		this.defaultTelnetMACDetails = defaultTelnetMACDetails;
	}

	public CPETelnetMacDetails getCpeTelnetMacDetails() {
		return cpeTelnetMacDetails;
	}

	public void setCpeTelnetMacDetails(CPETelnetMacDetails cpeTelnetMacDetails) {
		this.cpeTelnetMacDetails = cpeTelnetMacDetails;
	}

	public List<QOSMacDetails> getListOfQOSTelnetMacDetails() {
		return listOfQOSTelnetMacDetails;
	}

	public void setListOfQOSTelnetMacDetails(
			List<QOSMacDetails> listOfQOSTelnetMacDetails) {
		this.listOfQOSTelnetMacDetails = listOfQOSTelnetMacDetails;
	}

	public PHYTelnetMacDetails getPhyTelnetMacDetails() {
		return phyTelnetMacDetails;
	}

	public void setPhyTelnetMacDetails(PHYTelnetMacDetails phyTelnetMacDetails) {
		this.phyTelnetMacDetails = phyTelnetMacDetails;
	}

	public CountersMacDetails getCountersTelnetMacDetails() {
		return countersTelnetMacDetails;
	}

	public void setCountersTelnetMacDetails(
			CountersMacDetails countersTelnetMacDetails) {
		this.countersTelnetMacDetails = countersTelnetMacDetails;
	}
	
}
