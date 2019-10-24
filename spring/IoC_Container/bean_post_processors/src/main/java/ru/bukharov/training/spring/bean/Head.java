package ru.bukharov.training.spring.bean;

import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;

public class Head {

    private final static Logger logger = Logger.getLogger(Head.class);

    public Head() {
        logger.info("Create bean myHead");
        logger.info("----------");
        logger.info("Constructor");
    }

    @PostConstruct
    public void init() {
        logger.info("Post construct");
    }
}
