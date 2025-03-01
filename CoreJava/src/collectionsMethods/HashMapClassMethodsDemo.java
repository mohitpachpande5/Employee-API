package collectionsMethods;
/*
##  Introduction  
`HashMap` is a part of the Java Collection Framework and is present in the `java.util` package. 
It is used to store key-value pairs, where each key is unique and mapped to a value.  

---

##  Key Features of `HashMap`  
- Implements Map Interface.  
- Stores key-value pairs in a hash table.  
- Allows `null` keys and values (only one `null` key is allowed).  
- Not synchronized (not thread-safe, use `ConcurrentHashMap` for thread safety).  
- No guaranteed order of elements (unlike `LinkedHashMap` or `TreeMap`).  
- Fast lookup, insertion, and deletion (average O(1) time complexity).  

---

##  Constructors
| Constructor | Description |
|---------------|----------------|
| `HashMap()` | Creates an empty HashMap with the default capacity (16) and load factor (0.75). |
| `HashMap(int initialCapacity)` | Creates a HashMap with a specified initial capacity. |
| `HashMap(int initialCapacity, float loadFactor)` | Creates a HashMap with a given initial capacity and load factor. |
| `HashMap(Map<? extends K, ? extends V> m)` | Creates a HashMap with elements from another Map. |

---

##  Commonly Used Methods in `HashMap`
| Method | Description |
|-----------|----------------|
| `put(K key, V value)` | Inserts a key-value pair. |
| `get(K key)` | Retrieves the value for a key, or `null` if not found. |
| `remove(K key)` | Removes a key-value pair. |
| `containsKey(K key)` | Checks if a key exists in the map. |
| `containsValue(V value)` | Checks if a value exists in the map. |
| `size()` | Returns the number of key-value pairs. |
| `isEmpty()` | Checks if the map is empty. |
| `keySet()` | Returns a set of all keys. |
| `values()` | Returns a collection of all values. |
| `entrySet()` | Returns a set of key-value pairs (`Map.Entry<K, V>`). |
| `putAll(Map m)` | Copies all key-value pairs from another map. |
| `clear()` | Removes all elements from the map. |


---

##  Internal Working of `HashMap`
- Uses a hash table (array of linked lists or binary trees).  
- Computes the hash code of the key to determine the bucket (index in the array).  
- Handles collisions using separate chaining (linked list or tree).  
- Resizes dynamically when the load factor threshold is exceeded.  


###  Collision Handling
| Method | Description |
|-----------|----------------|
| Separate Chaining | Uses linked lists or red-black trees at each bucket. |
| Treeification | Converts a linked list to a red-black tree if collisions exceed a threshold (default: 8). |


---

##  Performance Analysis
| Operation | Average Case | Worst Case (High Collisions) |
|--------------|----------------|-------------------|
| `put(K key, V value)` | O(1) | O(n) |
| `get(K key)` | O(1) | O(n) |
| `remove(K key)` | O(1) | O(n) |
| `containsKey(K key)` | O(1) | O(n) |
| `iteration` | O(n) | O(n) |

- Best case: O(1) (no collisions).  
- Worst case: O(n) (when all keys map to the same bucket).  
- Optimized using tree-based structure (O(log n) worst case for large collisions).  

---

## `HashMap` vs. Other Maps
| Feature | `HashMap` | `LinkedHashMap` | `TreeMap` |
|------------|----------|----------------|---------|
| Ordering | No order | Insertion order | Sorted order (ascending) |
| Performance (`put/get/remove`) | O(1) | O(1) | O(log n) |
| Allows `null` key | ✅ Yes | ✅ Yes | ❌ No |
| Thread-Safe | ❌ No | ❌ No | ❌ No |
| Use Case | Fast lookups | Maintain insertion order | Sorted data |


---


##  Real-World Use Cases
| Use Case | Why Use `HashMap`? |
|-------------|----------------------|
| Caching | Fast lookup of precomputed results. |
| Database Indexing | Mapping primary keys to records. |
| Configuration Storage | Key-value pairs for settings. |
| Counting Occurrences | Count word frequencies in text. |
| User Sessions | Store user data efficiently. |


---

## Conclusion
- Use `HashMap` when fast lookup is required.  
- Not ordered, but efficient (O(1) operations in most cases).  
- Handle high collisions carefully for better performance.  
- Use `ConcurrentHashMap` for thread safety.  


 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapClassMethodsDemo {

	    public static void main(String[] args) {
	        // Call the method to demonstrate HashMap operations
	        demonstrateHashMapOperations();
	    }

	    /**
	     * Demonstrates all major HashMap methods.
	     */
	    public static void demonstrateHashMapOperations() {
	        // 🔹 Creating a HashMap
	        HashMap<Integer, String> map = new HashMap<>();

	        // 🔹 Adding key-value pairs using put() & putIfAbsent()
	        map.put(1, "Apple");
	        map.put(2, "Banana");
	        map.put(3, "Cherry");
	        map.putIfAbsent(4, "Mango"); // Adds only if key 4 is absent
	        System.out.println("\n📌 Original HashMap: " + map);

	        // 🔹 Accessing values using get() & getOrDefault()
	        System.out.println("Value for key 2: " + map.get(2));
	        System.out.println("Value for non-existing key 5 (default): " + map.getOrDefault(5, "Not Found"));

	        // 🔹 Updating values using replace() & compute()
	        map.replace(2, "Blueberry"); // Replaces existing key 2
	        map.compute(3, (k, v) -> v.toUpperCase()); // Converts value of key 3 to uppercase
	        System.out.println("📌 Updated HashMap: " + map);

	        // 🔹 Checking existence of key/value
	        System.out.println("Contains key 1? " + map.containsKey(1));
	        System.out.println("Contains value 'Mango'? " + map.containsValue("Mango"));

	        // 🔹 Removing key-value pairs
	        map.remove(4); // Removes key 4
	        map.remove(3, "CHERRY"); // Removes key 3 only if value matches "CHERRY"
	        System.out.println("📌 HashMap after removals: " + map);

	        // 🔹 Retrieving keys, values, entries
	        System.out.println("Keys: " + map.keySet());
	        System.out.println("Values: " + map.values());
	        System.out.println("Entries: " + map.entrySet());

	        // 🔹 Iterating using forEach
	        System.out.print("Iterating using forEach: ");
	        map.forEach((key, value) -> System.out.print(key + "->" + value + " "));
	        System.out.println();

	        // 🔹 Iterating using Iterator
	        System.out.print("Iterating using Iterator: ");
	        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
	        while (iterator.hasNext()) {
	            Map.Entry<Integer, String> entry = iterator.next();
	            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
	        }
	        System.out.println();

	        // 🔹 Iterating using Stream API
	        System.out.print("Iterating using Stream API: ");
	        map.entrySet().stream().forEach(entry -> System.out.print(entry.getKey() + "=" + entry.getValue() + " "));
	        System.out.println();

	        // 🔹 Cloning HashMap
	        HashMap<Integer, String> clonedMap = (HashMap<Integer, String>) map.clone();
	        System.out.println("📌 Cloned HashMap: " + clonedMap);

	        // 🔹 Replacing all values using replaceAll()
	        map.replaceAll((k, v) -> v + " Fruit");
	        System.out.println("📌 HashMap after replaceAll(): " + map);

	        // 🔹 Checking if HashMap is empty & size
	        System.out.println("Is HashMap empty? " + map.isEmpty());
	        System.out.println("Size of HashMap: " + map.size());

	        // 🔹 Clearing all elements
	        map.clear();
	        System.out.println("📌 HashMap after clear(): " + map);
	    }
	}
