/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package store;

import customer.conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;

/**			

 *
 * @author ASUS
 */
public class itemcontrol {
    
   storefront fr;
    checkitems check;
    public itemcontrol () {
        fr = new storefront();
        check =new checkitems();
         check.setVisible(true);
         conn conection =new conn();
         Connection con=conn.connectdb();
         try {
                
           
            Statement stmt=con.createStatement();
            
            ResultSet rs= stmt.executeQuery("select * from items");
           while (rs.next()){
               String code =rs.getString("item_code");
               String name=rs.getString("item_name");
               String qty=rs.getString("qtyinstock");
               String cost=rs.getString("cost");
               String price=rs.getString("price");
               
               String tbldata[]={code,name,qty,cost,price};
               DefaultTableModel tblModel = (DefaultTableModel)check.gettblitem().getModel();
               
               tblModel.addRow(tbldata);
               
           }
            
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"can not execute the operation");
        }
         
        check.getbtnsearch().addActionListener((e)->{
           try {
               int searchcode =Integer.parseInt(check.gettxtcode().getText());
               
               
               DefaultTableModel model = (DefaultTableModel) check.gettblitem().getModel();
model.setRowCount(0);
                Connection con1=conn.connectdb();
           
            Statement stmt1=con1.createStatement();
            
            
            ResultSet reslt= stmt1.executeQuery("select * from items where item_code="+searchcode+"");
           while (reslt.next()){
               String code1 =reslt.getString(1);
               String name1=reslt.getString(2);
               String qty1=reslt.getString(3);
               String cost1=reslt.getString(4);
               String price1=reslt.getString(5);
               
               String tbldata1[]={code1,name1,qty1,cost1,price1};
               DefaultTableModel tblModel1 = (DefaultTableModel)check.gettblitem().getModel();
               
               tblModel1.addRow(tbldata1);
               
               
           }
            
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"can not execute the operation");
        }
           
            
            
        });
        
        
        check.getbtnback().addActionListener((e)->{
           
           check.dispose();
           
        });
        
        
    }
    
}
