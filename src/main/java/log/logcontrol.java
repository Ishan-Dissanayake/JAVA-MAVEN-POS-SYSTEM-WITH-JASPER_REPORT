/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;


import home.front;
import home.homecontrol;
    
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class logcontrol {
     logviwe vi;
    logmodel mod;
    front fro;
    public logcontrol(){
    vi=new logviwe();
    mod=new logmodel();
    fro=new front();
    
    vi.getBtnlog().addActionListener((e)->{
            loging();
        });
    vi.setVisible(true);
    vi.getbtnclose().addActionListener((  e)->{
    close();
    });
    
     
}public void loging(){
        String name=vi.getTxtuser().getText();
        String pw=vi.getTxtpw().getText();
        if(name.equals(mod.getusername()) && (pw.equals(mod.getpw()))){
            vi.setVisible(false);
            homecontrol home=new homecontrol();
            
            
            
            
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Incorrect details");
        }
        
    }
     public void close(){
         int close=JOptionPane.showConfirmDialog(null,"Close Application","Select",JOptionPane.YES_NO_OPTION);
        if (close==0){
            System.exit(0);
        }
     }
}
