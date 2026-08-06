package Logger.LevelLogger;

import Logger.Sink.Sink;

public class InfoLogger extends LevelLogger {
    public InfoLogger(Sink sink) {
        super(LogLevel.INFO, sink);
    }

    @Override
    public void log(String message) {
        sink.log("[INFO]: " + message);
    }
    
}
