package employee.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;


public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEMPID;

    JButton delete, back;

    RemoveEmployee(){

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 50, 150, 30); // Adjusted width to 150
        label.setFont(new Font("Tahoma", Font.BOLD,15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,55, 150,30);
        add(choiceEMPID);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMPID.add(resultSet.getString("empID"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 100, 150, 30); // Adjusted width to 150
        labelName.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,100,30);
        textName.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50, 150, 150, 30); // Adjusted width to 150
        labelPhone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,100,30);
        textPhone.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(textPhone);


        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 200, 150, 30); // Adjusted width to 150
        labelEmail.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,150,30);
        textEmail.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(textEmail);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empID = '"+choiceEMPID.getSelectedItem()+"' ");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empID = '"+choiceEMPID.getSelectedItem()+"' ");
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));

                    }

                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.DARK_GRAY);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(600,80,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(920,630,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,920,630);
        add(image);




        setSize(900,400);
        setLayout(null);
        setLocation(200,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete){
            try{
                conn c = new conn();
                String query = "delete from employee where empID= '"+choiceEMPID.getSelectedItem()+"' ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee's Detail Deleted Sucessfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
