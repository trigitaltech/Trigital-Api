package com.trigital.cm.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.trigital.cm.domain.Cmts;

@Service
public class XMLFileReader {

	public List<Cmts> xmlDataReader() {
		
		List<Cmts> cmtsIps = new ArrayList<Cmts>();

		try {

			File fXmlFile = new File("/home/expan/properties.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("cmts");
			System.out.println(nList.getLength());
			
			for(int item = 0;item < nList.getLength();item++){
				Node nNode = nList.item(item);
			    
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
					String name = eElement.getElementsByTagName("name").item(0).getTextContent();
					
					String ipAddress =  eElement.getElementsByTagName("ipaddress").item(0).getTextContent();
					
					String model = eElement.getElementsByTagName("model").item(0).getTextContent();
					cmtsIps.add(new Cmts(name, ipAddress, model));
				}
				
			}
			

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cmtsIps;

	}

}
