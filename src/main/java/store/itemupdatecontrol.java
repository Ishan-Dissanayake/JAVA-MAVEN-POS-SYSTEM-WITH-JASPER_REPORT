/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package store;

import customer.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author ASUS
 */
public class itemupdatecontrol {
    itemupdate cup;
    
    public itemupdatecontrol(){
        cup =new itemupdate();
        cup.setVisible(true);
        Connection con=conn.connectdb();
          cup.getcode().getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            public void removeUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            private void updateSuggestions() {
                String text = cup.getcode().getText();
                if (text.isEmpty()) {
                    cup.getListModel().clear();
                    return;
                }
                ArrayList<String> suggestions = fetchSuggestions(text,con);
                cup.getListModel().clear();
                for (String suggestion : suggestions) {
                    cup.getListModel().addElement(suggestion);
                }
            }
        });
        
        
        cup.getserch().addActionListener((e)->{
      
        String id=cup.getsrchnme().getText();
        try {
            
            	
	
            
            
                Statement stmt=con.createStatement();
            ResultSet result=stmt.executeQuery("Select * from items where item_name='"+id+"'");
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
       // Connection con=conn.connectdb();
            
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
    private ArrayList<String> fetchSuggestions(String text, Connection con1) {
        ArrayList<String> suggestions = new ArrayList<>();
        try {
            Statement stmt = con1.createStatement();
            String query = "SELECT item_name FROM items WHERE item_name LIKE '%" + text + "%'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                suggestions.add(rs.getString("item_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suggestions;
    }
    
}
