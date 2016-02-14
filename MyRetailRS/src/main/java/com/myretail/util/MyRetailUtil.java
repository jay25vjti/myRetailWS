/**
 * 
 */
package com.myretail.util;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myretail.dto.CurrentPriceDTO;
import com.myretail.dto.MyRetailDTO;
import com.myretail.es.dto.ESResponse;
import com.myretail.es.dto.Identifier;
import com.myretail.es.dto.Items;
import com.myretail.es.dto.Product_composite_response;

/**
 * Utility class
 * 
 * @author jayakrishnan.s
 *
 */
public class MyRetailUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRetailUtil.class);
	
	/**
	 * Helper to combine ES response and Price details from DS
	 * 
	 * @param eSResponse
	 * @param dbEntry
	 * @return MyRetailDTO
	 */
	public MyRetailDTO getProductAggregate(ESResponse eSResponse, CurrentPriceDTO dbEntry){
		
		LOGGER.debug("Invoked MyRetailUtil.getProductAggregate method. with CurrentPriceDTO "+dbEntry);
		
		MyRetailDTO dto = new MyRetailDTO();
		 Product_composite_response productComposite = eSResponse.getProduct_composite_response();
		 Items[] items = productComposite.getItems();
		 Identifier[] identifiers = items[0].getIdentifier();
		 
		 for(Identifier identifier : identifiers){
			 if("TCIN".equalsIgnoreCase(identifier.getId_type())){
				 LOGGER.debug("MyRetailUtil.getProductAggregate method.TCIN found for item "+items[0]);
				 dto.setId(identifier.getId());
			 }
		 }
		 dto.setName(items[0].getOnline_description().getValue());
		 dto.setCurrent_price(dbEntry);
		 
		 LOGGER.debug("Leaving MyRetailUtil.getProductAggregate method. with MyRetailDTO "+dto);
		return dto;
	}
	
	/**
	 * Helper to combine ES response and Price details from DS
	 * 
	 * @param eSResponse
	 * @param dbEntry
	 * @return MyRetailDTO
	 */
	public MyRetailDTO getProductAggregate(MyRetailDTO myRetailDTO, CurrentPriceDTO dbEntry){
		
		LOGGER.debug("Invoked MyRetailUtil.getProductAggregate method. with CurrentPriceDTO "+dbEntry);
		myRetailDTO.setCurrent_price(dbEntry);
		
		 
		 LOGGER.debug("Leaving MyRetailUtil.getProductAggregate method. with MyRetailDTO "+myRetailDTO);
		return myRetailDTO;
	}
	
	public boolean isValidESResponse(ESResponse eSResponse){
		
		LOGGER.debug("Invoked MyRetailUtil.isValidESResponse method");
		if(null == eSResponse){
			LOGGER.error("MyRetailUtil.isValidESResponse method. ES response is null");
			return false;
		}
		
		Items[] items = eSResponse.getProduct_composite_response().getItems();
		for(Items item: items){
			
			if((null != item.getErrors()) && (item.getErrors().length != 0)){
				LOGGER.info("MyRetailUtil.isValidESResponse method. Error item received from ES - "+item);
				return false;
			}
			
		}
		
		LOGGER.debug("Leaving MyRetailUtil.isValidESResponse method");
		return true;
	}
	
	public boolean isValidESResponse(MyRetailDTO myRetailDTO){
		
		LOGGER.debug("Invoked MyRetailUtil.isValidDBResponse method");
		
		if(null == myRetailDTO){
			LOGGER.error("MyRetailUtil.isValidDBResponse method. Product DB response is null");
			return false;
		}
		else if(null == myRetailDTO.getId()){
			LOGGER.error("MyRetailUtil.isValidDBResponse method. Product DB response is null");
			return false;
		}
		
		LOGGER.debug("Leaving MyRetailUtil.isValidDBResponse method");
		return true;
	}
	
	public List<MyRetailDTO> mergeDto(List<MyRetailDTO> dtos, List<CurrentPriceDTO> priceDtos){
		
		for(MyRetailDTO dto : dtos){
			CurrentPriceDTO priceDto = getPriceDto(dto.getId(), priceDtos);
			dto.setCurrent_price(priceDto);
		}
		
		return dtos;
	}
	
	private CurrentPriceDTO getPriceDto(String id, List<CurrentPriceDTO> priceDtos){
		
		CurrentPriceDTO dto = null;
		
		for(CurrentPriceDTO priceDto : priceDtos){
			if(id.equalsIgnoreCase(priceDto.getTcin())){
				dto = priceDto;
				break;
			}
		}
		
		return dto;
	}
	
	public boolean isReqAUthorized(String token){
		
		//ideally this token should come from a secure DS and  decrypted
		//hard coded here for simplicity
		if("myRetailToken".equalsIgnoreCase(token))
		return true;
		
		return false;
	}
	
	

}
