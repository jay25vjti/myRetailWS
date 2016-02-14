/**
 * 
 */
package com.myretail.service;

import java.util.List;

import com.myretail.dto.CurrentPriceDTO;
import com.myretail.dto.MyRetailDTO;

/**
 * This interface declares the methods that provides CRUD operations for
 * {@link com.javaadvent.bootrest.todo.Todo} objects.
 * @author jayakrishnan.s
 */
public interface MyRetailDBService {

	/**
	 * Find a DS entry corresponding to id
	 * 
	 * @param id
	 * @return
	 */
	CurrentPriceDTO findPriceById(String id);
	
	/**
	 * Find a DS entry corresponding to id
	 * 
	 * @param id
	 * @return
	 */
	MyRetailDTO findProductById(String id);

	/**
	 * Update a DS entry 
	 * 
	 * @param myRetailDTO
	 * @return
	 */
	CurrentPriceDTO updatePrice(MyRetailDTO myRetailDTO);
	
	/**
	 * create a DS entry
	 * 
	 * @param myRetailDTO
	 * @return
	 */
	MyRetailDTO create(MyRetailDTO myRetailDTO);
	
	/**
	 * Delete a DS entry
	 * 
	 * @param id
	 * @return
	 */
	MyRetailDTO delete(String id);
	
	/**
	 * Retrieve all DS entries
	 * 
	 * @return
	 */
	List<MyRetailDTO> findAll();

}
