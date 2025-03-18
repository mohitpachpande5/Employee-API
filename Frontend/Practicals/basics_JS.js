// Introduction to JavaScript
console.log("Hello, JavaScript!");

// Variables in JavaScript
let name = "Anirudha"; // let allows reassignment
const age = 25; // const prevents reassignment
var city = "Mumbai"; // var (old way, avoid using)

// Statements, Operators, Comments, Expressions, and Control Structures
// Statements: Individual instructions in JavaScript
let a = 15;
let b = 7;
let result;

// Operators: Used to perform operations on variables and values
result = a + b; // Addition operator
console.log("Addition:", result);

result = a - b; // Subtraction operator
console.log("Subtraction:", result);

result = a * b; // Multiplication operator
console.log("Multiplication:", result);

result = a / b; // Division operator
console.log("Division:", result);

result = a % b; // Modulus (Remainder) operator
console.log("Modulus:", result);

// Comments: Used to add explanations or disable code
// This is a single-line comment
/* This is a 
   multi-line comment */

// Expressions: Combinations of values, variables, and operators
let expressionResult = (a * 2) + (b / 2);
console.log("Expression Result:", expressionResult);

// Control Structures
if (a > b) {
    console.log("a is greater than b");
} else if (a === b) {
    console.log("a and b are equal");
} else {
    console.log("b is greater than a");
}

// Loop: For loop example
for (let i = 0; i < 5; i++) {
    console.log("Iteration:", i);
}

// JavaScript Scopes
function testScope() {
    let localVar = "I'm local";
    console.log(localVar);
}
testScope();
// console.log(localVar); // Uncaught ReferenceError: localVar is not defined

// Strings, String Methods
let text = "JavaScript is awesome!";
console.log(text.toUpperCase()); // Convert to uppercase
console.log(text.replace("awesome", "powerful"));

// Numbers, Number Methods
let num = 42.567;
console.log(num.toFixed(2)); // Round to 2 decimal places
console.log(Number.isInteger(num)); // Check if integer

// Boolean Values
let isJavaScriptFun = true;
console.log(isJavaScriptFun);

// Dates, Date Formats, Date Methods
let today = new Date();
console.log(today.toDateString()); // Get human-readable date
console.log(today.getFullYear()); // Get current year

// Arrays, Array Methods
let fruits = ["Apple", "Banana", "Cherry"];
fruits.push("Orange"); // Add item to array
console.log(fruits);
console.log(fruits.indexOf("Banana")); // Find index of an item

// Lab: Practice writing basic JavaScript programs
// Task: Write a program to calculate the square of a number
function square(num) {
    return num * num;
}
console.log("Square of 5:", square(5));

var text = " JavaScript is awesome! ";
console.log(text.length); // Get string length
console.log(text.toUpperCase()); // Convert to uppercase
console.log(text.toLowerCase()); // Convert to lowercase
console.log(text.trim()); // Remove whitespace
console.log(text.charAt(5)); // Get character at index 5
console.log(text.includes("awesome")); // Check if contains substring
console.log(text.replace("awesome", "powerful")); // Replace substring
console.log(text.split(" ")); // Split into an array
console.log(text.concat(" Let's learn it!")); // Concatenate strings

var num = 42.567;
console.log(num.toFixed(2)); // Round to 2 decimal places
console.log(num.toPrecision(3)); // Format to specific length
console.log(Number.isInteger(num)); // Check if integer
console.log(Number.parseFloat("123.45")); // Convert string to float
console.log(Number.parseInt("123.45")); // Convert string to integer
console.log(Math.round(num)); // Round number
console.log(Math.floor(num)); // Round down
console.log(Math.ceil(num)); // Round up
console.log(Math.random()); // Generate random number between 0 and 1
console.log(Math.max(10, 20, 30)); // Get max value
console.log(Math.min(10, 20, 30)); // Get min value

var today = new Date();
console.log(today.toDateString()); // Get human-readable date
console.log(today.toISOString()); // ISO format
console.log(today.toLocaleDateString()); // Local date format
console.log(today.toLocaleTimeString()); // Local time format
console.log(today.getFullYear()); // Get year
console.log(today.getMonth() + 1); // Get month (0-based index)
console.log(today.getDate()); // Get day of the month
console.log(today.getDay()); // Get weekday (0-Sunday, 6-Saturday)
console.log(today.getHours()); // Get hours
console.log(today.getMinutes()); // Get minutes
console.log(today.getSeconds()); // Get seconds
console.log(today.setFullYear(2022)); // Change year
console.log(new Date(2022, 0, 1)); // Create a specific date

// Converting String to Date
let dateString = "2025-03-18";
let convertedDate = new Date(dateString);
console.log("Converted Date:", convertedDate);

// Converting Date to String
let formattedDate = today.toISOString().split("T")[0];
console.log("Formatted Date:", formattedDate);

// Arrays, Array Methods
let fruits = ["Apple", "Banana", "Cherry"];
fruits.push("Orange"); // Add item to array
console.log(fruits);
console.log(fruits.indexOf("Banana")); // Find index of an item

// Creating Objects in JavaScript

// Using Object Literal
let person = {
    firstName: "Anirudha",
    lastName: "Gaikwad",
    age: 25,
    city: "Mumbai"
};
console.log(person);

// Using Constructor Function
function Car(brand, model, year) {
    this.brand = brand;
    this.model = model;
    this.year = year;
}
let myCar = new Car("Toyota", "Camry", 2022);
console.log(myCar);

// Using Class Syntax (ES6)
class Animal {
    constructor(name, type) {
        this.name = name;
        this.type = type;
    }
}
let dog = new Animal("Buddy", "Dog");
console.log(dog);

// What is DOM?
// The Document Object Model (DOM) represents the structure of an HTML document in a tree-like format, allowing JavaScript to manipulate web pages dynamically.

// Types of DOM:
// 1. Core DOM: Standard model for all document types.
// 2. HTML DOM: Specific for HTML documents.
// 3. XML DOM: Used for XML documents.

// Example of DOM Manipulation
// Changing text content using JavaScript
// Assuming an HTML file with: <p id="demo">Hello World</p>
document.getElementById("demo").innerText = "Hello JavaScript!";

// Writing a Method with Parameters and Return Type
function addNumbers(a, b) {
    return a + b;
}
console.log("Sum:", addNumbers(5, 10));

// Method inside an Object
let calculator = {
    multiply: function(x, y) {
        return x * y;
    }
};
console.log("Multiplication:", calculator.multiply(4, 5));
