import java.util.Arrays;
import java.io.*;

class Student{
    int rollno;
    String name;
    double marks;

    public Student(int a, String b, double c){
        rollno = a;
        name = b;
        marks = c;
    }
}



class SerialisableClass implements Serializable{
    String userName;
    static String organisationName;
    transient String password = "Hello World";
    int userId;

    public SerialisableClass(){}

    public SerialisableClass(String a, String b, int c){
        userName = a;
        organisationName  = b;
        userId = c;
    }
}


public class _20_io_streams {
    public static void main(String[] args) {
        System.out.println("In Java, in memory, the method area ans the stack is siad to be teh context of the program. ALl others like heap, files, printer, monitor, network -all r resources. program and reosurces communcaite by transferring data between them. This flow of data is called as Stream. Data is flowed in either BYtes (1 byte) or as Character(2 bytes). For bytes, we use class BYteStreeam, in which input and output r handles by inputstream and outputstream. For character, we use Character Stream, where input and output are handled by Reader and Writer. To avoid the incompatiibitly of speed of data sharing b/w program and resoruces, we use buffer, which is a mermoy object, whihc temprorialy hodls the data. So, teh sender stores teh data it sendin the buffer, atits own pspeed, and the receider gets the inormaiton frmo the butffer,in its speed, ensuring compatibiltiy b/w both of them.InputStream, Output Stream, Reader, Writer all thse classes inherit from object class, and these class contains sub-classes for reading and writing data in bytes/char/byte array/skip char/mark char/use pipe for input/output, use sequence input/output etc.,");

        try (FileOutputStream f =  new FileOutputStream("C:\\Users\\HP\\Desktop\\demo.txt")) {

            System.out.println("Writing the string into file");
            String name = "Vishal Kumar. S";
        
            f.write(name.getBytes());

            System.out.println("Writing the string into file, by storing the bytes into array, and write each byte into the file");

            byte b[] = name.getBytes();
            for(byte i: b){
                f.write(i);
            }



            System.out.println("Writing the string into file, by offset fiirst 3 characters and writ till end of the string");

            f.write(b, 3, b.length-3);
            
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not dound is an checked error, so user must give catch statements, to handel when file is not found");
        }
        catch(IOException e){
            System.out.println("IO Excepiton occured.");
        }

        try (FileInputStream f1 = new FileInputStream("C:\\Users\\HP\\Desktop\\demo.txt")) {

            byte b[] = new byte[f1.available()];
            f1.read(b);
            

            System.out.println("Reading teh file adn storing it ina  byte array and reading byte by byte");
            for(byte i: b){
                System.out.print((char)i);
            }

            FileInputStream f2 = new FileInputStream("C:\\Users\\HP\\Desktop\\demo.txt");

            
            System.out.println("f.read() reads each byte, and when reacehd end of string, return -1 as next byte");
            System.out.println("Redaing file byte by byte:");
            int i;
            do{
                i = f2.read();
                if(i!=-1){
                    System.out.print((char)i);
                }

            }while(i!=-1);
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("File not found is an checked error, so user must give catch statements, to handel when file is not found");
        }
        catch(IOException e){
            System.out.println("IO Excepiton occured.");
        }

        System.out.println("file io streams are used to read/write form disk i.e permanetn stroage, where byte i/o streams are used to read/write from the byte array, i.e memory object only, not directly from permanent storage. It is useful when data is already in memory (e.g., from a string or byte array.");
        try {
            byte b[] = {'a','b','c','d','e','f','g'};
            System.out.println("Reading from a byte array, as a stream...");
            ByteArrayInputStream bis = new ByteArrayInputStream(b);
            bis.mark(0);
            byte read[] = bis.readAllBytes();
            System.out.println(Arrays.toString(read));
            String char_read = new String(read);
            System.out.println(char_read);

            System.out.println("Writing to a bytearray stream.. Preivsouyl, we used readAllBytes, do we reached end of arary, so we woudl not be able to read form the starting of bis,so we use mark adn reset a, to markt the 0th epsotion fo the array, adn then rest ti to read from there itself. Its possible in byte arrya,since  alle lemtns r inbytearray,we cancces sugin index, wheras in filestream,its not possibel, since ther we woudl use fiel pointer,it an onyl movein forward direction.");
            bis.reset();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int i;
            bos.write('V');
            bos.write('I');
            bos.write('S');
            bos.write('H');
            bos.write('A');
            bos.write('L');
            do{
                i = bis.read();
                if(i!=-1){
                    bos.write(i);   
                }

            }while(i!=-1);
            
            byte retrieve[] = bos.toByteArray();
            for(byte j: retrieve){
                System.out.print((char)j);
            }
        
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("Sequnce i/o stream is used to read/wrtei data from multiple sources in a sepcific sequential order");

        try{

        System.out.println("CharArrayReaader is simialr to bytearay streams, only the dataype is different. Here,it reads Character (2 bytes)");
        
        
        char data1[] = {'V','i','s','h','a','l'};
        CharArrayReader data1Stream = new CharArrayReader(data1);
        data1Stream.mark(100);
        data1Stream.read();
        data1Stream.read();
        data1Stream.read();
        data1Stream.mark(100);
        data1Stream.read();
        data1Stream.read();
        data1Stream.read();
        
        int i = 0;
        do{
            i = data1Stream.read();
            if(i!=-1){
                System.out.print((char)i);  
            }

        }while(i!=-1);

        String data2 = "Hi,Im learning IO Streams";
        ByteArrayInputStream data2Stream = new ByteArrayInputStream(data2.getBytes());
        data2Stream.mark(100);
        
        FileInputStream data3Stream = new FileInputStream("C://Users//HP//Desktop//demo.txt");

    
        SequenceInputStream sis = new SequenceInputStream(data3Stream, data2Stream);

        
        FileOutputStream combined_file = new FileOutputStream("C://Users//HP//Desktop//output.txt");


        combined_file.write(sis.readAllBytes());

        FileInputStream fis = new FileInputStream("C://Users//HP//Desktop//output.txt");
        byte output[] = fis.readAllBytes();
        System.out.println(new String(output));


        System.out.println("Let see use Bufferd i/o streams and readers:, these are useful to store the i/o stream or readers temporirality in mermoy in buffer, toe nsure compatibitly , no speed issues b/w sender adn receiver.");

        data1Stream.reset();
        data2Stream.reset();
        BufferedInputStream bfis = new BufferedInputStream(new FileInputStream("C://Users//HP//Desktop//demo.txt"));
        BufferedReader bfir = new BufferedReader(new InputStreamReader(bfis));

        System.out.println("Marking a posn is supported in fleinputstream? "+data3Stream.markSupported());
        System.out.println("Marking a posn is supported in bytearrayinputstream? "+data2Stream.markSupported());
        System.out.println("Marking a posn is supported in Bufferedinputstream? "+bfis.markSupported());
        System.out.println("Marking a posn is supported in Bufferedreader? "+bfir.markSupported());
        System.out.println("So, since it buffer supports mark operations, we can set a posn mark and we can rest and again print from the mark posn. Bufferinputstreama dn bufferreader behaves teh same, teh only diff., is byte vs char. Bufferreader is useful, when u have unicode character, since char can store 2 bytes. Bufferreader also has readLine() mehto,dwihihc bufferinputreader dosent have");
        System.out.println((char)bfis.read());
        System.out.println((char)bfis.read());
        System.out.println((char)bfis.read());
        System.out.println("marking at 4th posn 'h'");
        bfis.mark(100);
        do{
            i = bfis.read();
            if(i!=-1){
                System.out.print((char)i);  
            }

        }while(i!=-1);      
        System.out.println();
        System.out.println("Reading it again from marked posn");
        bfis.reset();
        do{
            i = bfis.read();
            if(i!=-1){
                System.out.print((char)i);  
            }

        }while(i!=-1);   
        System.out.println();
        System.out.println("Athough i exhausted compeltely from the CharReader, but i marked at posn 4, oi alsoreserttted, after exhasuted the reader stream, so when useong the reader stream in the BufferReader can from the 4th char itself, using readLine(), ill read from 4th char till complete read all line \n rem content: "+bfir.readLine());

        System.out.println("there are 2 types of file access in java- \n1. Sequential Access -  Here, we canonly either read or write a file. \n2. RandomAccess - randomaccess allows to perform both read and write with teh saem file pointer, and also we can randomly access any position, from starting of the file. Here, read/write automatically moves the pointer to the next posn.");

        RandomAccessFile raf  =  new RandomAccessFile("C:\\Users\\HP\\Desktop\\demo.txt","rw");
        System.out.println((char)raf.read());
        System.out.println("Moving posn., to 2");
        raf.seek(2);
        System.out.println((char)raf.read());
        System.out.println("Re-writing on posn., 3");
        raf.write('j');
        System.out.println(raf.readLine());
        System.out.println("only the rem char from the next char of overriden posn is seen, to see the modfied  character,s also we ened to rewind the pointer.");
        raf.seek(0);
        System.out.println(raf.readLine());
        System.out.println("posn., is moved to end, rewind again");
        raf.seek(0);
        raf.skipBytes(5);
        System.out.println("skipped 5 characters");
        System.out.println(raf.readLine());
        raf.seek(0);
        System.out.println("File pointe posn "+raf.getFilePointer());
        raf.seek(raf.getFilePointer()+2);
        System.out.println("File pointe posn+2 posn.,"+(char)raf.read());
    
        System.out.println("File class is used to represent file or directory metadata (like its path, name, size, permissions) — it doesn't read/write file content. We can modify the persmisisons liek read/write only, list all the fiels in it, much more");
        File f = new File("C://Users//HP//Documents//Core_Java_Notes//javadoc");
        File list[] = f.listFiles();

        for(File j: list){
            System.out.println(j);
        }
        
        f.setReadOnly();
        System.out.println("I have set the javadoc directory, to read only, if i try to write anything in it ,it will cause error");

        try (FileOutputStream write = new FileOutputStream("C://Users//HP//Documents//Core_Java_Notes//javadoc//index.html");) {
            
        } catch (Exception e) {
            System.out.println("It causes issue, since i set this file's directory as only read only, so i cannot write in it");
            System.out.println();
        }

        System.out.println("Serialisation is the process of storing the objects, as it is in its own datatype in the file. PRoblem is , when we use FileOutputStream, we can only write the data into the file in byte array form. When we use FileWriter, we can write the data only in char array or string type. If we use PrintStream, we can store the data in the file, as String and it accepts any primitive datatype (int, float, boolean, char, String, etc.), tehn to retrive teh attributes from the file, we need to use BufferReader, as it only ahs readLine() method, so create a reader of teh fileinputstream, as input to the BufferReader, and then retirve each line, and convert the datatypes using parseInt, parseFloat, to convert from String to the roginal datatypes. To store the data in teh same datatype itself, instead of string, in the file use DataOutputStream. While retireivn the data from the datainputstream, we ened to retiever correctly in teh smae order od dataypes, we write in dataoutputstream. Serialisation and deserialisation refers to storing and retrieving the state of the object, We can directly serialise the object, instead of each of its attributes/elements like preiovusly we did, by using ObjectOutput and ObjectInputStream. To serialise an object, \n1. The object's class must implement Serialisable.\n2. To read the object from the file using ObjectInputStream, the class must have non-parameterised constructor, if u have parameterised constructor in the class, it would override the default non-parameterised constructor, so we would not able to retrieve/de serailsie the object from the memory, so either have no constructor, or else if u have prametrised consturctor, also ahve non-paramerised one.\n3. Static and transient members of a class cannot be  serailseid since static members belong to the class, not to any individual object. Serialization only deals with object state, not class state.You mark a field transient when you do not want it to be part of the serialized object. So, it is also not covered. When u do not want any member to not inlcude in the serialsiaiton, use static or transient. When u retierve the object from teh file, usign ObjectINputStream,it is mandatory to typecaset teh object to the serialised class name.");

        Student s = new Student(122,"Vishal",95.34d);
 
        try (FileOutputStream f1 = new FileOutputStream("C://Users//HP//Desktop//demo.txt"); PrintStream ps = new PrintStream(f1)) {
            ps.println(s.marks);
            ps.println(s.name);
            ps.println(s.rollno);
        
            FileInputStream f2 = new FileInputStream("C://Users//HP//Desktop//demo.txt");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(f2));
            
            double marks = Double.parseDouble(bfr.readLine());
            String name = (bfr.readLine());
            int rollno = Integer.parseInt(bfr.readLine());

            System.out.println("Retrieving all the object's attributes from the file, after input using PrintStream.");
            System.out.println("Marks is: "+marks+"\nName is: "+name+"\nRoll No: "+rollno);
            
            DataOutputStream dos =  new DataOutputStream(f1);
            dos.writeDouble(marks);
            dos.writeUTF(name);
            dos.writeInt(rollno);
            
            DataInputStream dis = new DataInputStream(f2);
            double marks1 = dis.readDouble();
            String name1 = dis.readUTF();
            int rollno1 = dis.readInt();
            
            System.out.println("Retrieving all the object's attributes from the file, using DataInputStream, without type conversion of datatype. The order should not be changed, during retrieving from the file.");
            System.out.println("Marks is: "+marks1+"\nName is: "+name1+"\nRoll No: "+rollno1);

            SerialisableClass sc =  new SerialisableClass("Vishal Kumar. S","FaceBook",12345);
            ObjectOutputStream oos = new ObjectOutputStream(f1);
            oos.writeObject(sc);

            ObjectInputStream ois = new ObjectInputStream(f2);

            SerialisableClass.organisationName = "Instagram";

            SerialisableClass retrievedObject = (SerialisableClass)ois.readObject();
            
            System.out.println("Serialised class's object;s retrived values:\n"+"Static member Organisation: "+retrievedObject.organisationName+"\n2. Transient member Password: "+retrievedObject.password+"\n3. normal mamber user_id: "+retrievedObject.userId);
            

        } catch (Exception e) {
            // TODO: handle exception
        }
        






        System.out.println("Piped i/o streams are used, where the producer prodeuc contetn adn writes it in ouptut pipe, and consuemr consumes conetne from input pipe, whrere weill conenct th einput and ouptut pipe in th mian function, so the producer can continosuly produece data adns end to th eoutput pipe and iot passed via input pipe to the consuemr to consuem data.BufferedInput/OutputStream r useful for efficient file or data reading/writing, whereas PipedInput/OutputStream is useful in Thread-to-thread communication. IN  buffered/o stream, a larger internal buffer is used e.g 8KB wheras in piepd i/o stream, a shared circular buffer(limited size) is used and pipied i/o is meant for simulataneous threads, access, whereas buffered i/o does not. the problems of buffer full and buffer empty are automatically handled by pipes, whereas not in buffer,so buffers r used  for efficient file handling.");
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);
        Producer p =  new Producer(pos);
        Consumer c =  new Consumer(pis);


        p.start();
        c.start();

        }


        catch(IOException e){

        }


    }            
        }



class Producer extends Thread{
    PipedOutputStream o_p_pipe;
    public Producer(PipedOutputStream o){
        o_p_pipe = o;
    }

    public void run(){
        int i = 0;
        try{
        while(i<30){
            o_p_pipe.write(i);
            System.out.println("Producinng content: "+i);
            Thread.sleep(100);
            i++;
        }
    }
    catch(Exception e){

    }
    }
}


class Consumer extends Thread{
    PipedInputStream i_p_pipe;

    public Consumer(PipedInputStream i){
        i_p_pipe = i;
    }

    public void run(){
        try{
        while(true){
            int data = i_p_pipe.read();
            System.out.println("Consuming content: "+data);
            Thread.sleep(100);

        }
        }

        catch(Exception e){
        
        }
    }


}