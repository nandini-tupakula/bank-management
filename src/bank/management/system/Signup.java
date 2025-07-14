package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JTextField textName, textFname, textEmail, textAdd, textcity, textState, textPin;
    JRadioButton r1, r2, m1, m2, m3;
    JDateChooser dateChooser;
    JButton next;
    String formno;

    JPanel panel; // 🔸 Class-level declaration to fix 'cannot find symbol'

    Signup() {
        super("APPLICATION FORM");

        Random ran = new Random();
        formno = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(900, 1000)); // ensures scrolling

        JLabel label1 = new JLabel("APPLICATION FORM NO. " + formno);
        label1.setFont(new Font("Raleway", Font.BOLD, 28));
        label1.setBounds(160, 20, 600, 40);
        panel.add(label1);

        JLabel label2 = new JLabel("Page 1: Personal Details");
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        label2.setBounds(290, 90, 600, 30);
        panel.add(label2);

        JLabel labelName = new JLabel("Name:");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 130, 100, 30);
        panel.add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 130, 400, 30);
        panel.add(textName);

        JLabel labelfName = new JLabel("Father's Name:");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(100, 180, 200, 30);
        panel.add(labelfName);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway", Font.BOLD, 14));
        textFname.setBounds(300, 180, 400, 30);
        panel.add(textFname);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 230, 200, 30);
        panel.add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 230, 400, 30);
        panel.add(dateChooser);

        JLabel labelG = new JLabel("Gender:");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100, 280, 200, 30);
        panel.add(labelG);

        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        r1.setBounds(300, 280, 100, 30);
        r2.setBounds(400, 280, 100, 30);
        r1.setBackground(Color.WHITE);
        r2.setBackground(Color.WHITE);
        panel.add(r1);
        panel.add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 330, 200, 30);
        panel.add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        textEmail.setBounds(300, 330, 400, 30);
        panel.add(textEmail);

        JLabel labelMs = new JLabel("Marital Status:");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100, 380, 200, 30);
        panel.add(labelMs);

        m1 = new JRadioButton("Married");
        m2 = new JRadioButton("Unmarried");
        m3 = new JRadioButton("Other");
        m1.setBounds(300, 380, 100, 30);
        m2.setBounds(400, 380, 100, 30);
        m3.setBounds(500, 380, 100, 30);
        m1.setBackground(Color.WHITE);
        m2.setBackground(Color.WHITE);
        m3.setBackground(Color.WHITE);
        panel.add(m1);
        panel.add(m2);
        panel.add(m3);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(m1);
        maritalGroup.add(m2);
        maritalGroup.add(m3);

        JLabel labelAdd = new JLabel("Address:");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(100, 430, 200, 30);
        panel.add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway", Font.BOLD, 14));
        textAdd.setBounds(300, 430, 400, 30);
        panel.add(textAdd);

        JLabel labelCity = new JLabel("City:");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100, 480, 200, 30);
        panel.add(labelCity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway", Font.BOLD, 14));
        textcity.setBounds(300, 480, 400, 30);
        panel.add(textcity);

        JLabel labelPin = new JLabel("Pin Code:");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100, 530, 200, 30);
        panel.add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.BOLD, 14));
        textPin.setBounds(300, 530, 400, 30);
        panel.add(textPin);

        JLabel labelstate = new JLabel("State:");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelstate.setBounds(100, 580, 200, 30);
        panel.add(labelstate);

        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        textState.setBounds(300, 580, 400, 30);
        panel.add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 640, 80, 30);
        next.addActionListener(this);
        panel.add(next);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setContentPane(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "";
        String email = textEmail.getText();
        String marital = m1.isSelected() ? "Married" : m2.isSelected() ? "Unmarried" : m3.isSelected() ? "Other" : "";
        String address = textAdd.getText();
        String city = textcity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all required fields");
        } else {
            try {
                Connn c = new Connn();
                String query = "INSERT INTO signup VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = c.connection.prepareStatement(query);
                pstmt.setString(1, formno);
                pstmt.setString(2, name);
                pstmt.setString(3, fname);
                pstmt.setString(4, dob);
                pstmt.setString(5, gender);
                pstmt.setString(6, email);
                pstmt.setString(7, marital);
                pstmt.setString(8, address);
                pstmt.setString(9, city);
                pstmt.setString(10, pincode);
                pstmt.setString(11, state);

                pstmt.executeUpdate();
                pstmt.close();
                c.connection.close();

                setVisible(false);
                new Signup2(formno);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
