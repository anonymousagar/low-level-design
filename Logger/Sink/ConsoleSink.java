package Logger.Sink;

public class ConsoleSink extends Sink {
    public ConsoleSink() {
        super("ConsoleSink");
    }

    public void log(String message) {
        // Implementation for logging to console
        System.out.println("Logging to Console: " + message);
    }
    
}
