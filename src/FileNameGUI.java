import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 4/19/2018
 */
public class FileNameGUI extends JFrame {
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JLabel secretSantaLabel;
    private JTextField saveFileBox;
    private JButton finalizeButton;
    private JButton exitButton;
    private JLabel instructionsLabel;
    private Container cPane;

    public FileNameGUI(String title) {
        cPane = this.getContentPane();
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setLocation(663, 243);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cPane.add(formPanel);
        finalizeButton.setPreferredSize(new Dimension(140, 70));
        exitButton.setPreferredSize(new Dimension(140, 70));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        finalizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean test = true;
                Model.f = new File(Model.desktop.getPath());
                Model.fileName = saveFileBox.getText() + ".txt";
                Model.newFile = new File(Model.desktop, Model.fileName);
//                Model.newFile = new File(Model.path + "\\" + Model.fileName);
                try {
                    File[] files = Model.f.listFiles();
                    for (File f : files) {
                        if (Model.fileName.equals(f.getName()) && !f.isDirectory()) {
                            test = false;
                            new ErrorGUI("Secret Santa Error", "File Already Exists");
                            saveFileBox.setText("Enter a File Name ...");
                            break;
                        }
                    }
                    if (test) {
                        Model.newFile.createNewFile();
                        Model.saveBuilder = new StringBuilder();
                        Model.saveString = "";
                        for (Map.Entry<Person, Person> p : Model.peopleAndAssignments.entrySet()) {
                            Model.saveBuilder.append(p.getKey().getName() + " will get a valentine for " + p.getValue().getName() + "\n");
                        }
                        Model.save();
                        dispose();
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    new ErrorGUI("Secret Santa Error", "File Creation Error");
                } catch (IOException e1) {
                    e1.printStackTrace();
                    new ErrorGUI("Secret Santa Error", "An Error Occurred");
                }
            }
        });
    }
}
