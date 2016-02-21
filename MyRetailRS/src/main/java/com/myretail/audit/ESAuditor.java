package com.myretail.audit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * An Auditor which audits all service invocations.
 * Currently printing to console, ideally should be persisted for future. 
 * 
 * @author jayakrishnan.s
 *
 */
@Aspect
@Component
public class ESAuditor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ESAuditor.class);
	
	/**
	 * A reusable pointcut for each advice.
	 * invokes for all DB and ES service calls
	 * 
	 */
	@Pointcut("execution(* com.myretail.service.*.*(..))")
	public void serviceInvocation(){}
	
	/**
	 * Log after returning from service
	 * 
	 * @param joinPoint
	 */
	@AfterReturning("serviceInvocation()")
	public void logServiceAccess(JoinPoint joinPoint) {
		LOGGER.info("Completed: "+joinPoint);
		
	}
	
	/**
	 * Log if an exception occurs in service invocation
	 * 
	 * @param joinPoint
	 */
	@AfterThrowing("serviceInvocation()")
    public void logExceptions(JoinPoint joinPoint){
        LOGGER.info("Exception thrown in: "+joinPoint);
    }
	
	/**
	 * Invoke before and after service invocation.
	 * Can ideally help in service execution time etc
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable 
	 */
	@Around("serviceInvocation()")
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        LOGGER.info("Before invoking Service: "+proceedingJoinPoint);
        Object value = null;
            value = proceedingJoinPoint.proceed();
        
        LOGGER.info("After invoking Service. Return value="+value);
        return value;
    }
}
