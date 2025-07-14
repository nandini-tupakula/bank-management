package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    Login() {
        super("Bank Management System");

        setExtendedState(JFrame.MAXIMIZED_BOTH); // 🔸 Fullscreen
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(600, 40, 100, 100);
        add(image);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(500, 150, 450, 40);
        add(label1);

        label2 = new JLabel("Card Number:");
        label2.setFont(new Font("Raleway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(400, 230, 250, 30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(650, 230, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField2);

        label3 = new JLabel("ATM PIN:");
        label3.setFont(new Font("Raleway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(400, 300, 250, 30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(650, 300, 230, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(550, 370, 100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(670, 370, 100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(610, 420, 120, 30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        JLabel bgLabel = new JLabel(new ImageIcon(bgImage));
        bgLabel.setBounds(0, 0, 1920, 1080);
        add(bgLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                String cardno = textField2.getText();
                String pin = String.valueOf(passwordField3.getPassword());

                Connn c = new Connn();
                String q = "SELECT * FROM login WHERE card_number = ? AND pin = ?";
                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setString(1, cardno);
                ps.setString(2, pin);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    setVisible(false);
                    new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

                ps.close();
                rs.close();
                c.connection.close();

            } else if (e.getSource() == button2) {
                textField2.setText("");
                passwordField3.setText("");
            } else if (e.getSource() == button3) {
                setVisible(false);
                new Signup();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
