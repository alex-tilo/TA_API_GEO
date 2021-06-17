package core;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utilities {
	
	ObjectMapper mapper = new ObjectMapper();
	
    public Map<String,Object> readJSONFileAsMap(String api, String type) throws Exception {
    	String path = "src/test/resources";
    	String file = type;
    	String ext = ".json";
    	return mapper.readValue(new File(path + "/" + api + "/" + file + ext), new TypeReference<Map<String, Object>>() {	   	 
    	});
   }
    
    public String readJSONFileAsString(String api) throws Exception {
    	String path = "src/test/resources";
    	String payload = "payload";
    	String ext = ".json";
        return new String(Files.readAllBytes(Paths.get(path + "/" + api + "/" + payload + ext)));
    }
    
    public String readJSONFileAsStringEH(String api) throws Exception {
    	String path = "src/test/resources";
    	String payload = "payload_bl";
    	String ext = ".json";
        return new String(Files.readAllBytes(Paths.get(path + "/" + api + "/" + payload + ext)));
    }
    
    public String readJSONFile(String api, String payload) throws Exception {
    	String path = "src/test/resources";
        return new String(Files.readAllBytes(Paths.get(path + "/" + api + "/" + payload)));
    }
    
    public String readTextFileAsString(String api) throws Exception {
    	String path = "src/test/resources";
    	String body = "body";
    	String ext = ".txt";
        return new String(Files.readAllBytes(Paths.get(path + "/" + api + "/" + body + ext))).trim();
    }
    
    public String getKey(String key) throws Exception {
    	String path = System.getProperty("user.dir");
    	String ext = ".txt";
        return new String(Files.readAllBytes(Paths.get(path + "/" + key + ext))).trim();
    }
    public String getToken(String token) throws Exception {
    	String path = System.getProperty("user.dir");
    	String ext = ".txt";
        return new String(Files.readAllBytes(Paths.get(path + "/" + token + ext))).trim();
    }


    public void writeConfig(String url, String port, String timeout, int statusCode) {
    System.out.println();
    System.out.println("===============================================");
    System.out.println("URI:\t\t" 			+ url);
    System.out.println("Port:\t\t" 			+ port);
    System.out.println("Timeout:\t" 		+ timeout);
    System.out.println("Status Code:\t" 	+ statusCode);
    System.out.println("===============================================");
    }
    
    public void writeFile(String fileName, String str) throws IOException {
    			String path = System.getProperty("user.dir");
    		    BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/" + fileName, false));
    		    writer.write(str); writer.close();
    		}
    public void write2File(String fileName, String str) throws IOException {
    	String path = System.getProperty("user.dir");
        Files.write( Paths.get(path + "/" + fileName), str.getBytes());
	}
}
