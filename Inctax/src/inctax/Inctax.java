package inctax;
import java.sql.*;
import java.util.*;
import java.text.*;

public class Inctax {
    public static void main(String[] args) {
        int tax=0;
    Scanner sc=new Scanner(System.in);
System.out.println("");
 DateFormat date = new SimpleDateFormat("dd/MM/yyyy\t\t\t\t\t\t\tHH:mm:ss");
      Calendar cal = Calendar.getInstance();
      System.out.println(date.format(cal.getTime()));
System.out.println(" \t\t---------------------------------------");
System.out.println("\t\t | WELCOME TO INCOME TAX CALCULATOR! |");
System.out.println(" \t\t---------------------------------------");
System.out.println(" * Title:-");
System.out.println("   ->Enter 1 for Mr. ");
System.out.println("   ->Enter 2 for Ms./Mrs. ");
System.out.print("Enter Here:- ");


int x=1;
do{
    int t=sc.nextInt();
if(t!=1 && t!=2){
    System.out.println("Invalid Input...Try Again!");
    System.out.print("Enter Here:- ");
}
else{
    x=2;
}}
while(x==1);
System.out.print("   ->Enter Your First Name: ");
String fn=sc.next();
System.out.print("   ->Enter Your Last Name: ");
String ln=sc.next();
       System.out.print("Enter your PAN Card No.:- ");
     String pan;
   int z=1; 
   do{ 
       
        pan = sc.next();
     if(pan.length()!=10){
     System.out.println("Invalid Input...Try Again!");
    System.out.print("Enter Here:- ");

}else{
z=2;
}}
  while(z==1);
       System.out.print("Enter Annual Salary:- ");
       int ic=sc.nextInt();
       System.out.print("Enter Income from other Sources:- ");
       int o=sc.nextInt();
       int i=ic+o;
       System.out.println("  * DEDUCTIONS:- ");
        System.out.print("(i)  G.P.F. (in Rs.) :- ");
int gpf=sc.nextInt();
System.out.print("(ii)  P.P.F.  (in Rs.) :- ");
int ppf=sc.nextInt();
System.out.print("(iii)  L.I.C.  (in Rs.) :- ");
int lic=sc.nextInt();
System.out.print("(iv)  Infrastructure Bonds  (in Rs.) :- ");
int ib=sc.nextInt();
System.out.print("(v)  Tuition Fee  (in Rs.) :- ");
int tf=sc.nextInt();
System.out.println("");
int ded=gpf+ppf+lic+ib+tf;
        
              
       
              if(i<250000){
System.out.println("-------------------------------------------------------------");
       System.out.println("Your Total Annual Income is Rs. "+i); 
System.out.println("-------------------------------------------------------------");
System.out.println("Your Total Deducted Amount is Rs. "+ded);        
 System.out.println("-------------------------------------------------------------");
    System.out.println("Payable Tax is NIL");
System.out.println("-------------------------------------------------------------");      
 }
       else if(i>=250000 && i<500000){
System.out.println("-------------------------------------------------------------");   
    System.out.println("Your Total Annual Income is Rs. "+i); 
System.out.println("-------------------------------------------------------------");
System.out.println("Your Total Deducted Amount is Rs. "+ded);      
System.out.println("-------------------------------------------------------------"); 
     int p=i-250000-ded;
          tax=p/10;
                     System.out.println("Your Net Payable Amount is Rs. "+tax);
System.out.println("-------------------------------------------------------------");
    }
       else if(i>=500000 && i<1000000){
System.out.println("-------------------------------------------------------------");      
System.out.println("Your Total Annual Income is Rs. "+i);
System.out.println("-------------------------------------------------------------");   
System.out.println("Your Total Deducted Amount is Rs. "+ded);    
System.out.println("-------------------------------------------------------------");
      int p=i-500000-ded;
           tax=p/5;
          
           System.out.println("Your Net Payable Amount is Rs. "+tax);
System.out.println("-------------------------------------------------------------");    
}else{
    System.out.println("-------------------------------------------------------------");  
  System.out.println("Your Total Annual Income is Rs. "+i); 
System.out.println("-------------------------------------------------------------");
System.out.println("Your Total Deducted Amount is Rs. "+ded); 
System.out.println("-------------------------------------------------------------");           
int p=i-1000000-ded;
           tax=(p*3)/10;
                     System.out.println("Your Net Payable Tax is Rs. "+tax);}
                           
                   
  
 System.out.println("-------------------------------------------------------------");
System.out.println(fn+" "+ln+" Thank You for using our Online Calculator!!!");
System.out.println("-------------------------------------------------------------");
System.out.println("Have A Nice Day!");
System.out.println("-------------------------------------------------------------");
System.out.println("For any Queries Contact: 1800 800 999");
System.out.println("-------------------------------------------------------------");
PreparedStatement stmt=null;
                String dbURL;
        dbURL = "jdbc:mysql://localhost:3306/google";
       String username="root";
       String password="google";
  
       try{
  Connection dbCon=DriverManager.getConnection(dbURL,username,password);
 stmt=dbCon.prepareStatement("insert into tax1 values(?,?,?) ");
 stmt.setString(1,fn);
 stmt.setString(2, pan);
 stmt.setInt(3,tax);
 int abc=stmt.executeUpdate();
           System.out.println(""+abc);        
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }                                       
    
    
    
    
    
    
}