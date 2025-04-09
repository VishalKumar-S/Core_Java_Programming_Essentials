
class Ben10Watch{
   public String name;
   public String owner_Name;
   public int charge_rem;

   Ben10Watch(){
      System.out.println("Im parent class");
      System.out.println("Im a ben 10 Watch Non-parameterised constructor. I dont know my owner details, or charge remaining details.");
   }

   Ben10Watch(String n, String owner_n, int c_r){
      name = n;
      owner_Name = owner_n;
      charge_rem = c_r;
      System.out.println("Im parent class");
      System.out.println("Owner name is "+owner_Name+"\nWatch name is "+name+"\nCharge rem in Watch is "+charge_rem);
   }




}


class AlienForce extends Ben10Watch{
   public String alien_Name;
   public int strength;

   AlienForce(){
      System.out.println("Im child class");
      System.out.println("I'm a alien in Ben 10 Watch. Use parameterised constructors to know abt my name and powers.");
   }
   
   AlienForce(String a_n){
      System.out.println("Im child class");
      alien_Name = a_n;
      System.out.println("Owner name is "+owner_Name+"\nWatch name is "+name+"\n Alien name is "+alien_Name+"\n I don't know about strength, use 2 parameterised constructor to know about it");
   }

   AlienForce(String o_n, String name, int c_r, String a_n, int s){
      super(name, o_n, c_r);
      alien_Name = a_n;
      strength =s;
      System.out.println("Im child class");
      System.out.println("Owner name is "+owner_Name+"\nWatch name is "+name+"\n Alien name is "+alien_Name+"\nAlien Strength is "+strength);
   }

   public void WhoAreU(){
      System.out.println("Im an Normal Alien");
   }

   public void SeasonName(){
      System.out.println("I'm alien force season");
   }

}


class UltimateForce extends AlienForce{
   public String addn_Power;
   public int addn_Strength;
   public String alien_Name;


   UltimateForce(){
      System.out.println("Im grand-child class");
      System.out.println("I'm a ulimtae-alien in Ben 10 Watch. Use parameterised constructors to know abt my name,addn., strength and addn., powers.");
   }
   UltimateForce(String u_a_n, String a_p, int a_s){
      alien_Name = u_a_n;
      addn_Power = a_p;
      addn_Strength = a_s;
      System.out.println("Im grand-child class");
      System.out.println("Owner name is "+owner_Name+"\nWatch name is "+name+"\n Alien name is "+super.alien_Name+"\nAlien Strength is "+strength+ "\nUltimate Alien Name "+ alien_Name+"\nUltimate Alien Power "+addn_Power+"\nAdditional Strength it has "+ addn_Strength);
   }

   UltimateForce(String u_a_n, String o_n, String n, int c_r, String a_n, int s, String addn_Power, int addn_Strength){
      super(o_n,n,c_r,a_n,s);
      alien_Name = u_a_n;
      this.addn_Power = addn_Power;
      this.addn_Strength = addn_Strength;
      System.out.println("Im grand-child class");
      System.out.println("Owner name is "+owner_Name+"\nWatch name is "+name+"\nAlien name is "+super.alien_Name+"\nAlien Strength is "+strength + "\nUltimate Alien Name "+ alien_Name+"\nUltimate Alien Power "+addn_Power+"\nAdditional Strength it has "+ addn_Strength);
   }

   public void WhoAreU(){
      System.out.println("Im an Ultimate Alien");
   }

}


class A{}
class B extends A{}

class C{
   public A display(){
      System.out.println("Im returingin class A's obj");
      return new A();
   }
}


class D extends C{
   public B display(){
      System.out.println("I'm returning class B obj., child of class A. ");
      return new B();
   }
}

public class _10_inheritance {
   public static void main(String[] args) {
    System.out.println("inheritance is used for specialisation, adding new features to the existing features e.g TS Excel 75 -> TVS EXcel 100., adding height to circle becomes cylinder, adding touch,camera,internet features specialise phone to smartphone. Interfaces are used for generalsiation, used to combine multiple infdividual thigns of a same category or type into a single unit, for refernce or for any activity. For eg,. combinging Iphone, samsung, vivo, oppo phones into a category  Smartphones, and we can use this generalsiation fo any pupose like , 15% tax on all Smartphones.");
    System.out.println("'this' keyword acts as an ref., variable to the object, it acts as an implicit ref., variable, inside the class. It is useful to resolve name conlficts, where the data mamber of the class and the the parameter are same names e.g, alien_name = alien_name. So,we can use this to refer, which points to the data member e.g., this.alien_name = alien_name;");
    System.out.println("Non-parametrise constuctor: ");
    Ben10Watch b1 = new Ben10Watch();
    System.out.println("Parameterised constuctor: ");
    Ben10Watch b2 = new Ben10Watch("Omnitrix","Ben Tennyson",70);
    System.out.println("Whiel we call child cls AlienForce consturctor, it automatically calls the parent class constuctor also. Byd efault, it calls only the aprent;s non -parameterised constructor, but if we need to call parameterised constructor of a class, we need to use super keyword. If parent and child has an attribute of same name, attribute_name would directly refer to the curr class's attr., To refer to the parent's attr., we need to super.attribute_name, which woudl refer to the parent's attibute.");
    System.out.println("Child class calling non-parameterised parent's constuctor by defualt: ");
    System.out.println("##########");
    AlienForce a1 =  new AlienForce();
    System.out.println("##########");
    System.out.println("here,we will now use parameterised constuctor fo child, but we wont use super, so we will be using the dufalt non-p onstuctor pof aprent, here we wont send any parent attibtues values, so it's Null");
    AlienForce a2 = new AlienForce("Humangasour");
    System.out.println("##########");
    System.out.println("We will now use super and set parent attibteus values alos , using aprent; parametsied  constuctors and use th parent's attibuets in child print statement.");
    AlienForce a3 = new AlienForce("Ben Tennyson","Omnitrix",50,"Diamond Head",100);
    System.out.println("##########");
    System.out.println("We will now create a obj in grnd chidl class, it willa tuiomidatically, cll teh parent, child non-parameterised constructors, we didnt use super() keyword to use the paraemterised chidl cosnturctors, so we cna set praent adn child's attribtue valeus, so theria ttibetu values wodul be null here");
    UltimateForce u1 = new UltimateForce("Ultimate Alien of ?","Extra shields, shooting power", 170);
    System.out.println("##########");
    System.out.println("We will now create a obj in grand child class, will all aprent;s an child's attibutes,a nd we will use super keyword, to call the parametrised cosntuctor of child, which will  set teh child's attributes, adn it ill call teh parent;s parameteiose constructor to set the paren;t attibutes. adn thenw e will use all parent;s, child's attribute values in teh  grand child's print statemtn. We also used this keywrod to resovle name conflicts and super to refer to the same att., name alienName of child class.");
    UltimateForce u2 = new UltimateForce("Ultimate Big Chill","Ben Tennyson", "Omnitrix",30, "Big Chill",80,"Fire", 180);
    System.out.println("Note: super() keyowrd should always be teh first statmetn inside the child's constuctor, if we need to modify teh parent's constuto beign called. It will cause issue, if we use super keyword, as second or third statemetns in teh code inside the child's constructor.");
    System.out.println("##########");
    System.out.println("Accesing child's method from grandchild");
    u2.SeasonName();
    System.out.println("##########");
    System.out.println("Overriding child's method by grandchild");
    u2.WhoAreU();   
    System.out.println("##########");
    System.out.println("Dynamic Method Dispatch/RUn type polymorphism means, when we create a ref., of a super class, pointing to the object of a sub-class, and when an overrided method is been called, then the method of the superclass is shadowed, the sub-class emthods are onyl executed. i.e the methods being executed are based on the object u created, not based on the ref., var.,. The part on the left side i.e the type of the ref., var., created desiced which atributes or methods are accessible, and the right part, object creation is done during runtime. During compilation, The compiler determines what methods and fields are legally accessible based on the declared reference type. During run-time, wheich method or attibtue to be used, is decied based on the object type created during runtime. But it is not possible to create a ref var., of type child class, and point it to object of parent class, e.g., UltimateForce u10 = new AlienForce(); it would lead to error, the reason is, the subclass might have additional members or methods that the superclass does not, which would result in a type mismatch or runtime error.");
    AlienForce a4 = new UltimateForce();
    System.out.println("##########");
    System.out.println(" Here, if we access like a4.addn_Power or a4/(any method that is present only in Ulitmate force, not in Alien Force), it would cause compile error , since addn_Power is not an attr., of AlienForce. During compilation, the compiler checks whether its a valid attr., of the ref., type .If no, error. ");
    System.out.println("Displaying grandchild obj's WhoAreU method, using child's ref variable.");
    a4.WhoAreU();
    System.out.println("In Java, if we call a amthod like power() in child class, if it contains the smae emthod naem method, but with parameter, for e.g, power(x), and its parent contains power(), java wont consider power(x) of child class as an overrided method of parent's power(), as in Java, method signatures (including parameter types, return type and counts) are part of the method identity, so a method with different parameters is considered a different method. So,it will execute the parent's power() method. S Whereas in Python, methods are primarily identified by name, not by their parameters. When you override a method in Python with a different parameter list, you're completely replacing the parent's method with your new implementation. It doesn't look for an alternative implementation in the parent class that might match the call signature better. So, Python woudl show error, as power(x) as a child method, has an apameter which is not provided by the user.");

    System.out.println("If both chidl adn parent class method have same name, return type, paramer count- it becomes overriding, when parameter/ its counts r diff, name alson same,it beomces overloading, when name, parametr, apramter counts all r same, but if return type is diff for both,it becomes neither overloading or overridiing. But there is an execption case, where overriding is possible, even if return types r diff.,Java allows for what's called \"covariant return types\" as a special exception to this rule. Covariant return types mean that an overriding method can return a subtype of the return type declared in the parent class method. Since B extends A (meaning B is a subtype of A), this override is valid. This works because a B object is also an A object (through inheritance), so anywhere an A is expected, a B can be provided safely. This feature doesn't extend to primitive types or unrelated reference types - the return type in the child must be a subtype of the parent's return type.");
    System.out.println("############");
    C d1 = new D();
    System.out.println("I'm creating a ref., var of class C, potingin to a class D object, and acesing display method, where child's dispaly method itslef executed, eventhoguih return type of both aprent and child;s method r diff., since return type of child, is a a sub-class of return type of parent method's return type. So, overriding is accepted here.");
    d1.display();
    System.out.println("############");
    System.out.println("Overriding is not possible for static and final methods. Access modifiers based on strictness: private>protected>public. Overriding is possible b/w methods of parent and child class methods, where the child class., method's access modifier's should be in the same strictness level or less strictness level than the parent method's access modifier. If the parent method is public, overrided chidl method  also shoudl eb public. If par., method is protected, voerrided chidl emthod should be only protected, public. If par., method is private, teh child's method can be private, protected or public.");
    System.out.println("Polymorphism (one name, diff., actions) contains Overlaoding (Compile time Polymorphism), where which emthod to eb called is decide based on the parameters, during compile time itself and Overriding (Run time polymorphism)");
    System.out.println("Private members of a superclass are not directly accessible to the subclass. It can be accesed only by using getters/setters provided by the superclass.");
  }   

  
}
 