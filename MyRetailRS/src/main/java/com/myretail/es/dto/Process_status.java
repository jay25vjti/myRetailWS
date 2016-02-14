package com.myretail.es.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Process_status {
	
	private String operation_description;

    private String is_ready;

    private String operation_code;

    public String getOperation_description ()
    {
        return operation_description;
    }

    public void setOperation_description (String operation_description)
    {
        this.operation_description = operation_description;
    }

    public String getIs_ready ()
    {
        return is_ready;
    }

    public void setIs_ready (String is_ready)
    {
        this.is_ready = is_ready;
    }

    public String getOperation_code ()
    {
        return operation_code;
    }

    public void setOperation_code (String operation_code)
    {
        this.operation_code = operation_code;
    }

    @Override
    public String toString()
    {
        return "Process_status [operation_description = "+operation_description+", is_ready = "+is_ready+", operation_code = "+operation_code+"]";
    }

}
