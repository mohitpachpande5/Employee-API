package collectionsMethods;
/*
https://docs.oracle.com/en/java/javase/21/core/java-core-libraries1.html
https://docs.oracle.com/javase/tutorial/collections/index.html
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Vector.html
## Introduction
`Vector` is a class in the Java Collection Framework that implements the `List` interface. 
It is a resizable array that allows storing duplicate elements and maintains insertion order. 
It is similar to `ArrayList`, but synchronized, making it thread-safe.

---

##  Features of `Vector`
- Implements `List` interface: Maintains an ordered collection.
- Synchronized: Thread-safe, making it slower than `ArrayList` in single-threaded applications.
- Allows duplicate elements: Can store multiple occurrences of the same value.
- Supports dynamic resizing: Unlike arrays, `Vector` grows automatically when needed.
- Uses an `incremental capacity` mechanism: Increases capacity by 100% when full 
  (compared to `ArrayList`, which increases by 50%).
- Implements `Serializable` and `Cloneable` interfaces.

---


## Constructors
| Constructor | Description |
|---------------|----------------|
| `Vector()` | Creates an empty vector with default initial capacity (10). |
| `Vector(int capacity)` | Creates a vector with the specified initial capacity. |
| `Vector(int capacity, int increment)` | Creates a vector with initial capacity and custom increment value. |
| `Vector(Collection<? extends E> c)` | Creates a vector containing all elements of a given collection. |

---

## Common Methods of `Vector`
| Method | Description |
|-----------|----------------|
| `add(E e)` | Adds an element at the end. |
| `add(int index, E element)` | Inserts an element at a specific index. |
| `addAll(Collection<? extends E> c)` | Adds all elements from a collection. |
| `get(int index)` | Retrieves an element at a specific index. |
| `set(int index, E element)` | Replaces an element at a specific index. |
| `remove(int index)` | Removes the element at a specific index. |
| `remove(Object obj)` | Removes the first occurrence of an element. |
| `removeAll(Collection<?> c)` | Removes all elements present in a collection. |
| `clear()` | Removes all elements from the vector. |
| `size()` | Returns the number of elements. |
| `isEmpty()` | Checks if the vector is empty. |
| `contains(Object o)` | Checks if the vector contains a specific element. |
| `indexOf(Object o)` | Returns the index of the first occurrence of an element. |
| `lastIndexOf(Object o)` | Returns the index of the last occurrence. |
| `capacity()` | Returns the current capacity. |
| `firstElement()` | Retrieves the first element. |
| `lastElement()` | Retrieves the last element. |
| `clone()` | Creates a shallow copy of the vector. |
| `toArray()` | Converts vector to an array. |
| `elementAt(int index)` | Gets an element at the specified index. |
| `removeElementAt(int index)` | Removes an element at a specific index. |


---

## Differences Between `Vector` and `ArrayList`
| Feature | `Vector` | `ArrayList` |
|---------|---------|------------|
| Synchronization | Synchronized (Thread-safe) | Not synchronized (Not thread-safe) |
| Performance | Slower due to synchronization overhead | Faster |
| Growth Rate | Increases capacity by 100% when full | Increases capacity by 50% |
| Legacy | Introduced in Java 1.0 | Introduced in Java 1.2 |
| Iterators | Uses both `Enumeration` & `Iterator` | Uses only `Iterator` |

---

##  When to Use `Vector`?
- When thread safety is required.
- In legacy codebases where `Vector` is already in use.
- When working in multi-threaded environments where concurrent modifications can occur.

in modern Java development, `ArrayList` is preferred unless thread safety is explicitly needed. 
For better performance in multi-threaded environments, use `CopyOnWriteArrayList` from `java.util.concurrent`.

---

##  Real-World Use Cases
| Use Case | Why Use `Vector`? |
|-------------|----------------|
| Thread-safe list operations | Ensures safe access in a multi-threaded application. |
| Legacy applications | Used in older Java applications before `ArrayList` existed. |
| Banking & Financial systems | Ensures consistency when handling concurrent transactions. |
| Multithreaded logging systems | Collects log messages safely from multiple threads. |

---

##  Conclusion
- `Vector` is a synchronized, resizable array-based data structure.
- It is useful for multi-threaded applications but is slower than `ArrayList` due to synchronization.
- Modern Java applications prefer `ArrayList` unless thread safety is required.

 */
import java.util.*;

public class VectorClassMethodsDemo {
    
    public static void main(String[] args) {
        // Create and demonstrate all vector operations
        demonstrateVectorMethods();
    }

    /**
     * This method demonstrates various operations on a Vector collection.
     * Vector is synchronized, dynamic-sized, and allows duplicate elements.
     */
    public static void demonstrateVectorMethods() {
        // Creating a Vector
        Vector<String> vector = new Vector<>();

        // Adding elements
        vector.add("Banana");
        vector.add("Apple");
        vector.add("Mango");
        vector.add("Orange");
        vector.add("Pineapple");

        System.out.println("\n📌 Original Vector: " + vector);

        // Accessing elements
        System.out.println("First Element: " + vector.firstElement());
        System.out.println("Last Element: " + vector.lastElement());
        System.out.println("Element at Index 2: " + vector.get(2));

        // Updating an element
        vector.set(1, "Cherry");
        System.out.println("Updated Vector (Replacing Apple with Cherry): " + vector);

        // Checking element presence
        System.out.println("Contains Mango? " + vector.contains("Mango"));

        // Getting the size of the Vector
        System.out.println("Size of Vector: " + vector.size());

        // Removing an element
        vector.remove("Banana");
        System.out.println("After Removing 'Banana': " + vector);

        // Sorting in ascending order
        Collections.sort(vector);
        System.out.println("Sorted Vector (Ascending Order): " + vector);

        // Sorting in descending order
        Collections.sort(vector, Collections.reverseOrder());
        System.out.println("Sorted Vector (Descending Order): " + vector);

        // Reversing elements manually
        Collections.reverse(vector);
        System.out.println("Reversed Vector: " + vector);

        // Iterating using an Iterator
        System.out.print("Iterating using Iterator: ");
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Iterating using Enumeration
        System.out.print("Iterating using Enumeration: ");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();

        // Iterating using ListIterator (Forward & Backward)
        System.out.print("Iterating using ListIterator (Forward): ");
        ListIterator<String> listIterator = vector.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        System.out.print("Iterating using ListIterator (Backward): ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();

        // Cloning the Vector
        Vector<String> clonedVector = (Vector<String>) vector.clone();
        System.out.println("Cloned Vector: " + clonedVector);

        // Copying elements into an array
        String[] array = new String[vector.size()];
        vector.copyInto(array);
        System.out.print("Copied Array: ");
        for (String item : array) {
            System.out.print(item + " ");
        }
        System.out.println();

        //  Checking vector capacity
        System.out.println("Current Capacity of Vector: " + vector.capacity());

        //  Checking if the Vector is empty
        System.out.println("Is Vector Empty? " + vector.isEmpty());

        //  Clearing all elements from the Vector
        vector.clear();
        System.out.println("Vector after Clearing: " + vector);
    }
}
