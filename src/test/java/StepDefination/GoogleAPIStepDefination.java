package StepDefination;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.runner.RunWith;

import GoogleAPIResources.Resources;
import GoogleAPIResources.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
@RunWith(Cucumber.class)
	public class GoogleAPIStepDefination extends Util {
	Resources p=new Resources();
	RequestSpecification p1;
	Response p2;
	public static String id;
	@Given("Add the Payload {string} {string} {string}")
	public void add_the_payload(String name, String address, String language) throws IOException  {	    	
	         p1=given().spec(Requestspec()).body(p.AddPlaceData(name,address,language));
	                
	    }

	@When("User submit the {string} API with {string} method")
	public void user_submit_the_api_with_method(String strArg1, String strArg2) throws Throwable {
	    	
	    	if(strArg2.equalsIgnoreCase("POST")) {
	    	 p2= p1.when().post(prop(strArg1)).then().spec(Resposespec()).extract().response(); 
	    	id=parseresponse(p2).get("place_id");}
			else if(strArg2.equalsIgnoreCase("GET"))
	    	{p2=given().spec(Requestspec()).queryParam("place_id",id).when().
	    		get(prop(strArg1)).then().spec(Resposespec()).extract().response();
	    	  	System.out.println(p2.asString());
	    	  	System.out.println("Hello");
	    	  	System.out.println("Hello2");}
			else {
				p2=p1.when().delete(prop(strArg1)).then().spec(Resposespec()).extract().response();
			}
	    }

	    @Then("^Validate the status code \"([^\"]*)\"$")
	    public void validate_the_status_code_something(String strArg1) throws Throwable {
	        int code=p2.getStatusCode();
	        System.out.println(code);
	    }

	    @And("^Validate the \"([^\"]*)\" in respose is \"([^\"]*)\"$")
	    public void validate_the_something_in_respose_is_something(String strArg1, String strArg2) throws Throwable {
	        
	        if (strArg1.equalsIgnoreCase("status")) 
	        assertEquals(parseresponse(p2).get("status"), strArg2);
	        else
	        	assertEquals(parseresponse(p2).get("scope"), strArg2);
	        
	    }

	    @Given("Delete payload")
	    public void delete_payload() throws IOException {
	        p1=given().spec(Requestspec()).body(p.deletedata(id));        
	    }
	}


