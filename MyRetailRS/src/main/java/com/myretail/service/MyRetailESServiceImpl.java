/**
 * 
 */
package com.myretail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myretail.constants.MyRetailConstants;
import com.myretail.dto.MyRetailDTO;
import com.myretail.es.dto.ESResponse;

/**
 * Service layer for external ES interactions
 * 
 * @author jayakrishnan.s
 *
 */

@Service
public class MyRetailESServiceImpl implements MyRetailESService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRetailESServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.myretail.service.MyRetailESService#getProductDetails(java.lang.String, java.lang.String)
	 */
	public ESResponse getProductDetails(String id, String idType){
	
		LOGGER.info("Invoked MyRetailESService.getProductDetails with id {} and type {}", id, idType);
		
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
		ESResponse esResp = restTemplate.getForObject("http://api.target.com/products/v3/"+id+"?fields=descriptions&id_type="+idType+"&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz", ESResponse.class);
		LOGGER.debug("Leaving MyRetailESService.getProductDetails with id {} and type {}", id, idType);
		return esResp;
	}
	
	/**
	 * An HttpClient for controlling the connection and read time outs
	 * 
	 * @return ClientHttpRequestFactory
	 */
	private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(MyRetailConstants.ES_READ_TIMEOUT);
        factory.setConnectTimeout(MyRetailConstants.ES_CONNECTION_TIMEOUT);
        return factory;
    }

	@Override
	public MyRetailDTO findProductById(String id) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("TOKEN", "myRetailToken");
		HttpEntity entity = new HttpEntity(headers);
		
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
		
		HttpEntity<MyRetailDTO> response = restTemplate.exchange(
				"http://localhost:8080/products/v3/"+id, HttpMethod.GET, entity, MyRetailDTO.class);
		
		return response.getBody();
	}

}
