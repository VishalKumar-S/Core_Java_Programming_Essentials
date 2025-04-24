import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.Map.Entry; 
import java.util.Arrays;


class Bank extends SerialisableClass{
    int accNo;
    String pwd;
    double balance;

    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }
    public String getPwd() {
        return pwd;
    }
    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}


class CustomComparatorPriorityQueue implements Comparator<Integer>{

    public int compare(Integer a, Integer b){
        if (a<b){
            return 1;
        }

        else if(a>b){
            return -1;
        }        

        return 0;

    }
}


class CustomComparatorTreeSet implements Comparator<PlacementCategorisation>{
    public int compare(PlacementCategorisation firstPerson, PlacementCategorisation secondPerson){
        if(firstPerson.cgpa < secondPerson.cgpa){
            return 1;
        }
   
        else if(firstPerson.cgpa > secondPerson.cgpa){
            return -1;
        }   

        else{
            if(firstPerson.lcRatings < secondPerson.lcRatings){
                return 1;
            }
            else if(firstPerson.lcRatings > secondPerson.lcRatings){
                return -1;
            }        
                
            else{
                return 0;
            }

    
        }


    }

}


class PlacementCategorisation implements Comparable<PlacementCategorisation>{
    String name;
    int lcRatings;
    float cgpa;

    public PlacementCategorisation(String name,int a, float b){
        this.name = name;
        lcRatings = a;
        cgpa = b;
    }

    public int compareTo(PlacementCategorisation secondPerson){
        if(this.lcRatings < secondPerson.lcRatings){
            return 1;
        }
        if(this.lcRatings > secondPerson.lcRatings){
            return -1;
        }        

        else{
            if(this.cgpa < secondPerson.cgpa){
                return 1;
            }
            else if(this.cgpa > secondPerson.cgpa){
                return -1;
            }   
            
            else{
                return 0;
            }

    
        }


    }


    public String toString(){
        return "Student{name='" + name + "', lcRating=" + lcRatings + ", cgpa=" + cgpa + "}";

    }

    

}



class OrderByInsertionLinkedHashMap<K, V> extends LinkedHashMap<K,V>{


    public OrderByInsertionLinkedHashMap(int initialCapacity, float loadFactor){
        super(initialCapacity,loadFactor);
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> e) {
        return  size() >6;
    }


}




public class _22_collections {
    public static void main(String[] args) {
        System.out.println("COllections = Data Structures, gorup of data. All collections r present inside java.util package. Collection support any type of object, so they r called Generic.\n collection interface implements Iterable interface. Colelction interface contains common attirbutes all Data structure requires like add, addall, remove, remoceALl, contains, containsAll, equals, seize, iterator, toArray. Interfaces List, Set, Queue, Map implements from Collections and also have theri addn., methods based on their demand e.,g List-need ordering and indexing, Set-needs no duplicates. \n Interface List contains the classes - arraylsit, linekdlist, stack, vector, which implements the List interface.\n Queue interface is implemented by Piroity Queue class, Deque interface, where ArrayDeque class implemtns it.\nSet interface is implmented by hashSet, LinekHashset classes, SortedSet interface, which is implemented by TreeSet class\n Map interface is implemented  by hashmap, linkedhashmap, hashtable classes, sortedMap interface, which is implmented by TreeMap class. A synchronized collection is thread-safe — meaning multiple threads can access it without corrupting the data. But synchronization comes at a performance cost ⛔ (slower). So, Java keeps most collections unsynchronized by default — for better speed. If you need thread safety, you opt-in. Synchronised class e.,f are Vector, Stack, HashTable, Proeprties -  which are legacy classes, and Collections.synchronizedXxx()\t - it Makes any List, Set, Map thread-safe. Most Modern classes r Non-synchronized (Not Thread-safe) e.g list,map,set realted alll classes. Since, 90% of the time, collections are used in single-threaded environments. Synchronization adds performance overhead. Java provides options to make them thread-safe if needed, instead of enforcing it always.");


        ArrayList <Integer> al1 = new ArrayList<>();
        ArrayList <Integer> al2 = new ArrayList<>(List.of(50,60,70,80,90,100));

        al1.addAll(al2);
        
        System.out.println("Using Iterator for iteration, her no extra updation is needed in the loop");
        for(Iterator<Integer> i = al1.iterator(); i.hasNext();){
            System.out.println(i.next());
        }
        
        System.out.println("Using for-each loop");
        for(Integer x: al1){
            System.out.print(x+ " ");
        }

        System.out.println("Using for-each loop with var keyword, no need to sue the class name");
        for(var x: al1){
            System.out.print(x+ " ");
        }

        System.out.println("Using lambda expressions");
        al1.forEach((n)->{System.out.println(n);});

        System.out.println("Using method reference pointer");
        al1.forEach(System.out::println);

        System.out.println("LinkedList: By default, linkedlist is doubly linkedlist in Java.");
        LinkedList <Integer> ll1 = new LinkedList<>();
        LinkedList <Integer> ll2 = new LinkedList<>(List.of(1,2,3,4,5));

        ll1.addAll(ll2);
        
        System.out.println("Using Iterator for iteration, her no extra updation is needed in the loop");
        for(Iterator<Integer> i = ll1.iterator(); i.hasNext();){
            System.out.print(i.next()+" ");
        }
        System.out.println();

        System.out.println("Using List iterator for iteration, unlike iterator, list iterator can iterate in both of the directions(forward and backward).");
        for(ListIterator<Integer> i = ll1.listIterator(ll1.size()); i.hasPrevious();){
            System.out.print(i.previous()+" ");
        }

        System.out.println();
        
        
        System.out.println("Using for-each loop");
        for(Integer x: ll1){
            System.out.print(x+ " ");
        }
        
        System.out.println();

        System.out.println("Using for-each loop with var keyword, no need to sue the class name");
        for(var x: ll1){
            System.out.print(x+ " ");
        }

        System.out.println();

        System.out.println("Using lambda expressions");
        al1.forEach(n->System.out.println(n));

        System.out.println("Using method reference pointer");
        al1.forEach(System.out::println);


        System.out.println("Instead of implementing deque usign linkedlist, use Arrayqueue, whihc is much faster, Use ArrayQueue itself for stack,queue operations.");

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.offerFirst(1);
        ad.offerFirst(2);
        ad.offerFirst(3);

        ad.offerLast(4);
        ad.offerLast(5);
        ad.offerLast(6);

        ad.pollFirst();
        ad.pollLast();

        ad.forEach((i)->System.out.println(i));

        System.out.println("Priority Queue: By default, it's min heap.");

        PriorityQueue <Integer> minHeap = new PriorityQueue<>();
        minHeap.add(465);
        minHeap.add(81);
        minHeap.add(1);
        minHeap.add(5);

        System.out.println("THe elemnrs are :");
        minHeap.forEach(System.out::println);
        System.out.println("the first element is "+ minHeap.peek());
        minHeap.poll();        

        System.out.println("THe elemnrs are :");
        minHeap.forEach(System.out::println);
        System.out.println("the first element is "+ minHeap.peek());

        System.out.println("Priority Queue: Max Heap");

        PriorityQueue <Integer> maxHeap = new PriorityQueue<>(new CustomComparatorPriorityQueue());
        maxHeap.add(465);
        maxHeap.add(81);
        maxHeap.add(1);
        maxHeap.add(5);

        System.out.println("THe elemnrs are :");
        maxHeap.forEach(System.out::println);
        System.out.println("the first element is "+ maxHeap.peek());
        maxHeap.poll();        

        System.out.println("THe elemnrs are :");
        maxHeap.forEach(System.out::println);
        System.out.println("the first element is "+ maxHeap.peek());

        System.out.println("Hashing: \n Here we sue a hash function to place the key in the bucket(consider like it as the index).THe intial size of hash is 16. There r 2 typeso h Hashign \n 1. Open Addressing:\n Here, the key is placed on the bucket based on the hash fuinction e.,g hash fucntion = key%10, kif keys to be placed are 15,45,55,9 , then 15%10 = 5, then at bucket 5, 15 is placed. Then for 45, it also 45%10 = 5, but bucket 5 is already filled, so we cehcke tell the next bucket after  5 is free/not, wehnw e get the free bucket, we will fill 45 in it. FOr 55 also the smae will be follwod. Whenever we need to retievie a key, we will go to the hash function marked bucket, then if that key is not the bucket contianinb gvalu, we will iterate nad see next untila n empty space is found. If an expty dpace is found,then that ket is not present in the hash tbale. THe reason is for e.g, 15 at bucket 5, so 44 at bucket 6, then 55 at bucket 7, 9 in bucket 9 for e.g, if we search for key 75,then go to 75%10 = 5,then 6,then 7, then 8, bucket 8 is empty, so the key si not preset. SOw,ith this empty buckets, we can stop iteraing to ind the key soon. If we didnt have empty spoace,then ther might eb scenariso,where we need t iterate till the end of the hash table to find the key is presetn or not. SO, the time will not be constant. So, its importnat to have gooad amut fo empty spaces in th ahs tabl. its called as Loading factor(amt of keys to be filled). its reocmmedne to have a laoding factor of 75% in the hash tabel i.e 75% keys, and 25% empty buckets. So,we cane asily figute out key si persent or not. WHenever teh bucket is full, new bucket of mpre size is created, wherver bucket size is increased, the has fucntion needs to be changed, since the hash funciton si changed, the old palced kesy on buckets are wrong, so we need to re-hash the keys,to palce them proeprly it he enw sizehash table .\n 2. Chaining: \n Here neitehr the hash table size or hash function or re-hashing happens. here, teh key is not stored in the bucket itself, hash value is computed for the key, and the key si soreod a sa linkelist node, whose next is null, and this node is poitne db y taht hash valeu bucket. Hevner collsion happens, for eg. 15,55 for has fucntion key%10, then for 55, after it knows bukcet 5, is potingn to node 15, it wont move on to bukcet 6, instead a new node of 55 is created, adn it is pointed next of node 15. Simialry, all teh collsiion hash valu nodea sre palcesd as a lineklsit structure. SO, whenever we need to retiive a key, we will iterate the linekdksit pointing to the bucket, and if no node valeu matches the key,trhenthe key is not present.");

        HashSet<Integer> hs = new HashSet<>(10,75);
        hs.add(6);
        hs.add(8);
        hs.add(7);
        hs.add(8);
        System.out.println("Only unique elements r presnt in the hashset"+hs);

        System.out.println("TreeSet is used to insert/delete elemnts in O(logn) T.C. It stores only unqiue elments, that too in sorted manner, since it implents fro SortedSet interface");
        TreeSet<Float> ts = new TreeSet<>(List.of(10f,89f,50f,1f,1f,3f,34131f,5f,34131f));

        System.out.println("treeSet contains onyl unqieu elements, that too sorted.");
        System.out.println(ts);

        System.out.println("Comparable interface is used, when we want objects of our class to have a default way to be compared. It's used to define the 'natural ordering' of a class. e.g compare 2 objects of our custom class Whereas Comparator is a separate class that defines custom ordering. It is used when you want alternative ways to compare objects or when you can't modify the original class e.g used in Priority quue, tpo mae it implemnt max heap. Comparable uses compareTo(T obj) method\n Comparator uses compare(T obj1, T obj2) method\n We return  -1, if an curnet object shoudl coem before the second object, return +1,if the current object shoudl come after the second obejct, return 0,if both are same.");


        PlacementCategorisation student1 = new PlacementCategorisation("A", 1547, 8.48f);

        PlacementCategorisation student2 = new PlacementCategorisation("B", 1845, 8.59f);

        PlacementCategorisation student3 = new PlacementCategorisation("C", 1547, 9f);

        TreeSet<PlacementCategorisation> categorisation = new TreeSet<>();

        categorisation.add(student1);
        categorisation.add(student2);
        categorisation.add(student3);

        System.out.println("Inserting the objects of our class in the TreeSet data structure, sorting the objects on our class, based on implementing comparable interface and overrdiing compareTo method to set our own default comapring method of our class.We did it  to have a standard way of comparing our class objects.");

        System.out.println("Students sorted by LC ratings (descending) and CGPA (descending):, done by overridng the toString method");
        for(var i: categorisation){
            System.out.println(i);

        }

        System.out.println("The collection classes don't specifically look for the compare() method of Comparator. Rather: When you don't provide a Comparator, collections will try to use the object's natural ordering by calling compareTo() (which requires the class to implement Comparable) When you do provide a Comparator, collections will use that Comparator's compare() method instead");

        System.out.println("If you want multiple ways to compare or want to modify ordering without changing the class: Use Comparator. here,we will also use a custom comparator, which will be used, instead of the compraeTO() of our class");
        System.out.println("Our custom comparator's soritng based on cgpa, is exeucted ehre, instead of teh default class' compareTo() leetcode rating based sorting.");




        PlacementCategorisation student4 = new PlacementCategorisation("A", 1547, 8.48f);

        PlacementCategorisation student5 = new PlacementCategorisation("B", 1845, 8.48f);

        PlacementCategorisation student6 = new PlacementCategorisation("C", 1547, 9f);

        TreeSet<PlacementCategorisation> categorisation2 = new TreeSet<>(new CustomComparatorTreeSet());
        categorisation2.add(student4);
        categorisation2.add(student5);
        categorisation2.add(student6);

        System.out.println("Students sorted by CGPA (descending) and LC Ratings (descending):, done by overridng the toString method");
        for(var i: categorisation2){
            System.out.println(i);            
        }

        TreeMap<Integer, String> tm = new TreeMap<>(Map.of(10,"vsvavava",1,"A",2,"F",3,"A",4,"G"));

        System.out.println("TreeMap: TreeMap, uses a Red-Black Tree, which is a balanced binary search tree. The keys are stored in sorted order, and the tree re-balances itself as elements are added or removed. No load factor is needed because it doesn’t use buckets or deal with hash collisions.");
        System.out.println(tm);
        tm.put(5, "C");
        tm.put(8, "L");
        System.out.println(tm);

        System.out.println("Using Ceiling entry, to get the next closest key and value,if we didnt find a key 7\n key: "+tm.ceilingEntry(7).getKey()+ "\n Value: "+tm.ceilingEntry(7).getValue());

        System.out.println("Using Floor entry, to get the previous closest key and value,if we didnt find a key 7\n key: "+tm.floorEntry(7).getKey()+ "\n Value: "+tm.floorEntry(7).getValue());
        Entry <Integer, String> e = tm.firstEntry();
        System.out.println("Using Entry to get the first key and value of the treemap\n Key: "+ e.getKey() + "\n Value: "+e.getValue());



        System.out.println("Linked Hash Map: Linked Hash Map, unlike plain HashMaps, Each bucket has it's value and prev and next value pointing entries. So, it acts like a linekdlist, each entry of value in the hash table know its prev and next value being inserted. So, the order of insertion of values is known in the hashtable, via this linkedlist like structure. By default, loading factor is set as 75%. We can limit the no of values to be kept within the hash table. In linkedhashmap, we can either order the elements, by the order of insertion of the elemnts, or based on teh order of access(It sortes teh least frequently used elemtns at top, and most recently used at bottom). This order by access, makes it behave liek cache memoery. If we limit the no of elemnets in the hashtable, then if we try to add a new element ot the linkedhastable, if its based on default order by insertion, then the first inserted elment wodul be remoed adn new element would be added. If we set the linkedhashmap order by access, then the least frequently used element would be removed, and the new elemnt would be added, used to have bhavior like cache memory. To set limit to the number of elmenets to be rpestn in the hash tbale, we need to create a class extendning LinedkHashMap class, and override the method of removeEldestEntry().");




        OrderByInsertionLinkedHashMap<Integer, String> lhm = new OrderByInsertionLinkedHashMap<Integer, String>(5,0.75f);
        lhm.put(1,"V");
        lhm.put(2,"i"); 
        lhm.put(3,"s");
        lhm.put(4,"h");
        lhm.put(5,"a");
        lhm.put(6,"l");

        System.out.println("Order by insertion, w have inial capacity st to 5,whenw e add enw elmens, teh size of hte hash table would increase"+ lhm);

        System.out.println("By default, we have order by insertion, as we set maxmimum limit to be 6 elements, let us create a new element,it will replace the oldest inserted element.");
        lhm.put(7," ");
        System.out.println("New Linek hash map: \n"+lhm);
        

        System.out.println("linked Hash Map with order by access:");

        LinkedHashMap<Integer, String> lhm1 = new LinkedHashMap<>(5,0.75f,true){
            protected boolean removeEldestEntry(Map.Entry<Integer, String> e) {
                return  size() >6;
        }
        };
        lhm1.put(1,"V");
        lhm1.put(2,"i");
        lhm1.put(3,"s");
        lhm1.put(4,"h");
        lhm1.put(5,"a");
        lhm1.put(6,"l");

        lhm1.get(4);
        lhm1.get(2);
        lhm1.get(6);

        
        System.out.println("Order by access, i set the intial capacity as 5, laoding factor as 75% and set order by access = True. Now, the linkedhasmap would be sorted, based on the most frequently used at the bottom and the least used are at the top\n"+ lhm1);

        lhm1.put(7, " ");
        lhm1.put(8, "k");
        lhm1.put(9, "u");
        lhm1.put(10, "m");

        System.out.println("We override the removeEldestEntry() method of the HashedLinkedlist to set the limit fo elments in the hash tbale to only 6. To voerride the removeEldestEntry() method, we need to use the class, that extends from the HashedLinkedlist class. So, here we used, anonymous class, to oerride the method, and since we set order by access as True, least freuently used are replaced, when no of elements exceeds greater than 6.\n"+lhm1);

        HashSet<String> hs1 = new HashSet<>();
        hs1.add("v");
        hs1.add("i");
        hs1.add("s");
        hs1.add("h");
        hs1.add("a");
        hs1.add("l");

        System.out.println("The order of elements in Hashset, depends on the hash codes of the elements — and how they’re distributed in the internal table.Hashset: \n"+hs1+"\n  whereas in LinkedHashSet, the elements are sorted, based on the insertion order.SO, if u need to iterate the keys in the insertion order itself, use LinkedHashSet");
    
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("v");
        lhs.add("i");
        lhs.add("s");
        lhs.add("h");
        lhs.add("a");
        lhs.add("l");

        
        System.out.println("Order of elements in LinkedHashSet based on the insertion order:\n"+lhs);


        System.out.println("Properties class is useful, for applications, where we need to store the proeprties of the applications e.,g settings as text or xml file. Proeprties contaisn objects as key-valeu pairs, and the key and value both should be only strings.");

        Properties printer = new Properties();

        printer.setProperty("Printer Name","HP LaserJet Pro MFP M479fdw");
        printer.setProperty("Model Number","W1A80A");
        printer.setProperty("Print Speed","Up to 28 pages per minute (black and color)");


        try {
            printer.store(new FileOutputStream("C:/Users/HP/Desktop/PrinterProperties.txt"), "Printer Properties");

        } catch (Exception eh) {
            System.out.println("No speciifed file name");
        }

        try  {
            printer.load(new FileInputStream("C:/Users/HP/Desktop/PrinterProperties.txt"));
            System.out.println("Printing the printer settings properties from the text file:\n"+printer);

        } catch (Exception eebrb) {
        }


        System.out.println("Storing the properties as a xml file");
        try {
            printer.storeToXML(new FileOutputStream("C:/Users/HP/Desktop/PrinterProperties.xml"), "Printer Properties");

        } catch (Exception eh) {
            System.out.println("No speciifed file name");
        }

        try  {
            printer.loadFromXML(new FileInputStream("C:/Users/HP/Desktop/PrinterProperties.xml"));
            System.out.println("Printing the printer settings properties from the xml file:\n"+printer);

            System.out.println("We can aslo acess specific property from the proeprty object:");
            System.out.println("Model Number: "+printer.getProperty("Model Number"));
            System.out.println("Printer Name: "+printer.getProperty("Printer Name"));
            System.out.println("Print Speed: "+printer.getProperty("Print Speed"));

        } catch (Exception eebrb) {
        }



        String text = "i'm=learning;Java=Programming";
        try {
            FileOutputStream fos = new FileOutputStream("C://Users//HP//Desktop//StringTokeniser.txt");
            byte b[] = text.getBytes();
            fos.write(b);

            FileInputStream fis =  new FileInputStream("C://Users//HP//Desktop//StringTokeniser.txt");
            int s = fis.read();
            while(s!=-1){
                System.out.print((char)s);
                s = fis.read();
            }
            System.out.println();


            System.out.println("String Tokeniser is used to extract the string with the delimiters sepcified. here, any delimiter with symbol =,; would be removed.");

            StringTokenizer st = new StringTokenizer(text,"=;");
            
            while(st.hasMoreTokens()) {
                System.out.println(st.nextToken());
            }
        } catch (Exception esvs) {
            // TODO: handle exception
        }

        System.out.println("A BitSet is a data structure that stores bits (0s and 1s) efficiently — like a dynamic array of bits, it;s  more memory-efficient than boolean[], since bitset uses only 1 bit per flag, whereas boolean uses 1 byte per flag. Usecases of bitset would be Tracking visited users, active features, or flags over billions of records, bloom filters,  Sieve of Eratosthenes (Prime Number Generation). SO, bitset can be used to perform logical oepraison liek and,or,andnot, flip etc.,");
        BitSet bs =  new BitSet();
        bs.set(0);
        bs.set(2);
        bs.set(4);
        bs.set(6);
        bs.set(8);



        BitSet bs1 =  new BitSet();
        bs1.set(1);
        bs1.set(3);
        bs1.set(5);
        bs1.set(7);
        bs1.set(9);

        bs.or(bs1);
        System.out.println("After OR operation"+bs);
        bs.and(bs1);
        System.out.println("After AND operation"+bs);
        bs.flip(0,bs.length());
        System.out.println("After flip operation from 0 to length indices"+bs);


        Integer c[] = {97,646,41,13,6826,1,2,3,4,5};
        Arrays.sort(c);
        System.out.println("Sorting array based on default comparable comapre implemnetaion of the INteger class\n"+Arrays.toString(c));

        Arrays.sort(c,new CustomComparatorPriorityQueue());
        System.out.println("Sorting based on custom Comparator\n"+Arrays.toString(c));

    
        System.out.println("Bank Application to store all the accountNo as Kye, Account object as value, in hashMap, delete account, view account, view alla ccount, save account, store all the account objects in a file usign serailsiaiton, and retireve all the objecrs from teh file adn store it back to teh hashmap,when u restart the code");


        try  {

            HashMap <Integer, Bank> accounts = new HashMap<>();

            Bank user1 =  new Bank();
            user1.setAccNo(12345);
            user1.setBalance(500);
            user1.setPwd("Vishal");

            Bank user2 =  new Bank();
            user2.setAccNo(67891);
            user2.setBalance(700);
            user2.setPwd("Kumar");


            accounts.put(user1.getAccNo(),user1);
            accounts.put(user2.getAccNo(),user2);

            
            ObjectOutputStream writeObjects = new ObjectOutputStream(new FileOutputStream("C:/Users/HP/Desktop/BankApplication.txt"));

            System.out.println("In Java, a HashMap stores key-value pairs, but when you want to iterate over both keys and values together, you need a view of the map in the form of entries. Each entry is a Map.Entry<K, V> object — which holds key and value. map.entrySet()  returns a set of all key-value pairs in the map, each as a Map.Entry.");
            for(Map.Entry<Integer, Bank> loop: accounts.entrySet()){
                writeObjects.writeObject(loop.getValue());
            }

            FileInputStream fis = new FileInputStream("C:/Users/HP/Desktop/BankApplication.txt");
            ObjectInputStream ois =  new ObjectInputStream(fis);

            System.out.println("Retrieving account objects from file, and displaying the details, and store them back into hashmap");

    
            HashMap <Integer, Bank> retrievedHashMap = new HashMap<>();

            Object obj = ois.readObject();
            while (obj!= null) {
                Bank account = (Bank)obj;
                int accNo = account.getAccNo();

                retrievedHashMap.put(accNo, account);
                System.out.println("Account details:\n"+account.getAccNo()+"\n"+account.getBalance()+"\n"+account.getPwd());

                obj = ois.readObject();


            }

        } catch (Exception vsbsdbdbd) {
            // TODO: handle exception
        }
        






}
 
    
}




