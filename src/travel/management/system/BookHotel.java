package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    Choice hotel, AC, FOOD;
    JTextField tfdays, t1;
    String usename;
    JLabel l1, id, number, phone, l5;
    JButton checkprice, bookhotel, back;

    BookHotel(String username) {
        this.usename = username;
        setBounds(350, 200, 1100, 680);
        setLayout(null);
        JLabel text = new JLabel("BOOK Hotels");
        text.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        text.setBounds(118, 11, 300, 53);
        add(text);

        JLabel la2 = new JLabel("Username :");
        la2.setBounds(35, 70, 200, 14);
        add(la2);

        l1 = new JLabel();
        l1.setBounds(271, 70, 200, 14);
        add(l1);

        JLabel lblId = new JLabel("Select Hotels :");
        lblId.setBounds(35, 110, 200, 14);
        add(lblId);

        hotel = new Choice();
        hotel.setBounds(271, 110, 150, 30);
        add(hotel);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from hotel1");
            while (rs.next()) {
                hotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel la3 = new JLabel("Total Persons");
        la3.setBounds(35, 150, 200, 14);
        add(la3);

        t1 = new JTextField();

        t1.setBounds(271, 150, 150, 20);
        add(t1);

        JLabel lbldays = new JLabel("Total no of days");
        lbldays.setBounds(35, 190, 200, 14);
        add(lbldays);

        tfdays = new JTextField();

        tfdays.setBounds(271, 190, 150, 20);
        add(tfdays);

        JLabel lblac = new JLabel("AC/NON-AC");
        lblac.setBounds(35, 230, 200, 14);
        add(lblac);

        AC = new Choice();
        AC.add("AC");
        AC.add("NON-AC");
        AC.setBounds(271, 230, 150, 30);
        add(AC);

        JLabel lblfood = new JLabel("FOODS");
        lblfood.setBounds(35, 270, 200, 14);
        add(lblfood);

        FOOD = new Choice();
        FOOD.add("YES");
        FOOD.add("NO");
        FOOD.setBounds(271, 270, 150, 30);
        add(FOOD);

        JLabel lbl1 = new JLabel("ID :");
        lbl1.setBounds(35, 310, 200, 14);
        add(lbl1);

        id = new JLabel();
        id.setBounds(271, 310, 200, 14);
        add(id);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setBounds(35, 350, 200, 14);
        add(lbl2);

        number = new JLabel();
        number.setBounds(271, 350, 200, 14);
        add(number);

        JLabel lbl3 = new JLabel("Phone :");
        lbl3.setBounds(35, 390, 200, 14);
        add(lbl3);

        phone = new JLabel();
        phone.setBounds(271, 390, 200, 14);
        add(phone);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 430, 200, 14);
        add(lblDeposite);

        l5 = new JLabel();
        l5.setBounds(271, 430, 200, 14);
        l5.setForeground(Color.RED);
        add(l5);

        try {
            Conn conn = new Conn();
            String query = "select *from customer where username='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                l1.setText(rs.getString("username"));
                id.setText(rs.getString("id"));
                number.setText(rs.getString("number"));
                phone.setText(rs.getString("phone"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("check price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel = new JButton("BOOK HOTEL");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200, 490, 120, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back = new JButton("back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 50, 700, 300);
        add(la1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery("select * from hotel1 where name='" + hotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodinclude"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(t1.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = AC.getSelectedItem();
                    String foodselected = FOOD.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("YES") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        l5.setText("RS" + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "please enter valid number");
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() ==bookhotel) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('" + l1.getText() + "', '" + hotel.getSelectedItem() + "', '" + t1.getText() + "','"+tfdays.getText()+"','"+AC.getSelectedItem()+"','"+FOOD.getSelectedItem()+"', '" + id.getText() + "', '" + number.getText() + "', '" + phone.getText() + "', '" + l5.getText() + "')");
                JOptionPane.showMessageDialog(null, "HOTEL Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("PARSHWA");
    }

}
