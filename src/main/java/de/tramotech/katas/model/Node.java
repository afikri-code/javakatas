package de.tramotech.katas.model;

import lombok.Data;

/**
 * Represents a node in a doubly-linked list.
 */
@Data
public class Node {
    /** The key associated with the node */
    int key;

    /** The value associated with the node */
    int value;

    /** The previous node in the list */
    Node previous;

    /** The next node in the list */
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}