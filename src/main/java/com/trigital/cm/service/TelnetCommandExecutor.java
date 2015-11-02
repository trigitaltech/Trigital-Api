package com.trigital.cm.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketException;

import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TelnetCommandExecutor {
	
	private static final Logger log = LoggerFactory.getLogger(TelnetCommandExecutor.class);
	
	private TelnetClient telnet = new TelnetClient();
	private InputStream in;
	private PrintStream out;
	private final String telnetServer = "125.99.88.90";
	private final String userName = "venkat";
	private final String password = "venkat@75";
	
	
	public String executeTelnetCommand(String executeCommand) {
		
		final PropertyManager propertyManager = new PropertyManager();
		
		return this.telnetCommandExecutor(executeCommand);

	}

	private String telnetCommandExecutor(String executeCommand) {
		
		try {
			telnet.connect(telnetServer);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
