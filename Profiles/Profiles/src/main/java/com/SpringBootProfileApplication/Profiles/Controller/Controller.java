package com.SpringBootProfileApplication.Profiles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootProfileApplication.Profiles.Service.ServiceClass;

@RestController
@RequestMapping("/Profile")
public class Controller {
	
	@Autowired
	ServiceClass serviceClass;
	
	@GetMapping
	public String getProperties() {
		return serviceClass.getProperties();
	}

	
	

}
