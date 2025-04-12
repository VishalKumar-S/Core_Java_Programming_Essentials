import java.io.FileInputStream;
import java.io.FileReader;
import java.util.regex.PatternSyntaxException;
import java.util.Scanner;

class CustomExceptionHandling extends Exception{
    public String toString(){
        return "Regex pattern didn't matched.";
    }
}

public class _16_Exception_handling {
    public static void main(String[] args) {
        System.out.println("Errors r of 3 types:\n1. Syntax errors - these errors r corrected with the help of compiler. Happens due to the carelessness of programmer.\n2. Logical Errors- These errors are alsode ute ot programmer's carelssenses. These errors are corrected with teh help of  tracing/debuggers.\n3.Runtime erors - these errors r not due to mishandling of program, by the user. These errors are called as exceptions, and these occur in the run-time, due to the mishandling of program by the user, like bad inputs e.g -10 for age, resource unavialbilty etc., We can only notify users, theseare the exceprions occured. We use excpeion handling to resolve these errors. We can use try-catch blocks, simple try-catch, or single try,multiple catch blocks,or ensterd-try-catch blocks. if we use finally block, its executed compulosityl, whether u catch the exception or not. So,finally block is used to free up teh resources being utilised e.g f.close(). There is anothe concept, try with resources, so isntead of using finaly for closing the resources, if we use try with resources, after try gets exectued, the reources gets automatically closed. For try with resources, there is no need of catch and finaly blocks. finaly is not eneded,a s try itself close th reorusecs, catch block is requried if u need toc pature hte exception ther eitself, instead of throing to teh upper heirarchy.");
        try (FileInputStream f = new FileInputStream("_14_static.java");Scanner sc = new Scanner(f)) {
            String a  = sc.next();
            System.out.println("Read the file, now automataically the file and Scanner resource will be closed. If we didnt use it, we need to use finally block to free up the resources.\n First token is: "+a);
        } catch (Exception e) {
            System.out.println("Invalid file");
        }

        System.out.println("In multiple catch blocks, the first catch block should handle the child class exception. This is because Java evaluates catch blocks in the order they are written, and if a parent class exception (like Exception) is caught first, it will also catch all its child exceptions, making subsequent catch blocks for child exceptions unreachable. This would result in a compilation error.");
        try {
            // Code that may throw exceptions
        } catch (ArithmeticException e) {
            // Handle child exception
        } catch (Exception e) {
            // Handle parent exception
        }
        
        System.out.println("Theere arr 2 classes related to erros - Exception and Errror. Both of these classes, are inherited from throwable class. Throwable class is inherited from Object SuperClass. THe Exception class, contains the subclasses - ClassNotFound Eception, IOEXception, INteruptedEXception, NUmberFormatException and Run time Exception. All the sub classes here mentioend except Runtime exceptions come under checked exception, thses errors must be cheked with tyr catch blokcs by the user, whereas the Run time error is unchecked exception, it;s optional for teh user to use tyr catch or not, Run time exceptions contains teh sub classes arithmetic exception, index out of bound exception, null pointer exceptioon. Printing the excepiotns ahe hte options liek String.getMessage(),it will retun eh error message as a string, void printStackTrace(), it will give th trace of error");

        System.out.println("Try-catch:-");
        int a[] = {1,0,2,3,4};
        try{
            int c = a[0]/a[1];
        }
        catch(ArithmeticException e){
            System.out.println("Do not divide by 0");
        }

        System.out.println("Try- multiple catch:-");
        int a1[] = {1,0,2,3,4};
        try{
            int c1 = a[0]/a[1];
            int d = a[10];
        }
        catch(ArithmeticException e){
            System.out.println("Do not divide by 0");
        }        

        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Ensure indeices r within arryy boundaries.");
        }


        System.out.println("Nested Try catch:-");
        try{
            try{
                Class.forName("Helicopter");   }
            catch(ClassNotFoundException e){
                System.out.println("Class not found: \n"+e);
            }

            _16_Exception_handling obj2 = null;
            try{
                System.out.println(obj2.toString());
            }
            catch(NullPointerException e){
                System.out.println(e);
            }
            int result = 10/0;
        }
        catch(ArithmeticException e){
            e.printStackTrace();
        }

        finally{
            System.out.println("Just executed nested try-catech block");
        }

        System.out.println("For all checked exceptions, whenever a method cretes a exception, our compiler, will hceck whether teh user have given try-catch statement in that method itsefl, if not, it checks for try cathc statemn in the abvoe method it called it, it checks all the hierarchy of emthdos it called it, till main emthod, if main emthod also didint  resolve the excepiton,using try-cathc, compiler will cause error. throw keyword is used to throw the error, to the method, which called it. throws keyword deifnes that this method, is gogin to throw the excepito,so the upper heirarchy method, knwo the method im gonna clal is goign to thwo exception, so either need to resolve teh esisseu, by usign tyr-catch over ther,or again use throw keyword to send the erro to its upper heriarchy. i.e in simple terms, if u do not want to reoslve the exception, with try-catch block in the current level, use throws and thrwo ekywrod to send the eception to the upper lvel, if in our code, we are only senidng ht expceiton to the higher levles, with throw adn thrwos, wihtout actually usgin try-cathc vlbosks, tehn fianlyl compiler woudl resutl in error. Somehwere, int heriracey,we need to use tyr-cath dn resolve hte exception.We can also create out own exception class, by extedning the exception class. Let use see an example of custom exception class, with thrwo,thrwos keyword try-block statemsnt at differnet  level of method calls.");

        try{
            Validation();
        }
        catch(Exception e){
            System.out.println("Finally catched the excpetion at main method, even here if i throw, it will cause compile error. Phone no validation exception catched after 3 throws in the main method\n"+e);
        }        
    }

    public  static void Validation() throws CustomExceptionHandling{
        ValidationCriteria("name","Vishal1234");

        ValidationCriteria("e_mail","vishal123@.");

        try{
        ValidationCriteria("address","");
        }
        catch(Exception e){
            System.out.println("Catced address exception in 2nd throw\n"+e);
        }

        try{
            ValidationCriteria("phoneno","1234589");
        }
        catch(Exception e){
            System.out.println("Im throwing 3rd time");
            throw new CustomExceptionHandling();
        }

    }

    public  static void ValidationCriteria(String criteria, String input) throws CustomExceptionHandling{
        if (criteria.equals("name")){
            System.out.println("Name Validation: ");
            validateName(input);
            System.out.println("Name validation exception resovled with not using any throws, used try catch immediately in the method itself, whreer execption occured.");
        }
        if (criteria.equals("e_mail")){
            try{
                System.out.println("E-mail Validation: ");
                validateEmail(input);
            }
            catch(Exception e){
                System.out.println("E-mail validation exception resovlld with 1 throw \n"+e);
            }            
        }

        if (criteria.equals("address")){
            try{
                System.out.println("Address Validation: ");
                validateAddress(input);
            }
            catch(Exception e){
                System.out.println("Im throwing 2nd time.");
                throw new CustomExceptionHandling();
            }
        }
        if (criteria.equals("phoneno")){
            try{
                System.out.println("Phone No Validation: ");
                validatePhoneno(input);
            }
            catch(Exception e){
                System.out.println("im throwing 2nd time.");
                throw new CustomExceptionHandling();
            }
        }
    }

    public  static void validateName(String input){
        try{
            String pattern = "][][]8442$%$&#&";
            if (!input.matches(pattern)){
                System.out.println("It's not a valid name");
            }
            else{
                System.out.println("It's a valid name");
            }
            }
    
        catch(PatternSyntaxException p){
            p.printStackTrace();
        }

    }

    public  static void validateEmail(String input) throws CustomExceptionHandling{
            String pattern = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.(com|org|in)";
            if (input.matches(pattern)){
                System.out.println("It's a valid e_mail id");
            }
            else{
                System.out.println("Im throwing 1 time.");
                throw new CustomExceptionHandling();
            }
    }

    public  static void validateAddress(String input) throws CustomExceptionHandling{
        String pattern = "[a-zA-Z0-9]+";
        if(input.matches(pattern)){
            System.out.println("Address is valid");
        }
        else{
            System.out.println("Address is wrong");
            System.out.println("im thrwoing 1st time.");
            throw new CustomExceptionHandling();
        }
        
    }

    public static void validatePhoneno(String input) throws CustomExceptionHandling{
        String pattern = "[0-9]{10}";
        if(input.matches(pattern)){
            System.out.println("Phone No is valid");
        }
        else{
            System.out.println("Phone No is wrong");
            System.out.println("im throwing 1st time.");
            throw new CustomExceptionHandling();
        }
        
    }

}