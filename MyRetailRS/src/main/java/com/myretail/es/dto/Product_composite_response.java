package com.myretail.es.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product_composite_response {
	
	private Items[] items;

    private Request_attributes[] request_attributes;

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public Request_attributes[] getRequest_attributes ()
    {
        return request_attributes;
    }

    public void setRequest_attributes (Request_attributes[] request_attributes)
    {
        this.request_attributes = request_attributes;
    }

    @Override
    public String toString()
    {
        return "Product_composite_response [items = "+Arrays.toString(items)+", request_attributes = "+Arrays.toString(request_attributes)+"]";
    }

}
