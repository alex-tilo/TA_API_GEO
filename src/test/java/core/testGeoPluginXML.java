package core;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.*;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.*;

public class testGeoPluginXML {
	
	String environment 	= null;
	String config 		= "config.properties";
	String api 			= "xml.gp";
	
	Utilities u = new Utilities();
	
	Properties p = new Properties();
	Response response = null;
	static String url;
	static String path;
	static String port;
	static String timeout;
	
	static String ip;
	
	private void setup(String config, String environment) throws FileNotFoundException, IOException {
		  
		p.load(new FileInputStream(config));	 
			url 					= p.getProperty("url");
			path 					= p.getProperty("path");
			port 	  				= p.getProperty("port");
			timeout 				= p.getProperty("timeout");
	
			RestAssured.baseURI 	= url;
			RestAssured.basePath 	= path;
			RestAssured.port 		= Integer.parseInt(port);
	}

	@Test(enabled = true, priority = 1, description = "GEO Validation XML")
	@Description(
					"<b>URI: </b> http://www.geoplugin.net/xml.gp <br />" + 
					"<b>Port: </b> 80 <br />"
				)
	public void geoPluginXML() throws Exception {
		
		setup(config, environment);
	    try {
		response = given()
				.headers(u.readJSONFileAsMap(api, "header"))
				.filter(new AllureRestAssured())
		
		.when()
				.get(api);
		response.then()
				.log().headers()
				.log().body()
				.assertThat()
				.time(lessThan(Long.valueOf(timeout)), TimeUnit.MILLISECONDS)
				.and()
				.statusCode(200)
				.and()
				.header("content-type", "application/xml; charset=utf-8")
				.and()
				.body("geoPlugin.geoplugin_status", equalTo("200"))
				.and()
				.body(matchesXsdInClasspath(api + "/schema.xsd"))	
				.extract().response();
		System.out.println();
		System.out.println(response.xmlPath().get("geoPlugin.geoplugin_request").toString());
	    }
    	catch (Exception e) {e.printStackTrace();}
    	finally {u.writeConfig(url, port, timeout, response.getStatusCode());}
}
}
