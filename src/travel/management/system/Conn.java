
package travel.management.system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
           //1//
           Class.forName("com.mysql.cj.jdbc.Driver");
           //2//
           c=DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","MYSQL");
           //3//
           s=c.createStatement();
           
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
