import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseScreen extends JFrame implements ActionListener {

    // Base for all screens
    BaseScreen() {
        // Title of Entire Program
        this.setTitle("Grade Calculator");

        // Setting the logo of application
        ImageIcon appImage = new ImageIcon("logo.png");
        this.setIconImage(appImage.getImage());

        // Default Settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.pack();
        this.setSize(1000, 1000);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }





}
