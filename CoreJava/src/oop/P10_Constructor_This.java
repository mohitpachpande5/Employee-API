package oop;
/*

## What is a Constructor?  
A constructor is a special method in Java that is used to initialize objects. 
It is called automatically when an object is created.  

### Key Points:  
- A constructor must have the same name as the class.  
- It does not have a return type (not even `void`).  
- It allocates memory for an object and initializes instance variables.  
- Constructors can be overloaded to allow different ways of object initialization.  

---

## Types of Constructors in Java  

### Default Constructor  
A default constructor is a constructor with no parameters.  

### Parameterized Constructor  
A parameterized constructor takes arguments to initialize instance variables with specific values.  

## Constructor Overloading  
Constructor overloading means defining multiple constructors with different parameter lists in the same class.  

## 6. Purpose of a Constructor  

| Feature | Description |
|------------------------|----------------------------------------------------------------------|
| Automatic Execution    | Called automatically when an object is created.                      |
| Memory Allocation      | Allocates memory for the object in the heap.                         |
| Object Initialization  | Assigns default or user-defined values to instance variables.        |
| Encapsulation          | Ensures proper data initialization and hiding implementation details.|
| Code Reusability       | Overloading allows different ways to initialize objects.             |


## `this` Keyword in Java  
The `this` keyword refers to the current object of the class.  

### Where & Why is `this` Used?  

| Usage                                     | Purpose                                                                         |
|-------------------------------------------|---------------------------------------------------------------------------------|
| Referring to Instance Variables           | Differentiates between instance and local variables if they have the same name. |
| Calling Another Constructor               | Uses `this()` to call another constructor in the same class.                    |
| Returning the Current Object              | Used to return the current object in methods.                                   |
| Passing the Current Object as a Parameter | Passes the current object reference to another method or constructor.           |

#### Syntax:  
this.variableName;      // Referring to instance variable
this.methodName();      // Calling another method in the same class
this();                // Calling another constructor
return this;           // Returning current object

---

*/

//P10_Constructor_This class demonstrating constructors and 'this' keyword usage
public class P10_Constructor_This {
	    double radius;
	    // 🔹 Default Constructor - Initializes radius to 1.0
	    P10_Constructor_This() {
	        this(1.0); // Calls parameterized constructor
	        System.out.println("Default Constructor Called: Radius = " + this.radius);
	    }

	    // 🔹 Parameterized Constructor - Initializes radius to given value
	    P10_Constructor_This(double radius) {
	        this.radius = radius; // Using 'this' to refer to instance variable
	        System.out.println("Parameterized Constructor Called: Radius = " + this.radius);
	    }

	    // 🔹 Copy Constructor - Creates a new object using another Circle object
	    P10_Constructor_This(P10_Constructor_This otherCircle) {
	        this(otherCircle.radius); // Calls parameterized constructor
	        System.out.println("Copy Constructor Called: Radius = " + this.radius);
	    }

	    // 🏁 Method to calculate and return area of the circle
	    double calculateArea() {
	        return Math.PI * this.radius * this.radius; // Using 'this' for clarity
	    }

	    // 🏁 Method to calculate and return circumference of the circle
	    double calculateCircumference() {
	        return 2 * Math.PI * this.radius;
	    }

	    // 📢 Display method demonstrating 'this' keyword calling another method
	    void showDetails() {
	        System.out.println("🔵 Circle with Radius: " + this.radius);
	        System.out.println("📐 Area: " + this.calculateArea());
	        System.out.println("📏 Circumference: " + this.calculateCircumference());
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        // 🚀 Using Default Constructor
	        P10_Constructor_This c1 = new P10_Constructor_This();
	        c1.showDetails();

	        // 🚀 Using Parameterized Constructor
	        P10_Constructor_This c2 = new P10_Constructor_This(5.0);
	        c2.showDetails();

	        // 🚀 Using Copy Constructor
	        P10_Constructor_This c3 = new P10_Constructor_This(c2);
	        c3.showDetails();
	    }
	}

