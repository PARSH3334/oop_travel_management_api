package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    
    JLabel lblusername,lblnumber,labelname;
    
    JTextField tfnumber,tfstate,tfaddress,tfphone,tfemail,tfid,tfgender;
    
    JButton add,back;
    String username;
    UpdateCustomer(String username){
        this.username=username;
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,10,500,25);
        text.setFont(new Font("Times new roman",Font.BOLD,20));
        text.setForeground(new Color(100,186,188));
        add(text);
        
        lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
        lblusername = new JLabel();
        lblusername.setBounds(220,50,150,25);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        tfid= new JTextField();
        tfid.setBounds(220,90,150,25);
        tfid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfid);
        
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        tfnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        tfgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfgender);
        
       
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(30,250,150,25);
        lblstate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(220,250,150,25);
        tfstate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfstate);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(220,290,150,25);
        tfaddress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(30,330,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        tfphone =new JTextField();
        tfphone.setBounds(220,330,150,25);
        tfphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30,370,150,25);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblemail);
        
        tfemail =new JTextField();
        tfemail.setBounds(220,370,150,25);
        tfemail.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfemail);
        
        add= new JButton("Update");
        add.setForeground(Color.BLACK);
        add.setBackground(new Color(100,186,188) );
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);
        
        back= new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(100,186,188) );
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,200,400);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username ='"+username+"'");
            while(rs.next()){
                lblusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString ("id"));
                tfnumber.setText(rs.getString ("number"));
                tfgender.setText(rs.getString ("gender"));
                tfstate.setText(rs.getString ("country"));
                tfaddress.setText(rs.getString ("address"));
                tfphone.setText(rs.getString ("phone"));
                tfemail.setText(rs.getString ("email"));
                
               
            }
                
                
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==add){
            String username =lblusername.getText();
            String id =tfid.getText();
            String number=tfnumber.getText();
            String name = labelname.getText();
            String gender =tfgender.getText();
            String state =tfstate.getText();
            String address =tfaddress.getText();
            String phone = tfphone.getText();
            String email=tfemail.getText();
            
            try{
                Conn c=new Conn();
                String query="update customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender= '"+gender+"',country='"+state+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "customer Details Updated Successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateCustomer("PARSHWA");
    }
        
        
}
 
