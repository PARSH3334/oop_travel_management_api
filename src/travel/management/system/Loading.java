 package travel.management.system;;

import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    public void run(){
        try{
            for(int i=1;i<=101;i++)
            {
               int max = bar.getMaximum();
               int  value =bar.getValue();
               
               if(value<max)
               {
                   bar.setValue(bar.getValue()+1);
               }
               else{
                
                  setVisible(false);
                  new Dashboard(username);
                   
               }
               Thread.sleep(50);
            }
                    
                
        }catch (Exception e){
            e.printStackTrace();
        }
    }
        
    Loading(String username){
        this.username=username;
        t=new Thread(this);
        setBounds(500,200,800,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel Management Application");
        text.setBounds(70,20,600,40);
        text.setForeground(new Color(100,186,188));
        text.setFont(new Font("Times New Roman",Font.BOLD,35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,330,35);
        bar.setStringPainted(true);
        add(bar);
        
        
        
        JLabel loading = new JLabel("Loading please wait...");
        loading.setBounds(220,140,300,30);
        loading.setForeground(new Color(54,69,79));
        loading.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(loading);
        
       JLabel lblusername = new JLabel("Welcome "+username);
        lblusername.setBounds(275,310,400,40);
        lblusername.setForeground(new Color(54,69,79));
        lblusername.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(lblusername);
        
        t.start();
        
        
        setVisible(true);
    }
      
    public static void main(String[] args)
    {
        new Loading("");
    }
        
}