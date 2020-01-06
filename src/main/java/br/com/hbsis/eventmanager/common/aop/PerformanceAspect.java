package br.com.hbsis.eventmanager.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
@ConditionalOnExpression("${aop.performance.enabled:false}")
public class PerformanceAspect {

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void repositoryClassMethods() {
    }

    @Around("repositoryClassMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.nanoTime();
        Object returnValue = joinPoint.proceed();
        long end = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();

        if(log.isDebugEnabled()){
            log.debug("Execution of " + methodName + " took " +
                            TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        }

        return returnValue;
    }
}
