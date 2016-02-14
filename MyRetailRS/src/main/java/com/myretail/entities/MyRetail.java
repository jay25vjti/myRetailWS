package com.myretail.entities;

import org.springframework.data.annotation.Id;

public class MyRetail {
	
	@Id
    private String id;
	
	private String tcin;
	
	 private String name;
	 
	 public MyRetail(){}
	 
	 public MyRetail(String tcin, String name){
		 this.tcin = tcin;
		 this.name = name;
	 }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyRetail [id=" + id + ", tcin=" + tcin + ", name=" + name + "]";
	}
	 
	 

}
