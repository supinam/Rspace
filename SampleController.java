package com.rspace.test.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.rspace.test.model.SampleBean;

@RestController
public class SampleController {

	@Autowired
	private RestTemplate restTemplate;
	
	 
	
	@GetMapping("/samples")
	public void getAllSamples(){
		
		// api endpoint
		String url = "https://demos.researchspace.com/api/inventory/v1" + "/samples";
		
		
		HttpHeaders headers = new HttpHeaders();
		
		// set headers
		headers.add("apiKey", "nsEXOcJ734fMrTp16D4jQ05wtSJc2w3t");
		headers.setContentType(MediaType.APPLICATION_JSON);
			
		
		HttpEntity request = new HttpEntity(headers);
		
		// call the rest api
        ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,request,String.class,1);
        
        	
		String samples = response.getBody();
		
		// convert the response string to jsonObject
		JsonElement jsonElement = new JsonParser().parse(samples);
				
		//print the response
	System.out.println(jsonElement.getAsJsonObject().get("samples"));
				
		
	}
}
