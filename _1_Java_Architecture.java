import java.util.*;



public class _1_Java_Architecture{
    public static void main(String[] args) {
        System.out.println("Compiler just translates the code, interperter performs both translation and execution. Compiler does teh translation only if, no issues in the code, interpreter translated til teh line fo code,where it didn't find any issue. Compiler stores the translations as a seperate file e.g, byuet cod file. So , it executes only one time. THenw e use the translate file for all execution. But Interpreter, transalted ans executes every time. So, compielr is slower, interpreter is faster. Java is a Hybrid Langauage.");
        System.out.println("In C/C++, when .cpp program is compiled, the source code gets directly converted into the machine code, and these executable .exe files contains instructions/system calls that can be directly executed by the CPU via the OS. So, u can't use the .exe compiled file in Windows OS, to another OS, to run the .exe file, as the .exe file contains system calls speicific to that os, whereas in Java, the soruce code, gets compiled into byte code, and this byte code is independednt and common in all OS, and we use JVM, whcih interprets teh byte code and executes the instructions by communicating with teh hardware via OS. The JVM is platform dependent. Dep., on the OS. So, teh same byte code can be executed in any OS, with using the help fo that OS's compatible JVM. So, java is said to be platfrom independent.");
        System.out.println("JDK = Development tools + JRE");
        System.out.println("JRE = Java class library + JVM");
        System.out.println("JVM contains interpreter/JIT compiler");

        System.out.println("\nJDK is used for compilation of Java programs (javac is the compiler)");
        System.out.println("Command: javac Introduction.java creates Introduction.class");
        System.out.println("JRE is used for executing Java programs. JRE uses the JVM internally.JVM is the interpreter. (java Introduction)");
        System.out.println("Command: java Introduction, here the word java calls the jvm");
        System.out.println("JVM Architecture: ");
        System.out.println("The java code file in disk is converted into byte code, and loading is performed (i.e) the byte code is placed in the memory using Loader (Class Loader - java speicic term,as in java all r classes) -  the Class loader consists of 3 components - Loading, Linking, Initialisation. \n Loading consists of \n: 1. Booststrap Class Loader -Loads the core Java classes from the JDK/JRE \n 2. Extension Class loader - Loads extension libraries beyond the core Java classes \n 3. Application Class Loader - it loads the user-defined classes in our application.\n Linking consists of - \n 1. Verify - It verifies or checks whether the byte code is valid or not. \n 2. Prepare - It will allocate memory to the static variables. \n3. Resolve - It refers the reference of the method, from the place, wheere the method is being called in the code. \n . In initialisation, all the static var., and static blocks are initialised. \n The program is laoded into the memory is organised in the ram into multiple components. Let us see about each of them. \n 1. Code section (Method area -java speciic term - Contains all loaded classes bytecode. Each class becomes a separate entity within this single method area. Stores class metadata, methods, static variables, and constant pool) \n 2. Stack -  Each thread of the program, has it's own stack, and program register, but shares common heap area, where the object of the classes and instance var., are stored and the stack contains local variables (variables inside a method) and frames of method calls, when a method is called in the thread execution, it's stack gets the fraem of the method addeded, when the methods gets returned after exectuion, the frame is removed from the stack.So the stack represents the execution path of your program - it tracks which methods are currently being executed and in what order. \n 3. Heap - contains the dynamic objects created during execution of the program, e.,g new object creation. \n 4. PC registers - they contain the ref., to the memory adderesses of the next instruction to be executed. \n 5. Native Method Stack - is a special stack used to manage the native method (c/c++) calls. This stack is separate from Java's regular call stack. It allows native code to execute with its own memory management rules. The native method stack is needed because native methods don't follow Java's memory management rules and may have different calling conventions.\n EXECUTION ENGINE: \n After these organisation, the execution engine of the JVM, which contains interpreter, JIT compiler and garbage collector . It converts the byte code into Machine Level Code, so cpu will executes it.IF a  loop/repeteadly any code aprt , jvm needs to translate, it could use jit compiler instead of innterpreter for effeicieny. Garbage collector will remopve the objects in the Heap space, after some tim,e fi that object is not used. \n NATIVE METHOD INTERFACE: \n For tasks that directly access low-level hardware or operating system features like file handling, networking, and graphics, Java often needs to use native code (c/c++). Java Native Interface (JNI) is the bridge that allows Java code to call native methods and vice versa. It defines how Java methods map to native functions.");
        System.out.println("\nIn Java, everything is inside classes");
        System.out.println("When the interpreter executes 'java Introduction', it executes the main method");
        System.out.println("main method return type is void, public makes it visible");
        System.out.println("static keyword allows using main without creating an object");
        System.out.println("System.out.println");
        System.out.println("System is a class within java.lang package");
        System.out.println("out is an instance of PrintStream class from java.io package");
        System.out.println("println() is a method of the PrintStream class");
        
        System.out.println("\nIs it compulsory for file and class names to be the same?");
        System.out.println("For non-public classes: No, but the compiled class name must be used to run the program");
        System.out.println("Example: Introduction.java with class Conclusion inside creates Conclusion.class");
        System.out.println("You must run it with: java Conclusion");
        
        System.out.println("\nFor public classes: Yes, file and class names MUST match exactly (including case)");
        System.out.println("This ensures each public class has a unique and identifiable source file");
        
        System.out.println("\nMain method signature must be exactly: public static void main(String[] args)");
        System.out.println("Without this exact signature, the program won't run");
        System.out.println("The method must be:");
        System.out.println("- public: Accessible from outside the class");
        System.out.println("- static: Can be called without creating an object");
        System.out.println("- void: Doesn't return a value");
        System.out.println("- Named 'main'");
        System.out.println("- Take String[] as parameter");
        
        System.out.println("\nExample of command line arguments:");
        System.out.println("java Introduction vishal kumar");
        System.out.println("args[0] will contain: vishal");
        System.out.println("args[1] will contain: kumar");
        System.out.println("Java is sepcial ebcuase it IS Write Once, Run Anywhere(wora),, it's platform independednt, exceptional backward compatibilty, better emmory management and security");


        
        
    }
}