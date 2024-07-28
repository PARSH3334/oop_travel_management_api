
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewPackage extends JFrame implements ActionListener{
    
    
    JButton Back;
    ViewPackage(String username){
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS"); 
		text.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		text.setBounds(60, 0, 300, 30);
		add(text);
        
        JLabel lblusername=new JLabel("USERNAME");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername=new JLabel("");
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid=new JLabel("PACKAGE");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        JLabel labelpackage=new JLabel("");
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);
        
        JLabel lblnumber=new JLabel("TOTAL PERSONS");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        JLabel labelperson=new JLabel();
        labelperson.setBounds(220,130,150,25);
        add(labelperson);
        
        JLabel lblname=new JLabel("ID");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        JLabel labelid=new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);
        
        JLabel lblgender=new JLabel("NUMBER");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber);
        
        JLabel lblcountry=new JLabel("PHONE");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        JLabel labelphone=new JLabel("");
        labelphone.setBounds(220,250,150,25);
        add(labelphone);
        
        JLabel lbladdress=new JLabel("PRICE");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        JLabel labelprice=new JLabel("");
        labelprice.setBounds(220,290,150,25);
        add(labelprice);
        
      
        
        Back= new JButton("BACK");
        Back.setBounds(130,360,100,25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,480,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(420,10,450,400);
        add(image);
        
       
        try{
            Conn conn=new Conn();
            String query="select *from bookpackage where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelperson.setText(rs.getString("person"));
                            }
            
            
        }catch(Exception e){
            
        }
        
    
        setVisible(true);
        
    }
     
    
   
    public void actionPerformed(ActionEvent ae) {
         setVisible(false); 
    }
    public static void main(String args[]){
        new ViewPackage("PARSHWA");
    }

    
}
