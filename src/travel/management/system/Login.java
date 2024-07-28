
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,ForgetPassword;
    JTextField tfpassword,tfusername;
    Login(){
        setSize(900,400); 
        setLocation(350,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(255,102,0));
        p1.setBounds( 0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 0, 500, 500);
        add(p2);
        
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("Times New Roman",Font.BOLD,18));
        
        p2.add(lblusername);
         tfusername =new JTextField();
        tfusername.setBounds(60,60,300,30);
        p2.add(tfusername);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("Times New Roman",Font.BOLD,18));
        
        p2.add(lblpassword);
        tfpassword =new JTextField();
        tfpassword.setBounds(60,150,300,30);
        p2.add(tfpassword);
        
        
        login =new JButton("login");
        login.setBounds(60,250,130,30); 
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        p2.add(login);
        
        
        
        ForgetPassword =new JButton("ForgetPassword");
        ForgetPassword.setBounds(260,250,130,30); 
        ForgetPassword.setBackground(new Color(133,193,233));
        ForgetPassword.setForeground(Color.WHITE);
        ForgetPassword.addActionListener(this);
        p2.add(ForgetPassword);
        
        
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            try{
                    String username=tfusername.getText();
                    String password=tfpassword.getText();
                    
                    String query="select *from account where username='"+username+"' AND password='"+password+"'";
                    Conn c =new Conn();
                    ResultSet rs=c.s.executeQuery(query);
                    
                    if(rs.next()){
                        setVisible(false);
                        new Loading(username);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "INCORRECT USERNAME OR PASSWORD");
                    }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== ForgetPassword){
            setVisible(false);
            new ForgetPassword();
        }
        
    }
    
    
    public static void main(String[] args){
    
    new Login();
    }
    
}
