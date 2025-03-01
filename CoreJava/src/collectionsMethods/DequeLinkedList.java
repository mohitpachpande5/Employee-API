package collectionsMethods;
/*
📌 Implementing a Deque (Doubly-Ended Queue) using LinkedList in Java
A Deque (Double-Ended Queue) allows insertion and removal from both ends efficiently.
Java's LinkedList class implements the Deque interface,
making it a great choice for a Doubly Queue.
 */

import java.util.LinkedList;
import java.util.Queue;

import java.util.*;

public class DequeLinkedList {

    public static void main(String[] args) {
        // Call the method to demonstrate Deque operations
        demonstrateDequeOperations();
    }

    /**
     * Demonstrates Deque (Doubly Queue) operations using LinkedList.
     */
    public static void demonstrateDequeOperations() {
        // 🔹 Creating a Deque using LinkedList
        Deque<String> deque = new LinkedList<>();

        // 🔹 Adding elements at the front and back
        deque.addFirst("Apple");
        deque.addLast("Banana");
        deque.offerFirst("Cherry"); // Alternative to addFirst
        deque.offerLast("Mango");   // Alternative to addLast
        deque.addFirst("Grapes");
        deque.addLast("Watermelon");

        System.out.println("\n📌 Original Deque: " + deque);

        // 🔹 Accessing elements without removing
        System.out.println("First Element (getFirst): " + deque.getFirst());
        System.out.println("Last Element (getLast): " + deque.getLast());
        System.out.println("Peek First (peekFirst): " + deque.peekFirst());
        System.out.println("Peek Last (peekLast): " + deque.peekLast());

        // 🔹 Removing elements from both ends
        System.out.println("Removed First (removeFirst): " + deque.removeFirst());
        System.out.println("Removed Last (removeLast): " + deque.removeLast());

        // 🔹 Using poll methods (removes but returns null if empty)
        System.out.println("Poll First Element: " + deque.pollFirst());
        System.out.println("Poll Last Element: " + deque.pollLast());

        System.out.println("📌 Deque after removals: " + deque);

        // 🔹 Iterating using Iterator
        System.out.print("Iterating using Iterator: ");
        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 🔹 Iterating using Descending Iterator
        System.out.print("Iterating using Descending Iterator: ");
        Iterator<String> descendingIterator = deque.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.print(descendingIterator.next() + " ");
        }
        System.out.println();

        // 🔹 Reversing the Deque
        List<String> reversedDeque = new ArrayList<>(deque);
        Collections.reverse(reversedDeque);
        System.out.println("Reversed Deque: " + reversedDeque);

        // 🔹 Checking if Deque is empty
        System.out.println("Is Deque Empty? " + deque.isEmpty());

        // 🔹 Clearing all elements
        deque.clear();
        System.out.println("Deque after Clearing: " + deque);
    }
}
