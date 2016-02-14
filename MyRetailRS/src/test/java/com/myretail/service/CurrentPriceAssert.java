package com.myretail.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;

import com.myretail.entities.CurrentPrice;

public class CurrentPriceAssert extends AbstractAssert<CurrentPriceAssert, CurrentPrice>{

	private CurrentPriceAssert(CurrentPrice actual) {
		super(actual, CurrentPriceAssert.class);
		
	}
	
	static CurrentPriceAssert assertThatCurrentPrice(CurrentPrice actual) {
        return new CurrentPriceAssert(actual);
    }
	
	CurrentPriceAssert hasId(String expectedId) {
	        isNotNull();

	        String actualId = actual.getId();
	        assertThat(actualId)
	                .overridingErrorMessage("Expected id to be <%s> but was <%s>",
	                        expectedId,
	                        actualId
	                )
	                .isEqualTo(expectedId);

	        return this;
	    }
	
	CurrentPriceAssert hasNoId() {
        isNotNull();

        String actualId = actual.getId();
        assertThat(actualId)
                .overridingErrorMessage("Expected id to be <null> but was <%s>", actualId)
                .isNull();

        return this;
    }
	
	CurrentPriceAssert hasTcin(String expectedTcin) {
        isNotNull();

        String actualTcin = actual.getTcin();
        assertThat(actualTcin)
                .overridingErrorMessage("Expected tcin to be <%s> but was <%s>",
                		expectedTcin,
                        actualTcin
                )
                .isEqualTo(expectedTcin);

        return this;
    }
	
	CurrentPriceAssert hasNoTcin() {
        isNotNull();

        String actualTcin = actual.getTcin();
        assertThat(actualTcin)
                .overridingErrorMessage("Expected tcin to be <null> but was <%s>",
                		actualTcin
                )
                .isNull();

        return this;
    }
	
	CurrentPriceAssert hasPrice(String expectedPrice) {
        isNotNull();

        String actualPrice = actual.getPrice();
        assertThat(actualPrice)
                .overridingErrorMessage("Expected tcin to be <%s> but was <%s>",
                		expectedPrice,
                        actualPrice
                )
                .isEqualTo(expectedPrice);

        return this;
    }
	
	CurrentPriceAssert hasNoPrice() {
        isNotNull();

        String actualPrice = actual.getPrice();
        assertThat(actualPrice)
                .overridingErrorMessage("Expected tcin to be <null> but was <%s>",
                        actualPrice
                )
                .isNull();

        return this;
    }
	
	CurrentPriceAssert hasCurrencyCd(String expectedCurrencyCd) {
        isNotNull();

        String actualCurrencyCd = actual.getCurrencyCd();
        assertThat(actualCurrencyCd)
                .overridingErrorMessage("Expected tcin to be <%s> but was <%s>",
                		expectedCurrencyCd,
                		actualCurrencyCd
                )
                .isEqualTo(expectedCurrencyCd);

        return this;
    }
	
	CurrentPriceAssert hasNoCurrencyCd() {
        isNotNull();

        String actualCurrencyCd = actual.getCurrencyCd();
        assertThat(actualCurrencyCd)
                .overridingErrorMessage("Expected tcin to be <null> but was <%s>",
                		actualCurrencyCd
                )
                .isNull();

        return this;
    }

}
