import java.sql.*;
import java.util.ArrayList;




public class _23_jdbc {

    public static void displayCurrentBalance(ResultSet rs){
        try {
            while(rs.next()){
                System.out.println(rs.getInt(1)+"'s balance is "+rs.getDouble(2));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public static void displayTable(Statement st){
        try {
            ResultSet rs = st.executeQuery("Select * from students");

            while(rs.next()){
                System.out.println("Id is "+rs.getInt(1));
                System.out.println("Name is "+rs.getString(2));
                System.out.println("GPA  is "+rs.getFloat(3));
        
                System.out.println();
            } 
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void main(String[] args) {
        System.out.println("Java program can use files in hard disk, to store and retireve  small size data, using io streams, but here orgnaisin the data is done by the java porgram. For very large data, its difficult to organise the data to be stored in the file, in the java program itself, so that we use  Database porgram eg., Oracle, MySQl, SQLite, it manages organises the data, inteh form of tabels and connectison between tables, in the database in the hard  disk, and the java progaram interacts with the databse program, to retrieve ro tosre the data,a nd thsi interaction is caleld jdbc connectivity. The java program, writes the query statemnts, andd with teh help of connection class on teh java program,it is sent to the Driver. Driver is repsonsibel for connecitve java program to teh databse program, an convert java datatypes to comaptible database datatypes and vice versa, and  teh data bse program retrieves teh encessary data from the storage, and the result set is produced in the java program, there r 4 types of drivers\n1. Type 1: JDBC-ODBC Bridge\n Here, the jdbc driver part is written in java, and it converts the java data types into tehodbc neutral dattype. hen teh ODBC driver interacts with the seppfic database, and they interact with neural datatypes onlty. So, jdbc-odbc is aptailt written in java, i.e jdbc part, odbc part coudl be written in any languge, This odbc driver is create by mircosoft,to have  acommon driver,to interact with all the databse programs, isntead of ahving seperate drivers for each orace, mysql,sqlite, interactr with java driver. All the databse programs wil have their own odbc driver implementation adn they conver tteh databse dataypes into the neurtal odbc statndard datatypes, and ensure the connection. ODBC wil act as a common interface.\n Type-2: Native-API (partial)\n Here, the java driver,w ritne in java, interaats ith  the native api provied by the database progarm, i.e c/c++ , adn then the native apie.g oci in oracle, interacts with the databse program e.,g OCI. The oci part wil be in native c/c+.FIr sqllite,we use this.\nType03 Java net protocol driver \n It purely written in java, here the java side driver code, interacts with an in between server, and the database also interacts with the server. The online server enables the communcaitio between both jav program and  databse program, and tic ovnerts teh datatypes. \n Type 4: Thin Driver\n Its purely written in Java, here the java program uses the direct java driver code of the specific database program.\nJDBC drivers come in different types, with Type 1 (JDBC-ODBC Bridge) initially appearing attractive for its \"write once, connect anywhere\" approach. However, it has significant limitations including required ODBC installation on clients, performance issues from multiple translation layers, Microsoft's deprecation in Java 8, and dependency on native code. In contrast, Type 4 (Pure Java/Thin Driver) is now the industry standard because it's written entirely in Java (ensuring platform independence), requires no native libraries or client installations, communicates directly with databases, delivers superior performance by eliminating translation layers, and receives better maintenance from database vendors. While Type 1's universal solution concept seemed promising theoretically, practical considerations around performance and ODBC dependencies made it suboptimal. Type 4 drivers are specifically optimized for their respective databases, providing better performance and compatibility, which is why they're overwhelmingly preferred in modern Java applications.");

        System.out.println(".execute() will return teh resultset, we need to use enxt() to point to the first row adn then iterate. .executeUpdate() will return no of rows affected in teh database.When you get a ResultSet from a query, it initially points to a position before the first row. You must call next() to move the cursor to the first row before you can access any data. ");

        try {
            Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "user");

            Statement st = conn.createStatement();
            System.out.println("Inserting records using harcoding");

            System.out.println("We can also call stored procedures, with usin connection object itself,os taht we need not write same - execution statement repeatedly.Her,eim deleting all preivosu records,usin stored procedure. ");
            CallableStatement cs = conn.prepareCall("call deleteAllRecords()");

            cs.execute();
            
            String insertQuery = "insert into students values(2705,'VK',8.4)";
            st.executeUpdate(insertQuery);
            displayTable(st);

            System.out.println("BUt,we shoudl not harcode values, we should use variables");
            int newId = (int)(Math.random()*100);
            String newName = "Student"+newId;
            float newGPA = (float)(Math.random()*10);  
            insertQuery = "insert into students values"+'('+newId+ ",'"+newName+"',"+newGPA+')';
            st.executeUpdate(insertQuery);
            displayTable(st);
            
            System.out.println("But formteh query u can observe even for 3 values, how ahrd its to crete a query for it. So,we use prepared statements, where writing query becomes more simpler. W sue palceholder ?, and update it later, by sepciifying the index.");
            String query = "insert into students values(?,?,?)";
            PreparedStatement ps =  conn.prepareStatement(query);
            ps.setInt(1, newId+1);
            ps.setString(2, "Prepared"+newName);
            ps.setFloat(3, newGPA+1);

            ps.executeUpdate();
            displayTable(ps);

            System.out.println("Its not like to have ? as paramter, we must use preparedstatemetns only, we can also use ? in callablestatemnte, and set the IN and OUT vairbales of the stored proceudres. FOR setting teh OUT variabel iN the stored procedure,the syntax owuld be different from others.");

            CallableStatement cs2 = conn.prepareCall("call filterStudents(?,?)");
            cs2.setInt(1,2705);
            cs2.registerOutParameter(2, Types.VARCHAR);
            cs2.execute();
            System.out.println("Callabel statement\n Retrieving the output parameter.\n Name: "+cs2.getString(2));
        
            st.executeUpdate("update bankaccount set balance = 5000");
            System.out.println("Bank transaction:");
            String sender = "update bankaccount set balance = balance-5000 where id = 1 and balance>=5000";
            String receiver = "updat bankaccount set balance = balance+5000 where id = 2";
            try{
                st.executeUpdate(sender);
                st.executeUpdate(receiver);


                ResultSet displayBalance = st.executeQuery("select * from bankaccount");
                System.out.println("Bank Account current balance");
                displayCurrentBalance(displayBalance);


        }   

            catch(SQLSyntaxErrorException e){
                System.out.println("Server issue during amount credit in reciever account is imitated,by creating a dummy sql syntax issue");
                System.out.println("Due to server error, durign update of amount to receiver is failed, but sender got deducded. We can'tt rollback the sender's deduction transaction, as by default, transsactios we doing here are  auto-commit is set true in code. So,immediately when formse dner;s account, amount is deduceted,ig is repfeclted permanently in the database also.");
                System.out.println("To resolve this issue, we can do the following ways:\n1. Trun off auto-commit and after tyring to excute the steatemsn, check whether all the resultset's no fo rows affected are greater than 0, only then commit it, else, don't commit.");

                conn.setAutoCommit(false);
                int a = st.executeUpdate(sender);
                int b =  st.executeUpdate("update bankaccount set balance = balance+5000 where id = 2");

                if(a>0 && b>0){
                    System.out.println("Bank transactions succesfully completed.");
                    conn.commit();
                }
                else{
                    System.out.println("Bank transaction failed since account 1 has 0 balance, can;t deduct further. So, the no of rows affected with sender query is: "+a+"no of rows affected with reciever query is: "+b+"since not all query's rows are succesfuly updated, we are not going to commit  the trnasaction updates to the database. U can check teh databse,would not get update, sicne we truned off auto commit, the balance woudl remain the past amount only.");
                    ResultSet balance = st.executeQuery("select * from bankaccount");
                    System.out.println("Bank Account current balance, after sender fails to send, due to insuffient funds. ");
                    displayCurrentBalance(balance);
                }

                System.out.println("\n 2. Here, wewil use rollback, instad fo having pending transactions, whenever an transaction is not done successfulyl, we will rollback all preivous transactions, finally we will commit");


            }



            String update = "update bankaccount set balance = 5000";
            st.executeUpdate(update);
            conn.commit();
            ResultSet balance = st.executeQuery("select * from bankaccount");
            System.out.println("Bank Account current balance, resetted with amt of 5000 in both accounts and commited.");
            displayCurrentBalance(balance);
            ArrayList<Integer> noOfrowsUpdated =  new ArrayList<>();
            int countSenderRows = st.executeUpdate(sender);
            System.out.println("No fo rows affected by sender: "+countSenderRows);
            noOfrowsUpdated.add(countSenderRows);
            //the below is an random imitation to get the no of rows retuned by the resultset as 0, such that to show rollback, based on the count of no of rows chagnes reflected. The below statemtn in real-world sceanrio coudl be any  part of the business logic, which is wrong, so no fo rows affected is 0, so we rollback all the preivosu transactions made.
            int countReceiverRows = st.executeUpdate("update bankaccount set balance = balance+5000 where id = 2 and balance>5000");
            System.out.println("No fo rows affected by receiver: "+countReceiverRows);
            noOfrowsUpdated.add(countReceiverRows);

            balance = st.executeQuery("select * from bankaccount");
            System.out.println("Bank Account current balance, after deducing amt from sender, but undable to senfd it to reciever, due to some system issues");
            displayCurrentBalance(balance);            
            for(var x:noOfrowsUpdated){
                if (x==0){
                    System.out.println("Im rollbacking all the transactions, which are executed, but not commited yet, since the current transaction part, didnt work correctly as intended");
                    conn.rollback();
                }
            }
            conn.commit();
            balance = st.executeQuery("select * from bankaccount");
            System.out.println("Bank Account current balance, after rollbacking the deduction from sender transaction, after seeing we can't send the amt to the receiver successfully due to system issues. All uncommited changes will be rollbacked.");


            displayCurrentBalance(balance);

            conn.setAutoCommit(true);

            System.out.println("Students Table: ");
            displayTable(st);
            System.out.println("Batch Processing the queries: ");
            String query1 = "update students set gpa = gpa+1";
            String query2 = "update students set gpa = gpa-2";
            String query3 = "update students set gpa = gpa+3";
            
            st.addBatch(query1);
            st.addBatch(query2);
            st.addBatch(query3);
            st.executeBatch();
            System.out.println("After updation");
            displayTable(st);



        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }



    }
}