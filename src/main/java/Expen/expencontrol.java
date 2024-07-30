/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Expen;

import customer.conn;
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

public class expencontrol {
   Expen exp;
   
   public expencontrol(){
       exp = new Expen();
       exp.setVisible(true);
       
       conn conection =new conn();
       Connection con=conn.connectdb();
         
       exp.getbtnadd().addActionListener((e)->{
            try {
            String details=exp.gettxtdetail().getText();
            Double amount=Double.parseDouble(exp.gettxtamount().getText());

            String query="insert into Expenditures(Details,Amount)"+
                    "values('"+details+"',"+amount+")";
            Statement stmt;
            stmt = con.createStatement();
            stmt.executeUpdate(query);
               exp.gettxtdetail().setText("");
               exp.gettxtamount().setText("");
               
                JOptionPane.showMessageDialog(null, "Expenditures Added");
               
              } catch (SQLException ex) {
               Logger.getLogger(expencontrol.class.getName()).log(Level.SEVERE, null, ex);
           }
               
        });
       
       
   }
   
   
}
