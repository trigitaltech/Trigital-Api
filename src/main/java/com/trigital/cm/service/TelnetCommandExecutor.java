package com.trigital.cm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TelnetCommandExecutor {
	
	private static final Logger log = LoggerFactory.getLogger(TelnetCommandExecutor.class);
	
	public String executeTelnetCommand(String executeCommand) {
		final TelnetCommandExecutor esc = new TelnetCommandExecutor();
		
		final PropertyManager propertyManager = new PropertyManager();
		
		//"rsh -l root 125.99.127.30 shcm a089.e439.abc4"
		return esc.commandExecutor(executeCommand);

	}

	private String commandExecutor(String executeCommand) {
		// TODO Auto-generated method stub
		return null;
	}

}
