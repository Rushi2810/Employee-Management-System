package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,400);
        add(image);

        // Configure JFrame
        setSize(600, 400);  // Smaller window size
        setLayout(null);
        setLocationRelativeTo(null);   // Center the window on the screen
        setVisible(true);

        try{
            Thread.sleep(4700);
            setVisible(false);
            new Login();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();

    }
}
