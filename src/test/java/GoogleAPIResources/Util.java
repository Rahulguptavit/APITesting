package GoogleAPIResources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.swing.plaf.basic.BasicTabbedPaneUI.PropertyChangeHandler;

import com.fasterxml.jackson.databind.ser.PropertyBuilder;

import groovy.util.ObservableMap.PropertyEvent;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Util {
	public static RequestSpecification req;
	ResponseSpecification p2;
	// Generic method for Google API Request  
	public RequestSpecification Requestspec() throws IOException {
		if (req==null) {
		PrintStream print1= new PrintStream(new FileOutputStream("logging.txt"));
		         req=new RequestSpecBuilder().setBaseUri(prop("baseurl")).
       		addHeader("Content-Type", "application/json").addQueryParam("key", "qaclick123").
       		addFilter(RequestLoggingFilter.logRequestTo(print1)).
       		addFilter(ResponseLoggingFilter.logResponseTo(print1)).build();
		 return req;
		}
		return req; 
	}
	
	// Generic method for Google API Response
	public ResponseSpecification Resposespec() {

		ResponseSpecification p2= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        return p2;
       
	}
	
		// To read the data from property file
	public  String prop(String Stragr1) throws IOException {
	Properties prop= new Properties();
	File fl= new File("C:\\Users\\vandy\\GoogleAPI\\src\\test\\java\\Global.properties");
	FileInputStream inputfile= new FileInputStream(fl);
	prop.load(inputfile);
	return prop.getProperty(Stragr1).toString();
	
	}
	// To parse the response
	public JsonPath parseresponse(Response rsp) {
		JsonPath js= new JsonPath(rsp.asString());
		return js;
	
	}
}
