public class _3_operators_and_expressions{
    public static void main(String[] args){
        System.out.println("Coersion/Type promotion means any automatic conversion of dattype from one to another. Numeric promotion includes the foll., rules: ");
        System.out.println("In Java, numeric promotion follows specific rules:\n" +
        "If either operand is of type double, the other is converted to double.\n" +
        "Otherwise, if either operand is of type float, the other is converted to float.\n" +
        "Otherwise, if either operand is of type long, the other is converted to long.\n" +
        "Otherwise, both operands are converted to int.\n\n" +
        "In Java, when performing arithmetic operations with smaller data types, namely byte, short, and char, these are first promoted to int anytime they're used with a Java binary arithmetic operator, even if neither of the operands is int. This is done to avoid overflow, when 2 smaller datatype values is done dome oepration,there are chanced of the result no exceeds the bit size of the smaller datatype. By automatically promoting to int (32 bits), Java prevents unexpected overflow in intermediate calculations.\n"+
        "So,\n" +
        "byte + short => int + int => int (not short)\n" +
        "char + int => int + int => int\n" +
        "byte + byte => int + int => int (still int, not byte)");

        byte b = 1;
        short s  = 2;
        char c = 'a';
        long l = 99999;
        double d = 99999.99999;
        int i = 1;
        System.out.println("byte + short = int "+(b+s));
        System.out.println("char + int = int "+(c+i));
        System.out.println("long + double = double "+(l+d));
        System.out.println("int a  = 1, char b = 2; char c = b-a is wrong,we should write it as int c = b-a");
        int aa = 5;
        int bb = 7;
        int cc = aa/bb;
        float dd = (float)aa/bb;
        System.out.println("To get 5/7, we will get only int if we use int for result var "+cc+" we need to use float as datatype to get result as float"+dd);

        char z = 'g';
        z++;
        System.out.println("increment operation in char g is "+z+"here no new variblae is created, i.e z++ is not equal to z = z+1, here z++ just increment the exisitng value of the char itself, whereas z = z + 1, gets converted to integer,since char + int = int");

        char ll = 'a';
        int promotion = ll+1;
        System.out.println("Here, if we try  ll = ll+1; it will lead to error, since now, it's type casted to int, but ll's dattype is char, so to do it,we created integer promotion"+promotion);
        System.out.println("To convert a +ve no to -ve or -ve no to +ve,take 2's complement. 2's complement = 1's complement(~no)+1");
    
        System.out.println(">> signed right shift, >>> = unsigned right shift. >> preserves the msb (signed bit) during shifting, whereas ");
        System.out.println("-5: Bin:    "+Integer.toBinaryString(-5)+ " Value: "+ -5);
        System.out.println("-5>>1: Bin: "+Integer.toBinaryString(-5>>1)+ " Value: "+ (-5>>1));
        System.out.println("-5>>>1: Bin:"+Integer.toBinaryString(-5>>>1)+ " Value: "+ (-5>>>1)+ "i.e 0"+Integer.toBinaryString(-5>>>1)+" The sign bit is not preserved. So, it lead to some large no");
        System.out.println("There is no <<< in Java, since there is no diff., b/w << and <<<. However in both cases, the msb bit woudl be replaced with is subsequent bits.i.e in left shift operation, both +ve and -ve no;s are threated in the same manner");
        System.out.println("BItwise merging and masking \n 4 bits is called as Nibble. we can;t store a no in  4bits itsefl evn it can repr., within 4 bits,as min storage is 1 byte (8 bits) in Java. So,we can do bitwise merging, to store multiple numebrs in the smae byte itself, and then use bitwise maksing to retireve those numbers.\n for e.g a = 9, b = 10, bin of a"+Integer.toBinaryString(9)+" bin of b ="+Integer.toBinaryString(10)+"we can store it as 10101001 i.e first 4 bits as  a , next  4 bits as b, for that, b = (b<<4): "+Integer.toBinaryString(10<<4)+" c = a|b, c= "+Integer.toBinaryString(9|(10<<4))+" to retrive a and b from c, b = (c & 0b11110000)>>4 = "+Integer.toBinaryString(((9|(10<<4))&0b11110000)>>4));
        System.out.println("Precendence Order:\n 1. Post inc/dec ++,-- \n 2. Pre inc/dec ++,-- and unary +,- \n 3. *,/,% \n 4. +,- \n 5. Shift <<,>>,>>> \n 6. <=,>=,<,> \n 7. Equality == ,!= \n 8. Bitwise and & \n 9. Bitwise OR | \n 10.logical and && \n 11. logical or || \n 12. ternary ?: \n 13. assignment =,+=,-=,*=,/=,%=,<=,>=");

        System.out.println("Smaller datatype values can be stored wihtin larger dataype variables, easiyl,as it cn accomadate it, it si performed implecieitly, it;s called upasting or widening. If a larger datatype value needs to eb stored in a smaller dattype value, it needs to be explecieitly typecasted i.e short a = 10, byte b = (byte)a. It;s caleld as narrowing or downcasting. If the larger adttype value is greater than the max no of bits possible for the shorter dattype var., then lossy conversion happens. Note,  boolean datatype cannto eb downcasted or upcasted with any other datatypes and the only dattype that can eb done increment/decrement is boolean.");
        int ice = 500;
        ice+=72.8414;
        System.out.println("the compound assignment operator (+=) includes an implicit cast back to the type of the left-hand variable. So you won't get a compile error, but the fractional part of the number (0.8414) will be lost in the process "+ ice+ " This is different from trying to do a direct assignment like ice = ice + 72.8414; which would cause a compilation error because you'd need an explicit cast.");
    }
}



