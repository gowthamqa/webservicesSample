package com.qa.tests;

import java.util.HashMap;

import com.qa.common.utils.ApplicationProperties;

public class BaseTest {
	
	public static ApplicationProperties appProperties =   ApplicationProperties.getInstance();
	
	public static String HOST = appProperties.getHost();
	
	
	public HashMap<String, String> setHeaders() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		return headers;
		
	}
	
	public HashMap<String, String> setQueryParams() {
		HashMap<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("limit", "847");
		
		return queryParams;
		
	}
	
	public void setqueryParams() {
		HashMap<String, String> qparams = new HashMap<String, String>();
		qparams.put("", "");
		
	}

}
