package edu.team.electronic_journal.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RepositoryLoggingAspect {

    @Around("execution(* edu.team.electronic_journal.dao.*.*(..))")
    public Object aroundAllDaoMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println(methodName + " start working");

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println(methodName + " end working");

        return targetMethodResult;
    }
}
