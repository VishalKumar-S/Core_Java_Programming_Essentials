import java.lang.*;
import java.util.Arrays;


class Override{
    public String toString(){
        return "I'm gonna override toString(), hashcode(), equals() method of the obejct superclass here";
    }

    public int hashCode(){
        return 1;
    }

    public boolean equals(Override o){
        if(this.hashCode()==o.hashCode()){
            return true;
        }

        return false;
    }

}


enum Level{
    APPLE, BANANA, ORANGE, EASY("Level 1",10), MEDIUM("Level 2",20), HARD("Level 3",30);

    String levelNo;
    int points;

    private Level(String levelNo, int points){
        this.levelNo = levelNo;
        this.points = points;
        System.out.println("Level name: "+this.name()+" Level No: "+levelNo+", Points: "+points);
    }

    private Level(){
        System.out.println("constant: "+this.name()+", Order of the constant: "+this.ordinal());
    }
}


public class _17_java_lang_package {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        System.out.println("java.lang pakg automatically gets imported in java. It contains the superclass for all classes, Object class, which contains the methos liek toString(), .equals(), .hahscode(), Math class, multi-threading related methods");
        System.out.println("Printing Object class's isntance: "+o1);
        System.out.println("Printing Object class's toString() method: "+o1.toString());
        System.out.println("both r same, when we print the object also, the print method automaticall calls the toString() method of the object class.");
        System.out.println("For evey obj created., JVM creates an unique hashcode for it, by performing some operation on it's memoery address, useful for effeicent offerations in hash based collections. o1's hashcode: "+o1.hashCode());
        System.out.println("== checks for reference equality eveywehere, .equals() also checks for reference equality in the original Object class. IN some classes, liek String, its overridern to comapre teh content equality "+o1.equals(o2));

        Override or1 = new Override();
        Override or2 = new Override();
        System.out.println(or1);
        System.out.println("Hashcode of or1: "+or1.hashCode()+"\nHashcode of or2: "+or2.hashCode());
        System.out.println("In Java, .equals() vechsk whetehr 2 objects potins to the smae memory location or not by default. If two objects are equal according to .equals(), they must have the same hash code, since hashcode value is a cosntatn value generate basede on the mermoy address of the obj. However, the reverse is not true: Two objects with the same hash code are not necessarily equal, the reason is, the hashCode() method generates a 32-bit integer value, which means there is a finite range of possible hash codes. Different objects can produce the same hash code due to collisions. I overrided the .equals() emthod to check equality based on the hashcode value,using the overrided hashcode method, where we deifeind a constant value fro all objects, or1.equals(or2)= "+or1.equals(or2));
        
        System.out.println("Wrapper classes, does wrapping/boxing the primitve into an object. So, it's called Wrapping. So,we can get many feautes to it. Classs Number, Character, Boolean inherits class Object. Class Number contains the sub-classes Byte, FLoat, Short, Long, Integer, Double. The Number class consists of methods like  intvalueof, flaotvalueof, doublevalueof().... SO,a ll tis subclasses  overrides thes methdos and made teh implementiaon as is needed for them");

        System.out.println("Boxing: Using new cosntuctor type syntax is depreceted in Jva, to create object in Java. the second one, is recommedned to use.");
        Integer i1 = new Integer(10);
        Integer i2 =  Integer.valueOf(10);

        System.out.println("The below is called autoboxing, where u directly assign teh value to the i3 ref varibel. here, impleicitely, Integer.valeuOf() only being called");
        Integer i4 = 10;
        System.out.println(".valueOf() in these wrapper emthods have default string o t ehri dataype conversion method overlaoded. So, if the data tyep vlaeu of sthe string is within the limit fo the datatype,it gets converted, else error ariese.");
        Byte b1 = Byte.valueOf("100");

        try{
            Byte b2 = Byte.valueOf("255");
        }
        catch(Exception e){
            System.out.println("It causes error, since 255 exceeds the byet limit of -127 to 127, soit causes the error.");
        }



        System.out.println("If i try, Byte b2 = Byte.valueOf(100) It causes error, since int is larger than Byte, lossy conversion might happen. so,its not alloed, if u ened to sue, perfom expliceit conversion. I also cannot show it in try cathc block,a sits a compiel time error since, Byte doesnt haev any method .valueOf(int), its not an exception, to ath in try-blocks tamtent.");
        

        System.out.println("Explcit typecasting");
        int int_value = 100;
        Byte b3 = Byte.valueOf((byte)int_value);


        System.out.println("Unboxing means converting the wrapper objets back into primtives.");
        byte b4 = b3.byteValue();
        System.out.println("The below is auto unboxing, impliceitly,it also executes .byteValue()");
        byte b5 = b3;
        System.out.println("some eg..,s of Static methods in Integer class");
        System.out.println(Byte.SIZE);
        System.out.println("Integer.parseInt() returns a int primitive value, whereas Integer.valueOf() returns a Integer object.");
        System.out.println("Integer in bnary string: "+Integer.toBinaryString(128));
        Float b = 125/0f;
        Float c = (float)Math.sqrt(-1);
        System.out.println(Float.POSITIVE_INFINITY==b);
        System.out.println("c is not a no, imaginary no? "+ Float.isNaN(c));
        System.out.println("String is immutable, whereas String BUffer is mutable and by default it's size is 16 characters. when u append more than this limit, tehn automaticalyl, enw string buffer of alrge size si created and the data is copied into it and new characters r added. String buffer is thread-safe i.e it only execute in synchronsied manner. No 2 threads can execute methods liek append(), insert() to the string buffer object at the same time. String buffer will not allow it. But, sicne it executes only synchronised, String buffer is little slow. SO, to overcome this issue, we use String Builder, which is mutable, fast than string buffer, but its not thread safe. i.e 2 threads can perform operations on the same stringbuilder object at the same time. SO, if ur sure, taht only one single thread is going to be ther or ur sure that no 2 threads would operate a same operation at a same time, u can choose String Builder.");

        String s1  = new String("Vishal");
        StringBuffer s2  = new StringBuffer("Vishal");
        StringBuilder s3  = new StringBuilder("Vishal");

        String string_updated = s1.concat(" Kumar. S");
        StringBuffer stringbuffer_updated = s2.append(" Kumar. S");
        StringBuilder stringbuilder_updated = s3.append(" Kumar. S");

        System.out.println("String: "+s1+" New String object Created: "+string_updated+" Both ref var., point to the same obj? " + (s1==string_updated));
        System.out.println(s2+" Both ref var., point to the same obj? " + (s2==stringbuffer_updated));
        System.out.println(s3+" Both ref var., point to the same obj? " + (s3==stringbuilder_updated));

        System.out.println("Enums is liek a special class, where it contains variables as pre-defined constants. They are type-safe group of constants, where u can add proeprties to the consts using constructors and methods. It's like an object with pre-defined values. All r static and final by default. Enums can have constructors, but it should be private or default. We cna also have publci methods in enum. WHenever the enum is loaded into memro, all th eidentifiers are atumocically executes constructor for them. We can alos have valesu to the dientidiefers in Enums. But, if enum identiifers have values, then we shoudl use onyl parametreised cosntrucctor with teh valeus datatyeps for them.");
        Level e = Level.BANANA;
        Level enumArray[] = Level.values();
        System.out.println(Arrays.toString(enumArray));

        switch(e){
            case APPLE:
                System.out.println("Im a apple");
                break;
            case ORANGE:
                System.out.println("im an Orange");
                break;
            case BANANA:
                System.out.println("Im level easy. If we used strings instead of enum constant, they could also arise issues like typos, whilce chekding in if-else or switch statements.");
            default:
                System.out.println("Matched None");
                }
            
            System.out.println("In Java, reflection pacakge is ued to know the description of any class, we can know all the details of the class, it get sthe deteaisl fmo the class's class file");

            // Any of the 2 below implementations, we can use
            Class c1 = SuperTVS.class;

            SuperTVS t1 = new SuperTVS();
            t1.getClass();

            System.out.println("Class name: "+c1.getName()+"\n Class methods: "+Arrays.toString(c1.getMethods())+"\n Class constructors: "+Arrays.toString(c1.getConstructors())+"\n Class fields: "+Arrays.toString(c1.getDeclaredFields()));
    }
}
