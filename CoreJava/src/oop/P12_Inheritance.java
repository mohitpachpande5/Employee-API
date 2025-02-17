package oop;
/*
## What is Inheritance?  
Inheritance is one of the core concepts of Object-Oriented Programming (OOP) in Java. 
It allows one class (child or subclass) to inherit properties (fields) and behaviors (methods) from another 
class (parent or superclass). This promotes code reusability, maintainability, and hierarchical classification.

### Purpose of Inheritance
- Code Reusability – Reduces redundant code by allowing subclasses to use parent class methods and properties.  
- Method Overriding – Enables modification of inherited methods to provide a specific implementation.  
- Extensibility – Enhances modularity by allowing existing functionality to be extended without modifying existing code.  
- Improved Maintainability – Changes made in the parent class automatically apply to all subclasses.  

---

## Types of Inheritance in Java  
Java supports three types of inheritance through classes, but does not support multiple and hybrid inheritance with classes
to avoid the diamond problem. However, multiple inheritance can be achieved using interfaces.

| Type                     | Description                                   |
|--------------------------|-----------------------------------------------|
| Single Inheritance       | One class inherits from another class (A → B) |
| Multilevel Inheritance   | A class inherits from another class, which itself is inherited from another class (A → B → C) |
| Hierarchical Inheritance | A single parent class is inherited by multiple child classes (A → B, A → C) |
| Multiple Inheritance (Not Supported with Classes, Only with Interfaces) | A child class inherits from multiple parent classes (A, B → C) using interfaces |
| Hybrid Inheritance (Not Supported with Classes, Only with Interfaces) | A combination of two or more inheritance types achieved using interfaces |

---

## Meaning of Different Types of Inheritance  

### Single Inheritance  
- Meaning: A single child class inherits from a single parent class.  
- Use Case: When a subclass needs to extend the behavior of a single superclass.  

### Multilevel Inheritance  
- Meaning: A subclass acts as a parent for another subclass.  
- Use Case: When extending multiple levels of a class hierarchy (e.g., Grandparent → Parent → Child).  

### Hierarchical Inheritance  
- Meaning: Multiple child classes inherit from a single parent class.  
- Use Case: When multiple classes need the same base functionality.  

### Multiple Inheritance (Not Supported with Classes, Only with Interfaces)  
- Meaning: A class inherits from multiple interfaces (Java does not support this directly with classes).  
- Reason for Not Supporting in Classes: It leads to ambiguity (Diamond Problem).  
- Solution: Java uses interfaces to achieve multiple inheritance.  

### Hybrid Inheritance (Not Supported with Classes, Only with Interfaces)  
- Meaning: Combination of two or more types of inheritance (e.g., multiple + multilevel) achieved using interfaces.  
- Reason for Not Supporting in Classes: Complexity and ambiguity in method resolution.  

---

### Diamond Problem in Java Inheritance  

The Diamond Problem in Java occurs when a class inherits from two classes that have a common superclass,
leading to ambiguity in method resolution.  

#### Why does the Diamond Problem occur?  
If Java allowed multiple inheritance through classes, a subclass would inherit methods from two parent classes
that both inherit from a common superclass. If both parents override the same method differently, 
Java wouldn't know which version to use in the subclass, creating a conflict.  

#### Example Structure of the Diamond Problem  
```
    A
   / \
  B   C
   \ /
    D
```
- `B` and `C` inherit from `A` and override a method.
- `D` inherits from both `B` and `C`, leading to ambiguity: Which method from `B` or `C` should `D` inherit?  

#### How Java Avoids the Diamond Problem  
Java does not support multiple inheritance through classes to avoid this issue. Instead, Java allows multiple 
inheritance through interfaces because interfaces do not contain implementation, reducing ambiguity.  

#### Solution: Using Interfaces  
Instead of classes, Java allows multiple inheritance through interfaces where a class can implement multiple 
interfaces without conflict. If two interfaces have the same default method, the implementing class must 
override it to resolve ambiguity.  

---

## Why Not Use Inheritance in Some Cases?  

### Increased Coupling  
- Subclasses become tightly coupled with the parent class.  
- If a parent class changes, it may break subclasses.  

### Diamond Problem in Multiple Inheritance  
- Java does not support multiple inheritance using classes because of the diamond problem, 
where a child class inherits from two parent classes that have the same method.  
- Solution: Java uses interfaces instead.  

### Performance Overhead  
- Using inheritance increases memory usage as objects carry unused parent class methods and fields.  

### Reduced Flexibility  
- Inheritance forces an IS-A relationship, which might not always be suitable.  
- Composition (HAS-A relationship) is preferred when a flexible design is needed.  

---

## 5. Which Two Keywords are Used for Inheritance?  

1. `extends` Keyword  
- Used to inherit a class.  
- Use Case: Single, multilevel, and hierarchical inheritance.  

2. `implements` Keyword  
- Used to inherit an interface.  
- Use Case: Supports multiple inheritance via interfaces.  

---
 
*/

/*
Problem Statement:
Create a Shape Calculation System where different types of shapes (Circle, Rectangle, Sphere, and Cuboid) 
inherit from a common Shape class and override methods to calculate their area and surface area.
 */
public class P12_Inheritance {

	public static void main(String[] args) {
		Shape circle = new Circle(5);
	     Shape rectangle = new Rectangle(4, 6);
	     Shape sphere = new Sphere(3);
	     Shape cuboid = new Cuboid(3, 4, 5);

	     // Displaying results
	     System.out.println("Circle: Area = " + circle.area() + ", Surface Area = " + circle.surfaceArea());
	     System.out.println("Rectangle: Area = " + rectangle.area() + ", Surface Area = " + rectangle.surfaceArea());
	     System.out.println("Sphere: Area = " + sphere.area() + ", Surface Area = " + sphere.surfaceArea());
	     System.out.println("Cuboid: Area = " + cuboid.area() + ", Surface Area = " + cuboid.surfaceArea());

	}

}

//Base class: Shape
abstract class Shape {
 abstract double area();         // Method to calculate area
 abstract double surfaceArea();  // Method to calculate surface area
}

//Single Inheritance: Circle -> Shape
class Circle extends Shape {
 double radius;

 // Constructor
 Circle(double radius) {
     this.radius = radius;
 }

 // Overriding methods to calculate area and surface area
 @Override
 double area() {
     return Math.PI * radius * radius;  // πr²
 }

 @Override
 double surfaceArea() {
     return 2 * Math.PI * radius * radius;  // 2πr²
 }
}

//Single Inheritance: Rectangle -> Shape
class Rectangle extends Shape {
 double length, width;

 // Constructor
 Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 // Overriding methods to calculate area and surface area
 @Override
 double area() {
     return length * width;  // l × w
 }

 @Override
 double surfaceArea() {
     return 2 * (length * width);  // 2(l × w) (for a flat shape)
 }
}

//Multilevel Inheritance: Sphere -> Circle -> Shape
class Sphere extends Circle {
 // Constructor
 Sphere(double radius) {
     super(radius);
 }

 // Overriding methods to calculate area and surface area
 @Override
 double area() {
     return 4 * Math.PI * radius * radius;  // 4πr² (Sphere surface area)
 }

 @Override
 double surfaceArea() {
     return area();  // Sphere surface area is the same as area
 }
}

//Multilevel Inheritance: Cuboid -> Rectangle -> Shape
class Cuboid extends Rectangle {
 double height;

 // Constructor
 Cuboid(double length, double width, double height) {
     super(length, width);
     this.height = height;
 }

 // Overriding methods to calculate area and surface area
 @Override
 double area() {
     return length * width * height;  // Volume (l × w × h)
 }

 @Override
 double surfaceArea() {
     return 2 * (length * width + width * height + height * length);  // 2(lw + wh + hl)
 }
}



