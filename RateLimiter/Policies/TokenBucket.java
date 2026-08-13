package RateLimiter.Policies;

public class TokenBucket {
    double tokens;
    long lastRefillTimestamp;

    TokenBucket(double tokens, long lastRefillTimestamp) {
        this.tokens = tokens;
        this.lastRefillTimestamp = lastRefillTimestamp;
    }
}
