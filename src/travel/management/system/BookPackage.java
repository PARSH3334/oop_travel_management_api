package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
     Choice c1;
     JTextField t1;
     String usename;
     JLabel l1,id,number,phone,l5;
     JButton checkprice,bookpackage,back;
    
    BookPackage(String username){
        this.usename = username;
        setBounds(350,200,1100,500);
        setLayout(null);
        JLabel text = new JLabel("BOOK PACKAGE"); 
		text.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		text.setBounds(118, 11, 300, 53);
		add(text);
                
                JLabel la2 = new JLabel("Username :");
		la2.setBounds(35, 70, 200, 14);
		add(la2);
                
                l1 = new JLabel();
		l1.setBounds(271, 70, 200, 14);
		add(l1);
                
                JLabel lblId = new JLabel("Select Package :");
		lblId.setBounds(35, 110, 200, 14);
		add(lblId);
                
                c1 = new Choice();
                c1.add("Gold Package");
                c1.add("Silver Package");
                c1.add("Bronze Package");
                c1.setBounds(271, 110, 150, 30);
                add(c1);
                
                JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 150, 200, 14);
		add(la3);
                
                t1 = new JTextField();
                
		t1.setBounds(271, 150, 150, 20);
		add(t1);
		
                
		JLabel lbl1 = new JLabel("ID :");
		lbl1.setBounds(35, 190, 200, 14);
		add(lbl1);
                
                id = new JLabel();
		id.setBounds(271, 190, 200, 14);
		add(id);
		
		JLabel lbl2 = new JLabel("Number :");
		lbl2.setBounds(35, 230, 200, 14);
		add(lbl2);
                
                number = new JLabel();
		number.setBounds(271, 230, 200, 14);
		add(number);
           	
		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(35, 270, 200, 14);
		add(lbl3);
                
                phone = new JLabel();
		phone.setBounds(271, 270, 200, 14);
	        add(phone);

		
		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(35, 310, 200, 14);
		add(lblDeposite);
		
	        l5 = new JLabel();
		l5.setBounds(271, 310, 200, 14); 
                l5.setForeground(Color.RED);
		add(l5);
                
                try{
                Conn conn=new Conn();
                String query="select *from customer where username='"+username+"'";
                ResultSet rs=conn.s.executeQuery(query);
                while(rs.next()){
                   l1.setText(rs.getString("username"));
                   id.setText(rs.getString("id"));
                   number.setText(rs.getString("number"));
                   phone.setText(rs.getString("phone"));
                   
               }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice=new JButton("check price");    
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage=new JButton("book package");    
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back=new JButton("back");    
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);
        
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(450,50,700,300);
                add(la1);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack= c1.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 12000;
            }else if(pack.equals("Silver Package")){
                cost += 25000;
            } else{
                cost += 32000;
            }
            cost *= Integer.parseInt(t1.getText());
                            l5.setText("Rs "+cost);
        }else if(ae.getSource()==bookpackage){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpakage values('"+l1.getText()+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+id.getText()+"', '"+number.getText()+"', '"+phone.getText()+"', '"+l5.getText()+"')");
               JOptionPane.showMessageDialog(null, "Package Booked Successfully");
               setVisible(false);
            
            }catch(Exception e){
               e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new BookPackage("PARSHWA");
    }
    
    
}