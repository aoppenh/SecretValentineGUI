import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Andyo on 12/25/2016.
 * Version 4/18/2018
 */
public class RandomizedGUI extends JFrame {
    private Container cPane;
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JLabel secretSantaLabel;
    private JTextArea santaAssignments;
    private JTextArea santaAssigned;
    private JButton reDoButton;
    private JButton exitButton;
    private JLabel imgLabel1;
    private JLabel imgLabel2;
    private JButton saveButton;
    private StringBuilder randomList1;
    private StringBuilder randomList2;
    private String randomDisplayString1;
    private String randomDisplayString2;

    public RandomizedGUI(String title) {
        cPane = this.getContentPane();
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cPane.add(formPanel);
        reDoButton.setPreferredSize(new Dimension(140, 70));
        exitButton.setPreferredSize(new Dimension(140, 70));
        saveButton.setPreferredSize(new Dimension(140, 70));
        imgLabel1.setIcon(new ImageIcon("src\\santa-160903__340.png"));
        imgLabel2.setIcon(new ImageIcon("src\\santa-160903__340.png"));
        randomList1 = new StringBuilder();
        randomList2 = new StringBuilder();
        randomDisplayString1 = "";
        randomDisplayString2 = "";
        for (Map.Entry<Person, Person> p : Model.peopleAndAssignments.entrySet()) {
            String person = p.getKey().getName();
            String assignment = p.getValue().getName();
            randomList1.append(person);
            randomList1.append("\n");
            randomList2.append(assignment);
            randomList2.append("\n");
        }
        santaAssignments.setText(randomList1.toString());
        santaAssigned.setText(randomList2.toString());
        Model.list = santaAssignments.getText();
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        reDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomList1 = new StringBuilder();
                randomList2 = new StringBuilder();
                randomDisplayString1 = "";
                randomDisplayString2 = "";
                santaAssignments.setText("");
                santaAssigned.setText("");
                Model.people = new ArrayList<>();
                String[] temp = santaAssignments.getText().split("\n");
                for (String str : temp) {
                    Model.people.add(new Person(str, false, false));
                }
                Model.setPeopleAndAssignments();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new FileNameGUI("Secret Santa");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    new ErrorGUI("Secret Santa Error", "An Error Occurred");
                }
            }
        });
    }
}
