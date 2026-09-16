package com.SpringBootProfileApplication.Profiles.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("PROD")   // Must be point first to the spring.profiles.active=DEV 
public class ServiceClass {

	@Value("${app.username}")
	String userName;
	
	
	public String getProperties(){
		return userName;
	}
	
}
