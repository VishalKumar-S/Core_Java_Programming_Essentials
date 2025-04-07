
class ValidationSystem{
    public String name;

    private String e_mail;

    public ValidationSystem(){
        System.out.println("Im an constructor, note that consturctor gets autoamtically, called when obj created. By default constructor woudl eb there, ifw e didnt writean explicit constructor. sicne we wrote it,it overloaded the default constructor. Constructor overloading is possible in java. Same name with differn tparemtens hsoudl be there. The constructor should not have void/any return type in them");
        name = "Personal Validation System";
        String local_var = "Im a local variable.";
    }

    public ValidationSystem(String new_name){
        name = new_name;
}

    public ValidationSystem(String new_name, String e_mail){
        name = new_name;
        set_email(e_mail);
    }
    public String get_email(){
        return e_mail;

    }

    public void set_email(String e_mail){
        
    }

}

public class _9_property_methods_and_constructors {
    public static void main(String[] args) {
        ValidationSystem v = new ValidationSystem();
        System.out.println(v.name);
        System.out.println("If i try to print v.local_var, it would cause error, since unlike Python, where you can add properties to an object at any time, You don’t even need to define them in the class beforehand. In Java, it is strict and statically typed, All instance variables must be declared in the class., You cannot attach new variables to objects on the fly, Java checks everything at compile time. So, when u declare a variable inside a constuctor or method of a class, it;s considered as local var., and not as a class property. ");
        System.out.println("You cant write like public String local_var = \"Im a local variable.\"; withina method or cosntructor. In Java, access modifiers control visibility across classes and packages. Local variables (those declared within methods or constructors) exist only within the scope of that method or constructor - they're created when the method starts executing and are destroyed when the method finishes. Since local variables are never accessible outside their containing method or constructor, applying access modifiers to them would be meaningless. There's no concept of \"public\" or \"private\" within a single method's scope - either the variable exists in that scope or it doesn't.");

    }
}
