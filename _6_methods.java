public class _6_methods {

    static void method_learning(String name, int no){
        name = "Kumar";
        no+=1;
        System.out.println("I'm a int no: "+ no);
    }

    static void method_learning(String name, float no){
        name = "Kumar";
        no+=985.75f;
        System.out.println("I'm  method overloading, a float no: "+ no);
    }

    static void mutable_object(int[] m){
        m[0]= 100;
    }

    static void var_args(String name,int ...no){
        for (int x: no){
            System.out.println(name+"'s no is "+x);
        }

    }

    public static void main(String ... args) {
        System.out.println("Syntax of method is return_type function_name(arguments). U can only another static method from a static method. In java, the parameters of the method, from which another method is called as actual parameters, and the parameters of the method being called is the formal parameters. When the method is being called, all the contents in the actual parameter is copied to the formal parameter. When the actual parameters are primitives, e.g, int a = 5 , b = 10; method_learning(a,b) or method_learning(5,10), the content of these parameters are copied to teh formla paremeters ot eh emthod  is biegn called. Here the content is the actual value, so an another copy of the actualv alue is copied  in the formal parametes, so both of these values are different. So, whatever chagnes being done to the vairbels in formal apremteres, would not be reflected main in the main emthod being called, its called as Call By Value. Whereas instead of a primtive, if we give  ref variable of an object as an actual parameter, then when the content of the ref., var in actual parameter is copied to formaal paramet,w e knwo that ref., var., f objects not stre teh oject, instead teh ref/memoery add., of the objects. So, th reference to the object is copied to the formla paremters. So, since the reference to the obejct is same in both emthods, whatever change i do in the method beign called, teh same iwll eb refelcted in the method,which called it, it's called as Call by reference. In Java, emthod overlaoding possible. But 2 methods with same number of parameters adn teh same type of parameters is not allowed. Ilt;s illegal.Atleast any 1 change should be there between them.");

        String name = "Vishal";
        int no = 1;
        method_learning(name,800.23f);
        method_learning(name,537);
        int arr[] = {1,2,3,4};
        mutable_object(arr);
        System.out.println("After calling the method, string is not changed from Vishal to Kumar, since String is an immutable object, so a new object Kumar is created and updated to the local varibel name over there,so change is not reflected here"+" whereas our primitive no didn't change, no= "+no+" We try to change our array from arr [1,2,3,4] to"+ java.util.Arrays.toString(arr));
        System.out.println("In Java, variable arguments is allowed. Even printf function is having variable argumetns only, we have any much amunt of fomrat sepeifiers and its repsetive values. Note, wheneeer we are using other parameters along with a variable argument, var argumetn shoudl be th last arguemtn of the method, no argumetn shoudl come after the var argument. We can pass the var agumetns as both individual elements, as well as an array also. We can also use var args instead of String [] args, JVM accepts this method signature also. It works fine. Else,it's error. Check it below ");
        System.out.printf("I am %s, studying %s, %s year.","Vishal Kumar","Engineering","3rd year");
        System.out.println();
        var_args("Vishal");
        var_args("Vishal",1,2,3,4,5,6);
        var_args("Kumar",new int []{1,2,3,4,5});
        


    }
}



