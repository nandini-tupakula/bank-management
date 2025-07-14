// Due to the number of files and their length, all Java files for your Bank Management System will be added below in sequence.
// The files include full-screen layout, SQL security improvements, and comments where needed.

// Files already included:
// - Login.java
// - Connn.java
// - Signup.java

// The following files will be appended in sequence next:
// - Signup2.java
// - Signup3.java
// - main_Class.java
// - Deposit.java
// - Withdrawl.java
// - FastCash.java
// - BalanceEnquiry.java
// - mini.java
// - Pin.java

// Each file will follow Java conventions and include PreparedStatement usage for SQL operations.

// --- File: Signup2.java ---
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox<String> comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPan, textAadhar;
    JRadioButton r1, r2, e1, e2;
    JButton next;
    String formno;

    Signup2(String formno) {
        super("APPLICATION FORM - PAGE 2");
        this.formno = formno;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel label1 = new JLabel("Page 2: Additional Details");
        label1.setFont(new Font("Raleway", Font.BOLD, 22));
        label1.setBounds(300, 40, 600, 40);
        add(label1);

        JLabel l3 = new JLabel("Religion:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 120, 100, 30);
        add(l3);
        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        comboBox = new JComboBox<>(religion);
        comboBox.setBounds(300, 120, 400, 30);
        add(comboBox);

        JLabel l4 = new JLabel("Category:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 170, 100, 30);
        add(l4);
        String category[] = {"General", "OBC", "SC", "ST", "Other"};
        comboBox2 = new JComboBox<>(category);
        comboBox2.setBounds(300, 170, 400, 30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income:");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100, 220, 100, 30);
        add(l5);
        String income[] = {"Null", "<1,50,000", "<2,50,000", "5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        comboBox3 = new JComboBox<>(income);
        comboBox3.setBounds(300, 220, 400, 30);
        add(comboBox3);

        JLabel l6 = new JLabel("Education:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100, 270, 150, 30);
        add(l6);
        String education[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        comboBox4 = new JComboBox<>(education);
        comboBox4.setBounds(300, 270, 400, 30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 320, 150, 30);
        add(l7);
        String occupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        comboBox5 = new JComboBox<>(occupation);
        comboBox5.setBounds(300, 320, 400, 30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 370, 150, 30);
        add(l8);
        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD, 14));
        textPan.setBounds(300, 370, 400, 30);
        add(textPan);

        JLabel l9 = new JLabel("Aadhar Number:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100, 420, 180, 30);
        add(l9);
        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        textAadhar.setBounds(300, 420, 400, 30);
        add(textAadhar);

        JLabel l10 = new JLabel("Senior Citizen:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 470, 180, 30);
        add(l10);
        r1 = new JRadioButton("Yes");
        r1.setBounds(300, 470, 100, 30);
        r1.setBackground(Color.WHITE);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setBounds(400, 470, 100, 30);
        r2.setBackground(Color.WHITE);
        add(r2);
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(r1);
        seniorGroup.add(r2);

        JLabel l11 = new JLabel("Existing Account:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 520, 180, 30);
        add(l11);
        e1 = new JRadioButton("Yes");
        e1.setBounds(300, 520, 100, 30);
        e1.setBackground(Color.WHITE);
        add(e1);
        e2 = new JRadioButton("No");
        e2.setBounds(400, 520, 100, 30);
        e2.setBackground(Color.WHITE);
        add(e2);
        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(e1);
        accGroup.add(e2);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 600, 100, 30);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = textPan.getText();
        String aadhar = textAadhar.getText();
        String scitizen = r1.isSelected() ? "Yes" : "No";
        String eAccount = e1.isSelected() ? "Yes" : "No";

        if (pan.equals("") || aadhar.equals("")) {
            JOptionPane.showMessageDialog(null, "Fill all the required fields");
        } else {
            try {
                Connn c = new Connn();
                String q = "INSERT INTO signuptwo VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = c.connection.prepareStatement(q);
                pstmt.setString(1, formno);
                pstmt.setString(2, rel);
                pstmt.setString(3, cate);
                pstmt.setString(4, inc);
                pstmt.setString(5, edu);
                pstmt.setString(6, occ);
                pstmt.setString(7, pan);
                pstmt.setString(8, aadhar);
                pstmt.setString(9, scitizen);
                pstmt.setString(10, eAccount);
                pstmt.executeUpdate();
                pstmt.close();
                c.connection.close();
                setVisible(false);
                new Signup3(formno);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
