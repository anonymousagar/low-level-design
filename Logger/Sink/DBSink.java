package Logger.Sink;

public class DBSink extends Sink {
    public DBSink() {
        super("DBSink");
    }

    public void log(String message) {
        // Implementation for logging to database
        System.out.println("Logging to DB: " + message);
    }
}
