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
        return "print function automatically calls the toString method, in the parent Object class. Here, i overrided the toString() method, in the Student class and i used the print method to print this class obejct, so this method statemtn is automatically executed.";
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
