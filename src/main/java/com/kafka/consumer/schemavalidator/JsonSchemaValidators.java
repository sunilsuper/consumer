package com.kafka.consumer.schemavalidator;




import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;  
  
// create class to validate JSON document  
public class JsonSchemaValidators {
    // main() method start  
    public static void validateJson( InputStream jsonStreamdata ) throws Exception {  
          
        // create instance of the ObjectMapper class  
        ObjectMapper objectMapper = new ObjectMapper();  
        InputStream jsonStream=jsonStreamdata;
        InputStream schemaStream=null;
        // create an instance of the JsonSchemaFactory using version flag  
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance( SpecVersion.VersionFlag.V201909 );  
          
        // store the JSON data in InputStream  
        try {
                 // InputStream jsonStream = inputStreamFromClasspath("C:\\Users\\sunil.gopalghare\\eclipse-workspace_kafka\\consumer\\data.json");  
        	     //File initialFile = new File("C:\\Users\\sunil.gopalghare\\eclipse-workspace_kafka\\consumer\\data.json");
        	     // jsonStream = FileUtils.openInputStream(initialFile);
        		 //InputStream schemaStream = inputStreamFromClasspath("C:\\Users\\sunil.gopalghare\\eclipse-workspace_kafka\\consumer\\schema.json");
        	   File initialFile2 = new File("C:\\Users\\sunil.gopalghare\\eclipse-workspace_kafka\\consumer\\schema.json");
        	     schemaStream = new DataInputStream(new FileInputStream(initialFile2));
        				
        }catch(Exception e)
        {}
        {  
              
            // read data from the stream and store it into JsonNode  
            JsonNode json = objectMapper.readTree(jsonStream);  
              
            // get schema from the schemaStream and store it into JsonSchema  
            JsonSchema schema = schemaFactory.getSchema(schemaStream);  
              
            // create set of validation message and store result in it  
            Set<ValidationMessage> validationResult = schema.validate( json );  
       
            // show the validation errors   
            if (validationResult.isEmpty()) {  
                  
                // show custom message if there is no validation error   
                System.out.println( "There is no validation errors" );  
              
            } else {  
                  
            	for (ValidationMessage vm : validationResult) {
            		System.out.println(vm.getMessage());
				}
                // show all the validation error  
                
                
            }  
        }  
    }  
}  