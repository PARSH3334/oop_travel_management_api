
package travel.management.system;

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;



public class Firstpage extends JFrame  implements ActionListener {
    JFrame f1 = new JFrame();
    JButton login ,singup;
     Firstpage(){ 
        f1.setLayout(null);
        f1.setBounds(0,0,1600,1000);
        f1.getContentPane().setBackground(Color.PINK);
       
      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
       ImageIcon i6=new ImageIcon(i5);
       JLabel Image =new JLabel(i6);
       Image.setBounds(0,0,1600,1000);
       f1.add(Image);
       
       JLabel text =new JLabel(" Welcome To Travel Management System");
       text.setBounds(200,70,1200,70);
       text.setForeground(Color.BLACK);
       text.setFont(new Font("Railway",Font.BOLD,50));
       
         Image.add(text);
       
        login =new JButton("login");
        login.setBounds(200,700,130,30); 
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        Image.add(login);
        
        
        singup =new JButton("Signup");
        singup.setBounds(1200,700,130,30); 
        singup.setBackground(Color.BLACK);
        singup.setForeground(Color.WHITE);
        singup.addActionListener(this);
        Image.add(singup);
       
       
       
       
        
  
        f1.setVisible(true);
     }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==login){
             new Login();
         }else if(ae.getSource()==singup){
             new Signup();
         }
     }
     
     public static void main(String args[]){
         new Firstpage();
     }
}
