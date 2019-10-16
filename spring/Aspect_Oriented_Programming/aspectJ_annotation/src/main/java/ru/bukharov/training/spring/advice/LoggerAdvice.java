package ru.bukharov.training.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAdvice {

    @Pointcut("execution(* sayBye()) && bean(sasha)")
    public void namePointcut() {
    }

    @Around("namePointcut()")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(String.format("Start method: %s", pjp.getSignature().getName()));
        String message = (String) pjp.proceed();
        System.out.println(String.format("Finish method: %s", pjp.getSignature().getName()));
        return "Logged: " + message;
    }
}
