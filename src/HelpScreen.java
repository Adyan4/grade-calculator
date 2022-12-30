import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HelpScreen extends BaseScreen {

    JButton goBack;

    HelpScreen() {

        // Title
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("How to Use!");
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 35));
        welcomeLabel.setBounds(500, -10, 500, 100);
        this.add(welcomeLabel);


        // Back Button
        goBack = new JButton("← Back");
        goBack.setBounds(20, 10, 110, 30);
        goBack.setFocusable(false);
        goBack.setBackground(Color.white);
        goBack.addActionListener(this);
        this.add(goBack);

        // Introduction
        JLabel introLabel = new JLabel();
        introLabel.setText("Welcome to Grade Calculator! Here is how to use it...");
        introLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        introLabel.setBounds(400, 50, 500, 100);
        this.add(introLabel);

        // Create Screen
        JLabel createLabel = new JLabel();
        createLabel.setText("Create Class: ");
        createLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        createLabel.setBounds(50, 125, 500, 100);
        this.add(createLabel);
        JLabel createOne = new JLabel();
        createOne.setText( "- Click the Create Class button to open it up.");
        createOne.setFont(new Font("Verdana", Font.PLAIN, 15));
        createOne.setBounds(50, 150, 500, 100);
        this.add(createOne);
        JLabel createTwo = new JLabel();
        createTwo.setText( "- Set a class name. It will not save without one.");
        createTwo.setFont(new Font("Verdana", Font.PLAIN, 15));
        createTwo.setBounds(50, 175, 500, 100);
        this.add(createTwo);
        JLabel createThree = new JLabel();
        createThree.setText( "- Set an assignment name. This is completely optional.");
        createThree.setFont(new Font("Verdana", Font.PLAIN, 15));
        createThree.setBounds(50, 200, 500, 100);
        this.add(createThree);
        JLabel createFour = new JLabel();
        createFour.setText( "- Set your grade in the grade section. ");
        createFour.setFont(new Font("Verdana", Font.PLAIN, 15));
        createFour.setBounds(50, 225, 500, 100);
        this.add(createFour);
        JLabel createFive = new JLabel();
        createFive.setText( "- Set the weight of the assignment in the weight section.");
        createFive.setFont(new Font("Verdana", Font.PLAIN, 15));
        createFive.setBounds(50, 250, 500, 100);
        this.add(createFive);
        JLabel createSix = new JLabel();
        createSix.setText( "- Press Calculate and your current grade will show up!");
        createSix.setFont(new Font("Verdana", Font.PLAIN, 15));
        createSix.setBounds(50, 275, 500, 100);
        this.add(createSix);
        JLabel createSeven = new JLabel();
        createSeven.setText( "- Press Save to save progress.");
        createSeven.setFont(new Font("Verdana", Font.PLAIN, 15));
        createSeven.setBounds(50, 300, 500, 100);
        this.add(createSeven);
        JLabel createEight = new JLabel();
        createEight.setText( "- If any mistakes occur when calculating, a pop-up will appear.");
        createEight.setFont(new Font("Verdana", Font.PLAIN, 15));
        createEight.setBounds(50, 325, 500, 100);
        this.add(createEight);
        JLabel createNine = new JLabel();
        createNine.setText("- Click the Back button to go back to title screen.");
        createNine.setFont(new Font("Verdana", Font.PLAIN, 15));
        createNine.setBounds(50, 350, 500, 100);
        this.add(createNine);





        // Edit Screen
        JLabel editLabel = new JLabel();
        editLabel.setText("Edit Class: ");
        editLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        editLabel.setBounds(800, 125, 500, 100);
        this.add(editLabel);
        JLabel editOne = new JLabel();
        editOne.setText("- Click the Edit Class button to open it up.");
        editOne.setFont(new Font("Verdana", Font.PLAIN, 15));
        editOne.setBounds(800, 150, 500, 100);
        this.add(editOne);
        JLabel editTwo = new JLabel();
        editTwo.setText("- If you saved previously, your class should show up.");
        editTwo.setFont(new Font("Verdana", Font.PLAIN, 15));
        editTwo.setBounds(800, 175, 500, 100);
        this.add(editTwo);
        JLabel editThree = new JLabel();
        editThree.setText("- Click the checkmark to load/edit your progress.");
        editThree.setFont(new Font("Verdana", Font.PLAIN, 15));
        editThree.setBounds(800, 200, 500, 100);
        this.add(editThree);
        JLabel editFour = new JLabel();
        editFour.setText("- Click the X to delete your progress. A pop-up will show up");
        editFour.setFont(new Font("Verdana", Font.PLAIN, 15));
        editFour.setBounds(800, 225, 500, 100);
        this.add(editFour);
        JLabel editFive = new JLabel();
        editFive.setText("for confirmation.");
        editFive.setFont(new Font("Verdana", Font.PLAIN, 15));
        editFive.setBounds(800, 250, 500, 100);
        this.add(editFive);
        JLabel editSix = new JLabel();
        editSix.setText("- Click the Back button to go back to title screen.");
        editSix.setFont(new Font("Verdana", Font.PLAIN, 15));
        editSix.setBounds(800, 275, 500, 100);
        this.add(editSix);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Going Back
        if (e.getSource() == goBack) {
            JFrame titleScreen = new TitleScreen();
            this.setVisible(false);
            titleScreen.setVisible(true);
        }

    }
}
