package com.myretail.es.dto;

public class Alternate_description {
	
	private String type_description;

    private String value;

    private String type;

    public String getType_description ()
    {
        return type_description;
    }

    public void setType_description (String type_description)
    {
        this.type_description = type_description;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "Alternate_description [type_description = "+type_description+", value = "+value+", type = "+type+"]";
    }

}
