/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class customerDetailscontrol {
    
    customers cus;
   
    
    
    public customerDetailscontrol(){
   
     
    cus = new customers();
    cus.setVisible(true);
    conn conection =new conn();
         Connection con=conn.connectdb();
         
         try {
                
           
            Statement stmt=con.createStatement();
            
            ResultSet rs= stmt.executeQuery("select * from customers");
           while (rs.next()){
               String id =rs.getString("Customer_id");
               String name=rs.getString("Customer_Name");
               String tp=rs.getString("Customer_phoneNo");
               String email=rs.getString("Customer_Email");
               String add=rs.getString("Customer_Address");
               
               String tbldata[]={id,name,tp,email,add};
               DefaultTableModel tblModel = (DefaultTableModel)cus.gettble().getModel();
               
               tblModel.addRow(tbldata);
               
           }
            
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"can not execute the operation");
        }
         
         
        cus.getclose().addActionListener((e)->{
         
              cus.dispose();
        });
         
    }
    
}
