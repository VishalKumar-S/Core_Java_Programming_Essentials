import java.util.Arrays;


class ValidationRules{
    public String validation_type;
    private String validation_regex_pattern;

    public ValidationRules(String v_t, String v_r){
        validation_type = v_t;
        validation_regex_pattern = v_r;
    }

    public String get_validation_type(String s){
        return validation_type;
    }

    public String get_validation_regex_pattern(String s){
        return validation_regex_pattern;
    }

    public void set_validation_type(String s){
        validation_type = s;
    }


    public void set_regex(String s){
        validation_regex_pattern = s;
    }

    public String toString(){
        return  "\n validation type: "+validation_type+" validation regex pattern: "+validation_regex_pattern;
    }
}

class ValidationSystem{
    public String name;
    private String e_mail;
    public ValidationRules v[];

    public ValidationSystem(String n, String e, ValidationRules... rules){
        name = n;
        e_mail = e;
        v = rules;
    }
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

    public void set_email(String mail){
        String [] spam_list = {"spam@gmail.com","lottery@123.com"};
        if (Arrays.asList(spam_list).contains(mail)){
            System.out.println("It's not an valid user., It's an spam");
            return;
        }

        String regex_exp = "([a-z]+\\.*[a-z]*)+@[a-z]*\\.(org|in|com|net)";

        if (mail.matches(regex_exp)){
            e_mail = mail;
            System.out.println("E-=mail id " + mail + " valdiated successfully");
        }

        else{
            System.out.println(mail + " not a valid mail id");
            return;
        }
    }


    public String toString(){
        return "The current name is "+ name + "and mail id is "+ get_email()+ " Attributes of available verfication methods of the ref var., are: (we use toString() overriding in the ValidationRules class to achieve this)"+ Arrays.toString(v);
    }

}

public class _9_property_methods_and_constructors {
    public static void main(String[] args) {
        ValidationSystem v = new ValidationSystem();
        System.out.println(v.name);
        System.out.println("If i try to print v.local_var, it would cause error, since unlike Python, where you can add properties to an object at any time, You don’t even need to define them in the class beforehand. In Java, it is strict and statically typed, All instance variables must be declared in the class., You cannot attach new variables to objects on the fly, Java checks everything at compile time. So, when u declare a variable inside a constuctor or method of a class, it;s considered as local var., and not as a class property. ");
        System.out.println("You can't write like public String local_var = \"Im a local variable.\"; withina method or cosntructor. In Java, access modifiers control visibility across classes and packages. Local variables (those declared within methods or constructors) exist only within the scope of that method or constructor - they're created when the method starts executing and are destroyed when the method finishes. Since local variables are never accessible outside their containing method or constructor, applying access modifiers to them would be meaningless. There's no concept of \"public\" or \"private\" within a single method's scope - either the variable exists in that scope or it doesn't.");

        System.out.println("We should not expose our data as public always, as anyone could modify the data, wrongly and unauthorised. So, we need to do data hiding. That is we need to make the data as private, and create proeprty getter and setter methods , make that as public,a ns uer can view/modify the data onl with tehse methods. Within these methods, we would have all valdiation checks, ensure no data issues happens.");

        ValidationSystem s1 = new ValidationSystem();
        System.out.println("Name using non-parameterized constructor "+s1.name);
        ValidationSystem s2 = new ValidationSystem("Vishal Validation System");
        System.out.println("Name using 1-parameterized constructor "+s2.name);
        s2.set_email("VIsh1234@gmail.com");
        System.out.println("Mail id is: "+s2.get_email());
        ValidationSystem s3 = new ValidationSystem("Kumar Validation System", "vishalkumars.work@gmail.com");
        System.out.println("Name and e-mail id using 2-parameterized constructor "+s3.name+" Mail id is: "+s3.get_email());
        

        System.out.println("We can also create array of objects. We create an array, that of size 3, that can stores only the referecces of the object of the class ValidationRules.");
        ValidationRules rules[] = new ValidationRules[3];
        rules[0] = new ValidationRules("e_mail", "([a-z]+\\.*[a-z]*)+@[a-z]*\\.(org|in|com|net)");
        rules[1] = new ValidationRules("Name", "[A-Z][a-z]*(\\s[A-Z][a-z]*)*");
        rules[2] = new ValidationRules("OTP", "\\d{6}");
        s3.v = rules;
        System.out.println("Attributes of ValidationRules objects of the Validation System's s3's instance");
        for (ValidationRules x: s3.v){
            System.out.println(x);
            System.out.println("######");
        }

        System.out.println(s3);


        ValidationRules rule1 = new ValidationRules("email", "([a-z]+\\.*[a-z]*)+@[a-z]*\\.(org|in|com|net)");
        ValidationRules rule2 = new ValidationRules("name", "[A-Z][a-z]*(\\s[A-Z][a-z]*)*");
        ValidationRules rule3 = new ValidationRules("otp", "\\d{6}");

        ValidationSystem s4 = new ValidationSystem("Varargs System", "test@example.com", rule1, rule2, rule3);

        System.out.println("Attributes of ValidationRules objects of the Validation System's s4's instance");
        for (ValidationRules x: s4.v){
            System.out.println(x);
            System.out.println("######");
        }

        System.out.println(s4);
    }
}
