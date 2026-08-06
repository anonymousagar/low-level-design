package Logger.Sink;

public class Sink {
    private String sinkName;

    public Sink(String sinkName) {
        this.sinkName = sinkName;
    }

    public String getSinkName() {
        return sinkName;
    }

    public void log(String message) {
        // Default implementation, can be overridden by subclasses
        System.out.println("[" + sinkName + "]: " + message);
    }
}
