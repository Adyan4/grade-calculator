import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends JFrame implements ActionListener {

    JButton helpButton;
    JButton createButton;
    JButton editButton;


    TitleScreen() {

        /// From Base Screen

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

        /// Not From Base Screen

        // What is shown on the screen

        // Title
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to Grade Calculator!");
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 27));
        welcomeLabel.setBounds(400, 200, 500, 100);
        this.add(welcomeLabel);

        // Help Button
        helpButton = new JButton("Help");
        helpButton.setBounds(570, 350, 110, 30);
        helpButton.setFocusable(false);
        helpButton.setBackground(Color.white);
        helpButton.addActionListener(this);
        this.add(helpButton);

        // Create Button
        createButton = new JButton("Create Class");
        createButton.setBounds(500, 400, 110, 30);
        createButton.setFocusable(false);
        createButton.setBackground(Color.white);
        createButton.addActionListener(this);
        this.add(createButton);

        // Edit Button
        editButton = new JButton("Edit Class");
        editButton.setBounds(640, 400, 110, 30);
        editButton.setFocusable(false);
        editButton.setBackground(Color.white);
        editButton.addActionListener(this);
        this.add(editButton);




    }


    // Action Method
    @Override
    public void actionPerformed(ActionEvent e) {

        // Goes to help screen
        if (e.getSource() == helpButton) {
            JFrame helpScreen = new HelpScreen();
            this.setVisible(false);
            helpScreen.setVisible(true);
        }

        // Goes to create screen
        else if (e.getSource() == createButton) {
            JFrame createScreen = new CreateScreen();
            this.setVisible(false);
            createScreen.setVisible(true);
        }

        // Goes to edit screen
        else if (e.getSource() == editButton) {
            JFrame editScreen = new EditScreen();
            this.setVisible(false);
            editScreen.setVisible(true);
        }

    }
}
