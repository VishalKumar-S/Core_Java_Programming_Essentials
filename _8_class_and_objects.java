class Student{
    public String name;
    public float s1;
    public float s2;
    public float s3;

    public void print_details(){
        System.out.printf("MY name is %s, my total score is %f, and my grade is %s",name,(s1+s2+s3)/3, ((s1+s2+s3)/3>50) ? "Pass":"Fail");
        System.out.println();
    }
    
    public String toString(){
        return "When you use System.out.println(objectRef) or include a reference in a string concatenation, Java implicitly calls the toString() method on that object reference. The default implementation of toString() in the Object class (which all classes inherit from) returns a string in the format: getClass().getName() + '@' + Integer.toHexString(hashCode()). When you override toString() in your class, the println method will use your custom implementation instead of the default one. The magic happens through polymorphism. When println receives an object, it internally calls String.valueOf(obj), which in turn calls obj.toString(). Since the actual method called is determined at runtime based on the object's actual type (not its reference type), Java will use your overridden version if it exists.";
    }

}   

public class _8_class_and_objects {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Vishal";
        s.s1 = 100;
        s.s2 = 78;
        s.s3 = 90;
        s.print_details();
        System.out.println(s);
    }   
}
