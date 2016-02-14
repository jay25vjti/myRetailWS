package com.myretail.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;

import com.myretail.dto.CurrentPriceDTO;

public class CurrentPriceDTOAssert extends AbstractAssert<CurrentPriceDTOAssert, CurrentPriceDTO>{

	private CurrentPriceDTOAssert(CurrentPriceDTO actual) {
		super(actual, CurrentPriceDTOAssert.class);
	}
	
	static CurrentPriceDTOAssert assertThatCurrentPriceDTO(CurrentPriceDTO actual){
		return new CurrentPriceDTOAssert(actual);
	}

	CurrentPriceDTOAssert hasValue(String expectedValue){
		isNotNull();
		String actualValue = actual.getValue();
		
		assertThat(actualValue)
        .overridingErrorMessage("Expected value to be <%s> but was <%s>",
        		expectedValue,
                actualValue
        )
        .isEqualTo(expectedValue);

		return this;
	}
	
	CurrentPriceDTOAssert hasNoValue(){
		isNotNull();
		String actualValue = actual.getValue();
		
		assertThat(actualValue)
        .overridingErrorMessage("Expected value to be <null> but was <%s>",
                actualValue
        )
        .isNull();

		return this;
	}
	
	CurrentPriceDTOAssert hascurrency_code(String expectedcurrency_code){
		isNotNull();
		String actualcurrency_code = actual.getCurrency_code();
		
		assertThat(actualcurrency_code)
        .overridingErrorMessage("Expected value to be <%s> but was <%s>",
        		expectedcurrency_code,
        		actualcurrency_code
        )
        .isEqualTo(expectedcurrency_code);

		return this;
	}
	
	CurrentPriceDTOAssert hasNocurrency_code(){
		isNotNull();
		String actualcurrency_code = actual.getCurrency_code();
		
		assertThat(actualcurrency_code)
        .overridingErrorMessage("Expected value to be <null> but was <%s>",
        		actualcurrency_code
        )
        .isNull();

		return this;
	}
}
