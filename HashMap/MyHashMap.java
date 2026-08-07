package HashMap;

public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;

    public MyHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    public MyHashMap(int capacity) {
        int tableCapacity = getNextPowerOfTwo(capacity);
        table = new Entry[tableCapacity];
    }

    private int getNextPowerOfTwo(int capacity) {
        int n = 1;
        while (n < capacity) {
            n <<= 1; // Shift left to multiply by 2
        }
        return n;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Update existing value
                    return;
                }
                if (current.next == null) {
                    current.next = newEntry; // Add to the end of the chain
                    break;
                }
                current = current.next;
            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    } 
}
