
class A{
    static String block1 = "IM the first static block in A class";
    static String block2 = "IM the second static block in A class";

    static{
        System.out.println(block1);
    }

    static{
        System.out.println(block2);
    }
}



class B{
    static String block1 = "IM the first static block in B class";
    static String block2 = "IM the second static block in B class";

    static{
        System.out.println(block1);
    }

    static{
        System.out.println(block2);
    }

    void instanceDisplay(){
        System.out.println("im a parent class instance method.");
    }

    static void staticDisplay(){
        System.out.println("Im a parent class  static method.");    }
}

class C extends B{
    static void staticDisplay(){
        System.out.println("Im a child class static method.");
    }

    void instanceDisplay(){
        System.out.println("Im a child class instance method.");
    }

}




final class DatatypeSizes{
    final int INT= 4;

    static final int LONG;
    static{
        LONG = 8;
    }

    final int CHAR;
    public DatatypeSizes(){
        CHAR = 1;
    }


}


class SingletonCofeeMachine{
    private float waterQty;
    private float cofeePowderQty;
    private static SingletonCofeeMachine instance = null;
    private SingletonCofeeMachine(){
        waterQty = 1f;
        cofeePowderQty = 0.7f;
    }

    public static SingletonCofeeMachine getCofeeMachineInstance(){
        if(instance==null){
            instance = new SingletonCofeeMachine();
        }
        return instance;
    }

}

public class _14_static {
    static final String description = "ima  final varaible";
    static{
        System.out.println("Im static block in the main method");
    }
    public static void main(String[] args) {
        System.out.println("static belongs to a class , all static members are stored in the methdo area only. they can be used commonly, shared by all instance objects. Static methdos can use only static variables,they can;t access non-static members. Only inner classes can be static. Outer classes cannot be static. Static blocks can onyl use static members i.s static variables or static methods. Static blocks execute whenever the class is loaded into the memeory. Static block execuet in the order they r defined.");

        System.out.println("If u see, the static blocks in neihter class A or B are being executed, only teh static block in the min method is exeuted, teh reaons is the static blocks are executed only , when their classes are loaded into emeory. here, till now, we didnt use the class A or B anywhere in our code. So, since these classes arent used, so these classes are not laoded into the memory. To laod it into the mermoy,we need to use them. So, now well create an object in class B. so class B woudl eb loaded adn its static blocks are executed. Nteote, class A;s static blocks would not be execued, sinne class A is not sued anywhere in our code,so not laoded into emmeory\n");
        B b1 = new B();
        System.out.println("The reason why its not showing the static blocks execution, is, usually, java uses dynamic class loading, where classes r loaded at run time, when they r used. this laoding happesn just before , teh class is ebing actually used. VS Code uses its own Java extension and execution environment that may preload classes for performance or analysis reasons. When running through VS Code's run button, the B class might be already loaded before reaching your new B() statement. ans somehow skisp the intislaistion parts for the static part as an optimsisitaon whie creating a =n objet of it. So, to get teh correct output, use \n javac _14_static.java\njava _14_static\n thsi will correctly execute the static blocks as intended.\n Anythign declared with final keyword cannot be modifed later. final keyowrd variables are used in capital letters naming conventio, adn they cannot be modified.. final methods cannot be overrided in the child classes.SO we can be used to restrict overriding /run time polymorphism. A final class cannot be inherited by other classes, so we can use it to prevent inheirtance. You can't declare and initialise final variables seperateyl. Declarsation adn initialsitiaon needs to be done together. To do it seperately, we can use static blocks, to declare the variable outside and instantiate it inside the static block, but for that the final variable must be declared as static.We can also do it seperately by declaring the finalv airbel and initialsiing it, byc reating anc osnturctor of the class. Static methods, can only use static variables. Even if the variable is final outside the static method, it needs to be made static, to use within the static method. Static methods cannot be overrided since static methods are class-elvel attribtues, they are not instance-speciific, they cant ahieve ocerriding /run time polymorphism, but can be overlaoded, since overriding is decided on run-time (isntance-speciifc), which method to overload is decied ont eh compile time itself Since static methods are class-sepific, not isntance based, it is possible,during compile time. Static blocks cannot be defined within a method, static blocks needs to be defined at the class level. There are 2 types of binding - \n 1. Static/compile time binding - here, Java looks at the reference type (Parent) at compile time and the ref., type's version of staticMethod() is called. This is method hiding. Static methods follow this, since they belong to the class, not the object. When you call a static method, it doesn't matter what object you have - the method is associated with the class itself. That's why the compiler resolves static method calls based on the reference type (Parent) rather than waiting to see what actual object is created at runtime. The compiler sees you're using a Parent reference, so it binds to Parent's static method. \n2-Dynamic/Runtime Binding- Here, Java looks at the actual object type (Child) at runtime. The object's version of instanceMethod() is called. This is how method overriding works. It si used in all the normal instance methods we call.");
        B b2 = new B();
        C c1 = new C();
        b2.instanceDisplay();
        B.staticDisplay();

        c1.instanceDisplay();
        C.staticDisplay();

        B polyref = new C();
        polyref.instanceDisplay();
        System.out.println("Method overridign happens, due to run-time binding, since it's an instance method");
        polyref.staticDisplay();
        System.out.println("Method hiding happens, due to static/compile-time binding, since it's an static method");

        System.out.println("Now,i need to implemnt polyref.staticDisplay();, but vs code, whiele xeuctign, its; it's encountering a verification error because you're trying to call a static method through an object reference in a way that's confusing the bytecode verifier. The error specifically says \"Type 'C' is not assignable to 'B'\" at an invokevirtual instruction, which indicates that the JVM is getting confused about which method implementation to use. While it's syntactically valid to call static methods through object references in Java, it can cause issues with bytecode verification in some environments. I recommed using javac and java commands to manually execute the code.");
        System.out.println(description);
        System.out.println("#######");
        System.out.println("Singleton class- here, the scenario requires creation of only one instance of the class. e.g, here coffee machine scenairo, here creation fo one codfee amchien isntance is only enedd. and all users use this instance to drink cofee. For it, to avoid creation of instance of the class, we made teh constructor of the class tobe private, so cant be accessed from outside. Only insde memebrs int eh class can now create instance. We also create a private ref var to store teh instance's ref, within the class. We create a public method,to create instance of the class, we will ensur new instance will be created only if the ref., var,. points to null, else return teh sxisting instance itself. But,we cannot access this getIntance() method outsideof teh classs, since its aninstance mehtod,w e ened an isntance toa cces the method, but we cnannot create an isntance, since ocnstructor is made private, so we will make the getInstance() method as static, so that we can acccess it usign class name itself, so we also need to make te h instance ref., var also static., since static methods, cannot work with non-static members.");

        SingletonCofeeMachine s1 = SingletonCofeeMachine.getCofeeMachineInstance();
        SingletonCofeeMachine s2 = SingletonCofeeMachine.getCofeeMachineInstance();
        SingletonCofeeMachine s3 = SingletonCofeeMachine.getCofeeMachineInstance();
        if (s1==s2 && s2==s3){
            System.out.println(s1+"\n"+s2+"\n"+s3+"\nAll instance ref.,v aribles point to the only object we created. Thus,all isntances are smae, poiting to the same object.");
        }

    }    

}