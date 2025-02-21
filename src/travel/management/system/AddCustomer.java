
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfmail;
    JRadioButton male,female;
    JButton add,back;
    AddCustomer(String username){
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        comboid = new JComboBox(new String[]{"Passport","Adharr Card","PAN Card","Ration Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber =new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        labelname=new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        male=new JRadioButton("MALE");
        male.setBounds(220,210,70,25);
        male.setBackground(Color.white);
        add(male);
        
        
        female=new JRadioButton("FEMALE");
        female.setBounds(300,210,100,25);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        
        JLabel lblcountry= new JLabel ("Country");
        lblcountry.setBounds(30,230,150,50);
        add(lblcountry);
       
        tfcountry =new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        
        JLabel lblphone= new JLabel ("Phone");
        lblphone.setBounds(30,310,150,50);
        add(lblphone);
       
        tfphone =new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
        
        JLabel lblmail=new JLabel("E-Mail");
        lblmail.setBounds(30,370,150,25);
        add(lblmail);
        
        tfmail =new JTextField();
        tfmail.setBounds(220,370,150,25);
        add(tfmail);
        
        
        add=new JButton("ADD");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(40,430,100,25);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,430,100,25);
        back.addActionListener(this);
        add(back);
        
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);
        
        try{
           Conn c=new Conn();
          ResultSet rs = c.s.executeQuery("select*from account where username= '"+username+"'  ");
          
          while(rs.next()){
              labelusername.setText(rs.getString("username"));
              labelname.setText(rs.getString("name"));
          }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        setVisible(true);
        
      
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
          String username=labelusername.getText();
          String id=( String )comboid.getSelectedItem(); //type casting
          String number=tfnumber.getText();
          String name=labelname.getText();
          String gender=null;
          if(male.isSelected()){
              gender="Male";
          }
          else{
              gender="Female";
          }
          
          String country=tfcountry.getText();
          String address=tfaddress.getText();
          String phone=tfphone.getText();
          String email=tfmail.getText();
          
          try{
              Conn c1=new Conn();
              String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
              c1.s.executeUpdate(query);
              
              
              JOptionPane.showMessageDialog(null,"Customer Details Added sucessfully");
              setVisible(false);
              
          }catch(Exception e1){
             e1.printStackTrace();
          }
        }
        else{
            setVisible(false);
            
        }
    }
    
    
    
    
    public static void main(String args[]){
        new AddCustomer("PARSHWA");
    }
    
}
