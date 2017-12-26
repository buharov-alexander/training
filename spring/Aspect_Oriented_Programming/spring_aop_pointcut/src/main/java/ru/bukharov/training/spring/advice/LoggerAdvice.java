package ru.bukharov.training.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggerAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(String.format("Start method: %s", methodInvocation.getMethod().getName()));
        String message = (String) methodInvocation.proceed();
        System.out.println(String.format("Finish method: %s", methodInvocation.getMethod().getName()));
        return "Logged: " + message;
    }
}
