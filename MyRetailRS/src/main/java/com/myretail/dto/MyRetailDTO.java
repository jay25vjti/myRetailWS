package com.myretail.dto;

import javax.validation.constraints.NotNull;

/**
 * DTO representing aggregated response for a product
 * 
 * @author jayakrishnan.s
 *
 */
public class MyRetailDTO {
	
	@NotNull
	private String id;

	@NotNull
    private CurrentPriceDTO current_price;

	@NotNull
    private String name;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public CurrentPriceDTO getCurrent_price ()
    {
        return current_price;
    }

    public void setCurrent_price (CurrentPriceDTO current_price)
    {
        this.current_price = current_price;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "MyRetailDTO [id = "+id+", current_price = "+current_price+", name = "+name+"]";
    }

}
