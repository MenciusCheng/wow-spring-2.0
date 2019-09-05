package com.marvel.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Marvel on 2019/9/5.
 */
@Component
public class DataSourceShow implements ApplicationContextAware {

    private final static Logger logger = LoggerFactory.getLogger(DataSourceShow.class);
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        logger.info("-------setApplicationContext---------");
        logger.info(dataSource.getClass().getName());
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
