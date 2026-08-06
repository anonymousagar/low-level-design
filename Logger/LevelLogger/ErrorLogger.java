package Logger.LevelLogger;

import Logger.Sink.Sink;

public class ErrorLogger extends LevelLogger {
    public ErrorLogger(Sink sink) {
        super(LogLevel.ERROR, sink);
    }

    @Override
    public void log(String message) {
        sink.log("[ERROR]: " + message);
    }
}
