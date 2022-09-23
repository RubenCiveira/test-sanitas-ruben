package es.plexus.sanitas.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.util.StopWatch;
import es.plexus.sanitas.test.service.TraceAPIService;
import lombok.RequiredArgsConstructor;

@Configuration
@Aspect
@RequiredArgsConstructor
public class TracerAspect {
  private final TraceAPIService trace;  

  @Around("execution(* es.plexus.sanitas.test.controller.*.*(..))")
  public Object logControllerSpring(ProceedingJoinPoint joinPoint) throws Throwable {
    return logOperation(joinPoint);
  }
  
  private Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
    Logger logger = LoggerFactory.getLogger(ClassUtils.getUserClass(joinPoint.getTarget()));
    if (logger.isDebugEnabled()) {
      logger.debug("This method was called: {}", joinPoint.getSignature().toShortString());
    }
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    Object retVal = null;
    Throwable throwable = null;
    try {
      retVal = joinPoint.proceed();
    } catch (Throwable th) {
      throwable = th;
    }

    stopWatch.stop();

    if (null != throwable) {
      if (logger.isTraceEnabled()) {
        logger.error("{} throws {}({}) after {}ms. {}", joinPoint.getSignature().getName(),
            throwable.getMessage(), throwable.getClass(), stopWatch.getTotalTimeMillis(),
            throwable);
      } else {
        logger.error("{} throws {}({}) after {}ms", joinPoint.getSignature().getName(),
            throwable.getMessage(), throwable.getClass(), stopWatch.getTotalTimeMillis());
      }
    } else if (logger.isDebugEnabled()) {
      logger.debug("{} returns after {}ms value {}", joinPoint.getSignature().getName(),
          stopWatch.getTotalTimeMillis(), retVal);
    } else if (logger.isInfoEnabled()) {
      logger.info("{} ends after {}ms", joinPoint.getSignature().getName(),
          stopWatch.getTotalTimeMillis());
    }
    if (null != throwable) {
      throw throwable;
    } else {
      trace.trace( retVal );
    }
    return retVal;
  }
}
