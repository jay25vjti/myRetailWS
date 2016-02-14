package com.myretail.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Provide basic authentication for our resources
 * 
 * @author jayakrishnan.s
 *
 */
@Component
public class MyRetailFilter implements Filter{
	
	private static final String AUTHORIZATION_TOKEN = "TOKEN";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRetailFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;

        String accessToken = request.getHeader(AUTHORIZATION_TOKEN);
        
        if(new MyRetailUtil().isReqAUthorized(accessToken)){
        	LOGGER.info("Authorized request.."+request.getRequestURI());
        	chain.doFilter(req, resp);
        }else{
        	LOGGER.error("Unauthorized request received.."+request.getRequestURI());
        	HttpServletResponse response = (HttpServletResponse) resp;
        	response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
