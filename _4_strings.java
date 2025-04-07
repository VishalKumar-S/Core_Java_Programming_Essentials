public class _4_strings {
    public static void main(String[] args) {
        System.out.println("String objects are immutable");
        System.out.println("For printinng printf, format sepcifier ahs teh following order availabe - %[argument_idx $][flags][width][.precision]conversion \n arg_idx - says the which sepcpfic arg to use at that place, width says how mcuh characters eneds to eb pritned in otuput, flag says what shoudl be fileld in thae empty spaces of thwe width, .precision says how much decimal valeus to have, conversion says the dattype of teh value char -c, int - d(Decimal), o(octal),x (hexa), flaot - f,e,g, String - s, flad can have - (-ve sign if its a -ve no), + (+ve sign if its a +ve no), 0 - pad 0 in empty spaces inthe width, ','- gives , to the numer formatting");
        
        String s = "Vishal";
        System.out.printf(" Name Vishal with total output width of 10 characters %10s\n",s);
        int i = 1255555;
        float f = 125.87823f;
        double d = -4864.464684;
        long l = 999999999999999999l;

        System.out.printf("Now, I'll change the order of arguments of the format specifiers, flag,width,precision  long: %3$020d double: %2$-20.4f float: %1$+20.1f int: %4$,-500d" ,f,d,l,i);

        System.out.println("You can create strings via 2 ways: \n 1. String s = new String('svs')\n 2. String s = 'vishal' \n. String is a  class in Java. When u create string via 1st method, string object is created in the common heap area, as well as, String pool ( a special area inside the heap memory), but the s will have referecne to the string object in the common heap alone, the sting obejct created in the string pool would have no reference. At the same time,w ehn u create string usign method -2, here string object would be created in the string pool, not in the common heap area, and the ref., var s would be potinign to the string object in the string pool. This string pool acts as an optimistaion for strings in Java, wheever we try to create 2 string objects, containing the same string literal value, new string obj wont be created, if already exsiitng obj with teh same string literal, enw ref, varibel would point o theexisitn obj., instead fo creating enw, thus Reusing immutable strings saves memory");
        String s1 = "vishal";
        String s2 = "vishal";
        String s3 = new String("vishal");
        if (s1==s2){
            System.out.println("When a new string object is tried to create adn point to s1, first it is checked string literal vishal is already existing in string pool or not, if exsiitng, it woudl not create another string object in string pool, it would directly point to it. Since nothing presnet, it woudl create new string object witth the content vishal in teh pool, adn s1 points to it. When s2 tries to create a new string object, it checks whether the string pool contains anty obj already with teh same ltieral,if yes, it will direclty poitn to ti,instead of creating ewn string object, so s1 and s3 points the same");
        }
        
        if (s1!=s3) {
            System.out.println("Here, s3 creates a new string object in the heap common area, since it used new keyword, and then it checks whether stirng pool contains any obejct with teh same string literal, since alreayd present,it wont create anoht ernew object again in the string pool, and copies the content from it. Now, s3 is potingin to teh string ibejct rpesent i thre regualr heap emoeyr,diff., from teh stirng obejct in the pool. So, s1 and s3 are not same.");
            
        }

        byte b[] = {65,66,67,68,69,70};
        String characters = new String(b,1,3);
        System.out.println("String constructor with offset and length parameters "+characters);
        System.out.println("When u perform string methods like b = a.toUpperCase(),the resulting uppercase String is indeed stored in the heap, but it is NOT automatically stored in the String pool, whereas when u write String a = 'hello', it is automatically stored in the String pool. This design choice is intentional. The String pool is meant to be a cache for string literals and explicitly interned strings, not for every string created through operations. If all operation results were automatically added to the String pool, it would quickly become bloated with many one-time-use strings, defeating its purpose as an optimization.");
        System.out.println(".equals check whetehr the content is ame or not, ==  checks whether both points to the same memory location or not");
        String a1 = "Vishal";
        String a2 = "Kumar";
        System.out.println("IF 1st string's char's ascii is higher than 2nd, it syas how mich its higher in postiive no,if 1st string char is lower than a2, it says how much its lower "+a1.compareTo(a2));

        System.out.println("");

        System.out.println("Regex \n . - any single char is True \n [abc] e.g [a-z1-7]- any char within the char in [] \n [abc][vz] - 1st char should be a/b/c, 2nd char should be v/z \n A|B - singlc ahr either A or B \n  XZ - Eactly char should match XZ \n Metacharacters: \n \\d -single digit (ACtualy its' single backslash and d, but it's a escape char., so we r wrtiing \\d \n \\D - no digit \\s - Space \\S - no space \n \\w - alphabet or digit \\W - No alphabet or digit \n Quantifiers: \n * - 0/more time \n + - one or more time \n ? - 0/1 time \n {X} - X times \n {X,Y} - between X adn Y times");
        String name = "Vishal Kumar. S";
        String reg_exp = "([A-Z][a-z]*\\s)*[A-Z][a-z]*\\.\\s?[A-Z]";
        System.out.println("Im writign a regex expression to ensure each word execpt the last word in the name, starts iwth a capital letter, rem charactere inthe word, can be 0/more lowercase characters, and after each word a space is there, and there can be any sich amount of words, and the final word shouldbe havin gthe first char as caps, rem as small, but no space after that, then a signle dot should be there, and a 0/1 spce can be there,a dn intial should be in capital. CHekc out the regex exp"+name.matches(reg_exp));
        String names[] = {"VIshal Kumar. S", "Vishal Kumar. S", "Vishal Kumar K. S", "Vishal Kumar S", "Vishal Kumar.S" };
        for (String x: names){
            System.out.println(x+" "+ x.matches(reg_exp));

        }

    }
}
