package com.trigital.cm.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jscape.inet.telnet.Telnet;
import com.jscape.inet.telnet.TelnetAdapter;
import com.jscape.inet.telnet.TelnetException;
import com.jscape.inet.telnet.TelnetScript;
import com.jscape.inet.telnet.TelnetSession;
import com.jscape.inet.telnet.TelnetTask;
import com.trigital.cm.exception.TelnetConnectionException;

@Service
public class TelnetCommandExecutor extends TelnetAdapter{
	
	private static final Logger log = LoggerFactory.getLogger(TelnetCommandExecutor.class);
	
    private Telnet telnet = null;
	String loginPrompt = "Antophill-CMTS login:";
    String login = "venkat";
    String passwordPrompt = "Antophill-CMTS password:";
    String password = "venkat@75";
    String shellPrompt = "Antophill-CMTS>";
    TelnetSession session = null;
    
    
    public void connectTelnet(String hostName){
    	
    	log.info("connecting to telnetserver "+ hostName);
    	
    	session = new TelnetSession(hostName);
    	session.setShellPrompt(shellPrompt);
		session.setLoginPrompt(loginPrompt);
		session.setPasswordPrompt(passwordPrompt);
		session.addTelnetListener(this);
		try {
			session.connect(login,password);
		} catch (TelnetException e) {
			
			e.printStackTrace();
			log.error("Cannot connect to Telnet Server");
			throw new TelnetConnectionException("Cannot connect to Telnet Server");
		}
		System.out.println("successfully connected to telnet server");
		
		log.info("connected to telnetserver "+hostName);
    }
	
	public String executeTelnetCommand(String executeCommand) {

        String result = null;
		
        
		try {
			
			result = session.send(executeCommand);
			System.out.println("successfully executed the show cable modem command");
			System.out.println(result);

			
		} catch (TelnetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		return result;

	}
	
	public void disconnectTelnet(){
		try {
			session.disconnect();
		} catch (TelnetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("successfully disconnected the server");
	}

}
