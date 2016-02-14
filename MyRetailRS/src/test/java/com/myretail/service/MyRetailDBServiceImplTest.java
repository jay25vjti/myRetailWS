package com.myretail.service;

import static com.myretail.service.CurrentPriceDTOAssert.assertThatCurrentPriceDTO;
import static com.myretail.service.CurrentPriceAssert.assertThatCurrentPrice;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.myretail.dao.MyRetailPriceRepository;
import com.myretail.dao.MyRetailProductRepository;
import com.myretail.dto.CurrentPriceDTO;
import com.myretail.dto.MyRetailDTO;
import com.myretail.entities.CurrentPrice;
import com.myretail.entities.MyRetail;
import com.myretail.exception.MyRetailException;

@RunWith(MockitoJUnitRunner.class)
public class MyRetailDBServiceImplTest {
	
	private static final String ID = "13860428";
    private static final String NAME = "The Big Lebowski";
    private static final String VALUE = "13.00";
    private static final String CURRENCY_CODE = "USD";
	
	@Mock
	private  MyRetailPriceRepository priceRepository;
	
	@Mock
	private  MyRetailProductRepository productRepository;
	
	private MyRetailDBServiceImpl service;
	
	  @Before
	    public void setUp() {
	        this.service = new MyRetailDBServiceImpl(priceRepository, productRepository);
	    }
	  
	  @Test
	    public void create_ShouldSaveNewEntry() {
		  
		  MyRetailDTO myRetailDTO = new MyRetailDTO();
		  CurrentPriceDTO currentPriceDTO = new CurrentPriceDTO();
		  currentPriceDTO.setCurrency_code(CURRENCY_CODE);
		  currentPriceDTO.setValue(VALUE);
		  myRetailDTO.setCurrent_price(currentPriceDTO);
		  myRetailDTO.setId(ID);
		  myRetailDTO.setName(NAME);
		  
		  when(priceRepository.save(isA(CurrentPrice.class))).thenAnswer(invocation -> (CurrentPrice) invocation.getArguments()[0]);
		  when(productRepository.save(isA(MyRetail.class))).thenAnswer(invocation -> (MyRetail) invocation.getArguments()[0]);
		  
		  service.create(myRetailDTO);
		  
		  ArgumentCaptor<CurrentPrice> savedTodoArgument = ArgumentCaptor.forClass(CurrentPrice.class);
		  verify(priceRepository, times(1)).save(savedTodoArgument.capture());
	        verifyNoMoreInteractions(priceRepository);

	        CurrentPrice savedCurrentPrice = savedTodoArgument.getValue();
	        assertThatCurrentPrice(savedCurrentPrice).hasPrice(VALUE).hasCurrencyCd(CURRENCY_CODE);
	               
	  }
	  
	  @Test
	    public void create_ShouldReturnTheInformationOfCreatedEntry() {
		  
		  MyRetailDTO myRetailDTO = new MyRetailDTO();
		  CurrentPriceDTO currentPriceDTO = new CurrentPriceDTO();
		  currentPriceDTO.setCurrency_code(CURRENCY_CODE);
		  currentPriceDTO.setValue(VALUE);
		  myRetailDTO.setCurrent_price(currentPriceDTO);
		  myRetailDTO.setId(ID);
		  myRetailDTO.setName(NAME);

	        when(priceRepository.save(isA(CurrentPrice.class))).thenAnswer(invocation -> {
	        	CurrentPrice persisted = (CurrentPrice) invocation.getArguments()[0];
	            ReflectionTestUtils.setField(persisted, "id", ID);
	            return persisted;
	        });
	        
	        when(productRepository.save(isA(MyRetail.class))).thenAnswer(invocation -> {
	        	MyRetail persisted = (MyRetail) invocation.getArguments()[0];
	            ReflectionTestUtils.setField(persisted, "id", ID);
	            return persisted;
	        });

	        MyRetailDTO returned = service.create(myRetailDTO);

	        assertThatCurrentPriceDTO(returned.getCurrent_price())
	                .hasValue(VALUE)
	                .hascurrency_code(CURRENCY_CODE);
	    }
	  
	  @Test
	    public void delete_EntryFound_ShouldDeleteTheFoundEntry() {
		  CurrentPrice deleted = new CurrentPrice(ID, VALUE, CURRENCY_CODE);
		  MyRetail retaildeleted = new MyRetail(ID, NAME);

	        when(priceRepository.findByTcin(ID)).thenReturn(Optional.of(deleted));
	        when(productRepository.findByTcin(ID)).thenReturn(Optional.of(retaildeleted));

	        service.delete(ID);

	        verify(priceRepository, times(1)).delete(deleted);
	        verify(productRepository, times(1)).delete(retaildeleted);
	    }
	  
	  @Test
	    public void delete_EntryFound_ShouldReturnTheDeletedEntry() {
		  CurrentPrice deleted = new CurrentPrice(ID, VALUE, CURRENCY_CODE);
		  MyRetail retaildeleted = new MyRetail(ID, NAME);

	        when(priceRepository.findByTcin(ID)).thenReturn(Optional.of(deleted));
	        when(productRepository.findByTcin(ID)).thenReturn(Optional.of(retaildeleted));

	        MyRetailDTO returned = service.delete(ID);

	        assertThatCurrentPriceDTO(returned.getCurrent_price())
            .hasValue(VALUE)
            .hascurrency_code(CURRENCY_CODE);
	    }
	  
	  @Test
	    public void findAll_OneEntryFound_ShouldReturnTheInformationOfFoundEntry() {
		  CurrentPrice expected = new CurrentPrice(ID, VALUE, CURRENCY_CODE);
		  MyRetail retailexpected = new MyRetail(ID, NAME);

	        when(priceRepository.findAll()).thenReturn(Arrays.asList(expected));
	        when(productRepository.findAll()).thenReturn(Arrays.asList(retailexpected));

	        List<MyRetailDTO> currentPriceEntries = service.findAll();
	        assertThat(currentPriceEntries).hasSize(1);

	        MyRetailDTO actual = currentPriceEntries.iterator().next();
	        assertThatCurrentPriceDTO(actual.getCurrent_price())
	        .hasValue(VALUE)
            .hascurrency_code(CURRENCY_CODE);
	    }
	  
	  @Test(expected = MyRetailException.class)
	    public void findById_EntryNotFound_ShouldThrowException() {
	        when(priceRepository.findByTcin(ID)).thenReturn(Optional.empty());

	        service.findPriceById(ID);
	    }
	  
	  @Test
	    public void findById_EntryFound_ShouldReturnTheInformationOfFoundEntry() {
		  CurrentPrice found = new CurrentPrice(ID, VALUE, CURRENCY_CODE);

	        when(priceRepository.findByTcin(ID)).thenReturn(Optional.of(found));

	        CurrentPriceDTO returned = service.findPriceById(ID);

	        assertThatCurrentPriceDTO(returned)
	        .hasValue(VALUE)
            .hascurrency_code(CURRENCY_CODE);
	    }
	  
	  @Test
	    public void update_UpdatedEntryFound_ShouldSaveUpdatedTodoEntry() {
		  CurrentPrice existing = new CurrentPrice(ID, VALUE, CURRENCY_CODE);

	        when(priceRepository.findByTcin(ID)).thenReturn(Optional.of(existing));
	        when(priceRepository.save(existing)).thenReturn(existing);

	        MyRetailDTO updated = new MyRetailDTO();
			  CurrentPriceDTO currentPriceDTO = new CurrentPriceDTO();
			  currentPriceDTO.setCurrency_code(CURRENCY_CODE);
			  currentPriceDTO.setValue(VALUE);
			  updated.setCurrent_price(currentPriceDTO);
			  updated.setId(ID);
			  updated.setName(NAME);

	        service.updatePrice(updated);

	        verify(priceRepository, times(1)).save(existing);
	        assertThatCurrentPrice(existing).hasPrice(VALUE).hasCurrencyCd(CURRENCY_CODE);
	    }

}
