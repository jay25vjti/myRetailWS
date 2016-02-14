package com.myretail.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.constants.MyRetailConstants;
import com.myretail.dto.CurrentPriceDTO;
import com.myretail.dto.MyRetailDTO;
import com.myretail.es.dto.ESResponse;
import com.myretail.exception.InvalidProductException;
import com.myretail.exception.MyRetailException;
import com.myretail.service.MyRetailDBService;
import com.myretail.service.MyRetailESService;
import com.myretail.service.MyRetailService;
import com.myretail.util.MyRetailUtil;
import com.myretail.util.MyRetailValidator;


/**
 * Resource provides RESTful service that can retrieve product and price details by ID.
 * It also performs all CURD operations
 * 
 * @author jayakrishnan.s
 *
 */
@RestController
@RequestMapping("/myretail/products")
public class MyRetailController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRetailController.class);
	
	@Autowired
	private MyRetailDBService dbService;
	
	@Autowired
	private MyRetailService service;
	
	@Autowired
	private MyRetailValidator validator;
	
	@Autowired
	private MyRetailESService esService;
	
	/**
	 * bind the spring validator framework
	 * 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(new MyRetailValidator(esService));
	}
	
	 /**
	  * Resource to find a product by id alone.
	  * It searches both product from ES and price details based on 
	  * id as input and provides combined response
	  * 
	 * @param id
	 * @return MyRetailDTO
	 */
	@RequestMapping(value = "/v1/{id}", method = RequestMethod.GET)
	 MyRetailDTO findById(@PathVariable("id") @Validated(MyRetailValidator.class) String id) {
		
	        LOGGER.info("Invoked  findById with id: {}", id);
	        
	        MyRetailDTO response = service.findById(id);
	        
	        return response;
	    }
	
	/**
	  * Resource to find a product by id alone.
	  * It searches both product and price details from local DS based on 
	  * id as input and provides combined response
	  * 
	 * @param id
	 * @return MyRetailDTO
	 */
	@RequestMapping(value = "/v2/{id}", method = RequestMethod.GET)
	 MyRetailDTO findMyProductById(@PathVariable("id") @Validated(MyRetailValidator.class) String id) {
		
	        LOGGER.info("Invoked  findMyProductById with id: {}", id);
	        
	        MyRetailDTO response = service.findMyProductById(id);
	        
	        return response;
	    }


	    /**
	     * Resource to update a products price and currency code based on id
	     * 
	     * @param myRetailDTO
	     * @return MyRetailDTO
	     */
	    @RequestMapping(value = "/v1/{id}", method = RequestMethod.PUT)
	    MyRetailDTO update(@RequestBody @Valid MyRetailDTO myRetailDTO) {
	    	
	        LOGGER.info("Updating db entry with information: {}", myRetailDTO);
	        
	        MyRetailDTO response = service.update(myRetailDTO);
	        
	        return response;
	    }
	    
	    /**
	     * Resource to update a products in local DS based on id
	     * 
	     * @param myRetailDTO
	     * @return MyRetailDTO
	     */
	    @RequestMapping(value = "/v2/{id}", method = RequestMethod.PUT)
	    MyRetailDTO updateMyProduct(@RequestBody @Valid MyRetailDTO myRetailDTO) {
	    	
	        LOGGER.info("Updating product db entry with information: {}", myRetailDTO);
	        
	        MyRetailDTO response = service.updateMyProduct(myRetailDTO);
	        
	        return response;
	    }
	    
	    /**
	     * Helper resource to persist a product in data store
	     * 
	     * @param todoEntry
	     * @return CurrentPriceDTO
	     */
	    @RequestMapping(method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.CREATED)
	    MyRetailDTO create(@RequestBody @Valid MyRetailDTO myRetailDTO) {
	        LOGGER.info("Creating a new entry with information: {}", myRetailDTO);
	        MyRetailDTO created = dbService.create(myRetailDTO);
	        LOGGER.info("Created a new entry with information: {}", created);

	        return created;
	    }
	    

	    /**
	     * 
	     * Helper resource to delete a product from data store	     
	     *  
	     * @param id
	     * @return CurrentPriceDTO
	     */
	    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	    MyRetailDTO delete(@PathVariable("id") String id) {
	        LOGGER.info("Deleting entry with id: {}", id);

	        MyRetailDTO deleted = dbService.delete(id);
	        LOGGER.info("Deleted entry with information: {}", deleted);

	        return deleted;
	    }

	    /**
	     * Get all the products in data store
	     * 
	     * @return a list of products
	     */
	    @RequestMapping(method = RequestMethod.GET)
	    List<MyRetailDTO> findAll() {
	        LOGGER.info("Finding all entries");

	        List<MyRetailDTO> entries = dbService.findAll();
	        LOGGER.info("Found {} entries", entries.size());

	        return entries;
	    }

	    /**
	     * A global net to catch all exceptions
	     * 
	     * @param ex
	     */
	    @ExceptionHandler
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public void handleNotFound(MyRetailException ex) {
	        LOGGER.error("Handling error with message: {}", ex.getMessage());
	    }
	    
	    @ExceptionHandler
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void handleInvalidProduct(InvalidProductException ex) {
	        LOGGER.error("Product not configured in system {}", ex.getMessage());
	    }

}
