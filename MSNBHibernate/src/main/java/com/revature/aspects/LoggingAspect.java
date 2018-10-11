package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Simply logs the call for each method.
 * @author Small
 *
 */
@Aspect
@Component
public class LoggingAspect {
	private static Logger log = Logger.getRootLogger();
	@AfterReturning("within(com.revature.controllers.*)")
	public void methodCall(JoinPoint jp) {
		log.info(jp.toShortString()+" method was called");
	}
}
