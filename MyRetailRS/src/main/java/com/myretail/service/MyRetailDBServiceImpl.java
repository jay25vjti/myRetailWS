/**
 * 
 */
package com.myretail.service;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.dao.MyRetailPriceRepository;
import com.myretail.dao.MyRetailProductRepository;
import com.myretail.dto.CurrentPriceDTO;
import com.myretail.dto.MyRetailDTO;
import com.myretail.entities.CurrentPrice;
import com.myretail.entities.MyRetail;
import com.myretail.exception.MyRetailException;
import com.myretail.util.MyRetailUtil;


/**
 * Service layer for all DB interactions for CURD
 * 
 * @author jayakrishnan.s
 *
 */
@Service
public class MyRetailDBServiceImpl implements MyRetailDBService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRetailDBServiceImpl.class);
	
	private final MyRetailPriceRepository priceRepository;
	
	private final MyRetailProductRepository productRepository;
	
	 @Autowired
	 MyRetailDBServiceImpl(MyRetailPriceRepository repository, MyRetailProductRepository productRepository){
		 this.priceRepository = repository;
		 this.productRepository = productRepository;
	 }

	/* (non-Javadoc)
	 * @see com.myretail.service.MyRetailService#findById(java.lang.String)
	 */
	@Override
	public CurrentPriceDTO findPriceById(String id) {
		
		LOGGER.debug("Invoked MyRetailDBService.findPriceById method with id: {}", id);
		
		CurrentPrice currentPrice = findCurrentPriceById(id);
		
		LOGGER.debug("Leaving MyRetailDBService.findPriceById method with currentPrice: {}", currentPrice);
		
		return convertToDTO(currentPrice);
	}
	
	/* (non-Javadoc)
	 * @see com.myretail.service.MyRetailService#findById(java.lang.String)
	 */
	@Override
	public MyRetailDTO findProductById(String id) {
		
		LOGGER.debug("Invoked MyRetailDBService.findProductById method with id: {}", id);
		
		MyRetail currentProduct = findRetailProductById(id);
		
		LOGGER.debug("Leaving MyRetailDBService.findProductById method with MyRetail: {}", currentProduct);
		return convertMyRetailToDTO(currentProduct);
	}
	

	/* (non-Javadoc)
	 * @see com.myretail.service.MyRetailService#update(com.myretail.dto.MyRetailDTO)
	 */
	@Override
	public CurrentPriceDTO updatePrice(MyRetailDTO myRetailDTO) {
		
		LOGGER.debug("Invoked MyRetailDBService.updatePrice method with myRetailDTO: {}", myRetailDTO);
		CurrentPrice currentPrice = findCurrentPriceById(myRetailDTO.getId());
		
		currentPrice.setPrice(myRetailDTO.getCurrent_price().getValue());
		currentPrice.setCurrencyCd(myRetailDTO.getCurrent_price().getCurrency_code());
		
		currentPrice = priceRepository.save(currentPrice);
		LOGGER.info("Updated entry with information: {}", currentPrice);
		LOGGER.debug("Leaving MyRetailDBService.updatePrice method with currentPrice: {}", currentPrice);
		return convertToDTO(currentPrice);
	}
	
	
	/**
	 * Helper to get DS entry for an id
	 * 
	 * @param id
	 * @return
	 */
	private CurrentPrice findCurrentPriceById(String id){
		Optional<CurrentPrice> result = priceRepository.findByTcin(id);
		return result.orElseThrow(() -> new MyRetailException(id));
		
	}
	
	/**
	 * Helper to get DS entry for an id
	 * 
	 * @param id
	 * @return
	 */
	private MyRetail findRetailProductById(String id){
		Optional<MyRetail> result = productRepository.findByTcin(id);
		return result.orElseThrow(() -> new MyRetailException(id));
		
	}
	
	 /**
	  * Helper to convert a single DS entry to a DTO for resource usage
	  * 
	 * @param model
	 * @return
	 */
	private CurrentPriceDTO convertToDTO(CurrentPrice model) {
		
		 CurrentPriceDTO dto = new CurrentPriceDTO();
	        dto.setValue(model.getPrice());
	        dto.setCurrency_code(model.getCurrencyCd());
	        dto.setTcin(model.getTcin());

	        return dto;
	    }
	
	/**
	  * Helper to convert a single DS entry to a DTO for resource usage
	  * 
	 * @param model
	 * @return
	 */
	private MyRetailDTO convertMyRetailToDTO(MyRetail model) {
		
		MyRetailDTO dto = new MyRetailDTO();
	        dto.setId(model.getTcin());
	        dto.setName(model.getName());
	        return dto;
	    }
	 
	 /**
	  * Helper to convert a list of DS entries to DTO list for resource usage
	  * 
	 * @param models
	 * @return
	 */
	private List<CurrentPriceDTO> convertToDTOs(List<CurrentPrice> models) {
	        return models.stream()
	                .map(this::convertToDTO)
	                .collect(toList());
	    }
	
	/**
	  * Helper to convert a list of DS entries to DTO list for resource usage
	  * 
	 * @param models
	 * @return
	 */
	private List<MyRetailDTO> convert(List<MyRetail> models) {
		return models.stream()
                .map(this::convertMyRetailToDTO)
                .collect(toList());
	    }

	/* (non-Javadoc)
	 * @see com.myretail.service.MyRetailDBService#create(com.myretail.dto.MyRetailDTO)
	 */
	@Override
	public MyRetailDTO create(MyRetailDTO myRetailDTO) {
		
		LOGGER.debug("Invoked MyRetailDBService.create method with myRetailDTO: {}", myRetailDTO);
		//create local product
		MyRetail myRetail = new MyRetail(myRetailDTO.getId(), myRetailDTO.getName());
		myRetail = productRepository.save(myRetail);
		MyRetailDTO dto = convertMyRetailToDTO(myRetail);
		//create local price
		CurrentPrice currentPrice = new CurrentPrice(myRetailDTO.getId(), myRetailDTO.getCurrent_price().getValue(), myRetailDTO.getCurrent_price().getCurrency_code());
		currentPrice = priceRepository.save(currentPrice);
		dto.setCurrent_price(convertToDTO(currentPrice));
		
		LOGGER.debug("Leaving MyRetailDBService.create method with dto: {}", dto);
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.myretail.service.MyRetailDBService#delete(java.lang.String)
	 */
	@Override
	public MyRetailDTO delete(String id) {
		
		LOGGER.debug("Invoked MyRetailDBService.delete method with id: {}", id);
		
		MyRetail myRetail = findRetailProductById(id);
		productRepository.delete(myRetail);
		CurrentPrice currentPrice = findCurrentPriceById(id);
		priceRepository.delete(currentPrice);
		MyRetailDTO productDto = convertMyRetailToDTO(myRetail);
		CurrentPriceDTO priceDto =  convertToDTO(currentPrice);
		productDto.setCurrent_price(priceDto);
		LOGGER.debug("Leaving MyRetailDBService.delete method with productDto: {}", productDto);
		return productDto;
	}

	/* (non-Javadoc)
	 * @see com.myretail.service.MyRetailDBService#findAll()
	 */
	@Override
	public List<MyRetailDTO> findAll() {
		
		LOGGER.debug("Invoked MyRetailDBService.findAll method");
		
		List<MyRetail> dbProducts = productRepository.findAll();
		List<CurrentPrice> currentPrices = priceRepository.findAll();
		List<MyRetailDTO> dtos = convert(dbProducts);
		List<CurrentPriceDTO> priceDtos = convertToDTOs(currentPrices);
		MyRetailUtil util = new MyRetailUtil();
		dtos = util.mergeDto(dtos, priceDtos);
		
		LOGGER.debug("leaving MyRetailDBService.findAll method");
		return dtos;
	}

}
