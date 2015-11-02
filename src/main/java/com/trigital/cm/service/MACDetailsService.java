package com.trigital.cm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trigital.cm.domain.CPEMacDetails;
import com.trigital.cm.domain.CPETelnetMacDetails;
import com.trigital.cm.domain.CountersMacDetails;
import com.trigital.cm.domain.DefaultMACDetails;
import com.trigital.cm.domain.DefaultTelnetMACDetails;
import com.trigital.cm.domain.MACDetails;
import com.trigital.cm.domain.PHYMacDetails;
import com.trigital.cm.domain.QOSMacDetails;
import com.trigital.cm.domain.WidebandMacDetails;

@Service
public class MACDetailsService {

	private static final Logger log = LoggerFactory
			.getLogger(MACDetailsService.class);

	@Autowired
	ExecuteShellComand esc;
	
	@Autowired
	TelnetCommandExecutor tce;

	String executeCommandReset, executeCommandDefault, executeCommandCpe,
			executeCommandQos, executeCommandsWideband, executeCommandPhy,
			executeCommandCounters = null;

	// cisco10k
	DefaultMACDetails defaultMACDetails = null;
	CPEMacDetails cpeMacDetails = null;
	QOSMacDetails macDetailsQosA, macDetailsQosB = null;
	WidebandMacDetails widebandMacDetails = null;
	PHYMacDetails phyMacDetails = null;
	CountersMacDetails countersMacDetails = null;

	//CASA
	DefaultTelnetMACDetails defaultTelnetMACDetails = null;
	CPETelnetMacDetails cpeTelnetMacDetails = null;
	
	
	
	
	
	List<QOSMacDetails> listOfQOSMacDetails = new ArrayList<QOSMacDetails>();

	String[] defaultCommandResults, cpeCommandResults, qosCommandResults,
			wideBandCommandResults, phyCommandResults,
			countersCommandResults = null;
	String[] qosStringData = null;

	public MACDetailsService() {

	}

	public MACDetails getMACDetails(MACDetails macDetails) {

		if (macDetails.getCommand().equals("RESET")  && macDetails.getIpDetails().getCmts_make().equals("Cisco10K")) {

			executeCommandReset = "clear cable modem "
					+ macDetails.getMac_Address() + " reset";
			System.out.println(executeCommandReset);
			esc.shellCommandExecuter(executeCommandReset);

		} else if (macDetails.getCommand().equals("ALL") && macDetails.getIpDetails().getCmts_make().equals("Cisco10K")) {

			// Default Command
			defaultMACDetails = this.executeDefaultMacDetails(macDetails.getIpDetails().getIp_Address(), macDetails.getMac_Address());

			// CPE Command
			cpeMacDetails = this.executeCPEMacDetails(macDetails.getIpDetails().getIp_Address(), macDetails.getMac_Address());
			
			// QOS Command
			listOfQOSMacDetails = this.executeQOSMacDetails(macDetails.getIpDetails().getIp_Address(), macDetails.getMac_Address());

			//Wideband Channel Command
			widebandMacDetails = this.executeWidebandMacDetails(macDetails.getIpDetails().getIp_Address(), macDetails.getMac_Address());
			
			//Phy Command
			phyMacDetails = this.executePHYMacDetails(macDetails.getIpDetails().getIp_Address(), macDetails.getMac_Address());
			
			//Counters Command
			countersMacDetails = this.executeCountersMacDetails(macDetails.getIpDetails().getIp_Address(), macDetails.getMac_Address());

		} else if (macDetails.getCommand().equals("ALL") && macDetails.getIpDetails().getCmts_make().equals("CASA")) {
			
			executeCommandDefault = "shcm ";
			tce.executeTelnetCommand(executeCommandDefault);
		}
		
		macDetails.setDefaultMACDetails(defaultMACDetails);
		macDetails.setCpeMacDetails(cpeMacDetails);
		macDetails.setPhyMacDetails(phyMacDetails);
		macDetails.setWidebandMacDetails(widebandMacDetails);
		macDetails.setListofQosMacDetails(listOfQOSMacDetails);
		macDetails.setCountersMacDetails(countersMacDetails);
		
		return macDetails;
	}

	// Default Command
	public DefaultMACDetails executeDefaultMacDetails(String ipAddress,String macAddress) {

		
		executeCommandDefault = "rsh -l root " + ipAddress + " shcm "+ macAddress;

		System.out.println(executeCommandDefault);

		defaultCommandResults = esc.shellCommandExecuter(executeCommandDefault).split("\n")[3].split("\\s+");

		defaultMACDetails = new DefaultMACDetails(defaultCommandResults[0],
				defaultCommandResults[1], defaultCommandResults[2],
				defaultCommandResults[3], defaultCommandResults[4],
				defaultCommandResults[5], defaultCommandResults[6],
				defaultCommandResults[7], defaultCommandResults[8]);

		return defaultMACDetails;
	}
	
	// Default Telnet Command
	public DefaultTelnetMACDetails executeTelnetDefaultMacDetails(String macAddress) {
		
		executeCommandDefault = "shcm "+ macAddress;
		System.out.println(executeCommandDefault);

		defaultCommandResults = tce.executeTelnetCommand(executeCommandDefault).split("\n")[2].split("\\s+");

		defaultTelnetMACDetails = new DefaultTelnetMACDetails(defaultCommandResults[0], defaultCommandResults[1],
				defaultCommandResults[3], defaultCommandResults[4], defaultCommandResults[5], defaultCommandResults[6],
				defaultCommandResults[7], defaultCommandResults[8], defaultCommandResults[8], defaultCommandResults[9],
				defaultCommandResults[10]);

		return defaultTelnetMACDetails;
	}

	// CPE Command
	public CPEMacDetails executeCPEMacDetails(String ipAddress,String macAddress) {

		
		executeCommandCpe = "rsh -l root "+ ipAddress + " shcm "+ macAddress + " cpe";
		
		System.out.println(executeCommandCpe);
		
		cpeCommandResults = esc.shellCommandExecuter(executeCommandCpe).split("\n")[1].split("\\s+");
		
		cpeMacDetails = new CPEMacDetails(cpeCommandResults[0],
				cpeCommandResults[1], cpeCommandResults[2],
				cpeCommandResults[3]);

		return cpeMacDetails;
	}
	
	// CPE Command
	public CPETelnetMacDetails executeTelnetCPEMacDetails(String macAddress) {

		
		executeCommandCpe = "shcm "+ macAddress + " cpe";
		
		System.out.println(executeCommandCpe);
		
		cpeCommandResults = tce.executeTelnetCommand(executeCommandCpe).split("\n")[1].split("\\s+");
		
		cpeTelnetMacDetails = new CPETelnetMacDetails(cpeCommandResults[0], cpeCommandResults[1], cpeCommandResults[2], cpeCommandResults[3], cpeCommandResults[4]);

		return cpeTelnetMacDetails;
	}
	
	// QOS Command
	public List<QOSMacDetails> executeQOSMacDetails(String ipAddress,String macAddress) {

		
					// QOS Command
					executeCommandQos = "rsh -l root "+ ipAddress + " shcm "+ macAddress + " qos";
					System.out.println(executeCommandQos);
					qosCommandResults = esc.shellCommandExecuter(executeCommandQos)
							.split("\n");

					qosStringData = qosCommandResults[3].split("\\s+");

					macDetailsQosA = new QOSMacDetails(qosStringData[0],
							qosStringData[1], qosStringData[2], qosStringData[3],
							qosStringData[4], qosStringData[5], qosStringData[6],
							qosStringData[7], qosStringData[8], qosStringData[9]);
					listOfQOSMacDetails.add(macDetailsQosA);

					qosStringData = qosCommandResults[3].split("\\s+");
					
					macDetailsQosB = new QOSMacDetails(qosStringData[0],
							qosStringData[1], qosStringData[2], qosStringData[3],
							qosStringData[4], qosStringData[5], qosStringData[6],
							qosStringData[7], qosStringData[8], qosStringData[9]);
					listOfQOSMacDetails.add(macDetailsQosB);
					
			return listOfQOSMacDetails;
	}
	
	//Wideband Channel Command
	public WidebandMacDetails executeWidebandMacDetails(String ipAddress,String macAddress) {

		
					
					executeCommandsWideband = "rsh -l root "
							+ ipAddress + " shcm "
							+ macAddress + " wideband channel";
					
					System.out.println(executeCommandsWideband);
					
					wideBandCommandResults = esc.shellCommandExecuter(
							executeCommandsWideband).split("\n")[2].split("\\s+");
					
					widebandMacDetails = new WidebandMacDetails(
							wideBandCommandResults[0], wideBandCommandResults[1],
							wideBandCommandResults[2], wideBandCommandResults[3],
							wideBandCommandResults[4], wideBandCommandResults[5]);
					
			return widebandMacDetails;
	}
	
	//Phy Command
	public PHYMacDetails executePHYMacDetails(String ipAddress,String macAddress) {

					//Phy Command
					executeCommandPhy = "rsh -l root "+ ipAddress + " shcm "+ macAddress + " phy";
					
					System.out.println(executeCommandPhy);
					
					phyCommandResults = esc.shellCommandExecuter(executeCommandPhy).split("\n")[3].split("\\s+");
					
					phyMacDetails = new PHYMacDetails(phyCommandResults[0],
							phyCommandResults[1], phyCommandResults[2],
							phyCommandResults[3], phyCommandResults[4],
							phyCommandResults[5], phyCommandResults[6],
							phyCommandResults[7], phyCommandResults[8],
							phyCommandResults[9]);
					
			return phyMacDetails;
	}
	
	//Counters Command
	public CountersMacDetails executeCountersMacDetails(String ipAddress,String macAddress) {

					// Counters Command
					executeCommandCounters = "rsh -l root "+ ipAddress + " shcm "+ macAddress + " counters";
					
					System.out.println(executeCommandCounters);
					
					countersCommandResults = esc.shellCommandExecuter(executeCommandCounters).split("\n")[1].split("\\s+");
					
					countersMacDetails = new CountersMacDetails(
							countersCommandResults[0], countersCommandResults[1],
							countersCommandResults[2], countersCommandResults[3],
							countersCommandResults[4]);
					
			return countersMacDetails;
	}

}
