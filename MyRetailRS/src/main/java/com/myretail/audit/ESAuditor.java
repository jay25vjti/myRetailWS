package com.myretail.audit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
		System.out.println("Completed: " + joinPoint);
		
	}
	
	/**
	 * Log if an exception occurs in service invocation
	 * 
	 * @param joinPoint
	 */
	@AfterThrowing("serviceInvocation()")
    public void logExceptions(JoinPoint joinPoint){
        System.out.println("Exception thrown in "+joinPoint.toString());
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
        System.out.println("Before invoking Service");
        Object value = null;
            value = proceedingJoinPoint.proceed();
        
        System.out.println("After invoking Service. Return value="+value);
        return value;
    }
}
