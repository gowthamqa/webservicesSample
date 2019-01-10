package tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ServiceGet {
	
	String baseUri = "http://services.groupkt.com";
	String allStatesApi = "/state/get/IND/all";
	String singleStateApi = "/state/get/IND/";
	
	@Test
	public void testStates() {		
		Response resp = given().baseUri(baseUri+allStatesApi).get();
		//Response resp = given().baseUri("http://services.groupkt.com/country/search").queryParam("text", "un").get();
		System.out.println(resp.statusCode());
		String message = resp.body().asString();
		System.out.println(message);
	}
	
	@Test
	public void getCapitalCity() {
		String state = "UP";
		Response resp = given().baseUri(baseUri+singleStateApi+state).get();
		int statusCode = resp.statusCode();
		System.out.println(statusCode);
		String message = resp.body().asString();
		//System.out.println(message);		
		JSONObject jsonObj = new JSONObject(message);
		JSONObject jsonresp = (JSONObject) jsonObj.get("RestResponse");
		Iterator<String> it = jsonresp.keys();
		while (it.hasNext()) {
			if(it.next().contains("result")){
				JSONObject jsonresult = (JSONObject) jsonresp.get("result");
				String capitalCity = (String) jsonresult.get("capital");
				System.out.println(capitalCity);				
			}	
		}		
	}
	
	@Test
	public void getAllStatesWithCapitalCity() {		
		Response resp = given().baseUri(baseUri+allStatesApi).get();
		System.out.println("Status code: "+resp.statusCode());
		String message = resp.body().asString();
		//System.out.println(message);
		JSONObject jsonObj = new JSONObject(message);
		JSONObject jsonresp = (JSONObject) jsonObj.get("RestResponse");
		JSONArray jsonStates = (JSONArray) jsonresp.get("result");
		List<String> listStates = new ArrayList<String>();
		for (int i = 0; i < jsonStates.length(); i++) {
			JSONObject jsonSt = (JSONObject) jsonStates.get(i);
			String state = (String) jsonSt.get("abbr");
			listStates.add(state);
		}
		
		for (String state : listStates) {
			resp = given().baseUri(baseUri+singleStateApi+state).get();
			message = resp.body().asString();
		    jsonObj = new JSONObject(message);
			jsonresp = (JSONObject) jsonObj.get("RestResponse");
			JSONObject jsonresult = (JSONObject) jsonresp.get("result");
			String stateName = (String) jsonresult.get("name");
			String capitalCity = (String) jsonresult.get("capital");
			System.out.println(stateName+" : "+capitalCity);
			
		}

	}
	
	@Test
	public void getStateUsinpathpara() {		
		String statePath = "/state/get/IND/{state}";
		//Response resp = given().baseUri(baseUri+statePath).pathParam("state", "AP").get();
		//Response resp = given().pathParam("state", "AP").when().get(baseUri+statePath).then().statusCode(200);
		ValidatableResponse resp = given()
										.pathParam("state", "AP")
										.when().get(baseUri+statePath)
										.then().statusCode(200);
		//JsonPath jsonPath = new JsonPath(url);
		//Response resp = given().baseUri("http://services.groupkt.com/country/search").queryParam("text", "un").get();
		//System.out.println(resp.statusCode());
		//String message = resp.body().asString();
		//System.out.println(message);
	}
	
	@Test
	public void get() {
		
		/*Response getSpendOverrviewGraphResponse = given()
				.headers(setHeaders(LoginTest.token))
				.body(setAllUpSummaryBody())
				.queryParams(setqueryParams())
				.queryParams(addCustTypesQueryParams(Integer.valueOf(rfqID)))
				.when().post(CRM_Resource+"/rfq/getSpendOverrviewGraph")	
				.then().assertThat().statusCode(200)
				.extract().response();*/
	}

}
