/**
 * 
 */
package com.myretail.es.dto;

/**
 * @author jayakrishnan.s
 *
 */
public class Errors {

	private String message;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "Errors [message = "+message+"]";
    }
	
}
