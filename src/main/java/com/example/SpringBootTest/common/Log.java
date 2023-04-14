package com.example.SpringBootTest.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Log {
    private static Logger logger;

    public static void init() {
        logger = LogManager.getFormatterLogger("SpringBootTest");
        logger.info("log4j 啟動!");
    }

    public static Logger getLogger() {
        return logger;
    }
}
