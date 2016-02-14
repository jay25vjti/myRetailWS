/**
 * 
 */
package com.myretail.service;

import com.myretail.dto.MyRetailDTO;

/**
 * @author jayakrishnan.s
 *
 */
public interface MyRetailService {
	
	MyRetailDTO findById(String id);
	
	MyRetailDTO update(MyRetailDTO myRetailDTO);
	
	MyRetailDTO findMyProductById(String id);
	
	MyRetailDTO updateMyProduct(MyRetailDTO myRetailDTO);

}
