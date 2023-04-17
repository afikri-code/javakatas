package de.tramotech.katas;

import de.tramotech.katas.model.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of LRU Cache using a doubly linked list and a HashMap.
 */
public class LRUCache {
    // The maximum number of elements the cache can hold.
    int capacity;

    // A mapping from the keys to the corresponding nodes in the doubly linked list.
    private final Map<Integer, Node> cache = new HashMap<>();

    // The tail of the doubly linked list, which represents the least recently used element.
    Node tail;

    /**
     * Creates a new LRUCache with the given capacity.
     *
     * @param capacity the maximum number of elements the cache can hold
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Adds the given node to the head of the doubly linked list and updates the cache.
     *
     * @param node the node to add to the cache
     */
    void addNode(Node node) {
        if(tail == null) {
            // The cache is empty, so make the new node the tail of the doubly linked list.
            tail = node;
            tail.setPrevious(node);
        } else {
            // Add the new node to the head of the doubly linked list.
            node.setNext(tail);
            node.setPrevious(tail.getPrevious());
            tail.getPrevious().setNext(node);
            tail.setPrevious(node);
        }
        // Update the cache with the new node.
        cache.put(node.getKey(), node);
    }

    /**
     * Moves the given node to the head of the doubly linked list to mark it as the most recently used element.
     *
     * @param node the node to move to the head of the doubly linked list
     */
    void moveNodeToFront(Node node) {
        Node previous = node.getPrevious();
        if (previous != null) {
            if(node == tail) {
                tail = previous;
            }
            node.setPrevious(previous.getPrevious());
            node.setNext(previous);
            previous.setPrevious(node);
            previous.setNext(node.getNext());
        }
    }

    /**
     * Retrieves the value of the element with the given key from the cache.
     *
     * @param key the key of the element to retrieve
     * @return the value of the element, or -1 if the element is not in the cache
     */
    public int get(int key) {
        if(!cache.containsKey(key)) {
            // The element is not in the cache, so return -1.
            return -1;
        }
        Node node = cache.get(key);
        // Move the node to the head of the doubly linked list to mark it as the most recently used element.
        moveNodeToFront(node);
        return node.getValue();
    }

    /**
     * Adds the element with the given key and value to the cache.
     *
     * @param key the key of the element to add
     * @param value the value of the element to add
     */
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            // The element is already in the cache, so do nothing.
            return;
        }
        Node node = new Node(key, value);
        if(cache.size() == capacity) {
            // The cache is full, so remove the least recently used element from the tail of the doubly linked list.
            Node previous = tail.getPrevious();
            previous.setNext(null);
            cache.remove(tail.getKey());
            tail = previous;
        }
        // Add the new node to the head of the doubly linked list.
        addNode(node);
    }
}
