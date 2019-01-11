package com.qa.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.common.data.ExcelWriter;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestF12010 extends BaseTest {
	
	public String api = "/api/f1/{year}/1.json";
	
	@Test
	public void getCircuit() {
		
		Response resp = given().
				pathParam("year", "2010").
				when().get(HOST+api).
				then().assertThat().
				statusCode(200)
				.extract().response();
		System.out.println(resp.body().asString());
		
	}
	
	@Test
	public void getCountry2008() {
		
		Response resp = given().
				headers(setHeaders()).
				pathParam("year", "2008").
				when().get(HOST+api).
				then().assertThat().statusCode(200).
				extract().response();
		//System.out.println(resp.body().asString());
		JSONObject jsonObj = new JSONObject(resp.body().asString());
		JSONObject jsonresp = (JSONObject) jsonObj.get("MRData");
		//System.out.println(jsonresp);
		JSONObject jsonRaceTable = (JSONObject) jsonresp.get("RaceTable");
		//System.out.println(jsonRace);
		JSONArray array = (JSONArray) jsonRaceTable.get("Races");
		JSONObject jsonRace = (JSONObject) array.get(0);
		JSONObject circuit = (JSONObject) jsonRace.get("Circuit");
		JSONObject location = (JSONObject) circuit.get("Location");
		String countryName = (String) location.get("country");
		String locality = (String) location.get("locality");
		System.out.println("Country Name =====> "+countryName);
		System.out.println("Locality Name =====> "+locality);
		Assert.assertEquals("Australia", countryName);
		Assert.assertEquals("Melbourne", locality);
		
	}
	
	@Test
	public void getDriverCount() {
		
		//String[] valueToWrite = null;

		
		Response response = given().
				headers(setHeaders()).
				//queryParams(setQueryParams()).
				queryParams("limit", "10").
				when().get(HOST+"/api/f1/drivers.json").
				then().statusCode(200).
				extract().response();
		//String resp = response.body().asString();
		
		JSONObject jsonObj = new JSONObject(response.body().asString());
		JSONObject jsonresp = (JSONObject) jsonObj.get("MRData");
		JSONObject driverTble = (JSONObject) jsonresp.get("DriverTable");
		String total = (String) jsonresp.get("total");
		Assert.assertEquals(Integer.parseInt(total), 847);
		JSONArray driversArray = (JSONArray) driverTble.get("Drivers");
		System.out.println("Result ===============> "+driversArray.length());
		for (int i = 0; i < driversArray.length(); i++) {
			JSONObject drive = (JSONObject) driversArray.get(i);
			//String name = (String) drive.get("driverId");
			ExcelWriter ex = new ExcelWriter();
			ex.writeData(i, drive);
			System.out.println(drive.get("driverId")+" "+drive.get("givenName"));
		}
		
	
	}
	
	
	

}
