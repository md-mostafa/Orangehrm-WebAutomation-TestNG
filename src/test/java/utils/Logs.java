package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    private static Logger log = LogManager.getLogger("Logs");
    private Logs() {

    }

    public static void info(String msg) {
        log.info(msg);
    }
}