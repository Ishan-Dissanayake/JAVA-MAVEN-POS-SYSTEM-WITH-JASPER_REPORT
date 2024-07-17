/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class custupdatecontrol {
    custupdate cup;
    
    public custupdatecontrol(){
        cup =new custupdate();
        cup.setVisible(true);
        
        cup.getserch().addActionListener((e)->{
        Connection con=conn.connectdb();
        String id=cup.getsrchnme().getText();
        try {
                Statement stmt=con.createStatement();
            ResultSet result=stmt.executeQuery("Select * from customers where Customer_id='"+id+"'");
            if(result.next()){
                cup.getupname().setText(result.getString(2));
                cup.getuptp().setText(result.getString(3));
                cup.getupemail().setText(result.getString(4));
                cup.getupadd().setText(result.getString(5));   
            }else{
                JOptionPane.showMessageDialog(null,"id invalid");
            }
                
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"can not execute the operation");
        }
        
        
            
        });
        
         cup.getBtncus().addActionListener((e)->{
        
        String id1=cup.getsrchnme().getText();
        Connection con=conn.connectdb();
            
            String name1=cup.getupname().getText();
            int tp1=Integer.parseInt(cup.getuptp().getText());
            String email1=cup.getupemail().getText();
            String add1= cup.getupadd().getText();
               
            try {
            
            String query1="UPDATE customers SET Customer_Name = '"+name1+"' ,Customer_phoneNo ='"+tp1+"',Customer_Email='"+email1+"',Customer_Address='"+add1+"' WHERE Customer_id='"+id1+"'";
            Statement stmt=con.createStatement();
                stmt.executeUpdate(query1);
                
               cup.getsrchnme().setText("");
               cup.getupname().setText("");
               cup.getuptp().setText("");
               cup.getupemail().setText("");
               cup.getupadd().setText("");
               
               
                
                JOptionPane.showMessageDialog(null, "Customer details updated");
             }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"can not execute the operation");
        }
         });
        cup.getBtnclose().addActionListener((e)->{
        cup.dispose();
    });
    
    
}
}
