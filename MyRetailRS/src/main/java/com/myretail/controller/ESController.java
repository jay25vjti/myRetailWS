package com.myretail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.dto.MyRetailDTO;
import com.myretail.service.MyRetailDBService;

/**
 * Resource provides RESTful service that can retrieve product details by ID.
 * This is a dummy to actual ES
 * 
 * @author jayakrishnan.s
 *
 */
@RestController
@RequestMapping("/products")
public class ESController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ESController.class);
	
	@Autowired
	private MyRetailDBService dbService;
	
	/**
	  * Resource to find a product by id alone.
	  * It searches both product from ES and price details based on 
	  * id as input and provides combined response
	  * 
	 * @param id
	 * @return MyRetailDTO
	 */
	@RequestMapping(value = "/v3/{id}", method = RequestMethod.GET)
	 MyRetailDTO findById(@PathVariable("id") String id) {
		
	        LOGGER.info("Invoked local ES findById with id: {}", id);
	        
	        MyRetailDTO response = dbService.findProductById(id);
	        
	        return response;
	    }

}
