package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{
    JButton create,Back;
    JTextField tf,tn,tp,tA;
    Choice security;
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(255,102,0  ));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lusername=new JLabel("Username");
        lusername.setBounds(20, 20,80,25);
        lusername.setFont(new Font("Times New Roman",Font.BOLD,35));
        p1.add(lusername);
        
         tf=new JTextField();
        tf.setBounds(190, 20, 180, 25);
        p1.add(tf);
        
       JLabel name=new JLabel("Name");
        name.setBounds(20, 60, 80,25);
        name.setFont(new Font("Times New Roman",Font.BOLD,35));
        p1.add(name);
        
        tn=new JTextField();
        tn.setBounds(190, 60, 180, 25);
        p1.add(tn);
        
       JLabel password=new JLabel("Password");
        password.setBounds(20,100, 80,25);
        password.setFont(new Font("Times New Roman",Font.BOLD,35));
        p1.add(password);
        
         tp=new JTextField();
        tp.setBounds(190, 100, 180, 25);
        p1.add(tp);
        
        JLabel Security=new JLabel("Security Question");
        Security.setBounds(20, 140, 80,25);
        Security.setFont(new Font("Times New Roman",Font.BOLD,35));
        p1.add(Security);
        
        security=new Choice();
        security.add("WHAT IS YOUR NICKNAME");
        security.add("WHAT IS YOUR BEST GAME");
        security.add("WHAT IS YOUR DOMAIN OF STUDY");
        security.add("HOW IS YOUR ROLE IDEAL");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        
        JLabel lANS=new JLabel("Answer");
        lANS.setBounds(20, 180, 80,25);
        lANS.setFont(new Font("Times New Roman",Font.BOLD,35));
        p1.add(lANS);
        
         tA=new JTextField();
        tA.setBounds(190, 180, 180, 25);
        p1.add(tA);
        
        
         create =new JButton("CREATE");
        create.setBackground(Color.green);
        create.setForeground(Color.WHITE);
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
         Back =new JButton("BACK");
        Back  .setBackground(Color.blue);
        Back.setForeground(Color.WHITE);
        Back.setBounds(250,250,100,30);
        Back.addActionListener(this);
        p1.add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        
        setVisible(true);
        

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==create){
            String username=tf.getText();
            String name=tn.getText();
            String password=tp.getText();
            String question=security.getSelectedItem();
            String answer=tA.getText();
            
            String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                
                setVisible(false);
                new Login();
                
            } catch (Exception ea){
                ea.printStackTrace();
            }
        }else if(e.getSource()==Back){
            setVisible(false);
                new Login();
        }
    }
    
    
    public static void main(String []args){
        new Signup();
    }
    
}
