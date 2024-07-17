/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class customercontrol {
    
    customerviwe custv;
   
    public customercontrol(){
        custv =new customerviwe();
        custv.setVisible(true);
        
        custv.getBtncus().addActionListener((e)->{
            Connection con=conn.connectdb();
            
            String name=custv.getcusname().getText();
            int tp=Integer.parseInt(custv.getcustp().getText());
            String email=custv.getcusemail().getText();
            String add=custv.getcusadd().getText();
               
            try {
                
            String query="insert into customers(Customer_Name,Customer_phoneNo,Customer_Email,Customer_Address)"+
                    "values('"+name+"',"+tp+",'"+email+"','"+add+"')";
            Statement stmt=con.createStatement();
                stmt.executeUpdate(query);
                
               custv.getcusname().setText("");
               custv.getcustp().setText("");
               custv.getcusemail().setText("");
               custv.getcusadd().setText("");
               
               
                
                JOptionPane.showMessageDialog(null, "Customer Added");
                
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"can not execute the operation");
        }
             
        });
        
        custv.getBtnclose().addActionListener((e)->{
        
         
        custv.dispose();
         });
        
    }
}
