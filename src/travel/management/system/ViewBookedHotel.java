
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewBookedHotel extends JFrame implements ActionListener{
    
    
    JButton Back;
    ViewBookedHotel(String username){
        setBounds(450,200,1000,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW BOOKED HOTELS DETAILS"); 
		text.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		text.setBounds(60, 0, 300, 30);
		add(text);
        
        JLabel lblusername=new JLabel("USERNAME");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername=new JLabel("");
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblhotel=new JLabel("HOTEL NAME");
        lblhotel.setBounds(30,90,150,25);
        add(lblhotel);
        
        JLabel labelhotel=new JLabel("");
        labelhotel.setBounds(220,90,150,25);
        add(labelhotel);
        
        JLabel lblpersons=new JLabel("TOTAL PERSONS");
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);
        
        JLabel labelperson=new JLabel();
        labelperson.setBounds(220,130,150,25);
        add(labelperson);
        
        JLabel lbldays=new JLabel("TOTAL DAYS");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);
        
        JLabel labelday=new JLabel();
        labelday.setBounds(220,170,150,25);
        add(labelday);
        
        JLabel lblac=new JLabel("AC/NON-AC");
        lblac.setBounds(30,210,150,25);
        add(lblac);
        
        JLabel labelac=new JLabel();
        labelac.setBounds(220,210,150,25);
        add(labelac);
        
        JLabel lblfood=new JLabel("FOOD INCLUDED");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);
        
        JLabel labelfood=new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(30,290,150,25);
        add(lblid);
        
        JLabel labelid=new JLabel();
        labelid.setBounds(220,290,150,25);
        add(labelid);
        
        
        JLabel lblgender=new JLabel("NUMBER");
        lblgender.setBounds(30,330,150,25);
        add(lblgender);
        
        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,330,150,25);
        add(labelnumber);
        
        JLabel lblcountry=new JLabel("PHONE");
        lblcountry.setBounds(30,370,150,25);
        add(lblcountry);
        
        JLabel labelphone=new JLabel("");
        labelphone.setBounds(220,370,150,25);
        add(labelphone);
        
        JLabel lbladdress=new JLabel("PRICE");
        lbladdress.setBounds(30,410,150,25);
        add(lbladdress);
        
        JLabel labelprice=new JLabel("");
        labelprice.setBounds(220,410,150,25);
        add(labelprice);
        
      
        
        Back= new JButton("BACK");
        Back.setBounds(130,460,100,25);
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
            String query="select *from bookhotel where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelhotel.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labelday.setText(rs.getString("days"));
                labelperson.setText(rs.getString("persons"));
                            }
            
            
        }catch(Exception e){
            
        }
        
    
        setVisible(true);
        
    }
     
    
   
    public void actionPerformed(ActionEvent ae) {
         setVisible(false); 
    }
    public static void main(String args[]){
        new ViewBookedHotel("PARSHWA");
    }

    
}
