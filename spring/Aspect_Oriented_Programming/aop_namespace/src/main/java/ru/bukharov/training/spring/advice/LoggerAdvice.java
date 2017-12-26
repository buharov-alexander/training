package ru.bukharov.training.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerAdvice {
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(String.format("Start method: %s", pjp.getSignature().getName()));
        String message = (String) pjp.proceed();
        System.out.println(String.format("Finish method: %s", pjp.getSignature().getName()));
        return "Logged: " + message;
    }
}
