package Logger.LevelLogger;

import Logger.Sink.Sink;

public class WarningLogger extends LevelLogger {
    public WarningLogger(Sink sink) {
        super(LogLevel.WARNING, sink);
    }

    @Override
    public void log(String message) {
       sink.log("[WARNING]: " + message);
    }
}
