package FrameWork.Utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {

    static Logger mainLogger = LogManager.getLogger(Log.class.getName());

    public static void startTestDetails(String testname){
        mainLogger.info("-----------------------------");
        mainLogger.info("------- "+testname+" --------");
        mainLogger.info("-----------------------------");
    }

    public static void endTestDetails(){
        mainLogger.info("-----------------------------");
        mainLogger.info("--------  End Test  ---------");
        mainLogger.info("-----------------------------");
    }

    public static void debug(String message){
        mainLogger.debug(message);
    }

    public static void info(String message){
        mainLogger.info(message);
    }

    public static void error(String message){
        mainLogger.error(message);
    }
}
