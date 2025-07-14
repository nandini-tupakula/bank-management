// [Previous files included: Login.java, Connn.java, Signup.java, Signup2.java]

// --- File: Signup3.java ---
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {
        this.formno = formno;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(1000, 1000));

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        panel.add(l1);

        JLabel l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100, 140, 200, 30);
        panel.add(l2);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");
        r1.setBackground(Color.WHITE);
        r2.setBackground(Color.WHITE);
        r3.setBackground(Color.WHITE);
        r4.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 250, 30);
        r2.setBounds(350, 180, 250, 30);
        r3.setBounds(100, 220, 250, 30);
        r4.setBounds(350, 220, 300, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1); bg.add(r2); bg.add(r3); bg.add(r4);
        panel.add(r1); panel.add(r2); panel.add(r3); panel.add(r4);

        JLabel l3 = new JLabel("Services Required:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 270, 200, 30);
        panel.add(l3);

        c1 = new JCheckBox("ATM Card");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("EMAIL Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");
        JCheckBox c7 = new JCheckBox("I hereby declare that the above details are correct.");
        c1.setBackground(Color.WHITE); c2.setBackground(Color.WHITE);
        c3.setBackground(Color.WHITE); c4.setBackground(Color.WHITE);
        c5.setBackground(Color.WHITE); c6.setBackground(Color.WHITE);
        c7.setBackground(Color.WHITE);

        c1.setBounds(100, 310, 200, 30);
        c2.setBounds(350, 310, 200, 30);
        c3.setBounds(100, 350, 200, 30);
        c4.setBounds(350, 350, 200, 30);
        c5.setBounds(100, 390, 200, 30);
        c6.setBounds(350, 390, 200, 30);
        c7.setBounds(100, 430, 600, 30);
        panel.add(c1); panel.add(c2); panel.add(c3); panel.add(c4); panel.add(c5); panel.add(c6); panel.add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 500, 100, 30);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(400, 500, 100, 30);
        cancel.addActionListener(this);
        panel.add(cancel);

        JScrollPane scrollPane = new JScrollPane(panel);
        setContentPane(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String atype = null;
            if (r1.isSelected()) atype = "Saving Account";
            else if (r2.isSelected()) atype = "Fixed Deposit Account";
            else if (r3.isSelected()) atype = "Current Account";
            else if (r4.isSelected()) atype = "Recurring Deposit Account";

            Random ran = new Random();
            String cardno = "" + (Math.abs((ran.nextLong() % 90000000L) + 1409963000000000L));
            String pin = "" + (Math.abs((ran.nextLong() % 9000L) + 1000L));

            String services = "";
            if (c1.isSelected()) services += "ATM Card ";
            if (c2.isSelected()) services += "Internet Banking ";
            if (c3.isSelected()) services += "Mobile Banking ";
            if (c4.isSelected()) services += "EMAIL Alerts ";
            if (c5.isSelected()) services += "Cheque Book ";
            if (c6.isSelected()) services += "E-Statement ";

            try {
                if (atype == null) {
                    JOptionPane.showMessageDialog(null, "Please select account type");
                } else {
                    Connn c = new Connn();
                    String q1 = "INSERT INTO signupthree VALUES (?, ?, ?, ?, ?)";
                    String q2 = "INSERT INTO login VALUES (?, ?, ?)";
                    PreparedStatement ps1 = c.connection.prepareStatement(q1);
                    PreparedStatement ps2 = c.connection.prepareStatement(q2);
                    ps1.setString(1, formno);
                    ps1.setString(2, atype);
                    ps1.setString(3, cardno);
                    ps1.setString(4, pin);
                    ps1.setString(5, services);
                    ps2.setString(1, formno);
                    ps2.setString(2, cardno);
                    ps2.setString(3, pin);
                    ps1.executeUpdate();
                    ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Card No: " + cardno + "\nPin: " + pin);
                    setVisible(false);
                    new Deposit(pin);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}