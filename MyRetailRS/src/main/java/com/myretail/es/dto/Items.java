package com.myretail.es.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
	
	private Online_description online_description;

    private String department_id;

    private String relation;

    private String general_description;

    private String is_orderable;

    private String data_page_link;

    private String imn_identifier;

    private String relation_description;

    private Business_process_status[] business_process_status;

    private Store_description store_description;

    private String is_sellable;

    private String class_id;

    private String item_id;

    private String dpci;

    private Alternate_description[] alternate_description;

    private Identifier[] identifier;
    
    private Errors[] errors;

    public Online_description getOnline_description ()
    {
        return online_description;
    }

    public void setOnline_description (Online_description online_description)
    {
        this.online_description = online_description;
    }

    public String getDepartment_id ()
    {
        return department_id;
    }

    public void setDepartment_id (String department_id)
    {
        this.department_id = department_id;
    }

    public String getRelation ()
    {
        return relation;
    }

    public void setRelation (String relation)
    {
        this.relation = relation;
    }

    public String getGeneral_description ()
    {
        return general_description;
    }

    public void setGeneral_description (String general_description)
    {
        this.general_description = general_description;
    }

    public String getIs_orderable ()
    {
        return is_orderable;
    }

    public void setIs_orderable (String is_orderable)
    {
        this.is_orderable = is_orderable;
    }

    public String getData_page_link ()
    {
        return data_page_link;
    }

    public void setData_page_link (String data_page_link)
    {
        this.data_page_link = data_page_link;
    }

    public String getImn_identifier ()
    {
        return imn_identifier;
    }

    public void setImn_identifier (String imn_identifier)
    {
        this.imn_identifier = imn_identifier;
    }

    public String getRelation_description ()
    {
        return relation_description;
    }

    public void setRelation_description (String relation_description)
    {
        this.relation_description = relation_description;
    }

    public Business_process_status[] getBusiness_process_status ()
    {
        return business_process_status;
    }

    public void setBusiness_process_status (Business_process_status[] business_process_status)
    {
        this.business_process_status = business_process_status;
    }

    public Store_description getStore_description ()
    {
        return store_description;
    }

    public void setStore_description (Store_description store_description)
    {
        this.store_description = store_description;
    }

    public String getIs_sellable ()
    {
        return is_sellable;
    }

    public void setIs_sellable (String is_sellable)
    {
        this.is_sellable = is_sellable;
    }

    public String getClass_id ()
    {
        return class_id;
    }

    public void setClass_id (String class_id)
    {
        this.class_id = class_id;
    }

    public String getItem_id ()
    {
        return item_id;
    }

    public void setItem_id (String item_id)
    {
        this.item_id = item_id;
    }

    public String getDpci ()
    {
        return dpci;
    }

    public void setDpci (String dpci)
    {
        this.dpci = dpci;
    }

    public Alternate_description[] getAlternate_description ()
    {
        return alternate_description;
    }

    public void setAlternate_description (Alternate_description[] alternate_description)
    {
        this.alternate_description = alternate_description;
    }

    public Identifier[] getIdentifier ()
    {
        return identifier;
    }

    public void setIdentifier (Identifier[] identifier)
    {
        this.identifier = identifier;
    }
    
    public Errors[] getErrors ()
    {
        return errors;
    }

    public void setErrors (Errors[] errors)
    {
        this.errors = errors;
    }

    @Override
    public String toString()
    {
        return "Items [online_description = "+online_description+", department_id = "+department_id+", relation = "+relation+", general_description = "+general_description+", is_orderable = "+is_orderable+", data_page_link = "+data_page_link+", imn_identifier = "+imn_identifier+", relation_description = "+relation_description+", business_process_status = "+business_process_status+", store_description = "+store_description+", is_sellable = "+is_sellable+", class_id = "+class_id+", item_id = "+item_id+", dpci = "+dpci+", alternate_description = "+alternate_description+", identifier = "+identifier+", errors = "+errors+"]";
    }

}
