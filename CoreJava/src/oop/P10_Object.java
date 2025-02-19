package oop;
/*
## What is an Object in Java?  
An object in Java is an instance of a class that has:  
1. State (Attributes/Fields) – Represented by variables.  
2. Behavior (Methods/Functions) – Represented by functions defined in the class.  
3. Identity (Unique Memory Address) – Each object has a unique reference in memory.  

Java is an object-oriented programming (OOP) language, meaning that everything revolves around objects.  

---

## Why Use Objects in Java?  
- Encapsulation – Bundles data and behavior together.  
- Code Reusability – Reuse existing functionality by creating multiple instances.  
- Modularity – Divides large programs into manageable components.  
- Data Manipulation – Stores and processes real-world entities efficiently.  

---

## How to Create an Object in Java?  
There are five main ways to create an object in Java:  

| Method                                   | Description |
|------------------------------------------|----------------|
| Using `new` keyword                      | The most common way to create an object. |
| Using `Class.newInstance()` (Reflection) | Creates an object dynamically using reflection. |
| Using `clone()` method                   | Creates a duplicate (shallow copy) of an existing object. |
| Using Deserialization                    | Restores an object from a saved state (file/stream). |
| Using Factory Methods                    | Returns an object from a method instead of direct instantiation. |

---

## 1. Creating an Object Using `new` Keyword (Most Common Way)  
- The `new` keyword is the most widely used method to create an object.  
- It allocates memory in the heap for the object.  
- The constructor initializes the object.  

Syntax:  

ClassName obj = new ClassName(); 


---

## 2. Creating an Object Using `Class.newInstance()` (Reflection API)
- Uses Reflection to create objects dynamically.  
- `newInstance()` method invokes the default constructor.  
- Disadvantage: It requires handling exceptions (`InstantiationException`, `IllegalAccessException`).  

Syntax:  

ClassName obj = Class.forName("ClassName").newInstance();


---

## 3. Creating an Object Using `clone()` Method  
- Creates a duplicate object of an existing object.  
- Uses shallow copying by default.  
- The class must implement `Cloneable` interface.  

Syntax:  

ClassName obj2 = (ClassName) obj1.clone();


---

## 4. Creating an Object Using Deserialization  
- Deserialization is the process of converting a saved object (byte stream) back into an object.  
- Used in file handling, networking, and caching.  

Syntax:  

ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.ser"));
ClassName obj = (ClassName) in.readObject();


---

## 5. Creating an Object Using Factory Methods  
- A static method inside a class returns an object instead of direct instantiation.  
- Used in design patterns like Singleton, Factory Pattern.  

Syntax:  

ClassName obj = ClassName.createObject();


---

## Comparison of Object Creation Methods  

| Method                      | Heap Memory Allocation | Use Case |
|-----------------------------|------------------------|--------------|
| `new` keyword               | Yes                    | Regular object creation |
| `Class.newInstance()`       | Yes                    | Dynamic class loading (Reflection) |
| `clone()`                   | Yes                    | Object duplication |
| Deserialization             | Yes                    | Restoring objects from files |
| Factory Method              | Yes                    | Singleton, Factory Design Pattern |

---

## Key Takeaways
✔ Objects are instances of classes that store state and behavior.  
✔ Most common way to create an object is using the `new` keyword.  
✔ Other methods (`Reflection`, `clone()`, `Deserialization`, `Factory Pattern`) are used for special cases.  
✔ Objects are stored in heap memory, and references are stored in stack memory.  


*/
public class P10_Object {

}
