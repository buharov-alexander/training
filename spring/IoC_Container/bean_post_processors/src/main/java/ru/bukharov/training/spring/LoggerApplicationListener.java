package ru.bukharov.training.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class LoggerApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final static Logger logger = Logger.getLogger(LoggerApplicationListener.class);

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("We got event that context was created!");
    }
}
