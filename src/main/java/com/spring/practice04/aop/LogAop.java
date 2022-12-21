package com.spring.practice04.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
	private static final Logger log = LoggerFactory.getLogger(LogAop.class);
	
	@Around("within(com.spring.practice04.service.*)")
	public Object logBefore(ProceedingJoinPoint joinpoint) throws Throwable {
		String sigStr = joinpoint.getSignature().toShortString();
		long startTime = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
			long endTime = System.currentTimeMillis();
			log.info( sigStr +" 수행 시간 : " +(endTime-startTime) +"ms");		
		}
	}
}
