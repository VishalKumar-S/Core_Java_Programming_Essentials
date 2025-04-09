abstract class TVSMotors{
    public String brand_name = "TVS";

    public String getBrandName(){
        return brand_name;
    }

    public void design_vehicles(){
        System.out.println("Design new vehicles");
    }

    public void create_vehicles(){
        System.out.println("Create TVS 50, excel, bikes");
    }

    public abstract void offers();
    public abstract void work_hours();
    public abstract void billing_methods();
}

class SarathyTVS extends TVSMotors{

    public void brand_name(){
        System.out.println(getBrandName());
    }

    public void offers(){
        System.out.println("1% special discount on birthday purchases.");
    }

    public void work_hours(){
        System.out.println("Working hours Mon-Sat 8AM to 9 PM. Sunday holiday.");
    }

    public void billing_methods(){
        System.out.println("Credit Card, Debit Card. UPI options available.");
    }

}

abstract class ElevTVS extends TVSMotors{

}

public class _11_abstract_classes {
    public static void main(String[] args) {
        System.out.println("Classes r of 2 types: \n1. Concrete classes - normal traditional classes \n2. Abstract classes - We can create ref var of an abstract class, but we can't create objects of an abstract classes. An abstract class can contain 0/1+ abstract methods. \n Abstract methods are methods, which does not contain any body. If an class contains an abstract method, it should be an abstract class. Any class that inherits abstract class, either it should become abstract class, by declaring it also as an abstract class,but we cant create objects to this child class now or override all the abstract methods in the parent class, to make the child class as concrete class itself, so that it is useful so that we can create objects to the chidl class now. Abstract class, woudld be the standard defined, and the concrete classes inheriting them, will implement it.Abstract classes cannot be final. Final class means we acnt extedn it, final method, wmeans we cant override it. But abstract classes r meant for inheriting only. Abstract methods also cannot be final, since abstract mehtods are meant for ocerriding only. Abstract classes adn emthdos cannot have static keyword, since static means, attribtues can be called without creating a obj., but abstract means, that proeprty doesnt even deifned,there is no body at all first place. So,it is not allowed,");

        System.out.println("#####");
        System.out.println("We are either create an ref var of TVSMortor/SarathyTVS type adn create an obj of Sarathy tvs. its not possibel toc reate an object for tvsmotors tiself,sicne tis an abstact type.");
        TVSMotors showroom1 = new SarathyTVS();
        showroom1.offers();
        showroom1.billing_methods();
        showroom1.work_hours();
        SarathyTVS showroom_1 = new SarathyTVS();
        System.out.println("Accessing abstract parent class attribtues via getters and setters, to show it, we created anew obj of ref type of SarathyTVS, only then, the geBrandName() method is defined during compile time."+showroom_1.getBrandName());
        System.out.println("####");
        ElevTVS showroom2;
        System.out.println("ElevTVS: Since im inheriting from TVSMotors, and i took the new franchise for TVS just now, i cant override the abstract methods and tell the offers, working hours, billing methods right now, so to remain extending teh properties from TVSMotors class, i need to stay as abstract class. But since im an abstract class now, it would not be possible to create an object of mine. You can only create a ref.., var of type mine.");


    }
}
