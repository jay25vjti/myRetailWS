package com.myretail.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.nio.charset.Charset;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.myretail.constants.MyRetailConstants;
import com.myretail.controller.MyRetailController;
import com.myretail.dto.CurrentPriceDTO;
import com.myretail.dto.MyRetailDTO;
import com.myretail.es.dto.ESResponse;
import com.myretail.es.dto.Items;
import com.myretail.es.dto.Identifier;
import com.myretail.es.dto.Product_composite_response;
import com.myretail.exception.MyRetailException;
import com.myretail.service.MyRetailDBService;
import com.myretail.service.MyRetailESService;
import com.myretail.service.MyRetailService;
import com.myretail.util.MyRetailValidator;

@RunWith(MockitoJUnitRunner.class)
public class MyRetailControllerTest {
	
	private static final String ID = "13860428";
    private static final String NAME = "The Big Lebowski";
    private static final String VALUE = "13.00";
    private static final String CURRENCY_CODE = "USD";

	private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );
	
	@Mock
	private  MyRetailDBService dbService;
	@Mock
	private  MyRetailESService esService;
	@Mock
	private  MyRetailService service;
	@Mock
	private MyRetailValidator validator;
	
	private MockMvc mockMvc;
	
	 @Before
	    public void setUp() {
	        mockMvc = MockMvcBuilders.standaloneSetup(new MyRetailController())
	                .build();
	    }
	 
	  @Test
	  @Ignore
	    public void findById_EntryFound_ShouldReturnformationOfFoundEntryAsJson() throws Exception {
		  
		  MyRetailDTO myRetailDTO = new MyRetailDTO();
		  CurrentPriceDTO currentPriceDTO = new CurrentPriceDTO();
		  currentPriceDTO.setCurrency_code(CURRENCY_CODE);
		  currentPriceDTO.setValue(VALUE);
		  myRetailDTO.setCurrent_price(currentPriceDTO);
		  myRetailDTO.setId(ID);
		  myRetailDTO.setName(NAME);
		  
		  ESResponse eSResponse = new ESResponse();
		  Product_composite_response product_composite_response = new Product_composite_response();
		  Items[] items = new Items[1];
		  Identifier[] identifier = new Identifier[1];
		  Identifier anIdentifier = new Identifier();
		  anIdentifier.setId(ID);
		  anIdentifier.setId_type(MyRetailConstants.TCIN);
		  identifier[0] = anIdentifier;
		  Items item = new Items();
		  item.setIdentifier(identifier);
		  items[0] = item;
		  product_composite_response.setItems(items);
		  eSResponse.setProduct_composite_response(product_composite_response);
		  
		  
		  when(esService.getProductDetails(ID, MyRetailConstants.TCIN)).thenReturn(eSResponse);
		  Mockito.doNothing().when(validator).doESValidation(null, ID);
		  Mockito.doNothing().when(validator).validate(ID,null);
		  when(dbService.findPriceById(ID)).thenReturn(currentPriceDTO);
	        when(service.findById(ID)).thenReturn(myRetailDTO);
	      
	        
	        
	        
	       

	        mockMvc.perform(get("/products/{id}", ID))
	                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
	                .andExpect(jsonPath("$.id", is(ID)))
	                .andExpect(jsonPath("$.name", is(NAME)));
	    }
	
}
