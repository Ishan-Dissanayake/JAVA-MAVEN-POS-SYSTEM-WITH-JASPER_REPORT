/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package store;

import customer.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class itemupdatecontrol {
    itemupdate cup;
    
    public itemupdatecontrol(){
        cup =new itemupdate();
        cup.setVisible(true);
        
        cup.getserch().addActionListener((e)->{
        Connection con=conn.connectdb();
        String id=cup.getsrchnme().getText();
        try {
            
            	
	
            
            
                Statement stmt=con.createStatement();
            ResultSet result=stmt.executeQuery("Select * from items where item_code='"+id+"'");
            if(result.next()){
                cup.getupname().setText(result.getString(2));
                cup.getuptp().setText(result.getString(3));
                 cup.getcost().setText(result.getString(4));
                cup.getupemail().setText(result.getString(5));
              
                 
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
            int qt1=Integer.parseInt(cup.getuptp().getText());
            Double cost=Double.parseDouble(cup.getcost().getText());
            Double price=Double.parseDouble(cup.getupemail().getText());
           
      	
            try {
            
            String query1="UPDATE items SET item_name = '"+name1+"' ,qtyinstock ="+qt1+",cost="+cost+",price="+price+" WHERE item_code='"+id1+"'";
            Statement stmt=con.createStatement();
                stmt.executeUpdate(query1);
                
               cup.getsrchnme().setText("");
               cup.getupname().setText("");
               cup.getuptp().setText("");
               cup.getupemail().setText("");
             
               
               
                
                JOptionPane.showMessageDialog(null, "Item details updated");
             }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"can not execute the operation");
        }
         });
         
         cup.getdelete().addActionListener((e)->{
             try{
              String id=cup.getsrchnme().getText();
             Connection con2=conn.connectdb();
       Statement stmt2=con2.createStatement();
            String querydelt = "delete from items where item_code="+id+"";
            stmt2.executeUpdate(querydelt);
            
             cup.getsrchnme().setText("");
               cup.getupname().setText("");
               cup.getuptp().setText("");
               cup.getupemail().setText("");
             cup.getcost().setText("");
            
              JOptionPane.showMessageDialog(null, "Item details Deleted");
            
             }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"can not execute the operation");
        }
             
             
    });
         
         
        cup.getBtnclose().addActionListener((e)->{
        cup.dispose();
    });
    
    
}
}
