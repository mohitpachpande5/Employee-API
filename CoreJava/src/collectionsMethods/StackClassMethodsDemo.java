package collectionsMethods;
/*
##  Introduction  
`Stack` is a class in Java that represents a Last-In-First-Out (LIFO) data structure. 
It is part of the `java.util` package and extends `Vector`, meaning it inherits all properties 
of `Vector` but provides additional methods for stack operations.

---

##  Features of `Stack`
- Follows LIFO principle – The last element added is the first to be removed.
- Extends `Vector` – Inherits `Vector` methods and is synchronized.
- Allows `null` values – Unlike some collections, `Stack` allows `null` elements.
- Thread-safe – Because it extends `Vector`, its methods are synchronized.
- Slow compared to `Deque` – Due to synchronization overhead, `Deque` is often preferred.

---

##  Constructors
| Constructor | Description |
|---------------|----------------|
| `Stack()` | Creates an empty stack with an initial capacity of 10 (inherited from `Vector`). |


---

## Common Methods of `Stack`
| Method | Description |
|-----------|----------------|
| `push(E e)` | Pushes an element onto the top of the stack. |
| `pop()` | Removes and returns the top element of the stack. Throws `EmptyStackException` if empty. |
| `peek()` | Returns the top element without removing it. |
| `isEmpty()` | Checks if the stack is empty. |
| `search(Object o)` | Returns the 1-based position of an element from the top, or `-1` if not found. |


---

## Stack vs Deque (`ArrayDeque`)
| Feature | `Stack` | `Deque (ArrayDeque)` |
|---------|--------|----------------|
| Thread Safety | Synchronized | Not synchronized |
| Performance | Slower (due to synchronization) | Faster |
| Preferred For | Legacy code, thread-safe use | Modern applications |


---

##  Real-World Use Cases
| Use Case | Why Use `Stack`? |
|-------------|----------------------|
| Undo/Redo in text editors | Stores previous states for rollback. |
| Backtracking algorithms (Maze, DFS) | Remembers previous positions. |
| Expression evaluation (Postfix, Infix) | Helps in mathematical parsing. |
| Browser history navigation | Stores page history for "Back" button. |

---

##  Performance Analysis
| Operation | Time Complexity |
|--------------|--------------------|
| Push (`push(E e)`) | O(1) |
| Pop (`pop()`) | O(1) |
| Peek (`peek()`) | O(1) |
| Search (`search(E e)`) | O(n) |

---

## Conclusion
- Use `Stack` only when synchronization is needed; otherwise, prefer `ArrayDeque`.
- It is best for LIFO-based problems like recursion, undo/redo, and expression evaluation.
- Performance is slower than `ArrayDeque` due to inherited synchronization from `Vector`.


 */
import java.util.Stack;
import java.util.*;

public class StackClassMethodsDemo {

    public static void main(String[] args) {
        // Call the method that demonstrates all Stack operations
        demonstrateStackMethods();
    }

    /**
     * Demonstrates all major methods of Stack class.
     */
    public static void demonstrateStackMethods() {
        // 🔹 Creating a Stack
        Stack<String> stack = new Stack<>();

        // 🔹 Adding elements (push)
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Mango");
        stack.push("Orange");
        stack.push("Pineapple");

        System.out.println("\n📌 Original Stack: " + stack);

        // 🔹 Retrieving top element (peek)
        System.out.println("Top Element (Peek): " + stack.peek());

        // 🔹 Removing elements (pop)
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Stack after Pop: " + stack);

        // 🔹 Checking if stack is empty
        System.out.println("Is Stack Empty? " + stack.isEmpty());

        // 🔹 Searching for an element
        System.out.println("Position of 'Mango' (from top): " + stack.search("Mango"));
        System.out.println("Position of 'Banana' (from top): " + stack.search("Banana"));

        // 🔹 Iterating using Iterator
        System.out.print("Iterating using Iterator: ");
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 🔹 Iterating using ListIterator (Forward)
        System.out.print("Iterating using ListIterator (Forward): ");
        ListIterator<String> listIterator = stack.listIterator();
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

        // 🔹 Iterating using Enumeration
        System.out.print("Iterating using Enumeration: ");
        Enumeration<String> enumeration = stack.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();

        // 🔹 Cloning the Stack
        Stack<String> clonedStack = (Stack<String>) stack.clone();
        System.out.println("Cloned Stack: " + clonedStack);

        // 🔹 Copying elements into an array
        String[] array = new String[stack.size()];
        stack.toArray(array);
        System.out.print("Copied Array: ");
        for (String item : array) {
            System.out.print(item + " ");
        }
        System.out.println();

        // 🔹 Clearing the Stack
        stack.clear();
        System.out.println("Stack after Clearing: " + stack);
    }
}
