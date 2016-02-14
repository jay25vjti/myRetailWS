package com.myretail.entities;

import org.springframework.data.annotation.Id;

/**
 * Represents a DS entity
 * 
 * @author jayakrishnan.s
 *
 */
public class CurrentPrice {
	
	@Id
    private String id;
	
	 private String tcin;
	
	private String price;

    private String currencyCd;
    
    public CurrentPrice() {}
    
   public CurrentPrice(String tcin, String price, String currencyCd){
    	this.tcin = tcin;
    	this.price = price;
    	this.currencyCd = currencyCd;
    }
    
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTcin() {
		return tcin;
	}

	public void setTcin(String tcin) {
		this.tcin = tcin;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrentPrice [id=" + id + ", tcin=" + tcin + ", price=" + price + ", currencyCd=" + currencyCd + "]";
	}
    
    

}
