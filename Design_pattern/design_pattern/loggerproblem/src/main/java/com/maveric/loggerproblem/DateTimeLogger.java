package com.maveric.loggerproblem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeLogger implements ILogger {
    private final ILogger logger;

    public DateTimeLogger(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String msg) {
        String logMessage = getCurrentDateTime() + " Info-" + msg;
        logger.info(logMessage);
    }

    @Override
    public void error(String msg) {
        String logMessage = getCurrentDateTime() + " Error-" + msg;
        logger.error(logMessage);
    }

    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "[" + dateFormat.format(new Date()) + "]";
    }
}