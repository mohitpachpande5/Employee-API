package collectionsMethods;
/*
https://docs.oracle.com/en/java/javase/21/core/java-core-libraries1.html
https://docs.oracle.com/javase/tutorial/collections/index.html
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/LinkedList.html

## Introduction  
`LinkedList` is a part of the Java Collection Framework (`java.util` package). It implements the List and Deque interfaces, making it a doubly linked list that can function as both a list and a queue.

---

## Features of `LinkedList`
- Implements `List` and `Deque` interfaces – Supports list operations and queue operations.
- Doubly Linked List – Each node has references to both its previous and next node.
- Allows `null` elements – Unlike `TreeSet` or `TreeMap`, it permits `null` values.
- Not synchronized – Multiple threads accessing it require explicit synchronization.
- Insertion and deletion are fast – Unlike `ArrayList`, there’s no need for shifting elements.

---
## 4. Constructors
| Constructor | Description |
|---------------|----------------|
| `LinkedList()` | Creates an empty linked list. |
| `LinkedList(Collection<? extends E> c)` | Creates a linked list with elements from another collection. |

---

##  Common Methods of `LinkedList`
###  List Methods (From `List` Interface)
| Method | Description |
|-----------|----------------|
| `add(E e)` | Adds an element at the end. |
| `add(int index, E e)` | Inserts an element at a specific index. |
| `remove(int index)` | Removes an element at the given index. |
| `set(int index, E e)` | Replaces the element at the given index. |
| `get(int index)` | Returns the element at the given index. |
| `indexOf(Object o)` | Returns the first index of the element or `-1` if not found. |


###  Deque Methods (From `Deque` Interface)
| Method | Description |
|-----------|----------------|
| `addFirst(E e)` | Inserts at the beginning. |
| `addLast(E e)` | Inserts at the end (same as `add()`). |
| `removeFirst()` | Removes the first element. |
| `removeLast()` | Removes the last element. |
| `getFirst()` | Retrieves the first element without removing it. |
| `getLast()` | Retrieves the last element without removing it. |


---

## LinkedList vs ArrayList
| Feature | `LinkedList` | `ArrayList` |
|---------|------------|------------|
| Data Structure | Doubly Linked List | Dynamic Array |
| Performance for Insert/Delete | Faster (O(1) if head/tail, O(n) for middle) | Slower (O(n) due to shifting) |
| Performance for Get/Search | Slower (O(n)) | Faster (O(1) for random access) |
| Memory Usage | Higher (Extra memory for links) | Lower (No extra memory needed) |
| Preferred When | Frequent Insert/Delete | Frequent Random Access |


---

## Real-World Use Cases
| Use Case | Why Use `LinkedList`? |
|-------------|----------------------|
| Implementing LRU Cache | Efficient insertion/removal of least recently used items. |
| Handling Large Data Streams | Easy to insert/remove elements dynamically. |
| Undo/Redo Operations | Keeps track of changes in a doubly linked list format. |
| Queue or Stack Implementation | Works as both FIFO and LIFO using `Deque` methods. |

---

## Performance Analysis
| Operation | Time Complexity |
|--------------|--------------------|
| Insert at Beginning (`addFirst()`) | O(1) |
| Insert at End (`addLast()`) | O(1) |
| Insert in Middle (`add(index, e)`) | O(n) |
| Delete First (`removeFirst()`) | O(1) |
| Delete Last (`removeLast()`) | O(1) |
| Delete in Middle (`remove(index)`) | O(n) |
| Search (`get(index)`) | O(n) |

---

##  Conclusion
- Use `LinkedList` when you need fast insertions/deletions and don't require random access.
- Avoid `LinkedList` for indexed access (`get(index)`) since it’s slow.
- Consider `ArrayList` if you need fast search and iteration.

 */
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Iterator;

public class LinkedListMethodsDemo {
    public static void main(String[] args) {
	        // Call the method that demonstrates all LinkedList operations
	        demonstrateLinkedListMethods();
	    }

	    /**
	     * Demonstrates all major methods of LinkedList class.
	     */
	    public static void demonstrateLinkedListMethods() {
	        // 🔹 Creating a LinkedList
	        LinkedList<String> linkedList = new LinkedList<>();

	        // 🔹 Adding elements
	        linkedList.add("Apple");
	        linkedList.add("Banana");
	        linkedList.add("Mango");
	        linkedList.add("Orange");
	        linkedList.add("Pineapple");

	        // 🔹 Adding elements at the first and last position
	        linkedList.addFirst("Strawberry");
	        linkedList.addLast("Watermelon");

	        // 🔹 Using offer() methods (alternative to add())
	        linkedList.offer("Grapes");
	        linkedList.offerFirst("Blueberry");
	        linkedList.offerLast("Peach");

	        System.out.println("\n📌 Original LinkedList: " + linkedList);

	        // 🔹 Accessing elements
	        System.out.println("First Element (getFirst): " + linkedList.getFirst());
	        System.out.println("Last Element (getLast): " + linkedList.getLast());
	        System.out.println("Element at Index 2 (get): " + linkedList.get(2));

	        // 🔹 Using peek methods
	        System.out.println("Peek First Element: " + linkedList.peek());
	        System.out.println("Peek First (peekFirst): " + linkedList.peekFirst());
	        System.out.println("Peek Last (peekLast): " + linkedList.peekLast());

	        // 🔹 Updating elements
	        linkedList.set(1, "Cherry");
	        System.out.println("Updated LinkedList: " + linkedList);

	        // 🔹 Checking if an element is present
	        System.out.println("Contains 'Mango'? " + linkedList.contains("Mango"));

	        // 🔹 Removing elements
	        System.out.println("Removed First (removeFirst): " + linkedList.removeFirst());
	        System.out.println("Removed Last (removeLast): " + linkedList.removeLast());
	        System.out.println("Removed Element 'Cherry': " + linkedList.remove("Cherry"));
	        System.out.println("LinkedList after removals: " + linkedList);

	        // 🔹 Using poll methods
	        System.out.println("Poll First Element: " + linkedList.poll());
	        System.out.println("Poll Last Element: " + linkedList.pollLast());
	        System.out.println("LinkedList after polling: " + linkedList);

	        // 🔹 Sorting the LinkedList
	        Collections.sort(linkedList);
	        System.out.println("Sorted LinkedList (Ascending): " + linkedList);

	        // 🔹 Sorting in descending order
	        Collections.sort(linkedList, Collections.reverseOrder());
	        System.out.println("Sorted LinkedList (Descending): " + linkedList);

	        // 🔹 Reversing the order of elements
	        Collections.reverse(linkedList);
	        System.out.println("Reversed LinkedList: " + linkedList);

	        // 🔹 Iterating using Iterator
	        System.out.print("Iterating using Iterator: ");
	        Iterator<String> iterator = linkedList.iterator();
	        while (iterator.hasNext()) {
	            System.out.print(iterator.next() + " ");
	        }
	        System.out.println();

	        // 🔹 Iterating using ListIterator (Forward)
	        System.out.print("Iterating using ListIterator (Forward): ");
	        ListIterator<String> listIterator = linkedList.listIterator();
	        while (listIterator.hasNext()) {
	            System.out.print(listIterator.next() + " ");
	        }
	        System.out.println();

	        // 🔹 Iterating using ListIterator (Backward)
	        System.out.print("Iterating using ListIterator (Backward): ");
	        while (listIterator.hasPrevious()) {
	            System.out.print(listIterator.previous() + " ");
	        }
	        System.out.println();

	        // 🔹 Iterating using descendingIterator
	        System.out.print("Iterating using Descending Iterator: ");
	        Iterator<String> descendingIterator = linkedList.descendingIterator();
	        while (descendingIterator.hasNext()) {
	            System.out.print(descendingIterator.next() + " ");
	        }
	        System.out.println();

	        // 🔹 Using forEach() method
	        System.out.print("Iterating using forEach: ");
	        linkedList.forEach(element -> System.out.print(element + " "));
	        System.out.println();

	        // 🔹 Cloning the LinkedList
	        LinkedList<String> clonedList = (LinkedList<String>) linkedList.clone();
	        System.out.println("Cloned LinkedList: " + clonedList);

	        // 🔹 Copying elements into an array
	        String[] array = linkedList.toArray(new String[0]);
	        System.out.print("Copied Array: ");
	        for (String item : array) {
	            System.out.print(item + " ");
	        }
	        System.out.println();

	        // 🔹 Checking if LinkedList is empty
	        System.out.println("Is LinkedList Empty? " + linkedList.isEmpty());

	        // 🔹 Clearing the LinkedList
	        linkedList.clear();
	        System.out.println("LinkedList after Clearing: " + linkedList);
	    }
	}
