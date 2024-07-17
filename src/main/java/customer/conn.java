/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class conn {
    public static Connection connectdb(){
        Connection con=null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db_url="jdbc:mysql://localhost:3306/toy_shop";
            String username="root";
            String pwd="";
            con=DriverManager.getConnection(db_url,username,pwd);
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Can not connect to DB");
        }
        
        finally{
            return con;
        }
    }
    
    
    
}
