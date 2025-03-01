package oop;
/*

### Processes and Threads  
In concurrent programming, execution happens in two ways: processes and threads. 
Java mainly focuses on threads, but processes also play an important role.  

#### Processes:  
- A process runs independently with its own memory and resources.  
- It is often seen as a program or application running on the system.  
- Some applications may actually consist of multiple processes working together.  
- To communicate between processes, systems use Inter Process Communication (IPC) methods like pipes and sockets.  
- Java applications usually run as a single process, but you can create additional processes using `ProcessBuilder`.  

#### Threads:  
- A thread is like a lightweight process that runs inside a process.  
- Creating a thread is faster and uses fewer resources than creating a process.  
- All threads within a process share memory and files, which is efficient but can lead to synchronization issues.  
- Every Java program starts with one main thread, which can create additional threads as needed.  
- The Java platform supports multithreading, allowing multiple tasks to run concurrently.  

### Comparison table between Processes and Threads in Java:  

| Feature              | Process                                                    | Thread                            |
|----------------------|---------------------------------------------------|--------|
| Definition           | A self-contained execution unit with its own memory space. | A smaller execution unit within a process that shares memory with other threads. |
| Resource Consumption | Heavy – requires more memory and resources.                | Light – uses fewer resources. |
| Memory Sharing       | Each process has its own separate memory.                  | Threads share the process’s memory and resources. |
| Communication        | Communication between processes is complex                 | Easier communication since threads share the same memory. |
| Creation Speed       | Slow – requires more overhead to create a new process.     | Fast – requires less overhead to create a new thread. |
| Dependency           | Independent – one process does not depend on another.      | Dependent – threads within a process are linked. |
| Crash Impact         | If a process crashes, it does not affect other processes.  | If a thread crashes, it may affect the entire process. |
| Use Case             | Running separate applications, background services, etc.   | Performing multiple tasks within the same application (e.g., handling UI and background tasks in Java). |

---

## What is Multithreading in Java?  
Multithreading in Java is a technique that allows multiple tasks (threads) to execute concurrently within 
a single process. It improves application performance by utilizing CPU cores efficiently.  

### Key Features of Multithreading
- Concurrency – Allows multiple tasks to run simultaneously.  
- Parallel Execution – Threads can run on multiple cores to improve performance.  
- Resource Sharing – Threads share common memory and resources.  
- Independent Execution – Failure of one thread does not stop others.  
- Better UI Responsiveness – Essential for GUI-based applications.  

---

## Multithreading vs Multiprocessing
| Feature                           | Multithreading                    | Multiprocessing |
|-----------------------------------|-----------------------------------|------------------|
| Definition                        | Multiple threads within a process | Multiple processes running independently |
| Memory Usage                      | Threads share memory              | Processes have separate memory |
| Context Switching                 | Faster (same memory)              | Slower (independent memory) |
| Performance                       | Better for CPU-intensive tasks    | Better for isolated processes |
| Inter-process Communication (IPC) | Easier (shared memory)            | More complex |

---
## Thread Lifecycle in Java  
A thread in Java goes through multiple states during execution. 
Each state is managed using various thread methods.  

### Thread Lifecycle States  
1. New (Created) – Thread is created but not started yet.  
2. Runnable (Ready to run) – Thread is ready and waiting for CPU allocation.  
3. Running (Executing) – Thread has been scheduled and is executing.  
4. Blocked (Waiting for a resource) – Thread is waiting to acquire a lock.  
5. Waiting (Indefinite waiting) – Thread waits indefinitely until another thread notifies it.  
6. Timed Waiting (Waiting for a fixed time) – Thread is waiting for a specific duration.  
7. Terminated (Dead) – Thread has completed execution or has been stopped.  

---

## Methods Used in Thread Lifecycle
| Method        | State                   | Purpose                         |
|---------------|-------------------------|---------------------------------|
| `start()`     | New → Runnable          | Starts the thread and calls `run()`. |
| `run()`       | Runnable → Running      | Defines the thread’s task. |
| `sleep(ms)`   | Running → Timed Waiting | Pauses the thread for a given time. |
| `yield()`     | Running → Runnable      | Suggests that the CPU should give time to another thread. |
| `join()`      | Waiting                 | Makes one thread wait for another thread’s completion. |
| `wait()`      | Waiting                 | Makes a thread wait indefinitely for another thread’s notification. |
| `notify()`    | Waiting → Runnable      | Wakes up a waiting thread. |
| `notifyAll()` | Waiting → Runnable      | Wakes up all waiting threads. |
| `suspend()` *(Deprecated)* | Running → Blocked | Pauses the thread execution. |
| `resume()` *(Deprecated)* | Blocked → Running | Resumes a suspended thread. |
| `stop()` *(Deprecated)* | Any State → Terminated | Stops a thread immediately. |
| `interrupt()` | Running | Requests a thread to stop but doesn’t force it. |
| `isAlive()` | Any State | Checks if a thread is still running. |

---

### What is a Daemon Thread in Java?  
A daemon thread in Java is a low-priority background thread that runs in support of user threads. 
It is automatically terminated by the JVM when all non-daemon (user) threads finish execution.  

### Key Characteristics of Daemon Threads:  
✅ Runs in the Background: Used for background tasks like garbage collection.  
✅ Depends on User Threads: If no user thread is running, JVM exits, stopping daemon threads automatically.  
✅ Cannot Prevent JVM Termination: Unlike user threads, daemon threads do not keep the JVM alive.  
✅ Default Behavior: Threads are user threads by default but can be set as daemon before starting.  

### Use Cases of Daemon Threads:  
| Scenario            | Purpose of Daemon Thread |
|-------------------------|----------------------------|
| Garbage Collector (GC) | Automatically clears unused memory in JVM. |
| Daemon Threads in Executors | Background tasks in multi-threading. |
| Monitoring & Logging | Keeps logs updated in real-time without blocking execution. |
| Auto-Save in Editors | Saves file changes at regular intervals. |

---

## Creating Threads in Java  
Threads in Java can be created using two approaches:  

### A) Older Approach (Pre-Java 8)  
1. Extending the `Thread` Class  
   - Create a class that extends `Thread`.  
   - Override the `run()` method.  
   - Start the thread using `start()`.  

2. Implementing the `Runnable` Interface  
   - Implement `Runnable` in a class.  
   - Define the `run()` method.  
   - Pass the instance to `Thread` and call `start()`.  

### B) Newer Approach (Java 8+)  
1. Using Lambda Expressions  
   - No need to create a separate class.  
   - Pass a lambda expression to `Thread`.  

2. Using `ExecutorService` (Java 5+)  
   - A thread pool manages multiple threads efficiently.  
   - Avoids creating and destroying threads repeatedly.
   - Manages thread pools automatically.
   - Uses `ExecutorService` instead of manually handling threads.  

3. Using `Callable` and `Future` (Java 5+)  
   - Unlike `Runnable`, `Callable` can return results and throw exceptions.  
   - `Future` helps retrieve the result once computation is complete.  

4. Using `Fork/Join Framework` (Java 7+)  
   - Used for parallel processing of large tasks.  
   - Efficient for recursive computations.  
   - Designed for parallel processing.
   - Uses `ForkJoinPool` and `RecursiveTask`

5. Using `CompletableFuture` (Java 8+)  
   - Provides better handling of asynchronous programming.  
   - Supports chaining of multiple asynchronous operations.  
   - Provides asynchronous programming capabilities.
   - Supports chaining of tasks without blocking threads.
   
6. `Virtual Threads (Project Loom)` (Java 21)
- Introduces lightweight threads.
- Improves performance over traditional OS threads.
- Uses `Thread.ofVirtual().start()` to create virtual threads.

---

## Thread Synchronization (Handling Shared Resources)
When multiple threads share a resource, data inconsistency can occur. Synchronization ensures thread safety.

### Types of Synchronization
| Method               | Description |
|----------------------|----------------|
| Synchronized Methods | Locks an entire method so only one thread can execute it at a time. |
| Synchronized Blocks | Locks only a critical section of code instead of the entire method. |
| Reentrant Locks (`Lock` interface) | Provides more control than `synchronized`, supports fairness policies. |
| Volatile Keyword | Ensures changes to variables are visible to all threads immediately. |
| Atomic Variables (`AtomicInteger`, `AtomicBoolean`) | Provides lock-free, thread-safe operations. |

---

## Inter-Thread Communication (Thread Coordination)
Threads need to communicate with each other for better performance and control.

### Methods for Inter-Thread Communication
| Method     | Description |
|------------|----------------|
| `wait()` | Pauses the thread until `notify()` is called. |
| `notify()` | Wakes up one waiting thread. |
| `notifyAll()` | Wakes up all waiting threads. |
| `join()` | Makes a thread wait until another completes. |
| `yield()` | Suggests giving CPU time to another thread. |
| `sleep(ms)` | Makes the thread pause for a specified time. |

---

##  Deadlock, Starvation & Livelock Issues
| Problem | Description | Solution |
|------------|----------------|-------------|
| Deadlock | Two or more threads waiting for each other’s resources indefinitely. | Avoid nested locks, use lock ordering. |
| Starvation | A thread waits indefinitely as higher-priority threads keep executing. | Use fair locking mechanisms. |
| Livelock | Threads keep responding to each other’s state but do no useful work. | Implement timeouts for resource requests. |

---

## Real-World Use Cases of Multithreading
| Use Case | Why Use Multithreading? |
|-------------|----------------------------|
| Web Servers | Handle multiple user requests simultaneously. |
| Gaming Applications | Run game logic and UI rendering in parallel. |
| Banking Transactions | Process multiple transactions concurrently. |
| Data Processing | Process large datasets in parallel. |
| Machine Learning | Train models faster using multi-core CPUs. |

---

## Summary
- Older Approach: Extending `Thread` or implementing `Runnable`.
- Newer Approach: Executors, Callable/Future, Fork/Join, CompletableFuture.
- Synchronization Techniques: `synchronized`, `Lock`, `volatile`, `Atomic Variables`.
- Concurrency Issues: Deadlock, starvation, livelock.
- New Java Features: Virtual threads (Java 21) improve performance.

# Executor vs Traditional Threading in Java  

| Feature            | Traditional Threading (`Thread` & `Runnable`) | Executor Framework (`ExecutorService`) |
|------------------------|------------------------------------------------|---------------------------------------------|
| Thread Management  | Manually created using `new Thread()`. | Uses a thread pool for better management. |
| Thread Reusability | No reusability, a new thread is needed for every task. | Threads are reused from the pool, reducing overhead. |
| Performance        | Higher resource consumption due to frequent thread creation/destruction. | More efficient as it manages a fixed number of threads. |
| Scalability        | Poor scalability; creating many threads increases CPU & memory usage. | Highly scalable due to thread pooling. |
| Control           | Limited control over the threads. | Provides better control using `shutdown()`, `awaitTermination()`, etc. |
| Task Execution     | Starts using `start()`, but lacks flexible scheduling. | Supports delayed, periodic, and concurrent execution. |
| Concurrency Handling | Difficult to manage when multiple threads are used. | Manages concurrency more efficiently. |
| Exception Handling | No built-in mechanism for handling exceptions. | Can handle exceptions using `Future` and `Callable`. |
| Resource Utilization | Inefficient; may create more threads than required. | Optimized resource utilization via thread pooling. |
| Implementation Complexity | Requires manual thread management, synchronization, and monitoring. | Simplifies thread management using built-in mechanisms. |
| Best Use Case      | When few short-lived threads are needed. | When managing a large number of concurrent tasks. |

### Summary
- Use Traditional Threading when dealing with simple, one-off background tasks.  
- Use Executor Framework for better performance, scalability, and thread management in large applications.

*/


class MyThread extends Thread {
    public MyThread(String name) {
        super(name); // Setting thread name
    }

    @Override
    public void run() {
        System.out.println(getName() + " (RUNNING) ➜ Executing task...");

        try {
            System.out.println(getName() + " (SLEEPING) ➜ Sleeping for 2 seconds...");
            Thread.sleep(2000); // Sleep method

            System.out.println(getName() + " (YIELD) ➜ Yielding CPU to another thread.");
            Thread.yield(); // Yield method

            synchronized (this) {
                System.out.println(getName() + " (WAITING) ➜ Waiting for notification...");
                wait(3000); // Thread waits for 3 seconds
            }
            
        } catch (InterruptedException e) {
            System.out.println(getName() + " (INTERRUPTED) ➜ Thread was interrupted.");
        }

        System.out.println(getName() + " (ALIVE) ➜ Is alive: " + isAlive()); // Checking if thread is alive
    }
}

class MyRunnable implements Runnable {
	private volatile boolean running = true; // Volatile flag to use stop thread
    public void stopThread() {
        running = false;
    } 
    
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + " (RUNNING) ➜ Executing task...");

        try {
            System.out.println(currentThread.getName() + " (YIELD) ➜ Yielding CPU.");
            Thread.yield(); // Yield method

            System.out.println(currentThread.getName() + " (SLEEPING) ➜ Sleeping for 1 second...");
            Thread.sleep(1000); // Sleep method

        } catch (InterruptedException e) {
            System.out.println(currentThread.getName() + " (INTERRUPTED) ➜ Thread was interrupted.");
        }

        System.out.println(currentThread.getName() + " (STATE) ➜ Current State: " + currentThread.getState()); // Getting thread state
    }
}

public class P25_MultiThreading {
	
    public static void main(String[] args) {
        System.out.println("🔹 Main Thread Started!");

        // Creating thread using "extends Thread"
        MyThread thread1 = new MyThread("Thread-1");

        // Creating thread using "implements Runnable"
        Thread thread2 = new Thread(new MyRunnable(), "Thread-2");

        // Thread IDs
        System.out.println(thread1.getName() + " ➜ ID: " + thread1.threadId());
        System.out.println(thread2.getName() + " ➜ ID: " + thread2.threadId());

        // Set Priorities
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        // Check Priority
        System.out.println(thread1.getName() + " ➜ Priority: " + thread1.getPriority());
        System.out.println(thread2.getName() + " ➜ Priority: " + thread2.getPriority());

        // Daemon Status
        thread1.setDaemon(true);
        System.out.println(thread1.getName() + " ➜ Daemon: " + thread1.isDaemon());
        System.out.println(thread2.getName() + " ➜ Daemon: " + thread2.isDaemon());

        // Start Threads
        thread1.start();
        thread2.start();

        // Check if Threads are Alive
        System.out.println(thread1.getName() + " ➜ Is Alive: " + thread1.isAlive());
        System.out.println(thread2.getName() + " ➜ Is Alive: " + thread2.isAlive());

        try {
            thread1.join(3000); // Wait for 3 seconds max
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread (INTERRUPTED) ➜ Interrupted.");
        }

        // Notify Waiting Threads
        synchronized (thread1) {
            System.out.println("Main Thread (NOTIFY) ➜ Notifying Thread-1...");
            thread1.notify();
        }

        
        // Interrupt Thread
        if (thread1.isAlive()) {
            System.out.println(thread1.getName() + " (INTERRUPTING) ➜ Interrupting...");
            thread1.interrupt(); 
           
        }

        // Final Thread States
        System.out.println(thread1.getName() + " ➜ Final State: " + thread1.getState());
        System.out.println(thread2.getName() + " ➜ Final State: " + thread2.getState());
        //thread2.stopThread();
        System.out.println("🔹 Main Thread Exiting!");
    }
}

