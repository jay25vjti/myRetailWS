package com.myretail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * This config helps launch the application
 * @author Jayakrishnan S
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MyRetailConfig {
	
	 /**
	  * Launches the application
	  * 
	 * @param args
	 */
	public static void main(String[] args) {
	        SpringApplication.run(MyRetailConfig.class, args);
	    }

}
