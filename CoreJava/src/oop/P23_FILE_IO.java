package oop;
/*
#`java.io` Package 

## 1. What is a Stream?  
A stream in Java is a sequence of data (bytes or characters) used to read from or write to a source 
(such as files, memory, or network). It abstracts the data flow and simplifies input/output operations.  

Streams are classified into:  
1. Input Streams – Used for reading data from a source.  
2. Output Streams – Used for writing data to a destination.  

---

## 2. Types of Streams in Java (`java.io` Package)  
Java I/O is categorized into three main types:  

### A. Byte Streams  
- Handle binary data (e.g., images, videos, audio, and any non-text file).  
- Operate at the byte (8-bit) level.  
- Based on `InputStream` (for reading) and `OutputStream` (for writing).  
- Purpose: Used when dealing with raw binary data.  

#### Byte Stream Classes
| Category           | Input Class             | Output Class            | Purpose    |
|--------------------|-------------------------|-------------------------|------------|
| File Streams       | `FileInputStream`       | `FileOutputStream`      | Read/write binary data to/from files. |
| Buffered Streams   | `BufferedInputStream`   | `BufferedOutputStream`  | Improve efficiency using buffering. |
| Data Streams       | `DataInputStream`       | `DataOutputStream`      | Read/write primitive data types. |
| Object Streams     | `ObjectInputStream`     | `ObjectOutputStream`    | Serialize/deserialize objects. |
| Byte Array Streams | `ByteArrayInputStream`  | `ByteArrayOutputStream` | Read/write data to byte arrays. |
| Piped Streams      | `PipedInputStream`      | `PipedOutputStream`     | Used for inter-thread communication. |

---

### B. Character Streams  
- Handle text data (e.g., `.txt`, `.csv`, `.json`, etc.).  
- Operate at the character (16-bit Unicode) level.  
- Based on `Reader` (for reading) and `Writer` (for writing).  
- Purpose: Used when dealing with character-based data and text files.  

#### Character Stream Classes
| Category           | Reader Class            | Writer Class           | Purpose |
|--------------------|-------------------------|--------------------- --|------------|
| File Streams       | `FileReader`            | `FileWriter`           | Read/write character data to/from files. |
| Buffered Streams   | `BufferedReader`        | `BufferedWriter`       | Improve efficiency using buffering. |
| String Streams     | `StringReader`          | `StringWriter`         | Read/write data from/to strings. |
| Conversion Streams | `InputStreamReader`     | `OutputStreamWriter`   | Convert between byte and character streams. |
| Piped Streams      | `PipedReader`           | `PipedWriter`          | Used for inter-thread communication. |

---

### C. Console and Specialized Streams  
- Handle console-based input and output.  
- Used for interactive console applications, formatted output, and secure input handling (like passwords).  
- Purpose: Provide convenient methods for standard I/O and advanced serialization.  

#### Console and Specialized Stream Classes
| Category         | Class                 | Purpose |
|------------------|-------------------------|------------|
| Console I/O      | `Console`               | Read input from the console securely (e.g., passwords). |
| Standard Streams | `System.in`, `System.out`, `System.err` | Standard input, output, and error handling. |
| Print Streams    | `PrintStream`, `PrintWriter` | Output formatted text to files or console. |
| Serialization Streams | `ObjectInputStream`, `ObjectOutputStream` | Read/write objects for serialization. |

---

## 3. Purpose and Use Cases of Java Streams  

| Type of Stream    | Purpose                       | Use Cases                                           |
|-------------------|-------------------------------|-----------------------------------------------------|
| Byte Streams      | Handle binary data            | Reading/writing images, audio, video, encrypted files. |
| Character Streams | Handle text data              | Reading/writing `.txt`, `.csv`, `.json` files with proper encoding. |
| Buffered Streams  | Improve efficiency            | Reduce the number of I/O operations when handling large files. |
| Data Streams      | Read/write primitive types    | Saving structured binary data (e.g., game save files, settings files). |
| Object Streams    | Serialize/deserialize objects | Store/retrieve Java objects in files or over a network. |
| Console Streams   | Handle user input/output      | Interactive CLI applications, logging, debugging. |

---

## 4. Stream Class Hierarchy (From `java.lang.Object`)  
Below is the tree structure of the Java stream classes.


java.lang.Object
│
├── java.io.InputStream (Byte Input)
│   ├── FileInputStream
│   ├── BufferedInputStream
│   ├── DataInputStream
│   ├── ObjectInputStream
│   ├── ByteArrayInputStream
│   └── PipedInputStream
│
├── java.io.OutputStream (Byte Output)
│   ├── FileOutputStream
│   ├── BufferedOutputStream
│   ├── DataOutputStream
│   ├── ObjectOutputStream
│   ├── ByteArrayOutputStream
│   └── PipedOutputStream
│
├── java.io.Reader (Character Input)
│   ├── FileReader
│   ├── BufferedReader
│   ├── StringReader
│   ├── InputStreamReader
│   └── PipedReader
│
├── java.io.Writer (Character Output)
│   ├── FileWriter
│   ├── BufferedWriter
│   ├── StringWriter
│   ├── OutputStreamWriter
│   └── PipedWriter
│
├── java.io.Console (Console Input/Output)
│
├── java.io.PrintStream (Formatted Output)
│
├── java.io.PrintWriter (Formatted Output)
│
├── java.io.ObjectInputStream (Object Serialization)
│
└── java.io.ObjectOutputStream (Object Serialization)


---

## 6. Summary
- Streams are used for input/output operations in Java.  
- Three main types: Byte Streams (binary data), Character Streams (text data), and Console/Specialized Streams.  
- Streams are categorized into File Streams, Buffered Streams, Data Streams, Object Streams, and Print Streams.  
- Java stream classes follow a hierarchy under `java.io.InputStream`, `java.io.OutputStream`, `java.io.Reader`, and `java.io.Writer`.  
- The `File` class manages file and directory properties, while NIO (New I/O) provides modern file handling mechanisms.  

---
# `java.io.File` Class  

## 1. Introduction to `java.io.File`  
The `File` class in Java is part of the `java.io` package and is used to represent file and directory paths. 
It does not read or write file contents but provides methods for:  
- Creating new files and directories  
- Checking file properties (size, type, permissions)  
- Managing file operations (renaming, deleting, checking existence)  
- Navigating directories  

---

## 2. Key Features of `java.io.File` Class  
- Represents both files and directories  
- Provides file metadata (name, path, size, permissions)  
- Supports file and directory operations (create, delete, rename, list)  
- Does not handle actual file reading or writing (use `FileReader`, `FileWriter`, `InputStream`, 
  or `OutputStream` for I/O operations)  
- Works with both absolute and relative file paths  
- Platform-independent file handling  

---

## 3. Constructing `File` Objects  
The `File` class has multiple constructors to create a file reference:  
- `File(String pathname)` – Takes a file path as a string.  
- `File(String parent, String child)` – Specifies parent directory and file name separately.  
- `File(File parent, String child)` – Uses an existing `File` object as a parent directory.  

---

## 4. Common Methods in `java.io.File`  
### A. File Information Methods  
| Method              | Description |
|---------------------|----------------|
| `getName()`         | Returns the file name. |
| `getAbsolutePath()` | Returns the absolute path of the file. |
| `getPath()`         | Returns the path used to create the `File` object. |
| `getParent()`       | Returns the parent directory of the file. |
| `length()`          | Returns the file size in bytes. |
| `exists()`          | Checks if the file exists. |
| `isFile()`          | Checks if it is a file. |
| `isDirectory()`     | Checks if it is a directory. |

---

### B. File Operations Methods  
| Method                          | Description |
|---------------------------------|----------------|
| `createNewFile()`               | Creates a new empty file (returns `true` if created). |
| `delete()`                      | Deletes the file or directory. |
| `renameTo(File newFile)`        | Renames the file. |
| `canRead()`                     | Checks if the file is readable. |
| `canWrite()`                    | Checks if the file is writable. |
| `setReadOnly()`                 | Makes the file read-only. |
| `setWritable(boolean writable)` | Sets the file writable. |

---

### C. Directory Operations Methods  
| Method        | Description |
|---------------|----------------|
| `mkdir()`     | Creates a single directory. |
| `mkdirs()`    | Creates multiple nested directories. |
| `list()`      | Returns an array of filenames in a directory. |
| `listFiles()` | Returns an array of `File` objects representing directory contents. |

---

## 5. File Paths in Java  
### A. Absolute vs. Relative Paths  
- Absolute Path – A complete file path starting from the root directory.  
  Example:  
  - Windows: `C:\Users\Documents\file.txt`  
  - Linux/Mac: `/home/user/file.txt`  
- Relative Path – A path relative to the current working directory.  
  Example: `data/file.txt` (relative to project root)  

### B. File Path Separators  
Java uses platform-independent file path handling:  
- Windows: Uses `\` (backslash) (e.g., `"C:\\Users\\file.txt"`)  
- Linux/Mac: Uses `/` (forward slash) (e.g., `"/home/user/file.txt"`)  
- Java provides `File.separator` to handle platform differences dynamically.  

---

## 6. Checking File Permissions  
The `File` class allows checking and modifying file permissions:  
| Method                              | Purpose |
|-------------------------------------|------------|
| `canRead()`                         | Checks if the file is readable. |
| `canWrite()`                        | Checks if the file is writable. |
| `canExecute()`                      | Checks if the file is executable. |
| `setReadable(boolean readable)`     | Changes file read permission. |
| `setWritable(boolean writable)`     | Changes file write permission. |
| `setExecutable(boolean executable)` | Changes file execute permission. |

---

## 7. Handling File Deletion  
- `delete()` – Deletes the file or directory (returns `true` if deleted).  
- `deleteOnExit()` – Deletes the file when the JVM exits.  
- Note: Directories must be empty before deletion.  

---

## 8. Directory Handling in Java  
The `File` class is also used to work with directories:  
- `mkdir()` – Creates a directory (only if the parent directory exists).  
- `mkdirs()` – Creates directories, including missing parent directories.  
- `list()` – Returns filenames in a directory.  
- `listFiles()` – Returns `File` objects representing files in a directory.  

---

## 9. Difference Between `File` and I/O Streams  
| Aspect             | `File` Class                       | I/O Streams (`FileReader`, `FileWriter`, etc.) |
|--------------------|------------------------------------|---------------------------------------------|
| Purpose            | Manages file properties and paths. | Handles reading/writing file contents. |
| Reads/Writes Data? | No, only manages file metadata.    | Yes, performs actual data transfer. |
| Used For?          | Checking existence, permissions, renaming, and deleting files. | Reading/writing file content in bytes or characters. |
| Examples           | `File file = new File("data.txt");` | `FileReader fr = new FileReader("data.txt");` |

---

## 10. Summary
- The `java.io.File` class represents file and directory paths but does not handle file content.  
- It provides methods to create, delete, rename, and check file properties.  
- It supports absolute and relative file paths, ensuring platform independence.  
- File permissions can be checked and modified using `canRead()`, `canWrite()`, `setWritable()`, etc.  
- `mkdir()` and `mkdirs()` help create directories, while `list()` and `listFiles()` retrieve directory contents.  
- The `File` class is different from file I/O streams, which handle actual reading/writing operations.  

*/
public class P23_FILE_IO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
