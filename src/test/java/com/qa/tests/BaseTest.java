package com.qa.tests;

import java.util.HashMap;

import com.qa.common.utils.ApplicationProperties;

public class BaseTest {
	
	public ApplicationProperties appProperties =   ApplicationProperties.getInstance();
	
	
	public HashMap<String, String> setHeaders() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		return headers;
		
	}
	
	public void setqueryParams() {
		HashMap<String, String> qparams = new HashMap<String, String>();
		qparams.put("", "");
		
	}

}
