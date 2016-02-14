/**
 * 
 */
package com.myretail.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myretail.constants.MyRetailConstants;
import com.myretail.dto.MyRetailDTO;
import com.myretail.es.dto.ESResponse;
import com.myretail.es.dto.Items;
import com.myretail.service.MyRetailESService;

/**
 * Custom data validator framework
 * 
 * @author jayakrishnan.s
 *
 */
@Component
public class MyRetailValidator implements Validator{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRetailValidator.class);
	
	
	private MyRetailESService esService;
	
	@Autowired
	public MyRetailValidator(MyRetailESService esService){
		this.esService = esService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return MyRetailDTO.class.equals(clazz) || String.class.equals(clazz);
	}

	@Override
	public void validate(Object req, Errors errors) {
		
		LOGGER.info("inside validate method of MyRetailValidator");
		
		if(req instanceof String){
			doESValidation(errors, (String)req);
			
		}else if(req instanceof MyRetailDTO){
			ValidationUtils.rejectIfEmpty(errors, "id", "id.empty");
			
		
		MyRetailDTO myRetailDTO = (MyRetailDTO)req;
		
		//do some custom validation on request as business case is
		String id = myRetailDTO.getId();
		
		try{
		Integer.parseInt(id);
		}catch(NumberFormatException nbe){
			errors.rejectValue("id", "Id should be numeric");
		}
		
		doESValidation(errors, id);
	}
	}

	/**
	 * Helper to get see if valid ES item
	 * This is just to show custom validation possibility and
	 * we should not be invoking ES twice over here and again in service
	 * 
	 * @param errors
	 * @param id
	 */
	public void doESValidation(Errors errors, String id) {
		ESResponse eSResponse = esService.getProductDetails(id, MyRetailConstants.TCIN);
		if(null == eSResponse){
			errors.reject("Internal Error");
		}
		
		Items[] items = eSResponse.getProduct_composite_response().getItems();
		for(Items item: items){
			
			if((null != item.getErrors()) && (item.getErrors().length != 0)){
				//errors.rejectValue("id", "Valid.MyRetailDTO.id");
				errors.reject("Invalid ID");
			}
			
		}
	}

}
