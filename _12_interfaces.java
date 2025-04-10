import java.util.Arrays;
class TVSMotor{
    public String company_Name = "TVS";
    public String[] models_Availabe = {"Excel", "TVS 50", "TVS 100", "TVS Apache"};

}



interface Vehicle{
    // all the below var are public, static and final only be defaultJ
    String VEHICLE_OWNER = "TVS Motors";
    static int WARANTY_PERIOD_YEAR = 15;
    static final int FREE_SERVICE_DAYS = 90;

    String getName();

    // all the below methods are abstract and public only be default
    public double getPrice();
    public abstract int getModelYear();
    void addModel(String modelName, double price, int modelYear);

    default void displayVehicleDetails() {
        System.out.println("--- Vehicle Details ---");
        System.out.println("Owner: " + VEHICLE_OWNER);
        System.out.println("Warranty: " + WARANTY_PERIOD_YEAR + " years");
        formatAndPrintServiceInfo();
    }

    //private instance method
    private void formatAndPrintServiceInfo() {
        System.out.println("Free service available for first " + FREE_SERVICE_DAYS + " days");
    }


}


interface Inventory{
    String getAvailabeStocks();
    void updateCount();
}


class SuperTVS extends TVSMotor implements Vehicle, Inventory{

    public String modelName;
    public double price;
    public int modelYear;
    private int stocksAvailabe[] = {10,15,20,30};
    private int count = 0;
    private Customer customers[] = new Customer[100];

    public void addModel(String modelName, double price, int modelYear){
        this.modelName = modelName;
        this.price = price;
        this.modelYear = modelYear;
    }
    
    public void addCustomers(Customer customer){
        customers[count++] = customer;
        System.out.println("A new customer "+customer.getCustomerName()+" is joined in our family.");
    }

    public void inviteCustomers(){
        for(int i = 0; i< count;i++){
            Customer c = customers[i];
            member.callConnection(c);
            c.callback();
        }
    }

    public String available_models(){
        return Arrays.toString(models_Availabe);
    }

    public String getName(){
        return this.modelName;
    }

    public double getPrice(){
        return this.price;
    }

    public int getModelYear(){
        return this.modelYear;
    }

    public String getAvailabeStocks(){
        return Arrays.toString(stocksAvailabe);
    }
    
    public void updateCount(){
        for(int i = 0;i<stocksAvailabe.length;i++){
            stocksAvailabe[i]+=1;
        }
    }
}

abstract class SparkTVS extends TVSMotor implements Vehicle, Inventory{

}


interface member{
    public static void callConnection(Customer receiver){
        System.out.println("Calling "+ receiver.getCustomerName()+ " "+receiver.getPhoneNo()+" ....");
    }
    void callback();
}

interface PremiumMember extends member{
    void loyaltyRewards();
    void priorityService();
    void exclusiveEvents();
}

class VIPCustomer implements PremiumMember{
    private String name;
    private String position;
    private int loyaltyPoints;
    private int noOfPurchases;
    private int priority;

    public VIPCustomer(String name, String position, int noOfPurchases){
        this.name = name;
        this.position = position;
        this.noOfPurchases = noOfPurchases;
    }

    public void loyaltyRewards(){
        loyaltyPoints+=(noOfPurchases*100);
    }

    public void priorityService(){
        this.priority = this.priority+1;
    }

    public int getPriority(){
        return priority;
    }

    public int getLoyaltyRewards(){
        return loyaltyPoints;
    }

    public void exclusiveEvents(){
        System.out.println("Special Dinners, Weekend , Vacation plans.");
    }

    public void callback(){
        System.out.println("It's "+name+" P.A here "+ name +" is too busy.");
    }

}




class Customer implements member{
    private String customerName;
    private int phoneNo;

    public Customer(String customerName, int phoneNo){
        this.customerName = customerName;
        this.phoneNo = phoneNo;
    }

    public String getCustomerName(){
        return customerName;
    }

    public int getPhoneNo(){
        return phoneNo;
    }

    public void callback(){
        System.out.println("It's "+customerName+" here, will visit the showroom soon...");
    }
}



public class _12_interfaces {

    public static void main(String[] args) {
        System.out.println("Inheritance is used for inheriting from parent class to child class. Abstract classes are used for both inheriting purpose and to achieve polymporphism(overriding the abstract methods). If we need to achieve only polymorphism, no need of inheeritance, i.e there is nothing the parent class could give to the child class, only overriding of parents methods are done in child class, then we can use Interfaces instead of abstract classes. Interfaces are used, whenw e ened to achive only polymorphism i.e overriding/run-time polymorphism and dynamic method dispatch. an interface is an abstract class, with only abstract methods. An interface is used to achieve the funcitonaltiy of multiple inheritance. We use extend keyword to extend parent class prop., to child class. IN interfaces, we would use implements keywords, instead of extedn, and a classs can implemnt from any no of classes. By default, interfaces methods are abstract and public in nature. so, no need to use the keywords, abstract and public. Other than deuslt nature, we can explicilty create static, default, private methods in an interface . Like an abstract class, we can also not create objects for an interface, since all it contains is abstract. Whenever a class implements a interface, either it should be an abstract class or it should override all the methods in the interface. All variables/fields in an interface is public, static and final by default i.e making them constants, so The Java coding convention is to name constants in ALL_CAPS_WITH_UNDERSCORES. This converntion makes readbabiltiy better. An interface can contain an method with body, in 3 ways- either it should be static/default/private method.\n Static methods - Static methods provide utility functions related to the interface without requiring an instance. Cannot be overridden by implementing classes \n There is a concept called Default methods, that helps to evolve interfaces, without breaking the code. Tradiitonaly, in a system, where multiple classes have implemneted the interface, where they must have overrided all the methods in the interface, if we require to add a new functionality to the interface, then if we add a new abstract method to the interface, then we should ensure all the classes that have implemented the interface, should have override the new method, to compulsorilty to ensure teh code works, or we need to convert those classes to abstract. To ensure, the classes already implemented th interface, not show any issues, if we created the enw feature method as a default method in the interface, the code works fine, without the need of overriding them in all the classes. In the future classes, if we wish we can override the new featue method, no need to wrory abt the already implemnted classes. If its needed, u can also inherit in the already implemnetd classes. \n Private mehods supports code reuse within an interface. It acts as helper method to other methods in the interface. It's used to have the common code used by multiple default methods in the interface. Note, private methods cant be implementedd by other classes, private methods can be used only within the interface, private instance methods are used by a default method.");

        SuperTVS showroom1 = new SuperTVS();
        showroom1.addModel("TVS 100", 50000.00, 2010);

        System.out.println(showroom1.available_models()+"\n"+showroom1.getName()+"\n"+showroom1.getPrice()+"\n"+showroom1.getModelYear()+"\n"+showroom1.getAvailabeStocks());
        showroom1.updateCount();
        System.out.println("######");
        System.out.println("For SuperTVS to exist as a concrete class, we overrided all the interface methods it implemented.");
        Vehicle v1 = new SuperTVS();
        v1.addModel("TVS 10000", 428000.00, 2015);
        Inventory i1  = showroom1;
        TVSMotor t1 = showroom1;

        System.out.println("We cannot create objects of the interfaces, we can only create ref.,var., of their type. But, we can make them  point it to the showroom object, so that the Vehicle and Inventory ref.,v ariable can only access it's own  defined proeprties in that speciifc showroom, if cant access other poerpties or funcitonalites of teh showrrom i.e Vechicle v1 sysytem can onyl access vehvilce related details of that showroom, whereas invecntory i1 can onlt knwo about the inventory related atteibutes of the SuperTVS showrrom,it cant access otehr featues.");
        System.out.println("We are accesing vhecile related attribtues alone using cehcile ref type potingin to teh showrrom 0object, if we try toa ccess like v1.availabe_models(), it swoudl show error\n"+v1.getName()+"\n"+v1.getPrice()+"\n"+v1.getModelYear());

        System.out.println("We are accesing inventory related attribtues alone using inventory type pointing to the showrrom object, if we try to access like i1.getModelYear(), it swoudl show error"+" Avaialble Stocks: "+i1.getAvailabeStocks());

        System.out.println("We creates showroom  SparkTVS, where we didnt override any methods, so we made it as an sbstract class, to exist.");

        System.out.println("##########");
        Customer c1 = new Customer("Vishal", 123456789);
        Customer c2 = new Customer("Kumar", 987654321);
        showroom1.addCustomers(c1);
        showroom1.addCustomers(c2);
        System.out.println("Let's call all our customers, for festive season. here, ill use the invite customers method of supertvs and also i'll also demonstrate using static method inside the member interface.");
        showroom1.inviteCustomers();
        System.out.println("##############");
        System.out.println("Interfaces can be extended by interfaces. So, here the interface which extends the parent interface, need not override the aprent interface methods. But suppose, if any normal concrete class implements the child interface, then to exist, it should override all the abstract methods defined in all its interface superclasses i.e parent and child interfaces");
        VIPCustomer vip1 = new VIPCustomer("Shreekanth Verma Chekuri", "Tech Lead",  10);
        member m1 = vip1;
        m1.callback();
        PremiumMember pm1 = vip1;
        pm1.loyaltyRewards();
        pm1.priorityService();
        System.out.println("vip1's priority is: "+vip1.getPriority()+"\n loyalty Rewards is "+vip1.getLoyaltyRewards());
        pm1.exclusiveEvents();
        

        System.out.println("#####");
        System.out.println("WHY INTERFACES ARE IMPORTANT IN JAVA:\n------------------------------------\n1. MULTIPLE IMPLEMENTATIONS: Different classes can implement the same interface.\n   - Example: Customer, VipCustomer, CorporateClient can all implement Member interface\n   - All can be called by the Store in the same way callback(), despite having different implementations, else we need to call like callback_Vip_customer(), callback_corporate_clinet(), instead have callback(), alone and implement th enecessary modfiicaitons in tehri repsective classes.\n\n2. REAL-WORLD EXAMPLES WHERE INTERFACES ARE CRITICAL:\n\n   a) Event listeners in GUI programming:\n      - Button clicks need to notify different components\n      - The Button doesn't need to know what those components are, just that they have an \"onClick()\" method\n\n   b) Database connections:\n      - JDBC defines interfaces like Connection and Statement\n      - This lets you switch between MySQL, PostgreSQL, Oracle without changing your code\n\n   c) Collections framework:\n      - List interface can be implemented by ArrayList, LinkedList, etc.\n      - Your code can use any List implementation without modification\n\n   d) Dependency injection:\n      - Your business logic depends on interfaces, not concrete implementations\n      - Makes testing much easier by allowing you to substitute implementations\n\n3. THE POWER OF INTERFACES IN LARGER SYSTEMS:\n   - Change implementations without changing client code\n   - Allow for future extensions\n   - Test components in isolation\n   - Define clear boundaries between system parts\n\n4. CONCEPTUAL IMPORTANCE:\n   - Interfaces represent a contract or capability rather than an inheritable implementation\n   - They answer \"what can this do?\" rather than \"how does it do it?\"\n   - This separation is fundamental to good software design");
        System.out.println("##############");
        System.out.println("Interfaces vs Mulitple Inheirtance: Examples:\n 1. M.I - Smartphone inherits phone, camera, music player.\n I- Smartphone inherits phone, and it implements camera and music player.\n M.I says a smartphone is also a phone, camera, music player. whereas Interfaces says, a smartphone is basically a phone, which also has camera and music player features. \n Example 2 : M.I - SUzuki inherits from Car, Music Player \n I - Suzuki inherits from Car and implements Music Player. \n M.I says suzuki is a car as well as a musci player, whreas I say suzuki is a car, it also has music player features.\n Interfaces explanation are better than M.I. That's why m.i is not allwed in Java by design, so only it allws a class to inherit only from a single class, and as per need, it could implement the required features using interfaces");
    }
}