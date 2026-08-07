package HashMap;

public class Application {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>(22);

        map.put("One", 1);
        map.put("Two", 2);
        System.out.println(map.get("One")); // Output: 1
        System.out.println(map.get("Two")); // Output: 2
    }
}
