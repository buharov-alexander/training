package ru.bukharov.training.spring.pointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.lang.Nullable;
import ru.bukharov.training.spring.service.Person;

import java.lang.reflect.Method;

public class NamePointcut extends StaticMethodMatcherPointcut {

    private final String methodName;

    public NamePointcut(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public boolean matches(Method method, @Nullable Class<?> aClass) {
        return methodName.equals(method.getName());
    }

}
