import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;


public class EditScreen extends BaseScreen {

    JButton goBack;
    String[] datNames;
    JLabel[] classList;
    JButton[] loadList;
    JButton[] deleteList;
    CreateScreen createScreen;

    EditScreen() {

        // Title
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Edit");
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 35));
        welcomeLabel.setBounds(580, -10, 500, 100);
        this.add(welcomeLabel);


        // Back Button
        goBack = new JButton("← Back");
        goBack.setBounds(20, 10, 110, 30);
        goBack.setFocusable(false);
        goBack.setBackground(Color.white);
        goBack.addActionListener(this);
        this.add(goBack);

        // Requirements for UI:
        // Y: 100 to start, 35 each time, stop at 595(18x)
        // X: 20, 120, 200. 320, 420, 500

        // Finding the dat files and transferring them to a list
        String[] pathNames;
        String dir = System.getProperty("user.dir");
        File f = new File(dir);
        pathNames = f.list();
        datNames = new String[pathNames.length];
        int datIteration = 0;
        for (String pathName : pathNames) {
            if (pathName.endsWith(".dat")) {
                datNames[datIteration] = pathName;
                datIteration+=1;
            }
        }

        // Class Name On Screen
        int classX = 20;
        int classY = 100;
        classList = new JLabel[datNames.length]; // Setting the list

        // All the class names showing up
        for (int i = 0; i < datNames.length; i++) {
            if (datNames[i] == null) {
                break;
            }
            String className = datNames[i];
            className = className.replace(".dat", "");
            JLabel classLabel = new JLabel(className);
            classLabel.setFont(new Font("Verdana", Font.BOLD, 15));
            classLabel.setBounds(classX, classY, 110, 30);
            classList[i] = classLabel;
            if (classY == 595) {
                classY = 100;
                classX += 300;
            }
            else {
                classY += 35;
            }
            this.add(classLabel);
        }



        // Load Button on Screen
        int loadX = 120;
        int loadY = 100;
        loadList = new JButton[datNames.length];

        // All the load buttons showing up
        for (int i = 0; i < datNames.length; i++) {
            if (datNames[i] == null) {
                break;
            }
            JButton loadButton = new JButton("✔");
            loadButton.setBounds(loadX, loadY, 70, 30);
            loadButton.setFocusable(false);
            loadButton.setBackground(Color.white);
            loadButton.addActionListener(this);
            loadList[i] = loadButton;
            if (loadY == 595) {
                loadY = 100;
                loadX += 300;
            }
            else {
                loadY += 35;
            }
            this.add(loadButton);
        }



        // Delete Button on Screen
        int deleteX = 200;
        int deleteY = 100;
        deleteList = new JButton[datNames.length];

        // All the delete buttons showing up
        for (int i = 0; i < datNames.length; i++) {
            if (datNames[i] == null) {
                break;
            }
            JButton deleteButton = new JButton("X");
            deleteButton.setBounds(deleteX, deleteY, 70, 30);
            deleteButton.setFocusable(false);
            deleteButton.setBackground(Color.white);
            deleteButton.addActionListener(this);
            deleteList[i] = deleteButton;
            if (deleteY == 595) {
                deleteY = 100;
                deleteX += 300;
            }
            else {
                deleteY += 35;
            }
            this.add(deleteButton);
        }




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Going Back
        if (e.getSource() == goBack) {
            JFrame titleScreen = new TitleScreen();
            this.setVisible(false);
            titleScreen.setVisible(true);
        }

        // Loading
        for (int i = 0; i < loadList.length; i++) {
            if (e.getSource() == loadList[i]) {
                try {
                    FileInputStream file = new FileInputStream(datNames[i]);
                    BufferedInputStream buffer = new BufferedInputStream(file);
                    ObjectInputStream output = new ObjectInputStream(buffer);

                    DataStorage storage = (DataStorage) output.readObject();
                    this.createScreen = new CreateScreen();

                    // Setting text for loading
                    for (int j = 0; j < storage.assignmentList.length; j++) {
                        createScreen.assignmentList[j].setText(storage.assignmentList[j].getText());
                        createScreen.gradeList[j].setText(storage.gradeList[j].getText());
                        createScreen.weightList[j].setText(storage.weightList[j].getText());
                    }
                    createScreen.classText.setText(storage.classText.getText());

                    output.close();
                    createScreen.setVisible(true);
                    this.setVisible(false);
                }

                catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                catch(ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }

        // Deleting
        for (int i = 0; i < deleteList.length; i++) {
            if (e.getSource() == deleteList[i]) {
                int confirm = JOptionPane.showOptionDialog(null, "Are you sure you want to delete?", "Delete Class",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                if (confirm == JOptionPane.YES_OPTION) {
                    classList[i].setVisible(false);
                    loadList[i].setVisible(false);
                    deleteList[i].setVisible(false);
                    File deletedFile = new File(datNames[i]);
                    deletedFile.delete();
                }
            }
        }

    }

}
