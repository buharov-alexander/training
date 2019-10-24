package ru.bukharov.training.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ru.bukharov.training.spring.bean.Head;
import ru.bukharov.training.spring.bean.Person;

public class LoggerBeanPostProcessor implements BeanPostProcessor {

    private final static Logger logger = Logger.getLogger(LoggerBeanPostProcessor.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        String text = String.format("before initialization %s", beanName);
        logBean(bean, text);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        String text = String.format("after initialization %s\n", beanName);
        logBean(bean, text);
        return bean;
    }

    private void logBean(Object bean, String text) {
        if (bean instanceof Person || bean instanceof Head) {
            logger.info(text);
        }
    }
}
