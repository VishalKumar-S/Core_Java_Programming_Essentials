@FunctionalInterface
interface lambda1{
    public void display();
}


class child implements lambda1{
    public void display(){
        System.out.println("im tradiditonal way of overriding the interface.");
    }
}



@FunctionalInterface
interface lambda2{
    public String display(String s);
}


@FunctionalInterface
interface lambda3{
    public String combine(String delimiter, String ...s);
}


public class _19_lambda_expressions {
    public static int instance_variable = 100;

    public _19_lambda_expressions(){
        System.out.println("Using a constructor as an emthod reference, to the display() method, for this, we jsut need to use Class name::new keyword");
    }
    public static void main(String[] args) {
        lambda1 l1 = new lambda1(){
            public void display(){
                System.out.println("Im creating  anonymous inner class, to create a inner class of the interface lambda1 and create an object of it, and overrride teh abstract methods, simulatenously, here in the  {} itself");}
            };
        
        System.out.println("Lambda expressions r created to write optimsied or easy code, for implemneting or overriding methods of Functional interfaces(interfaces with only one method). lambda1 expressesions are less to code, even better than annonymous inner classes in the case of functional interfaces. Here, instead of creation of a class, here a method is created and it acts as an object, where teh abstract methdos of the interfaces would be overrided");
        lambda1 l2 = 
            ()-> {
                System.out.println("I implemented the Functional interface using lambda1 expression. Note: we r not menitoning the overrding method name, we r only usign (), since its a functional interface, there is only one method in the interface, so by default () mentions that single method in the interface. Trick to write its syntax is , write the anonymous inner class creation way of implemetning the interface, then first, remove the overrdiing method name along with its access mdofiiers i.e 'public void display' alone, next remove the 'new interface_name(){' till the opeinign brackt, then add a  -> after the (), then at the last remove the exta }; and then inlcude ; for the overrding method clsoing paranthesis.In lambda expressions, if the abstract method inteh functional interface has parameters, even then in the lambda expression, just mentionthe input variable in teh (), no need to mention the daatatyoe fo the input variavel, if suppose, eeven we need to return something in the overrided method, we need not to write return statement.");
            };
        
        lambda1 c1 = new child();
        c1.display();
        l1.display();
        l2.display();

        lambda2 l3 = (String s)->{return s;};
        lambda2 l4 = (s)->{return s;};
        lambda2 l5 = (s)->s;;

        lambda1 l6 = ()->{
            final StringBuffer welcome = new StringBuffer("Hi!!");
            int count = 0;
            System.out.println(welcome+"Lambda expressions can use local variables,that r created within this method, but thye should be final or effectivey final,count =" +count+ " if we perform this count++ anywhere in thies method in the code, it will lead to error. \nLambda expressions also can use instance variables of the class, within which it exists, and we can modify this instance vaiavel,ther eis no restriction of it being final. instance_variable is,afte rmodifying it, runs without any issues "+ (++instance_variable));
            System.out.println("You can also have multiple code statements in the lambda expressions.");};


        System.out.println(l3.display("Parameterised lambda expression with return keyword and datatype of the input variable."));
        System.out.println(l4.display("Parameterised lambda expression with return keyword alone"));
        System.out.println(l5.display("Parameterised lambda expression without return keyword, remove the {}; speific to the method"));
        l6.display();
        functional_argument(()->{System.out.println("We can pass methods as parameters in Java, we can send lambda expressions also as paramter. We need to properly mention the interface ref type and the input ref variable name in the formal arguments, and in the actual arguments, u pass the lambda expression directly, as done here.");});

        lambda2 l7 = method_ref::reverse;
        System.out.println(l7.display("Vishal Kumar. S"));
        
        
        lambda1 l8 = System.out::println;
        l8.display();


        lambda1 l9 = _19_lambda_expressions::new;
        l9.display();

        lambda3 l10 = String::join;

        
        System.out.println("String join method as method reference "+l10.combine(" ","Vishal","Kumar",". S"));

    }
    public static void functional_argument(lambda1 l7){
        l7.display();
    }

class method_ref{
    public static String reverse(String s){
        StringBuffer s1 = new StringBuffer(s);
        s1.reverse();
        System.out.println("Reversed String is: "+s1);
        System.out.println(":: refers to method reference operator. A shorthand for lambda expressions when the lambda is just calling an existing method. It passes the method reference (i.e., the behavior) to be executed later—not calling it immediately. Here, the 'method_ref::reverse' behaves like '()->method_ref.reverse()'");
        return s1.toString();
    }
}



}
