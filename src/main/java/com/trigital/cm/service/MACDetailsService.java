package com.trigital.cm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trigital.cm.domain.CPEMacDetails;
import com.trigital.cm.domain.CPETelnetMacDetails;
import com.trigital.cm.domain.Cisco10MacDetails;
import com.trigital.cm.domain.CountersMacDetails;
import com.trigital.cm.domain.DefaultMACDetails;
import com.trigital.cm.domain.DefaultTelnetMACDetails;
import com.trigital.cm.domain.MACDetails;
import com.trigital.cm.domain.PHYMacDetails;
import com.trigital.cm.domain.PHYTelnetMacDetails;
import com.trigital.cm.domain.QOSMacDetails;
import com.trigital.cm.domain.WidebandMacDetails;

@Service
public class MACDetailsService {

	private static final Class<MACDetailsService> macDetailsServiceClass = MACDetailsService.class;
    private static final Logger log = LoggerFactory.getLogger(macDetailsServiceClass);

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
	QOSMacDetails qosTelnetMacDetails = null;
	PHYTelnetMacDetails phyTelnetMacDetails = null;
	CountersMacDetails countersTelnetMacDetails = null;
	
	List<QOSMacDetails> listOfQOSMacDetails = new ArrayList<QOSMacDetails>();

	String[] defaultCommandResults, cpeCommandResults, qosCommandResults,
			wideBandCommandResults, phyCommandResults,
			countersCommandResults = null;
	String[] qosStringData = null;

	public MACDetailsService() {

	}

	public MACDetails getMACDetails(MACDetails macDetails) {
		
		
		
		log.info("I am in getMacDetails");
		if (macDetails.getCommand().equals("RESET")  && macDetails.getIpDetails().getCmts_make().equals("Cisco10K")) {

			executeCommandReset = "clear cable modem "+ macDetails.getMac_Address() + " reset";
			System.out.println(executeCommandReset);
			esc.shellCommandExecuter(executeCommandReset);

		} else if (macDetails.getCommand().equals("ALL") && macDetails.getIpDetails().getCmts_make().equals("Cisco10K")) {

			 macDetails.setCisco10MacDetails(this.getCisco10MacDetails(macDetails.getIpDetails().getIp_Address(), macDetails.getMac_Address()));

		} else if (macDetails.getCommand().equals("ALL") && macDetails.getIpDetails().getCmts_make().equals("CASA")) {
			
			tce.connectTelnet(macDetails.getIpDetails().getIp_Address());
			
			log.info("Execution of defaultTelnetMACDetails");
			// Default Telnet Command
			defaultTelnetMACDetails = this.executeTelnetDefaultMacDetails(macDetails.getMac_Address());
			log.info("Completion of defaultTelnetMACDetails");
			
			//CPE Telnet Command
			cpeTelnetMacDetails = this.executeTelnetCPEMacDetails(macDetails.getMac_Address());
			
			//QOS Telnet Command
			listOfQOSMacDetails = this.executeTelnetQOSMacDetails(macDetails.getMac_Address());
			
			//PHY Telnet Command
			phyTelnetMacDetails = this.executeTelnetPHYMacDetails(macDetails.getMac_Address());
			
			//Counters Telnet Commands
			countersTelnetMacDetails = this.executeTelnetCountersMacDetails(macDetails.getMac_Address());
			
			tce.disconnectTelnet();
			
			/*macDetails.setDefaultTelnetMACDetails(defaultTelnetMACDetails);
			macDetails.setCpeTelnetMacDetails(cpeTelnetMacDetails);
			macDetails.setPhyTelnetMacDetails(phyTelnetMacDetails);
			//macDetails.setWidebandMacDetails(widebandMacDetails);
			macDetails.setListofTelnetQosMacDetails(listOfQOSMacDetails);
			macDetails.setCountersTelnetMacDetails(countersMacDetails);*/
			
		}
		

		
		return macDetails;
	}

	// Default Command
	public DefaultMACDetails executeDefaultMacDetails(String ipAddress,String macAddress) {

		try {
			
			executeCommandDefault = "rsh -l root " + ipAddress + " shcm "+ macAddress;

			System.out.println(executeCommandDefault);

			defaultCommandResults = esc.shellCommandExecuter(executeCommandDefault).split("\n")[3].split("\\s+");

			defaultMACDetails = new DefaultMACDetails(defaultCommandResults[0],
					defaultCommandResults[1], defaultCommandResults[2],
					defaultCommandResults[3], defaultCommandResults[4],
					defaultCommandResults[5], defaultCommandResults[6],
					defaultCommandResults[7], defaultCommandResults[8]);
			
			defaultMACDetails.setFlag(true);
			
		} catch(Exception e){
			
			log.error("Could not execute Default MacDetails");
			
			if(!defaultMACDetails.isFlag()){
				
				// CPE Command
				cpeMacDetails = this.executeCPEMacDetails(ipAddress,macAddress);
				
				// QOS Command
				listOfQOSMacDetails = this.executeQOSMacDetails(ipAddress,macAddress);

				//Wideband Channel Command
				widebandMacDetails = this.executeWidebandMacDetails(ipAddress,macAddress);
				
				//Phy Command
				phyMacDetails = this.executePHYMacDetails(ipAddress,macAddress);
				
				//Counters Command
				countersMacDetails = this.executeCountersMacDetails(ipAddress,macAddress);
			
			}
			
			
		}
		

		return defaultMACDetails;
	}
	
	// Default Telnet Command
	public DefaultTelnetMACDetails executeTelnetDefaultMacDetails(String macAddress) {
		
		executeCommandDefault = "shcm "+ macAddress;
		System.out.println(executeCommandDefault);

		
		defaultCommandResults = tce.executeTelnetCommand(executeCommandDefault).split("\n")[3].split("\\s+");

		defaultTelnetMACDetails = new DefaultTelnetMACDetails(defaultCommandResults[0], defaultCommandResults[1], defaultCommandResults[2],
				defaultCommandResults[3], defaultCommandResults[4], defaultCommandResults[5], defaultCommandResults[6], defaultCommandResults[7],
				defaultCommandResults[8], defaultCommandResults[9]);

		return defaultTelnetMACDetails;
	}

	// CPE Command
	public CPEMacDetails executeCPEMacDetails(String ipAddress,String macAddress) {

		try {
			
			executeCommandCpe = "rsh -l root "+ ipAddress + " shcm "+ macAddress + " cpe";
			System.out.println(executeCommandCpe);
			cpeCommandResults = esc.shellCommandExecuter(executeCommandCpe).split("\n")[1].split("\\s+");
			cpeMacDetails = new CPEMacDetails(cpeCommandResults[0],cpeCommandResults[1], cpeCommandResults[2],cpeCommandResults[3]);
			
		} catch (Exception e) {

				log.error("Could not execute CPEMacDetails");
				
				// QOS Command
				listOfQOSMacDetails = this.executeQOSMacDetails(ipAddress,macAddress);

				//Wideband Channel Command
				widebandMacDetails = this.executeWidebandMacDetails(ipAddress,macAddress);
				
				//Phy Command
				phyMacDetails = this.executePHYMacDetails(ipAddress,macAddress);
				
				//Counters Command
				countersMacDetails = this.executeCountersMacDetails(ipAddress,macAddress);
			
			

		}
		

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

					try {
						
						// QOS Command
						executeCommandQos = "rsh -l root "+ ipAddress + " shcm "+ macAddress + " qos";
						System.out.println(executeCommandQos);
						qosCommandResults = esc.shellCommandExecuter(executeCommandQos).split("\n");

						qosStringData = qosCommandResults[3].split("\\s+");

						macDetailsQosA = new QOSMacDetails(qosStringData[0],
								qosStringData[1], qosStringData[2], qosStringData[3],
								qosStringData[4], qosStringData[5], qosStringData[6],
								qosStringData[7], qosStringData[8], qosStringData[9]);
						listOfQOSMacDetails.add(macDetailsQosA);

						qosStringData = qosCommandResults[4].split("\\s+");
						
						macDetailsQosB = new QOSMacDetails(qosStringData[0],
								qosStringData[1], qosStringData[2], qosStringData[3],
								qosStringData[4], qosStringData[5], qosStringData[6],
								qosStringData[7], qosStringData[8], qosStringData[9]);
						listOfQOSMacDetails.add(macDetailsQosB);
						
					} catch (Exception e) {
						
						//Wideband Channel Command
						widebandMacDetails = this.executeWidebandMacDetails(ipAddress,macAddress);
						
						//Phy Command
						phyMacDetails = this.executePHYMacDetails(ipAddress,macAddress);
						
						//Counters Command
						countersMacDetails = this.executeCountersMacDetails(ipAddress,macAddress);
					}
		
					
					
			return listOfQOSMacDetails;
	}
	
		// QOS Telnet Command
		public List<QOSMacDetails> executeTelnetQOSMacDetails(String macAddress) {

			
						// QOS Telnet Command
						executeCommandQos = "shcm "+ macAddress + " qos";
						System.out.println(executeCommandQos);
						qosCommandResults = tce.executeTelnetCommand(executeCommandQos).split("\n");

						for (String string : qosCommandResults) {
							
							System.out.println("++++++++++"+string);
						}
						
						System.out.println("Length of qosCommandResults"+qosCommandResults.length);
						
						qosStringData = qosCommandResults[4].split("\\s+");

						macDetailsQosA = new QOSMacDetails(qosStringData[0],
								qosStringData[1], qosStringData[2], qosStringData[3],
								qosStringData[4], qosStringData[5], qosStringData[6],
								qosStringData[7], qosStringData[8], qosStringData[9]);
						listOfQOSMacDetails.add(macDetailsQosA);

						qosStringData = qosCommandResults[5].split("\\s+");
						
						macDetailsQosB = new QOSMacDetails(qosStringData[0],
								qosStringData[1], qosStringData[2], qosStringData[3],
								qosStringData[4], qosStringData[5], qosStringData[6],
								qosStringData[7], qosStringData[8], qosStringData[9]);
						listOfQOSMacDetails.add(macDetailsQosB);
						
				return listOfQOSMacDetails;
		}
		
	
	//Wideband Channel Command
	public WidebandMacDetails executeWidebandMacDetails(String ipAddress,String macAddress) {

		try {
			
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
			
		} catch (Exception e) {
			
			//Phy Command
			phyMacDetails = this.executePHYMacDetails(ipAddress,macAddress);
			
			//Counters Command
			countersMacDetails = this.executeCountersMacDetails(ipAddress,macAddress);
			
		}
					
					
					
			return widebandMacDetails;
	}
	
	//Phy Command
	public PHYMacDetails executePHYMacDetails(String ipAddress,String macAddress) {

					try {
						
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
						
					} catch (Exception e) {
						
						//Counters Command
						countersMacDetails = this.executeCountersMacDetails(ipAddress,macAddress);
						
					}
		
					
					
			return phyMacDetails;
	}
	
		//Phy Command
		public PHYTelnetMacDetails executeTelnetPHYMacDetails(String macAddress) {

						//Phy Command
						executeCommandPhy = "shcm "+ macAddress + " phy";
						
						System.out.println(executeCommandPhy);
						
						phyCommandResults = tce.executeTelnetCommand(executeCommandPhy).split("\n")[3].split("\\s+");
						
						phyTelnetMacDetails = new PHYTelnetMacDetails(phyCommandResults[0],phyCommandResults[1],phyCommandResults[2],
											  phyCommandResults[3], phyCommandResults[4], phyCommandResults[5], phyCommandResults[6],
											  phyCommandResults[7], phyCommandResults[8],phyCommandResults[9]);
						
				return phyTelnetMacDetails;
		}
	
	//Counters Command
	public CountersMacDetails executeCountersMacDetails(String ipAddress,String macAddress) {

					try {
						
						// Counters Command
						executeCommandCounters = "rsh -l root "+ ipAddress + " shcm "+ macAddress + " counters";
						
						System.out.println(executeCommandCounters);
						
						countersCommandResults = esc.shellCommandExecuter(executeCommandCounters).split("\n")[1].split("\\s+");
						
						countersTelnetMacDetails = new CountersMacDetails(
								countersCommandResults[0], countersCommandResults[1],
								countersCommandResults[2], countersCommandResults[3],
								countersCommandResults[4]);
						
					} catch (Exception e) {
						
						countersTelnetMacDetails = null;
					}
					
			return countersTelnetMacDetails;
	}
	
		//Counters Telnet Command
		public CountersMacDetails executeTelnetCountersMacDetails(String macAddress) {

						// Counters Command
						executeCommandCounters = "shcm "+ macAddress + " counters";
						
						System.out.println(executeCommandCounters);
						
						countersCommandResults = tce.executeTelnetCommand(executeCommandCounters).split("\n")[2].split("\\s+");
						
						countersMacDetails = new CountersMacDetails(
								countersCommandResults[0], countersCommandResults[1],
								countersCommandResults[2], countersCommandResults[3],
								countersCommandResults[4]);
						
				return countersMacDetails;
		}
		
		public Cisco10MacDetails getCisco10MacDetails(String ipAddress,String macAddress){

			//Default Command
			defaultMACDetails = this.executeDefaultMacDetails(ipAddress, macAddress);
		
		
			
			// CPE Command
			cpeMacDetails = this.executeCPEMacDetails(ipAddress, macAddress);
			
			// QOS Command
			listOfQOSMacDetails = this.executeQOSMacDetails(ipAddress, macAddress);

			//Wideband Channel Command
			widebandMacDetails = this.executeWidebandMacDetails(ipAddress, macAddress);
			
			//Phy Command
			phyMacDetails = this.executePHYMacDetails(ipAddress, macAddress);
			
			//Counters Command
			countersMacDetails = this.executeCountersMacDetails(ipAddress, macAddress);

			
			return new Cisco10MacDetails(defaultMACDetails, cpeMacDetails, listOfQOSMacDetails, widebandMacDetails,
					phyMacDetails, countersMacDetails);
			
			
		}

}
