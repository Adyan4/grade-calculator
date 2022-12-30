import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Objects;


public class CreateScreen extends BaseScreen {

    JButton goBack;
    JButton theAnswer;
    JTextField[] assignmentList;
    JTextField[] gradeList;
    JTextField[] weightList;
    JTextField answerText;
    JButton saveClass;
    JTextField classText;




    CreateScreen() {

        // Title
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Calculate Your Grade!");
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 35));
        welcomeLabel.setBounds(400, -10, 500, 100);
        this.add(welcomeLabel);


        // Back Button
        goBack = new JButton("← Back");
        goBack.setBounds(20, 10, 110, 30);
        goBack.setFocusable(false);
        goBack.setBackground(Color.white);
        goBack.addActionListener(this);
        this.add(goBack);

        // Class Name
        JLabel classLabel = new JLabel();
        classLabel.setText("Class Name:");
        classLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        classLabel.setBounds(400, 50, 100, 100);
        this.add(classLabel);


        // Assignment Name
        JLabel assignmentLabel = new JLabel();
        assignmentLabel.setText("Assignment");
        assignmentLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        assignmentLabel.setBounds(200, 100, 100, 100);
        this.add(assignmentLabel);


        // Grade Name
        JLabel gradeLabel = new JLabel();
        gradeLabel.setText("Grade (%)");
        gradeLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        gradeLabel.setBounds(600, 100, 100, 100);
        this.add(gradeLabel);


        // Weight Name
        JLabel weightLabel = new JLabel();
        weightLabel.setText("Weight (%)");
        weightLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        weightLabel.setBounds(1000, 100, 100, 100);
        this.add(weightLabel);


        // Class Name Text-Field
        classText = new JTextField();
        classText.setBounds(525, 92, 150, 20);
        classText.addActionListener(this);
        this.add(classText);


        // Assignment Text-Field
        int assignmentY = 0;
        assignmentList = new JTextField[12];

        for (int i = 0; i < 12; i++) {
            JTextField assignmentText = new JTextField();
            if (i == 0) {assignmentY += 175;}
            else {assignmentY += 35;}

            assignmentText.setBounds(200, assignmentY, 100, 20);
            assignmentList[i] = assignmentText;
            this.add(assignmentText);
        }

        // Grade Text-Field
        int gradeY = 0;
        gradeList = new JTextField[12];

        for (int i = 0; i < 12; i++) {
            JTextField gradeText = new JTextField();
            if (i == 0) {gradeY += 175;}
            else {gradeY += 35;}

            gradeText.setBounds(600, gradeY, 100, 20);
            gradeList[i] = gradeText;
            this.add(gradeText);
        }

        // Weight Text-Field
        int weightY = 0;
        weightList = new JTextField[12];

        for (int i = 0; i < 12; i++) {
            JTextField weightText = new JTextField();
            if (i == 0) {weightY += 175;}
            else {weightY += 35;}

            weightText.setBounds(1000, weightY, 100, 20);
            weightList[i] = weightText;
            this.add(weightText);
        }

        // Calculating the Answer
        theAnswer = new JButton("Calculate");
        theAnswer.setBounds(400, 610, 110, 30);
        theAnswer.setFocusable(false);
        theAnswer.setBackground(Color.white);
        theAnswer.addActionListener(this);
        this.add(theAnswer);

        // Where the answer shows up
        answerText = new JTextField();
        answerText.setBounds(600, 610, 150, 30);
        answerText.setEditable(false);
        this.add(answerText);

        // Initializing Save Button
        saveClass = new JButton("Save");
        saveClass.setBounds(1150, 10, 110, 30);
        saveClass.setFocusable(false);
        saveClass.setBackground(Color.white);
        saveClass.addActionListener(this);
        this.add(saveClass);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Going Back
        if (e.getSource() == goBack) {
            JFrame titleScreen = new TitleScreen();
            this.setVisible(false);
            titleScreen.setVisible(true);
        }

        // Calculate Button
        if (e.getSource() == theAnswer) {

            // If weight is over 100 or below 0
            if (Objects.equals(getAnswer(gradeList, weightList), "Weight is incorrect")) {
                JOptionPane.showMessageDialog(null, "Invalid. Weighting is over 100 or below 0!", "Invalid", JOptionPane.WARNING_MESSAGE);
            }

            // If grade and weight are not both filled
            else if (Objects.equals(getAnswer(gradeList, weightList), "Both sides not filled")) {
                JOptionPane.showMessageDialog(null, "Invalid. Both the grade and weight need to be filled!", "Invalid", JOptionPane.WARNING_MESSAGE);
            }

            // If boxes are empty
            else if (Objects.equals(getAnswer(gradeList, weightList), "Fill the boxes!")) {
                JOptionPane.showMessageDialog(null, "Fill the boxes!!!", "Invalid", JOptionPane.WARNING_MESSAGE);
            }

            // If letters or other char appears
            else if (Objects.equals(getAnswer(gradeList, weightList), "No Characters")) {
                JOptionPane.showMessageDialog(null, "Invalid. No Characters!", "Invalid", JOptionPane.WARNING_MESSAGE);
            }

            // Everything is normal
            else {
                answerText.setText(getAnswer(gradeList, weightList));
            }
        }

        // Save Button
        if (e.getSource() == saveClass) {

            // If text is blank
            if (classText.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Error: Must put a class name!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            // Saving the File
            else {
                try {
                    FileOutputStream file = new FileOutputStream(classText.getText() + ".dat");
                    BufferedOutputStream buffer = new BufferedOutputStream(file);
                    ObjectOutputStream output = new ObjectOutputStream(buffer);

                    DataStorage storage = new DataStorage();
                    storage.assignmentList = assignmentList;
                    storage.gradeList = gradeList;
                    storage.weightList = weightList;
                    storage.classText = classText;

                    output.writeObject(storage);
                    output.close();

                }

                catch (IOException error) {
                    error.printStackTrace();
                }
            }

        }


    }

    // Method to get the calculated grade
    public String getAnswer(JTextField[] gradeList, JTextField[] weightList) {
        float answer = 0;
        float finalWeight = 0;

        try {
        // Going through each grade/weight
        for (int i = 0; i < gradeList.length; i++) {

            // Both text-fields need to filled out
            if (!gradeList[i].getText().isBlank() && !weightList[i].getText().isBlank()) {
                float grade = Float.parseFloat(gradeList[i].getText());
                grade = grade / 100;

                float weight = Float.parseFloat(weightList[i].getText());
                finalWeight += weight;

                answer += grade * weight;
            }

            // Skips over text fields when both are empty
            else if (gradeList[i].getText().isBlank() && weightList[i].getText().isBlank()) {

            }

            // Both sides are not filled
            else if (gradeList[i].getText().isBlank() || weightList[i].getText().isBlank()) {
                return "Both sides not filled";
            }
        }

        // Weight isn't between 0-100
        if (finalWeight < 0 || finalWeight > 100) {
            return "Weight is incorrect";
        }

        // Weight is empty / == 0
        if (finalWeight == 0) {
            return "Fill the boxes!";
        }

        // If the final weight is not complete
        if (finalWeight != 100) {
            answer /= finalWeight;
            answer *= 100;
        }
        return Float.toString(answer);
        }

        // If random char appears
        catch (NumberFormatException e) {
            return "No Characters";
        }

    }


}




