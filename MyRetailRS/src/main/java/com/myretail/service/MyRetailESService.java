/**
 * 
 */
package com.myretail.service;

import com.myretail.dto.MyRetailDTO;
import com.myretail.es.dto.ESResponse;

/**
 * @author jayakrishnan.s
 *
 */
public interface MyRetailESService {
	
	/**
	 * Invoke ES with id and retrieve product details
	 * 
	 * @param id
	 * @param idType
	 * @return ESResponse
	 */
	public ESResponse getProductDetails(String id, String idType);
	
	public MyRetailDTO findProductById(String id);

}
