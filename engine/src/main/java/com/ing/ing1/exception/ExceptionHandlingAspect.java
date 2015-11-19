package com.ing.ing1.exception;

import com.ing.ing1.engine.ApplicationFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * Created by ggkekas on 18/11/15.
 */
@Aspect
@Component
public class ExceptionHandlingAspect {
    private static final Logger LOGGER = LogManager.getLogger(ExceptionHandlingAspect.class);

    @Around("execution(* com.ing.ing1.http.INGApiClient.*(..))")
    public Object exceptionHandlingForRestCalls(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Object retVal =  null;
        try {
            LOGGER.info("Inside aspect");
            retVal = pjp.proceed();
        } catch(Throwable e) {
            if(ApplicationFactory.getConfiguration().isDebug()) {
                LOGGER.error("Error while trying to call " + pjp.getSignature().getName(), e);
            } else {
                LOGGER.error("Error while trying to call " + pjp.getSignature().getName() + "Error: " + e.getMessage());
            }
        } finally {
            // stop stopwatch
            return retVal;
        }
    }
}
