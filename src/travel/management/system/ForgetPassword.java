
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements ActionListener{
    JButton search,retrive,back;
    JTextField TU,TA,TQ,TN,TP;
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1. getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new  JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280 );
        p1.setForeground(new Color(100,186,188));
        add(p1);
        
        
        JLabel username=new JLabel("USERNAME");
        username.setBounds(40,20,100,25);
        username.setFont(new Font("Times New Roman",Font.BOLD,15));
        p1.add(username);
        
        TU=new JTextField();
        TU.setBounds(220,20,150,25);
        p1.add(TU);
        
        
        search=new JButton("SEARCH");
        search.setBackground(Color.red);
        search.setForeground(Color.BLACK);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel name=new JLabel("NAME");
        name.setBounds(40,60,100,25);
        name.setFont(new Font("Times New Roman",Font.BOLD,15));
        p1.add(name);
        
        TN=new JTextField();
        TN.setBounds(220,60,150,25);
        p1.add(TN);
        
        JLabel question=new JLabel("SECURITY QUESTION");
        question.setBounds(40,100,200,25);
        question.setFont(new Font("Times New Roman",Font.BOLD,15));
        p1.add(question);
        
        TQ=new JTextField();
        TQ.setBounds(220,100,190,25);
        p1.add(TQ);
        
        
        JLabel answer=new JLabel("ANSWER");
        answer.setBounds(40,140,150,25);
        answer.setFont(new Font("Times New Roman",Font.BOLD,15));
        p1.add(answer);
        
        TA=new JTextField();
        TA.setBounds(220,140,150,25);
        p1.add(TA);
        
        
        retrive=new JButton("RETRIVE");
        retrive.setBackground(Color.red);
        retrive.setForeground(Color.BLACK);
        retrive.setBounds(380,140,100,25);
        retrive.addActionListener(this);
        p1.add(retrive);
        
        JLabel password=new JLabel("PASSWORD");
        password.setBounds(40,180,150,25);
        password.setFont(new Font("Times New Roman",Font.BOLD,15));
        p1.add(password);
        
        TP=new JTextField();
        TP.setBounds(220,180,150,25);
        p1.add(TP);
        
        back=new JButton("BACK");
        back.setBackground(Color.red);
        back.setForeground(Color.BLACK);
        back.setBounds(150,250,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            try{
                String query="select *from account where username='"+TU.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                
                while(rs.next()){
                    TN.setText(rs.getString("name"));
                    TQ.setText(rs.getString("security"));
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==retrive){
            try{
                String query="select *from account where answer='"+TA.getText()+"'AND username='"+TU.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                
                while(rs.next()){
                    TP.setText(rs.getString("password"));
                    
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]){
        new ForgetPassword();
    }
}
