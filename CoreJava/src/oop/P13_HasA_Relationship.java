package oop;
/*
---

## What is a Has-A Relationship?  
A Has-A relationship in Java refers to composition or aggregation, where one class contains an instance 
of another class as a field instead of inheriting from it. 
This relationship is also known as "object containment".  

### Syntax:  
class ClassA {  
    ClassB objB;  // Has-A Relationship (Composition)
}

## Purpose of Has-A Relationship  
- Code Reusability: Allows a class to use functionalities of another class without directly inheriting from it.  
- Encapsulation: Keeps classes independent, reducing code complexity and improving maintainability.  
- Loose Coupling: Reduces dependencies between classes, making modifications easier without affecting the entire codebase.  
- Better Flexibility: Allows multiple objects to be used dynamically instead of enforcing a rigid hierarchy.  

## Why is Has-A Relationship Required?  
1. Avoids Inheritance Overuse:  
   - Inheritance creates a strict parent-child bond, which can lead to tightly coupled code.  
   - Composition allows more flexible relationships.  
   
2. Better Code Maintainability:  
   - Changes in the parent class in inheritance can affect all child classes.  
   - With Has-A, only the containing class needs modification, keeping other classes intact.  

3. Supports Real-World Modeling:  
   - Real-world entities often have composition relationships (e.g., A Car has an Engine, but a Car is not an Engine).  
   - This makes code more intuitive and natural.  

4. Solves Diamond Problem:  
   - Since Java does not support multiple inheritance, Has-A allows sharing behavior across classes without conflicts.  

## Why Use Has-A Instead of Inheritance?  
| Feature               | Inheritance (Is-A)               | Composition (Has-A)                   |
|-----------------------|----------------------------------|--------------------------------|
| Relationship Type     | Parent-Child (Strict Hierarchy)  | Object Containment (Flexible) |
| Code Reusability      | High but tightly coupled         | High and loosely coupled      |
| Modifications Impact  | Affects all child classes        | Affects only the containing class |
| Java Support          | Limited (No multiple inheritance for classes) | Fully supported |
| Real-world Example    | A Dog is an Animal               | A Car has an Engine |

## Conclusion  
- Has-A relationship (Composition) is preferred over Inheritance in cases where a class needs 
  to use another class's behavior without being forced into a strict hierarchy.  
- It improves modularity, reusability, and maintainability while avoiding issues like the diamond problem 
  in inheritance.  


*/
public class P13_HasA_Relationship {

	public static void main(String[] args) {
		

	}

}
