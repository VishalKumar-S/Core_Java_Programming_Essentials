
class OuterClass{
    int x = 1;
    static int z = 3;
    private String description = "Im an outer class";
    InnerClass i1 = new InnerClass();

    class InnerClass{
        int y = 2;
        public void innerDisplay(){
            System.out.println("From Inner class:\nX is "+x + "\n Y is "+y);
        }
    }

    public void outerDisplay(){
        System.out.println("From Outer class:\nX is "+x + "\n Y is "+  i1.y);
    }

    public void localClasses(){
        class LocalClass1{
            static final String sf = "IM allowed";
            private static void display(){
                System.out.println("Local innner classes, are classes used within a method, object of those classes are created inside the methods and used wihtinteh method itsefl, it s usualy doen to inherit or implement from something. We can't access the local class outside the method. The local inner classes cannot be public/private/protected/static, as they all make no sense, inside a method, as eveythign sinide amethod, annot be accessed outside, and all of them are one-time usable. Only allowed keywords for local inner classes r abstract and final. Inside the local inner class, it's variables can only have final/static final, statci varaibles are not allowed.The reason the static variables r not allowed, r they live forever in the memoery, till thr program completed(Stored in the method areax), whereaas for a methosd, evetyhing sinide it is temproary, onlty till its execution, having static varibles inside method, shoudl make teh static varibel accessibel even after the completeion of the method, whihc makes contradictory proerty, and it leads to memory leak adn thread-safety issues. So it is not allowed, whereas static methods are allowed in local inner classes, since static methods does not acces instance fields or modify shared data, so no memory leak issues, they are stateless i.e thye are safe,no risk of leaking method-local variables after mthod exectuion, since they are just re-usable blocks of code. Static final vairbales are aloowed since staic finalv airbls are constants, that are declared in the compile time in the byte code tisefl,they are nost stored in the run-time, so no issues in itm, related to its runtime lifetime conflict");
            }
        }

        abstract class LocalClass2{}
        final class LocalClass3{}


        LocalClass1 lc1 = new LocalClass1();
        lc1.display();
    }

    static class StaticInnerClass{
        public void display(){
            System.out.println("Unlike nested classes, her ein static inner classes, to use static classes, u can directly, create an objet of the static inner class, here no need of creatina object of outer class and then ccreate a inner class obj on it, like nested classes. But in static inner classes, u can access only static attributes of the outer class, u can;t access the instance attr., of the outer class., for eg., if u try ot acccess x, it throws error,, but we can acccess the static ioute rclass attr., z= "+z);
        }
    }

    class abstractSubClass{
        void createAnonymousClass() {
            String local_description = "Local Variable";
            AbstractClass ab1 =  new AbstractClass(){public void display(){System.out.println("Here, im creating an inner class, and create an anonymous class within it, for the Abstract class, by overriding the display method,\n Outer class attr: "+description+"\nLocal attr.,: "+ local_description+"\nANonymous inner classes, acan access outer class attr., incluiding private members, and it can also acccess local varaibles of the existing method, but only if the locl varaibles in the method are explecieitly final, or effecitvely final(they should not be modifeid after instiaiton) i.e after creation fo this anonymous class, below this code,wtihitn this method,if i try to re-dassign value to the local var., it leads to error.");}};
            System.out.println("Now, accesing th eoverride mehdo fo the anonymous class using the abstract class' ref var., Simialrly, we can do for interfaces also.");
            ab1.display();
    }
}

}


abstract class AbstractClass{
    public abstract void display();
}


interface AnonymousClasses{
    void display();
}

public class _13_innner_classes {
    public static void main(String[] args) {
        System.out.println("All outer class attibutes are accesibel for inner class, but for outer class, to access inner class,we need to creat an isntance of inner class, to access inner properties. While compilation, for outer class, outer classs.class fule will be gerneated and for inner class, outerclass$innerclass would be generated i.e the inner class obj woudl not be created, without creating an obj of the outer class");


        OuterClass o1 = new OuterClass();
        o1.outerDisplay();
        
        System.out.println("Let us see hwo to create an inner class obj directly");
        OuterClass.InnerClass i2 = new OuterClass().new InnerClass();
        i2.innerDisplay();
        o1.localClasses();
        AnonymousClasses a1 = new AnonymousClasses(){
            public void display(){
                System.out.println("Anonymous classes are used to create objects, as well as define class impliceitely, without defining a named class. for e,g it;s not possible to create objects to an interface, here we are usign the ref., type of the interface and create an ojbect, of any anonymous class, and we write it's implemnetation here, we are not creating object of the interface here, we are creating an anonymous class, by writing its implemetnaion, where we override all the abstract methods in the interface, such that this anonymous class becoems a valdi sub-class of the interface. WHlile creating this anonymous class, no name is deifned for it. so, its not reuseable , no defined named classes. one-time use pupsoe ANonymous classes r useful ins carniosu where the funcinality or pupsoe of implemetniong the interface in the class is very less i.e very few to implement/override, so isntead of creating a new class explceitley, we can use anonymous classes, to do the functionality.");
            }
        };

        System.out.println("Prinign the overrided method of the interface, by creating an object of an anonymous class and using the ref type of interface, to use the anonymous class's overrided method, (dynamic method dispatch)");
        a1.display();
        System.out.println("#########");
        System.out.println("Here, im not creating an obj of outer cclas,s im directly creating an obj of static inner class");
        OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
        sic.display();
        OuterClass.abstractSubClass asc =  new OuterClass().new abstractSubClass();
        asc.createAnonymousClass();

        
    
    
    }

}
