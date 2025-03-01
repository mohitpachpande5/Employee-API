package collectionsMethods;
/*
https://docs.oracle.com/en/java/javase/21/core/java-core-libraries1.html
https://docs.oracle.com/javase/tutorial/collections/index.html
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html

## Introduction
`ArrayList` is a resizable array implementation of the `List` interface in Java. 
It allows dynamic resizing, fast random access, and maintains insertion order. Unlike `Vector`, 
it is not synchronized, making it faster in single-threaded applications.  

---

## Features of `ArrayList`
- Implements `List` interface: Maintains the order of elements.
- Allows duplicate elements: Stores multiple occurrences of the same value.
- Dynamic resizing: Increases size when full.
- Not synchronized: Faster but not thread-safe.
- Uses an `incremental capacity` mechanism: Grows by 50% when full (unlike `Vector`, which grows by 100%).
- Implements `Serializable` and `Cloneable` interfaces.

---

---

## Constructors
| Constructor | Description |
|---------------|----------------|
| `ArrayList()` | Creates an empty list with default capacity (10). |
| `ArrayList(int capacity)` | Creates a list with the specified initial capacity. |
| `ArrayList(Collection<? extends E> c)` | Creates a list containing all elements from a given collection. |


---

## Common Methods of `ArrayList`
| Method | Description |
|-----------|----------------|
| `add(E e)` | Adds an element at the end. |
| `add(int index, E element)` | Inserts an element at a specific index. |
| `addAll(Collection<? extends E> c)` | Adds all elements from another collection. |
| `get(int index)` | Retrieves an element at a specific index. |
| `set(int index, E element)` | Replaces an element at a specific index. |
| `remove(int index)` | Removes an element at a specific index. |
| `remove(Object obj)` | Removes the first occurrence of an element. |
| `clear()` | Removes all elements from the list. |
| `size()` | Returns the number of elements. |
| `isEmpty()` | Checks if the list is empty. |
| `contains(Object o)` | Checks if the list contains a specific element. |
| `indexOf(Object o)` | Returns the index of the first occurrence. |
| `lastIndexOf(Object o)` | Returns the index of the last occurrence. |
| `toArray()` | Converts list to an array. |
| `iterator()` | Returns an iterator for traversing elements. |


---

## Differences Between `ArrayList` and `LinkedList`
| Feature | `ArrayList` | `LinkedList` |
|---------|------------|-------------|
| Implementation | Uses a dynamic array | Uses a doubly linked list |
| Insertion/Deletion | Slow in the middle | Fast at any position |
| Random Access (`get(index)`) | Fast (O(1)) | Slow (O(n)) |
| Memory Usage | Less (stores only elements) | More (stores elements + pointers) |
| Use Case | Best for frequent read operations | Best for frequent insert/delete operations |


---

## When to Use `ArrayList`?
- When fast random access (`get(index)`) is required.
- For read-heavy operations where elements are rarely removed or inserted in the middle.
- When memory consumption should be minimal.

---

## Real-World Use Cases
| Use Case | Why Use `ArrayList`? |
|-------------|----------------|
| Student records in a university | Fast access to records using index. |
| Online shopping cart system | Stores items in a user's cart temporarily. |
| Social media feed | Stores and retrieves posts in order. |
| Auto-complete suggestions | Stores word lists for quick retrieval. |

---

## Performance Analysis
| Operation | Time Complexity |
|--------------|--------------------|
| Insertion at end (`add(E e)`) | O(1) (Amortized) |
| Insertion at middle (`add(index, E e)`) | O(n) |
| Deletion (`remove(index)`) | O(n) |
| Searching (`get(index)`) | O(1) |
| Contains (`contains(E e)`) | O(n) |

---

##  Thread Safety
- `ArrayList` is not synchronized.
- Use `Collections.synchronizedList(new ArrayList<>())` for thread safety.
- Alternatively, use `CopyOnWriteArrayList` from `java.util.concurrent` for better performance in concurrent environments.

---

## Conclusion
- `ArrayList` is a fast, resizable array-based implementation.
- It is unsynchronized, making it faster than `Vector` in single-threaded environments.
- It is better for random access but slower for frequent insertions/deletions in the middle.
- Use `LinkedList` if insert/delete operations are frequent.

 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ArrayListClassMethodsDemo {

	    public static void main(String[] args) {
	        // Create and demonstrate all ArrayList operations
	        demonstrateArrayListMethods();
	    }

	    /**
	     * This method demonstrates various operations on an ArrayList collection.
	     * ArrayList is a dynamic-sized, ordered, and unsynchronized collection.
	     */
	    public static void demonstrateArrayListMethods() {
	        // Creating an ArrayList
	        ArrayList<String> arrayList = new ArrayList<>();
            List<Integer> listArray=new ArrayList<>();
	        // Adding elements
	        arrayList.add("Banana");
	        arrayList.add("Apple");
	        arrayList.add("Mango");
	        arrayList.add("Orange");
	        arrayList.add("Pineapple");

	        System.out.println("\n📌 Original ArrayList: " + arrayList);

	        // Accessing elements
	        System.out.println("First Element: " + arrayList.get(0));
	        System.out.println("Last Element: " + arrayList.get(arrayList.size() - 1));
	        System.out.println("Element at Index 2: " + arrayList.get(2));

	        // Updating an element
	        arrayList.set(1, "Cherry");
	        System.out.println("Updated ArrayList (Replacing Apple with Cherry): " + arrayList);

	        // Checking element presence
	        System.out.println("Contains Mango? " + arrayList.contains("Mango"));

	        // Getting the size of the ArrayList
	        System.out.println("Size of ArrayList: " + arrayList.size());

	        // Removing an element
	        arrayList.remove("Banana");
	        System.out.println("After Removing 'Banana': " + arrayList);

	        // Sorting in ascending order
	        Collections.sort(arrayList);
	        System.out.println("Sorted ArrayList (Ascending Order): " + arrayList);

	        // Sorting in descending order
	        Collections.sort(arrayList, Collections.reverseOrder());
	        System.out.println("Sorted ArrayList (Descending Order): " + arrayList);

	        // Reversing elements manually
	        Collections.reverse(arrayList);
	        System.out.println("Reversed ArrayList: " + arrayList);

	        // Iterating using an Iterator
	        System.out.print("Iterating using Iterator: ");
	        Iterator<String> iterator = arrayList.iterator();
	        while (iterator.hasNext()) {
	            System.out.print(iterator.next() + " ");
	        }
	        System.out.println();

	        // Iterating using ListIterator (Forward & Backward)
	        System.out.print("Iterating using ListIterator (Forward): ");
	        ListIterator<String> listIterator = arrayList.listIterator();
	        while (listIterator.hasNext()) {
	            System.out.print(listIterator.next() + " ");
	        }
	        System.out.println();

	        System.out.print("Iterating using ListIterator (Backward): ");
	        while (listIterator.hasPrevious()) {
	            System.out.print(listIterator.previous() + " ");
	        }
	        System.out.println();

	        //  Cloning the ArrayList
	        ArrayList<String> clonedArrayList = (ArrayList<String>) arrayList.clone();
	        System.out.println("Cloned ArrayList: " + clonedArrayList);

	        // Copying elements into an array
	        String[] array = new String[arrayList.size()];
	        arrayList.toArray(array);
	        System.out.print("Copied Array: ");
	        for (String item : array) {
	            System.out.print(item + " ");
	        }
	        System.out.println();

	        //  Checking if the ArrayList is empty
	        System.out.println("Is ArrayList Empty? " + arrayList.isEmpty());

	        //  Clearing all elements from the ArrayList
	        arrayList.clear();
	        System.out.println("ArrayList after Clearing: " + arrayList);
	    }
	}
