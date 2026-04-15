# lru-cache-implementation
Implementation of a Least Recently Used (LRU) cache with fixed capacity using efficient O(1) operations for insertion and retrieval.

## LRU Cache Eviction

This project implements a generic Least Recently Used (LRU) cache in Java.

The cache stores key-value pairs with a fixed capacity. When the capacity is exceeded, the least recently used item is automatically removed to make space for new entries.

The implementation uses a combination of a HashMap and a Doubly Linked List to ensure O(1) time complexity for both retrieval (get) and insertion (put) operations.

### Features
- Generic key-value storage
- Fixed capacity
- Automatic eviction of least recently used items
- Efficient O(1) operations

### How it works
- A HashMap provides fast lookup of cache entries.
- A Doubly Linked List maintains the order of usage.
- The most recently used item is moved to the front.
- The least recently used item is removed from the tail when capacity is exceeded.

### Usage
Run the main method to see sample test cases demonstrating cache behavior.
