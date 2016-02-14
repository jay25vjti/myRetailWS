package com.myretail.es.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Identifier {
	
	private String id;

    private String source;

    private String id_type;

    private String is_primary;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getId_type ()
    {
        return id_type;
    }

    public void setId_type (String id_type)
    {
        this.id_type = id_type;
    }

    public String getIs_primary ()
    {
        return is_primary;
    }

    public void setIs_primary (String is_primary)
    {
        this.is_primary = is_primary;
    }

    @Override
    public String toString()
    {
        return "Identifier [id = "+id+", source = "+source+", id_type = "+id_type+", is_primary = "+is_primary+"]";
    }

}
