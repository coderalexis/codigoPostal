package mx.gendra.cpostal.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import mx.gendra.cpostal.beans.ZipCode;
import mx.gendra.cpostal.beans.Settlements;

@RestController
public class Controller {
	
	static Map<String, ZipCode> mapZipCodes = new HashMap<String, ZipCode>();
	
	@GetMapping(value="/zip-codes/{zipcode}", produces = "application/json")
    public ResponseEntity<ZipCode> zipcodes(@PathVariable("zipcode") String zipcode) {
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");  
		ZipCode response = mapZipCodes.get(zipcode);
		//If not found zipcode in search, return http 404 code and json empty {}
		return  (response!=null) ? new ResponseEntity<ZipCode>(response,headers, HttpStatus.OK): new ResponseEntity<ZipCode>(new ZipCode(),headers,HttpStatus.NOT_FOUND);
	}
    

	@EventListener(ApplicationReadyEvent.class)
	public void initialConfiguration() {
		
		int countLine=0;
	    String filePath = "/home/CPdescarga.txt";
	    BufferedReader buffer;
	    String line = "";
	    try {
	        buffer = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.ISO_8859_1));
	        try {
	            while((line = buffer.readLine()) != null)
	            {
	            	countLine++;
	            	//The First two lines are headings
	            	if(countLine<2) 
	            		continue;
	            	
                	String separator = Pattern.quote("|");
	                String[] words = line.split(separator);
	                ZipCode zipcode = new ZipCode();
	                zipcode.setZip_code(words[0]);
	                zipcode.setLocality(words[4]);
	                zipcode.setFederal_entity(words[5]);
                    Settlements settlements = new Settlements();
                    settlements.setName(words[1]);
                    settlements.setZone_type( (words.length<15)?words[words.length-1]:words[words.length-2] );
                    settlements.setSettlement_type(words[2]);
                    zipcode.setMunicipality(words[3]);
                    zipcode.setSettlements(new ArrayList<Settlements>());
                    mapZipCodes.putIfAbsent(words[0], zipcode);
                    
                    if(mapZipCodes.containsKey(words[0]))
                        mapZipCodes.get(words[0]).getSettlements().add(settlements);
                        
	            }
	            buffer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } 
		
	}
}
