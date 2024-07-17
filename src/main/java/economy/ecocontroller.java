/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package economy;

import com.toedter.calendar.JDateChooser;
import customer.conn;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ecocontroller {
    
//     DateTime dtFrom = Convert.ToDateTime(dateTimePicker1.Text); //some DateTime value, e.g. DatePicker1.Text;
//            DateTime dtTo = Convert.ToDateTime(dateTimePicker2.Text); //some DateTime value, e.g. 
//           
//            MySqlDataAdapter mda = new MySqlDataAdapter("select * from summary where DATE between '" + dtFrom.ToString("yyyy/MM/dd") + "' and '" + dtTo.ToString("yyyy/MM/dd") + "' ", con5);
Connection con1=conn.connectdb();

account acc ;
        public ecocontroller(){
            acc =new account();
            acc.setVisible(true);
            
            
            
            
            acc.getBtnsearch().addActionListener((e)->{
       
  DefaultTableModel model = (DefaultTableModel) acc.gettblacc().getModel();
model.setRowCount(0);
            
          
           double sumcost=0;
           double sumprice=0;
           double profit=0;
            
         try{   
             Statement stmt=con1.createStatement();
             java.util.Date startDate =  acc.getd1().getDate();
             java.util.Date endDate =  acc.getd2().getDate();

            // Create a SimpleDateFormat to format the dates for the query
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Construct the SELECT query with the date range
            String selectQuery = "SELECT * FROM summary WHERE DATE BETWEEN '" + dateFormat.format(startDate) + "' AND '" + dateFormat.format(endDate) + "'";

            // Execute the SELECT query
            ResultSet resultSet = stmt.executeQuery(selectQuery);

           while (resultSet.next()){
               String code =resultSet.getString("item_code");
               String name=resultSet.getString("item_name");
               String qty=resultSet.getString("qty");
               String cost=resultSet.getString("cost");
               String price=resultSet.getString("price");
               
               double pri=0;
               pri = Double.parseDouble(price);
               sumprice=sumprice+pri;
               
               double cos=0;
              cos = Double.parseDouble(cost);
              sumcost=sumcost+cos;
              
               String tbldata[]={code,name,qty,cost,price};
               DefaultTableModel tblModel1 = (DefaultTableModel)acc.gettblacc().getModel();
               
               tblModel1.addRow(tbldata);
               
                
              
           }
           
             profit=sumprice-sumcost;
             acc.getprofit().setText(Double.toString(profit));
        
             
                
           
         }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"can not execute the operation");
        }
           });
            
            
            acc.getbtnbck().addActionListener((e)->{
            acc.dispose();

            
            }); 
           }
           
        
        
        
    
}
