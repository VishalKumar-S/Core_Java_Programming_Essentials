import java.util.*;

/**
 * This is a sample demo class to showcase various access modifiers,
 * constructors, and methods for Javadoc generation.
 * @author Vishal Kumar. S
 * @version 1.1
 * 
 */

@interface description{
    String type();
    String author() default "Vishal";
    String date();
    double version() default 1.0;
}

 @FunctionalInterface
 public interface Inner_18_javadoc_annotations {
    
 }

@description(type = "class",date = "13/04/25")
public class _18_javadoc_annotations {
    static List l;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        System.out.println("Javadoc is used to gernerate java documentiaon for our classes liekhwo the fofical doumentions of java classes r. Use /** *// for jaavadocumentation, single /* */ for comments. after use the requried symbol,u can add docuemtnion for the class, author, methdos, aprameretes, code etc., and execute javadoc java_file.java to gerneate java documention html file. Annotations are useful in many cases - eg., \n1. @Override - if we use this annotation in any overrirded method, in child clas with typos from the roignal method in aprent class, it show error, it's not overrdided, deu to typos. \n2. @Deprecated - if any method is not gogin to be used int he enwer version, emtneionign this will give warning, so user will not use this in future usecases.\n3. @suppress \n4. @FunctionalInterface -  When an interface uses more than 1 method, it leads to error.\n5. @SuppressWarnings - will suppress teh warnings e.g., @SuppressWarnings('Deprecated') will remove the deprecated warnign when program executes.\n6. @Safevarags - is used to suppress unsafe operation warnings related to varargs.\n We can create our own annotation,its created using interface, its used for strogin metadata in our classes. Whatver elements(methods in interface) we mention, needs to be given as arguemnt in the annotation, unlessw e give defautl valeu to teh elemnt in the custom annotation.");
        List list = new ArrayList();
        list.add("Hello");

    }

    @description(type = "fields",author = "Vishal Kumar",date = "13/04/25")
    public String publicName;
    private int privateId;
    protected boolean isActive;
    double defaultValue;

    /**
     * Default constructor.
     * Initializes default values.
     */
    public _18_javadoc_annotations() {


        this.publicName = "Guest";
        this.privateId = 0;
        this.isActive = true;
        this.defaultValue = 100.5;
    }

    /**
     * Parameterized constructor.
     * 
     * @param name the name to set
     * @param id the ID to set
     * @param active user activity status
     * @param value default double value
     */
    public _18_javadoc_annotations(String name, int id, boolean active, double value) {
        this.publicName = name;
        this.privateId = id;
        this.isActive = active;
        this.defaultValue = value;
    }

    /**
     * Public method to display user info.
     */
    public void displayInfo() {
        System.out.println("Name: " + publicName);
        System.out.println("ID: " + privateId);
        System.out.println("Active: " + isActive);
        System.out.println("Default: " + defaultValue);
    }

    /**
     * Private helper method.
     * Only accessible within the class.
     */

    private void secretMethod() {
        System.out.println("This is a secret method.");
    }

    /**
     * Protected method to toggle user activity status.
     */

    protected void toggleStatus() {
        isActive = !isActive;
    }

    /**
     * Method with default (package-private) access.
     */

    @Deprecated
    void resetValues() {
        publicName = "Guest";
        privateId = 0;
        isActive = true;
        defaultValue = 100.5;
    }

    @SafeVarargs
    public static <T> void printList(T... items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

}