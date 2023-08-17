package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.pojo.EmployeeDetails;


public class JsonToObjectMapper {
	 private static final Logger log = LoggerFactory.getLogger(JsonToObjectMapper.class);
	public static void EmployeeObjMapper(String s) 
	{
		ObjectMapper Obj = new ObjectMapper(); 
		EmployeeDetails	empljsonStr;
	try {
			empljsonStr =Obj.readValue(s, EmployeeDetails.class);
			log.info("You can save this object in any DB: "+empljsonStr.getEmpDet());
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
