package Logger;

import Logger.LevelLogger.*;
import Logger.Sink.ConsoleSink;
import Logger.Sink.DBSink;

public class LoggerService {
    private static LoggerService instance;
    private LevelLogger loggerChain;

    private LoggerService() {
        // Initialize the logger chain
        this.loggerChain = new InfoLogger(new DBSink());
        LevelLogger warningLogger = new WarningLogger(new ConsoleSink());
        LevelLogger errorLogger = new ErrorLogger(new DBSink());

        loggerChain.setNextLogger(warningLogger);
        warningLogger.setNextLogger(errorLogger);
    }

    public static synchronized LoggerService getInstance() {
        if (instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    public void log(LogLevel level, String message) {
        loggerChain.log(level, message);
    }
    
}
