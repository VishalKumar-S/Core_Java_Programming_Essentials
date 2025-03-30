import java.util.*;
public class _2_data_types_variables {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ur name, ill capture ur first name alone");
        String f_name = sc.next();
        System.out.println("MY first name is " + f_name);
        System.out.println("Enter ur name, ill capture ur entire name");
        String name = sc.nextLine();
        System.out.println("MY full name is " + name);

        System.out.println("The issue is, after getting teh firs name 'vishal' from the input buffer, still ' kumar' is left over in the input buffer. So, it used it, while printing the entire name.Solution is to clear the existing input buffer here");
        System.out.println("Enter ur name, ill capture ur first name alone");
        f_name = sc.next();
        System.out.println("MY first name is " + f_name);
        sc.nextLine();
        System.out.println("Enter ur name, ill capture ur entire name");
        name = sc.nextLine();
        System.out.println("MY full name is " + name);
        System.out.println("To set a custom base/radix, u can use sc.useradix() to");
        sc.useRadix(2);
        System.out.println("Enter the binary no");
        int bin_no = sc.nextInt();
        System.out.println("The binary no's decimal value is " + bin_no);
        System.out.println("Languages like C, C++ only supports ASCII, so char is 1 byte over there, here Java, supports unicode, which is a superset of ascii, i.e it can store other languages than English like french, Spanish etc.,. So, char is 2 bytes is Java. In c,c++, python true/false can be interchanged with 0/1, whereas in Java, strictly True/False only should be used. You can't use like boolean x = 1/0 it's wrong, u can only write it as boolean x  = True/False");
        System.out.println("All primitive wrappers Integer, Double, Boolean, etc., String, StringBuffer, StringBuilder, Math,Thread,System all r present inside java.lang pkg");
        System.out.println("Java.util contains Utility classes for data manipulation, collections, input handling, and more, which need explicit import.");
        System.out.println("Integer Types:");
        System.out.println("Default integral data type/ non-decimal datatype of Java is Integer. All the integral data types are signed. i.e they repr., both +ve and -ve no's.for eg., In an 8 bit signed integer, the MSB bit points whether the no is +ve/-ve, the remaining 7 bits say the value range i.e -127 to 127. For e.g., 01111111 - 127, 11111111 - -127. To convert from +ve into -ve or vice versa of a no, take its 2 complement i.e invert the bits and add +1.");
        System.out.println("Binary rep., of integer +5 is " + Integer.toBinaryString((5)));
        System.out.println("Binary rep., of integer -5 is " + Integer.toBinaryString((-5)));
    
        System.out.println("byte: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE + " (8-bit/ 1 Byte)");
        System.out.println("short: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE + " (16-bit/2 Byte)");
        System.out.println("int: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE + " (32-bit/4 Byte)");
        System.out.println("long: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE + " (64-bit/8 Byte)");
        
        System.out.println("If you only need the range of a 32-bit int, using a 64-bit long would be wasteful in terms of memory. The long takes double the space (64 bits), which could lead to increased memory consumption, cache usage, and potentially reduced performance for some operations due to the larger memory footprint.");
        System.out.println("\nFloating-Point Types:");
        System.out.println("IEEE 754 is a technical standard for floating-point arithmetic. PC don't store decimal values as such, like 157.4, it will store it like 1574 * 10 in memory, 1574-mantissa, 10 -exponent");
        System.out.println("Default decimal data type of Java is Double");
        int i = 'A';
        float f = 'A';  
        System.out.println("Character A "  + "converted to int: " + i);
        System.out.println("Character A"  + "converted to float: " + f);
        System.out.println("Java allows automatic conversion from char to float/int because a char (16-bit Unicode) fits within the larger range of a float (32-bit), int (32-bit). This is called widening primitive conversion. Java's conversion hierarchy: char → int → long → float → double, No explicit casting required when converting to a wider type since no data loss occurs, Reverse conversion (float to char) requires explicit casting");
        System.out.println("float: " + Float.MIN_VALUE + " to " + Float.MAX_VALUE + " (32-bit/ 4 Byte, 6-7 decimal digits precision)");
        System.out.println("double: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE + " (64-bit/ 8 Byte, 15-16 decimal digits precision)");
        System.out.println("It is possible to assign a character to a float variable like this: float f = 'A'; it will store the ascii value of A");
        System.out.println("\nCharacter Type:");
        System.out.println("ASCII char., range from 0 to 127 , a-z(97-122), A-Z(65-90), 0-9(48-57).So 127 numebr can be easily stored in 7 bit. But ascci covers only English, unicode covers all otehr langauges also, so Java supports that, to incld bitue all lang., symbols, it chose to have 2 Bytes for char");
        System.out.println("char: 0 to " + (int)Character.MAX_VALUE + " (16-bit/ 2 Byte Unicode character)");
        for (char c = 0x0900;c<=0x0970;c++){
            System.out.println(c);
        }
        System.out.println("\nBoolean Type:");
        System.out.println("boolean: true or false (1 bit, but stored as 8 bits)");
        System.out.println("In Java, a boolean is 1 byte (8 bits) instead of 1 bit due to memory access efficiency and JVM design. While a boolean only needs a single bit to represent true or false, using a full byte allows for faster processing and consistent memory management across different computer architectures. This design ensures optimal performance, with the small memory overhead being negligible compared to the computational benefits. You can verify this by using Boolean.SIZE, which returns 8, confirming the 1-byte allocation.");
        System.out.println("\nDefault Values:");
        System.out.println("byte: 0");
        System.out.println("short: 0");
        System.out.println("int: 0");
        System.out.println("long: 0L");
        System.out.println("float: 0.0f");
        System.out.println("double: 0.0d");
        System.out.println("char: '\\u0000' (null character)");
        System.out.println("boolean: false");
        
        System.out.println("In Java, variables can start with alphabet, _ or $, cannot start with a no, variables follow camelcases in java, ie. first charcter starts with small, and he follwoing words first cahr starts with capital letter, for e.g, 'avgOfAll' ");
        
        byte a = 12;
        byte b = 0b1100;
        byte c = 014;
        byte d = 0xc;
        System.out.println("In decimal form "+a);
        System.out.println("In binary form "+b);
        System.out.println("In octal form "+c);
        System.out.println("In hexadecimal form  "+d);
        System.out.println("/*\n" +
                " * long L = 125, it is correct, 125 is integer literal\n" +
                " * long L = 999999999999, it is wrong, it exceeds the integer literal max limit. To represent it, we need to,\n" +
                " * long L = 999999999999L, it is right, it's long literal now\n" +
                " * int i = 125L; it's wrong, Long literal can't be stored in an integer datatype, that is, we can't store a higher valued literal to a lower valued datatype\n" +
                " * float f = 25.75, it's wrong, by default, decimal values are represented in double format. Here, 25.75 is double, we can't represent a double literal (higher values) to a float datatype (lower valued datatype)\n" +
                " * double d = 25.75 or double d = 25.75d, no issues, both are correct.\n" +
                " * We can represent large values using _, for better readability.\n" +
                " * For eg., int i = 78_22_43_453 (for representing 78,22,43,453). No issues with it, but we can't represent it like int i = 453_ or 12._53 or 12.53_ i.e., at improper places where commas wouldn't come in the actual sense of representation we mean.\n" +
                " * A 32-bit CPU means it can take/process 32 bits (4 bytes) of data at a time. If the data is more (e.g., long takes 8 bytes i.e., 64 bits), then the 32-bit processor processes it in 2 cycles to complete the task, whereas a 64-bit CPU can complete it in 1 clock cycle or 1 time itself.\n" +
                " * Since the default integral data type of Java is 32-bit (4 bytes), it is compatible with a 32-bit CPU. The other integral data type long exists to represent higher-valued integral values, which it executes in more than 1 cycle if it's a 32-bit CPU. Other integral data types like short and byte exist for older CPUs like 8-bit/16-bit CPUs.\n" +
                " * Java uses short and byte for those CPUs or to communicate with older software designed for those CPUs.\n" +
                " */");
    }
}





