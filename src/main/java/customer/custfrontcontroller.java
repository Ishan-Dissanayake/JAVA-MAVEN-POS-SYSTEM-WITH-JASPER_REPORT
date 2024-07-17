/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class custfrontcontroller {
    custfront cfront;
    
    
    public custfrontcontroller(){
        cfront =new custfront();
        cfront.setVisible(true);
        
        cfront.getaddcust().addActionListener((e)->{
         
             customercontrol cc=new customercontrol();
              cfront.setVisible(false);
        });
        
        cfront.getupdt().addActionListener((e)->{
         
             custupdatecontrol cc1=new custupdatecontrol();
              cfront.setVisible(false);
        });
        
        
        
        
        cfront.getdet().addActionListener((e)->{
         
             customerDetailscontrol cd=new customerDetailscontrol();
              cfront.setVisible(false);
              
        });
        cfront.getclose().addActionListener((e)->{
         
              cfront.setVisible(false);
        });
    }
    
    
    
}
