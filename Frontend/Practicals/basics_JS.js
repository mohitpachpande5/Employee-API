/*
===========================================
          JavaScript Fundamentals
===========================================
*/

// =============================
// Types of Variables in JavaScript
// =============================

// Using var (Old way, function-scoped)
var x = 10;
console.log("var x:", x);

// 1.2 Using let (Block-scoped, preferred for reassignment)
let y = 20;
y = 25; // Allowed
console.log("let y:", y);

// 1.3 Using const (Block-scoped, cannot be reassigned)
const z = 30;
// z = 35; // Error: Assignment to constant variable
console.log("const z:", z);

// =============================
// Literals in JavaScript
// =============================

// Numeric Literal
let numLiteral = 100;

// String Literal
let strLiteral = "Hello, JavaScript!";

// Boolean Literal
let boolLiteral = true;

// Array Literal
let arrLiteral = [1, 2, 3, 4];

// Object Literal
let objLiteral = { name: "Anirudha", age: 25 };

console.log(numLiteral, strLiteral, boolLiteral, arrLiteral, objLiteral);

// =============================
// Data Types in JavaScript
// =============================

let str = "JavaScript"; // String
let num = 42; // Number
let bool = false; // Boolean
let arr = [10, 20, 30]; // Array (object type)
let obj = { key: "value" }; // Object
let undef; // Undefined
let nullable = null; // Null

console.log(typeof str, typeof num, typeof bool, typeof arr, typeof obj, typeof undef, typeof nullable);

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

// Decision Making and Control Statements
let num = 10;
if (num > 0) {
    console.log("Number is positive");
} else if (num < 0) {
    console.log("Number is negative");
} else {
    console.log("Number is zero");
}

// Switch Case
let day = "Monday";
switch (day) {
    case "Monday":
        console.log("Start of the week");
        break;
    case "Friday":
        console.log("End of the work week");
        break;
    default:
        console.log("Another day");
}

// Loops
// For Loop
for (let i = 0; i < 5; i++) {
    console.log("Iteration:", i);
}

// While Loop
let count = 0;
while (count < 3) {
    console.log("Count:", count);
    count++;
}

// Do-While Loop
do {
    console.log("This will execute at least once");
} while (false);


// =============================
// Functions with Parameters & Return Type
// =============================

function multiply(a, b) {
    return a * b;
}
console.log("Multiplication:", multiply(5, 6));

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

// =============================
// Date Formats
// =============================

console.log(new Date().toISOString()); // ISO Format
// Indian Date Format (DD/MM/YYYY)
console.log(new Date().toLocaleDateString("en-IN")); // Indian Format
console.log(new Date().toLocaleDateString("en-US")); // US Format
console.log(new Date().toLocaleDateString("en-GB")); // UK Format
// Custom Date Format (DD/MM/YYYY)
let customDate = today.getDate() + '/' + (today.getMonth() + 1) + '/' + today.getFullYear();
console.log(customDate);

// =============================
// Array Manipulation & Built-in Methods
// =============================

let numbers = [1, 2, 3, 4, 5];
numbers.push(6); // Add at end
console.log(numbers);
numbers.pop(); // Remove last element
console.log(numbers);
numbers.unshift(0); // Add at beginning
console.log(numbers);
numbers.shift(); // Remove first element
console.log(numbers);
console.log(numbers.concat([7, 8])); // Merge arrays
console.log(numbers.slice(1, 4)); // Extract sub-array
console.log(numbers.map(num => num * 2)); // Transform array
console.log(numbers.filter(num => num % 2 === 0)); // Filter even numbers
console.log(numbers.find(num => num > 2)); // Find first match





