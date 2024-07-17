/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package store;

/**
 *
 * @author ASUS
 */
public class storecontrol {
    
    storefront sfront;
    checkitems check;
 
    public storecontrol(){
        check = new checkitems();
        sfront = new storefront();
   
        
        sfront.setVisible(true);
        
        
        sfront.getbtncheck().addActionListener((e)->{
           sfront.setVisible(false);
            itemcontrol check=new itemcontrol();
        });
        
        sfront.getbtnadd().addActionListener((e)->{
           sfront.setVisible(false);
            addcontrol add=new addcontrol();
        });
        
        
        sfront.getbtnclose().addActionListener((e)->{
           sfront.dispose();
           
        });
        
        sfront.getitmupdte().addActionListener((e)->{
            sfront.setVisible(false);
          itemupdatecontrol itmup  = new itemupdatecontrol();
           
        });
        
        
        
    }
    
}
