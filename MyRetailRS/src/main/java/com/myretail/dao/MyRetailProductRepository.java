/**
 * 
 */
package com.myretail.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.myretail.entities.MyRetail;

/**
 * @author jayakrishnan.s
 *
 */
public interface MyRetailProductRepository extends Repository<MyRetail,String>{
	

	Optional<MyRetail> findByTcin(String id);
	
	MyRetail save(MyRetail myProduct);
	
	List<MyRetail> findAll();
	
	void delete(MyRetail myProduct);

}
