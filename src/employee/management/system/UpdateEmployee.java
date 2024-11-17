package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField teducation, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid;
    JButton add, back;
    String number;

    UpdateEmployee(String number){
        this.number = number;
        getContentPane().setBackground(new Color(176, 224,230));

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(255,255,255));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(425,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(255,255,255));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma", Font.BOLD,20));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(425,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(255,255,255));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(255,255,255));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(425,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(255,255,255));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(255,255,255));
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(425,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600,300,150,30);
        teducation.setBackground(new Color(255,255,255));
        add(teducation);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(425,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(255,255,255));
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempid.setForeground(Color.red);
        add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(255,255,255));
        add(tdesignation);

        try{
            conn c = new conn();
            String query = "select * from employee where empID = '"+number+"' ";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhar.setText(resultSet.getString("aadhar"));
                tempid.setText(resultSet.getString("empID"));
                tdesignation.setText(resultSet.getString("designation"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        add = new JButton("UPDATE");

        add.setBounds(450, 470, 150,40);
        add.setBackground(Color.DARK_GRAY);
        add.setForeground(Color.white);
        add(add);
        add.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(250, 470, 150,40);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);



        setSize(900,600);
        setLayout(null);
        setLocation(200,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            System.out.println("Update button clicked");
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try{
                conn c = new conn();
                String query = "update employee set fname= '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"' , email = '"+email+"', education = '"+education+"', designation= '"+designation+"' where empID = '"+number+"' ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details update successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                JOptionPane.showMessageDialog(null, "Error updating details: " + E.getMessage());
            }

        } else {
            setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}