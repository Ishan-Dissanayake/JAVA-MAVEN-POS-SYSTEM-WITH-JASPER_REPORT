/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package home;

import cart.billcontrol;
import customer.custfrontcontroller;
import economy.ecocontroller;
import store.storecontrol;
public class homecontrol {
   
    front fr;
    
    
    public homecontrol(){
        
        fr = new front();
        
       fr.setVisible(true);
      
       
         
        fr.getBtncus().addActionListener((e)->{
            
          custfrontcontroller cfrnt=new custfrontcontroller();
            
        });
       
       
      
        fr.getbtnstore().addActionListener((e)->{
            
          storecontrol str=new storecontrol();
            
        });       
        
                
        fr.btnbill().addActionListener((e)->{
            
          billcontrol bil=new billcontrol();
            
        }); 
        
        fr.btneco().addActionListener((e)->{
            
          ecocontroller bil=new ecocontroller();
            
        }); 
        
    }
    
    

}
