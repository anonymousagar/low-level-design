package BookMyShow;

public class User {
    private String userId;
    private String name;
    private UserRole role;

    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
        userId = generateUserId();
    }

    private String generateUserId() {
        // Simple implementation - in a real application, this would be more sophisticated
        return "USER_" + System.currentTimeMillis();    
    }

    public String getUserId() {
        return userId;
    }
}
