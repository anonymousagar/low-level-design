package Logger;

import static Logger.LevelLogger.LogLevel.*;

public class Application {
    public static void main(String[] args) {
        LoggerService loggerService = LoggerService.getInstance();
        loggerService.log(INFO, "Application started.");
        
        // Simulate some application logic
        loggerService.log(WARNING, "Performing some operations...");
        
        loggerService.log(INFO, "Application finished.");
        loggerService.log(WARNING, "Performing some operations...");
        loggerService.log(ERROR, "Performing some operations...");
        loggerService.log(WARNING, "Performing some operations...");
        loggerService.log(ERROR, "Performing some operations...");
    }
}
