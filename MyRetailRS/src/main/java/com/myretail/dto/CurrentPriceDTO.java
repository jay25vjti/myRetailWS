package com.myretail.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * DTO representing product's price and currency code from DS
 * 
 * @author jayakrishnan.s
 *
 */
public class CurrentPriceDTO {
	
	@NotNull
	private String value;

	@NotNull
    private String currency_code;
	
	@JsonIgnore
	private String tcin;

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getCurrency_code ()
    {
        return currency_code;
    }

    public void setCurrency_code (String currency_code)
    {
        this.currency_code = currency_code;
    }
    
    

    /**
	 * @return the tcin
	 */
	public String getTcin() {
		return tcin;
	}

	/**
	 * @param tcin the tcin to set
	 */
	public void setTcin(String tcin) {
		this.tcin = tcin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrentPriceDTO [value=" + value + ", currency_code=" + currency_code + ", tcin=" + tcin + "]";
	}

	

}
