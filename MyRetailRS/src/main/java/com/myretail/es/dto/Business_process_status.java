package com.myretail.es.dto;

public class Business_process_status {
	
	private Process_status process_status;

    public Process_status getProcess_status ()
    {
        return process_status;
    }

    public void setProcess_status (Process_status process_status)
    {
        this.process_status = process_status;
    }

    @Override
    public String toString()
    {
        return "Business_process_status [process_status = "+process_status+"]";
    }

}
