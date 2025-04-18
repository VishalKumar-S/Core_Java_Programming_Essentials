import java.util.ArrayList;
import java.util.Arrays;

class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Generics <T>{
    T data[] = (T[]) new Object[3];
    
    void addItem(int index, T val) {
        data[index] = val; 
    }

    static void check(Generics<?> g){
        System.out.println("So, we can use child classes, for the types that requires is's superclass as to eb type. It works fine without any issues.");

    }
}



interface GenericInterface1<T>{
    public void interfaceDisplay1(T data);

}

interface GenericInterface2<T>{
    public void interfaceDisplay2(T data);

}


    interface GenericInterface3<T>{
        public void displayWildCard(T g);

    }

class SubGenerics <T extends Number> extends Generics<String> implements GenericInterface1<T>, GenericInterface2<String>, GenericInterface3<Generics<? extends Number>> {

    <E> void display(E ... elem){
        System.out.println("Displaying var arg elements: ");
        for (E i: elem){
            System.out.print(i+" ");
        }
        System.out.println();
    }



    public void displayWildCard(Generics<? extends Number> g) {
        System.out.println("Working with Generics containing Number or it's subtype. <?> will acccept all types, but it cannot access them. since the method is still generic, due to ?, it don't allow any operation on g, since ? means undefined.");
    }
    

    public void interfaceDisplay1(T data){
        System.out.println("I'm an interface, overrided method. "+data);
    }

    public void interfaceDisplay2(String data){
        System.out.println("I'm an interface, overrided method. "+data);
    }

    public void check(Generics<T> g){
        System.out.println("We can use sub-classesse extedning sueprclass also, for the types requirring superclass as parameter.");
    }
}



public class _21_generics {
    public static void main(String[] args) {
        System.out.println("Object class is used for generalisation. You can create object of any type,any class to any Object class ref type. But the issue, is there is no type Safety, u can assign a  String object to a Object ref type(obj), adn then u can make teh obj ref to point to an Integer object, it wotn show any issue, sicne Object class is the superclass of all classes. To make the actual object class ref type to point to the obj pointed actaul object class object, we need to do casting, and we can assign obj to any datatype/class ref., type, with the help of casting, without even checking whether the new ref type and the obj refering object type r same or not, even no compielr issue happens, onyl during runtimte issue happens");

        Object obj = new String("Vishal");
        obj = Integer.valueOf(12);
        
        try{
            String str = (String)obj;
        }
        catch(Exception e){
            System.out.println("ClassCastException: Integer object cannot be cast into String");
        }


        System.out.println("The below is called Upcasting. Animal speaks (overridden if present in Dog)");
        Animal a = new Dog(); // Upcasting ✅
        a.speak(); 

        System.out.println("The below is called ✅ Downcasting – valid because object is actually a Dog i.e it's a subclass instance already");
        Dog d = (Dog) a;  
        d.bark(); 


        System.out.println("The below is called ✅ ClassCastException – invalid Runtime error");
        Animal a1 = new Animal(); 
        try {
            Dog d1 = (Dog) a1;     
        } catch (Exception e) {
            System.out.println("❌ Runtime error: ClassCastException, since we can't treat the Animal object as an Dog object, since both r different");
        }

    
        System.out.println("Here, we created an list of objects, for srtorign string type onyl. But, even,if we addan integeer object to the list, it's not showing any error, this is the issue with generalisation usign Object ref type, no type safety, any type object can be stored.");
        Object listOfStringObjects[] = new Object[3];
        listOfStringObjects[0] = "Vishal";
        listOfStringObjects[1] = Integer.valueOf(25);
        listOfStringObjects[2] = "Kumar";

        for(Object i: listOfStringObjects){
            try{
            System.out.println((String)i);
            }
            catch(Exception e){
                System.out.println("Here, we typecasted the datatype of an integer object to a String, which is wrong, but it didn't showed any compile error, it onyl shown run time error. The compiler doesn't check if the typecast will succeed at runtime(here integer object is trying to get converted to String object) - it only checks if the typecast is legally possible in the inheritance hierarchy, during the compile time. Since Object is a superclass of String, downcasting from Object to String is potentially valid.");
            }

        }

        Object [] data = new Object[3];
        data[0] = "visjsng";

        Generics<String> gs =  new Generics<>();



        
        System.out.println("Type erasure is Java's implementation mechanism for generics. At compile time, generic type information exists, but at runtime, all generic type information is \"erased.\" So ArrayList<String> becomes just ArrayList at runtime. here, in our case, during compile time, the data object of class Object is typecasted to String, , but after compilation, at runtime, the typecasted String is erased, and the data becomes the original Object array again.SO, her when we try to add a new String elment, its causing issue, since class not matching i.e Generics is ensuring only type safety at run time. Heap pollution is a specific issue that occurs when a variable of a parameterized type refers to an object that is not of that type. Your example with T data[] = (T[]) new Object[3]; creates heap pollution because the runtime type (Object[]) doesn't match what you're telling the compiler it is (T[]).");

        try {
            gs.data[0]="Vishal";
            gs.data[1]="Kumar";
            gs.data[2]=". S";                
        } catch (Exception e) {
            System.out.println("It causes issue since, since during runtime, due to type erasure, eh  cast is erased, adn the  object created is of type Object in emeory, so since object[] array isc reated, it leads to ClassCastException. But, when u try  to add any other type elmetns into the data[], it woudl have beeen lead to error at compile time itself, as tyep safety is ensured at compile time by generics, during compiel time, we make the compieler to believe the object aray is an string array using casting, during runtime, arrays checks their type, Arrays remember their type at runtime(reified-they store type info at runtime). SO type safety si enforced at run-time also");
        }
        
        System.out.println("IF we used  rawtype, without generics, and point it to the String generic object, its become now unchecked.It may pass compile time, since it assumed it is of type Object class for e.,g here i added a number to teh String array, it didn tgive any compiel error, but during run-time,it would cause error. It causes heap pollution. If u try to reteive the second element as  A sTRING vairbel,it willc ause issue in compile tiem tisefl, cannot convert from Object to String");
        Generics rawGs = gs;
        rawGs.data[2] = 52;


        System.out.println("We can use ArrayList, where we wont cast the type from Object to T in compile time. Vaidation of onyl correct T type memebrs r added to the ArrayList si ensured at the compile time itself, due to tyep safety of generics. So, during ");

        System.out.println("Cheating generics in arraylist, by assinging arrayListFenerics to unchecked/raw type ref type, bypassing the compile time type safety, but lead to heap pollution, causign run time erro,w hen we ttry to acces this wrong type added elmetn with correct type var.");
        ArrayList<String> arrayListGenerics =  new ArrayList<>();
        arrayListGenerics.add("123");

        ArrayList rawArrayList =  arrayListGenerics;        
        rawArrayList.add(131);


        System.out.println("If we extend a generic class, from our class, our class also must be generic in nature. If u need to retrieve only specpfi type attribuets fo teh generic class, use <sepcific data type> near te extends genericClass syntax, so we can use only that. If suppose used made our class as type String<String>, but mentioned variable in the extends generic class <T> syntax, then String is passed on to the above generic class. U can set upperbound, by <T extends Number>, so, it is limited to use onyl Numebr type. U can use any sub-class classes, that inherits from the Number class. Simple <> refers to Object type. We can use the inherited subclasses as type parameter inside <> for ref type, pointing to objects of the ref type's super classes. Inside <>, only extend keyword is allowed, even for itnerfaces use extedn only fro inside <>. for e.,g A- class, B<C - interfaces , then class ChildGenerics<T extends A & B & C>. ? means wildcard character, i.e means any type fo that generic is allowed. We can extend onyl one class, but can implement multiple interfaces. Let us see Generic methods, by getting the var args. Both extend and super keywords are allowed in generic method, which has ?, but in generic class definitions, only extends keyword is allowed. WHiel creatinga  object, the generic type fo the ref variable and the object's generic type should always be the same. Even if u use Class<?> a = new CLass<Integer>(); the ? acts as a placeholder, Wildcard generics (?) provide flexibility in parameter acceptance while maintaining type safety. You can read elements as their upper bound (Object for ?, Number for ? extends Number), but cannot modify the collection (except with null) because the exact type is unknown at compile time. This prevents heap pollution while allowing read-only access to generic collections of unknown type.");
        Generics<?> unknown =  new Generics<String>();

        unknown.addItem(0,null);
        System.out.println("It;s possible to access and update it to Null with wildcard character,first elemnt is: "+unknown.data[0]+"BUt if w try to execute like unknown.addItem(0,'Vishal'); it will lead to error, since ");

        SubGenerics<Integer> sg = new SubGenerics<>();
        System.out.println("using generic methods, also var ags is sued, adn desired datatype elemnets are passed,without chagning the formal parametres each time, with the help of generic methods");
        sg.display(124,543,563,125418,25415);
        sg.display("I'm ","a ","String");

        sg.interfaceDisplay1(784);
        System.out.println("Here, if we try using any string value as input to the interfaceDisplay1, it would cause issue since interfaceDisplay1 is fo type T, and T is of bounded to only Integer class types.");
        sg.interfaceDisplay2("15345");
        System.out.println("Here, if we try using any number value as input to the interfaceDisplay2, it would cause issue since interfaceDisplay2 is of type String");
        sg.addItem(0,"Vishal");
        System.out.println("Here,we could add String item, since we created SUbGenerics ref type of Type Integer, which is correct, as the Type of generic class SUbGenerics is bound to use or extedn only from number class. Long, double, Integer  classes inherits from NUmebr class only. SO it didnt show erro But i write like SubGenerics<String> sg = new SubGenerics<>(); it would definietely cause error, since String class not extends from Number class.");

        Generics<Integer> gsI =  new Generics<>();
        Generics<Float> gsF =  new Generics<>();
        Generics<String> gsS =  new Generics<>();

        sg.displayWildCard(gsI);
        sg.displayWildCard(gsF);
        System.out.println("If i try her with Generics<String> i.e gsS,it will elad to error, since the type is boudned with onyl Number Class");

        
        Generics<SubGenerics<Double>> childClass1 = new Generics<>();
        Generics.check(childClass1);

        

    }
}