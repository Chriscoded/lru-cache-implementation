import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private class CacheNode {
        K key;
        V value;
        CacheNode prev;
        CacheNode next;

        CacheNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int maxSize;
    private final Map<K, CacheNode> cacheMap;
    private CacheNode mostRecent;
    private CacheNode leastRecent;

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        this.cacheMap = new HashMap<>();
    }

    public V get(K key) {
        CacheNode node = cacheMap.get(key);
        if (node == null) {
            return null;
        }

        moveToFront(node);
        return node.value;
    }

    public void put(K key, V value) {
        CacheNode existing = cacheMap.get(key);

        if (existing != null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }

        CacheNode newNode = new CacheNode(key, value);
        cacheMap.put(key, newNode);
        addToFront(newNode);

        if (cacheMap.size() > maxSize) {
            removeLeastUsed();
        }
    }

    private void moveToFront(CacheNode node) {
        if (node == mostRecent) return;

        // detach node
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        if (node == leastRecent) {
            leastRecent = node.prev;
        }

        addToFront(node);
    }

    private void addToFront(CacheNode node) {
        node.prev = null;
        node.next = mostRecent;

        if (mostRecent != null) {
            mostRecent.prev = node;
        }

        mostRecent = node;

        if (leastRecent == null) {
            leastRecent = node;
        }
    }

    private void removeLeastUsed() {
        if (leastRecent == null) return;

        cacheMap.remove(leastRecent.key);

        if (leastRecent.prev != null) {
            leastRecent = leastRecent.prev;
            leastRecent.next = null;
        } else {
            mostRecent = null;
            leastRecent = null;
        }
    }

    public void display() {
        CacheNode current = mostRecent;
        while (current != null) {
            System.out.print(current.key + "=" + current.value + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }
}