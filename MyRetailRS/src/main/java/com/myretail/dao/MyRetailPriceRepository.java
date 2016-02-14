/**
 * 
 */
package com.myretail.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.myretail.entities.CurrentPrice;

/**
 * The repository for the MongoDb data store
 * 
 * @author jayakrishnan.s
 *
 */
public interface MyRetailPriceRepository extends Repository<CurrentPrice,String>{
	
	Optional<CurrentPrice> findByTcin(String id);
	
	CurrentPrice save(CurrentPrice currentPrice);
	
	List<CurrentPrice> findAll();
	
	void delete(CurrentPrice currentPrice);

}
