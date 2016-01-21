package com.trigital.cm.api.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import scala.collection.immutable.Page;

import com.trigital.cm.domain.MACDetails;
import com.trigital.cm.exception.DataFormatException;
import com.trigital.cm.exception.NoRecordsFoundException;
import com.trigital.cm.service.MACDetailsService;
import com.trigital.cm.service.PropertyManager;
import com.trigital.cm.service.TelnetCommandExecutor;
import com.trigital.cm.service.XMLFileReader;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/cablemodem")
@Api(value = "Cable Modems", description = "Trigital API")
public class MACController extends AbstractRestHandler {
	
	private static final Logger log = LoggerFactory.getLogger(MACController.class);

    @Autowired
    private MACDetailsService macDetailsService;
    
	@Autowired
	XMLFileReader xmlFileReader;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Show list of Cable modems", notes = "Returns list of Cable modems")
    public
    @ResponseBody
    ResponseEntity processCMTSDetails(@RequestBody MACDetails macDetails,
                                 HttpServletRequest request, HttpServletResponse response) {
    	log.info("Ip Address "+macDetails.getIpDetails().getIpAddress());
    	log.info("Mac Address "+macDetails.getMac_Address());
    	log.info("Command "+macDetails.getCommand());
    	log.info("Make "+macDetails.getIpDetails().getModel());
    	macDetails = this.macDetailsService.getMACDetails(macDetails);
    	
    	if(macDetails.getCisco10MacDetails()==null && macDetails.getCasaMacDetails()==null){
    		throw new NoRecordsFoundException("No Records Found");
    	}
    	return this.success(macDetails);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a list of cmtsips from properties files", notes = "This is a list of CMTSIP's. Enter list of CMTS IP in Properties.ini file with || as separator")
    public
    @ResponseBody
    ResponseEntity showCMTSIPData(HttpServletRequest request, HttpServletResponse response) {
    	log.info("Loding CMTS IP's from Properties");
        return this.success(xmlFileReader.xmlDataReader());
    }
    
    public ResponseEntity success(final Object obj) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return new ResponseEntity(obj, responseHeaders, HttpStatus.OK);
    }


    
}
