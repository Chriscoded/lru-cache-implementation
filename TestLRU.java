public class TestLRU {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.display();

        cache.get(1); // makes 1 most recent
        cache.display();

        cache.put(3, "Three"); // evicts 2
        cache.display();

        System.out.println("Get 2: " + cache.get(2)); // null
    }
}