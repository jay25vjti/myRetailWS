package com.myretail.es.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ESResponse {
	
	private Product_composite_response product_composite_response;

    public Product_composite_response getProduct_composite_response ()
    {
        return product_composite_response;
    }

    public void setProduct_composite_response (Product_composite_response product_composite_response)
    {
        this.product_composite_response = product_composite_response;
    }

    @Override
    public String toString()
    {
        return "ESResponse [product_composite_response = "+product_composite_response+"]";
    }

}
