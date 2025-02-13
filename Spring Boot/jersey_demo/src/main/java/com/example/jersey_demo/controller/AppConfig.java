package com.example.jersey_demo.controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		packages("com.example.jersey_demo");
	}
	
}
