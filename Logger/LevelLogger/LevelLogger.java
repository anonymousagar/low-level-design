package Logger.LevelLogger;

import Logger.Sink.Sink;

public class LevelLogger {
    private LogLevel logLevel;
    private LevelLogger nextLogger;
    protected Sink sink;

    public LevelLogger(LogLevel logLevel, Sink sink) {
        this.logLevel = logLevel;
        this.sink = sink;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void log(LogLevel level, String message) {
        if (this.logLevel == level) {
            log(message);
        } else if (nextLogger != null) {
            nextLogger.log(level, message);
        }
    }

    public void log(String message) {
        // Default implementation, can be overridden by subclasses
        sink.log(message);
    }

    public void setNextLogger(LevelLogger nextLogger) {
        // Default implementation, can be overridden by subclasses
        this.nextLogger = nextLogger;
    }
}
