package com.trigital.cm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trigital.cm.domain.MACDetails;

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
    	MACDetails macDetailsDefault = null; 
    	MACDetails macDetailsCpe = null;
    	MACDetails macDetailsQos = null;
    	MACDetails macDetailsWideband = null;
    	MACDetails macDetailsPhy = null;
    	MACDetails macDetailsCounters = null;
    	
    	String[] defaultCommandResults,cpeCommandResults,qosCommandResults,wideBandCommandResults,phyCommandResults,
    																									countersCommandResults = null;

    	
    	if(macDetails.getCommand()=="RESET"){
    		
    		executeCommandReset = "clear cable modem "+macDetails.getMac_Address()+" reset";
    		System.out.println(executeCommandReset);
    		esc.shellCommandExecuter(executeCommandReset);
    		
    	}else {
    		
    		executeCommandDefault = "rsh -l root "+macDetails.getIp_Address()+" shcm "+macDetails.getMac_Address();
    		System.out.println(executeCommandDefault);
    		defaultCommandResults = esc.shellCommandExecuter(executeCommandDefault).split("\n")[3].split("\\s+");
    		macDetailsDefault = new MACDetails(defaultCommandResults[0],defaultCommandResults[0],defaultCommandResults[0],
    									defaultCommandResults[0],defaultCommandResults[0],defaultCommandResults[0],
    									defaultCommandResults[0],defaultCommandResults[0],defaultCommandResults[0]);
    				
    		executeCommandCpe = "rsh -l root "+macDetails.getIp_Address()+" shcm "+macDetails.getMac_Address()+" cpe";
    		System.out.println(executeCommandCpe);
    		cpeCommandResults = esc.shellCommandExecuter(executeCommandCpe).split("\n")[3].split("\\s+");
    		
    		
    		/*executeCommandQos = "rsh -l root "+macDetails.getIp_Address()+" shcm "+macDetails.getMac_Address()+" cpe";
    		System.out.println(executeCommandQos);
    		resultQos = esc.shellCommandExecuter(executeCommandQos);
    		qosCommandResults = resultQos.split("\n")[3].split("\\s+");
    		
    		executeCommandsWideband = "rsh -l root "+macDetails.getIp_Address()+" shcm "+macDetails.getMac_Address()+ " wideband channel";
    		System.out.println(executeCommandsWideband);
    		resultWideband = esc.shellCommandExecuter(executeCommandsWideband);
    		wideBandCommandResults = resultWideband.split("\n")[3].split("\\s+");
    		
    		executeCommandPhy = "rsh -l root "+macDetails.getIp_Address()+" shcm "+macDetails.getMac_Address()+ " wideband channel";
    		System.out.println(executeCommandPhy);
    		resultPhy = esc.shellCommandExecuter(executeCommandPhy);
    		phyCommandResults = resultPhy.split("\n")[3].split("\\s+");

    		executeCommandCounters = "rsh -l root "+macDetails.getIp_Address()+" shcm "+macDetails.getMac_Address()+ " wideband channel";
    		System.out.println(executeCommandCounters);
    		resultCounters = esc.shellCommandExecuter(executeCommandCounters);
    		countersCommandResults = resultCounters.split("\n")[3].split("\\s+");*/
    		
		}
    
    	
    	
    	//System.out.println("length "+lineSeparators.length);
    	
    	/*for (String string : lineSeparators) {
			System.out.println("log "+string);
		}
    	
    	String details = lineSeparators[3];
    	String[] listOfDetails = details.split("\\s+");
    	
    	macDetails.setMac_Address(listOfDetails[0]);
    	macDetails.setIp_Address(listOfDetails[1]);
    	macDetails.setI_f(listOfDetails[2]);
    	macDetails.setMac_state(listOfDetails[3]);
    	macDetails.setPrim_Sid(listOfDetails[4]);
    	macDetails.setRxpwr(listOfDetails[5]);
    	macDetails.setTiming_Offset(listOfDetails[6]);
    	macDetails.setNum_CPE(listOfDetails[7]);
    	macDetails.setDIP(listOfDetails[8]);*/
        return macDetailsDefault;
    }

}
