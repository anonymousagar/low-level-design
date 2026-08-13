package RateLimiter;

public interface RateLimitPolicy {
    boolean allowRequest(String key, long currentTimeMillis);
}
