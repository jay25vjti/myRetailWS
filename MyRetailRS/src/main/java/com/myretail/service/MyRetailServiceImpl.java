package com.myretail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.constants.MyRetailConstants;
import com.myretail.dto.CurrentPriceDTO;
import com.myretail.dto.MyRetailDTO;
import com.myretail.es.dto.ESResponse;
import com.myretail.exception.InvalidProductException;
import com.myretail.exception.MyRetailException;
import com.myretail.util.MyRetailUtil;

/**
 * @author jayakrishnan.s
 *
 */

@Service
public class MyRetailServiceImpl implements MyRetailService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRetailServiceImpl.class);
	
	@Autowired
	private MyRetailDBService dbService;
	
	@Autowired
	private MyRetailESService esService;

	@Override
	public MyRetailDTO findById(String id) {
		
		LOGGER.debug("Finding entry in Service with id: {}", id);
        ESResponse eSResponse = esService.getProductDetails(id, MyRetailConstants.TCIN);
        MyRetailUtil util = new MyRetailUtil();
        if(!util.isValidESResponse(eSResponse)){
        	throw new InvalidProductException(id);
        }
        CurrentPriceDTO dbEntry = dbService.findPriceById(id);
        LOGGER.debug("Found db entry with information: {}", dbEntry);

        
        MyRetailDTO response = util.getProductAggregate(eSResponse, dbEntry);
        
        LOGGER.debug("Returning entry in Service with MyRetailDTO: {}", response);
        
		return response;
	}

	@Override
	public MyRetailDTO update(MyRetailDTO myRetailDTO) {
		
		 LOGGER.debug("Updating db entry with information: {}", myRetailDTO);
		 MyRetailUtil util = new MyRetailUtil();
	        ESResponse eSResponse = esService.getProductDetails(myRetailDTO.getId(), MyRetailConstants.TCIN);
	        if(!util.isValidESResponse(eSResponse)){
	        	throw new InvalidProductException(myRetailDTO.getId());
	        }

	        CurrentPriceDTO dbEntry = dbService.updatePrice(myRetailDTO);
	        LOGGER.debug("Updated db entry with information: {}", dbEntry);

	       
	        MyRetailDTO response = util.getProductAggregate(eSResponse, dbEntry);
	        
	        return response;
	}

	@Override
	public MyRetailDTO findMyProductById(String id) {
		
		LOGGER.debug("Finding entry in Service with id: {}", id);
		
		MyRetailUtil util = new MyRetailUtil();
		MyRetailDTO myRetailDTO = esService.findProductById(id);
        LOGGER.debug("Found es local entry with information: {}", myRetailDTO);
        
        if(!util.isValidESResponse(myRetailDTO)){
        	throw new InvalidProductException(id);
        }
		
		CurrentPriceDTO dbEntry = dbService.findPriceById(id);
        LOGGER.debug("Found db entry with information: {}", dbEntry);
        
        MyRetailDTO response = util.getProductAggregate(myRetailDTO, dbEntry);
		
		return response;
	}

	@Override
	public MyRetailDTO updateMyProduct(MyRetailDTO myRetailDTO) {
		
		LOGGER.debug("Updating db entry with information: {}", myRetailDTO);
		 MyRetailUtil util = new MyRetailUtil();
		 MyRetailDTO dto = esService.findProductById(myRetailDTO.getId());
		 
		 if(!util.isValidESResponse(myRetailDTO)){
	        	throw new InvalidProductException(myRetailDTO.getId());
	        }
	        CurrentPriceDTO dbEntry = dbService.updatePrice(myRetailDTO);
	        LOGGER.debug("Updated db entry with information: {}", dbEntry);

	       
	        MyRetailDTO response = util.getProductAggregate(dto, dbEntry);
	        
	        return response;
	}

}
