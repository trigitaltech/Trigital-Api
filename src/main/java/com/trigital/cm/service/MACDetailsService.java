package com.trigital.cm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trigital.cm.domain.CPEMacDetails;
import com.trigital.cm.domain.CountersMacDetails;
import com.trigital.cm.domain.DefaultMACDetails;
import com.trigital.cm.domain.MACDetails;
import com.trigital.cm.domain.PHYMacDetails;
import com.trigital.cm.domain.QOSMacDetails;
import com.trigital.cm.domain.WidebandMacDetails;

@Service
public class MACDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(MACDetailsService.class);
	
	@Autowired
	ExecuteShellComand esc;
    
    public MACDetailsService(){
    	
    }
    

    public MACDetails getMACDetails(MACDetails macDetails) {
    	
    	String executeCommandReset,executeCommandDefault,executeCommandCpe,executeCommandQos,executeCommandsWideband,
    									executeCommandPhy,executeCommandCounters = null;
    	
    	//MACDetails resultReset = new MACDetails();
    	DefaultMACDetails defaultMACDetails = null;
    	CPEMacDetails cpeMacDetails = null;
    	QOSMacDetails macDetailsQosA,macDetailsQosB = null;
    	WidebandMacDetails widebandMacDetails  = null;
    	PHYMacDetails phyMacDetails = null;
    	CountersMacDetails countersMacDetails = null;
    	
    	List<QOSMacDetails> listOfQOSMacDetails = new ArrayList<QOSMacDetails>();
    	
    	String[] defaultCommandResults,cpeCommandResults,qosCommandResults,wideBandCommandResults,phyCommandResults,countersCommandResults = null;
    	String[] qosStringData = null;
    	
    	if(macDetails.getCommand()=="RESET"){
    		
    		executeCommandReset = "clear cable modem "+macDetails.getMac_Address()+" reset";
    		System.out.println(executeCommandReset);
    		esc.shellCommandExecuter(executeCommandReset);
    		
    	}else {
    		
    		//Default Command
    		executeCommandDefault = "rsh -l root "+macDetails.getIpDetails().getIp_Address()+" shcm "+macDetails.getMac_Address();
    		System.out.println(executeCommandDefault);
    		defaultCommandResults = esc.shellCommandExecuter(executeCommandDefault).split("\n")[3].split("\\s+");
    		defaultMACDetails = new DefaultMACDetails(defaultCommandResults[0],defaultCommandResults[1],defaultCommandResults[2],
    									defaultCommandResults[3],defaultCommandResults[4],defaultCommandResults[5],
    									defaultCommandResults[6],defaultCommandResults[7],defaultCommandResults[8]);
    		
    		//CPE Command
    		executeCommandCpe = "rsh -l root "+macDetails.getIpDetails().getIp_Address()+" shcm "+macDetails.getMac_Address()+" cpe";
    		System.out.println(executeCommandCpe);    		
    		cpeCommandResults = esc.shellCommandExecuter(executeCommandCpe).split("\n")[1].split("\\s+");
    		cpeMacDetails = new CPEMacDetails(cpeCommandResults[0], cpeCommandResults[1], cpeCommandResults[2], cpeCommandResults[3]); 
    		
    		//QOS Command
    		executeCommandQos = "rsh -l root "+macDetails.getIpDetails().getIp_Address()+" shcm "+macDetails.getMac_Address()+" qos";
    		System.out.println(executeCommandQos);
    		qosCommandResults = esc.shellCommandExecuter(executeCommandQos).split("\n");

    		qosStringData = qosCommandResults[3].split("\\s+");
    		
    		for (String string : qosStringData) {
				System.out.println("QOS "+string);
			}
    		macDetailsQosA = new QOSMacDetails(qosStringData[0], qosStringData[1], qosStringData[2], qosStringData[3],
    				qosStringData[4], qosStringData[5], qosStringData[6], qosStringData[7], qosStringData[8], qosStringData[9]);
    		listOfQOSMacDetails.add(macDetailsQosA);
    		
    		qosStringData = qosCommandResults[3].split("\\s+");
    		macDetailsQosB = new QOSMacDetails(qosStringData[0], qosStringData[1], qosStringData[2], qosStringData[3],
    				qosStringData[4], qosStringData[5], qosStringData[6], qosStringData[7], qosStringData[8], qosStringData[9]);
    		listOfQOSMacDetails.add(macDetailsQosB);
    		
    		//Wideband Channel Command
    		executeCommandsWideband = "rsh -l root "+macDetails.getIpDetails().getIp_Address()+" shcm "+macDetails.getMac_Address()+ " wideband channel";
    		System.out.println(executeCommandsWideband);
    		wideBandCommandResults = esc.shellCommandExecuter(executeCommandsWideband).split("\n")[2].split("\\s+");
    		widebandMacDetails = new WidebandMacDetails(wideBandCommandResults[0], wideBandCommandResults[1],
    										wideBandCommandResults[2], wideBandCommandResults[3], wideBandCommandResults[4], wideBandCommandResults[5]); 
    		//Phy Command
    		executeCommandPhy = "rsh -l root "+macDetails.getIpDetails().getIp_Address()+" shcm "+macDetails.getMac_Address()+ " phy";
    		System.out.println(executeCommandPhy);
    		phyCommandResults = esc.shellCommandExecuter(executeCommandPhy).split("\n")[3].split("\\s+");
    		phyMacDetails = new PHYMacDetails(phyCommandResults[0], phyCommandResults[1], phyCommandResults[2], phyCommandResults[3],
    				phyCommandResults[4], phyCommandResults[5], phyCommandResults[6],
    				phyCommandResults[7], phyCommandResults[8], phyCommandResults[9]);

    		//Counters Command
    		executeCommandCounters = "rsh -l root "+macDetails.getIpDetails().getIp_Address()+" shcm "+macDetails.getMac_Address()+ " counters";
    		System.out.println(executeCommandCounters);
    		countersCommandResults = esc.shellCommandExecuter(executeCommandCounters).split("\n")[1].split("\\s+");
    		countersMacDetails = new CountersMacDetails(countersCommandResults[0], countersCommandResults[1],
    										countersCommandResults[2], countersCommandResults[3], countersCommandResults[4]);
    		
    		macDetails.setDefaultMACDetails(defaultMACDetails);
    		macDetails.setCpeMacDetails(cpeMacDetails);
    		macDetails.setPhyMacDetails(phyMacDetails);
    		macDetails.setWidebandMacDetails(widebandMacDetails);
    		macDetails.setListofQosMacDetails(listOfQOSMacDetails);
    		macDetails.setCountersMacDetails(countersMacDetails);
    		
		}
        return macDetails;
    }

}
