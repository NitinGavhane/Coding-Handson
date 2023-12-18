package com.maveric.loggerproblem;

public class LoggerImpl implements ILogger {
    @Override
    public void info(String msg) {
        System.out.print("Info-"+msg+"\n");
    }

    @Override
    public void error(String msg) {
        System.err.println("Error-"+msg+"\n");
    }
}

