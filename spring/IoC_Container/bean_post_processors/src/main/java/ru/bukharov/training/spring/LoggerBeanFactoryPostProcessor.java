package ru.bukharov.training.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class LoggerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private final static Logger logger = Logger.getLogger(LoggerBeanFactoryPostProcessor.class);

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("BeanFactoryPostProcessor starts working");
        logger.info("----------");

        logger.info("We found bean definition myPerson");
        logger.info(beanFactory.getBeanDefinition("myPerson"));

        logger.info("We found bean definition myHead");
        logger.info(beanFactory.getBeanDefinition("myHead"));

        logger.info("\n");
    }
}
