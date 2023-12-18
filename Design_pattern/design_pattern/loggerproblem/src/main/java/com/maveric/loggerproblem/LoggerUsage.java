package com.maveric.loggerproblem;

public class LoggerUsage {
    public static void main(String[] args) {
        ILogger logger = new LoggerImpl();
        ILogger dateTimeLogger = new DateTimeLogger(logger);

        dateTimeLogger.info("successful");
        dateTimeLogger.error("something went wrong");
    }
}