//import java.lang.String;
import operatoroverloading.strings.*;

public class _15_packages_and_access_modifers {
    public static void main(String[] args) {
        System.out.println("Pacakges are used ot organise classes, interfacs and pacakges. We can create our own pacakge adn sue them. First before creating a file for a package, in that file, we need to mention the package name, wher the file going to exist in the top of the file. Then we need to compile and save the file in the same package directory or even in other directory, like 'javac -d ./Subtraction.java', this creates .class file in the package/folder structure the code file mentioned. you can also create class files in other directories, but when u r running th ejava filr, u need to umention that directory explicitely to run the file. IN java, either we can mention the pacakge import statemsn at the start, and use its utility inside teh code, or directly write import tstmetn in the code itself, for eg., check it below");

        java.lang.String description = new java.lang.String("Hello World");
        String a = "Vishal";
        String b = "ish";
        Subtraction s = new Subtraction();
        System.out.println("Custom Operator overloading, subtraction fo strings: "+a+" - "+b+" = "+s.stringSubstraction(a,b));

        System.out.println("Thre r 4 access modifers - public, private, protected, defaultOuter class can be only default and public, it cannot be private or protected. Inner classes can be any of the  4 access modifiers. Default behaves same as public, but only within the same package. If  a class inherits another class, it's a 'is a ' relationship. If a  class creates an object of another class,its a 'has a' relationship. \n1. Within a same class, all 4 access modifiers r accessbile.\n2. In a same pkg,sub-class, all are acesible except Private\n3. In a same pkg,non-sub-class, all are acesible except Private\n4. In a diff., pkg., sub-class., except private, default others r allowed.\n5. In a diff., pkg., non- sub-class., except public others all r not allowed.\n If there is a website like ");
    }
    
}
