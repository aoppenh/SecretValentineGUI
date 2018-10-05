import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/04/2018
 */
public class AddPeopleGUI extends JFrame {
    static ArrayList<Person> tempPeople = new ArrayList<>();
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JTextArea addedPeople;
    private JScrollPane addScroll;
    private JButton addPersonButton;
    private JTextField addPersonBox;
    private JButton exitButton;
    private JButton randomizeButton;
//    private JButton importFileButton;
    private JLabel imgLabel2;
    private JLabel imgLabel1;
    private JLabel imgLabel3;
    private JLabel imgLabel4;
    private JComboBox addPrefBox;
    private JButton deletePersonButton;
    private Container cPane;
    private Color customColor = new Color(72,187,47);

    public AddPeopleGUI(String title, String list) {
        Model.counterAdded = 0;
        cPane = this.getContentPane();
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cPane.add(formPanel);
        addPersonBox.setText("Enter Name ...");
        addedPeople.setEnabled(true);
        addScroll.setPreferredSize(new Dimension(1326, 800));
        addedPeople.setText(list);
        addedPeople.setDisabledTextColor(customColor);
        exitButton.setPreferredSize(new Dimension(140, 70));
        randomizeButton.setPreferredSize(new Dimension(140, 70));
        addPersonButton.setPreferredSize(new Dimension(140, 70));
        deletePersonButton.setPreferredSize(new Dimension(140, 70));
//        importFileButton.setPreferredSize(new Dimension(140, 70));
        imgLabel1.setIcon(new ImageIcon("src\\santa-160903__340.png"));
        imgLabel2.setIcon(new ImageIcon("src\\santa-160903__340.png"));
        imgLabel3.setIcon(new ImageIcon("src\\snowman-160884__340.png"));
        imgLabel4.setIcon(new ImageIcon("src\\snowman-160884__340.png"));
        addPersonBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPersonBox.setText("");
            }
        });
        addPrefBox.addItem("Straight - Male");
        addPrefBox.addItem("Straight - Female");
        addPrefBox.addItem("Homosexual");
        addPrefBox.addItem("Lesbian");
        addPrefBox.addItem("Bisexual");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.tempDisplayString = "";
                String[] temp = addedPeople.getText().split("\n");
                if (Model.counterAdded != temp.length) {
                    Model.counterAdded = temp.length;
                } else if (temp.length == 0) {
                    Model.counter = 0;
                }
                String strTemp = addedPeople.getText() + addPersonBox.getText() + "\n";
                String[] strLines = strTemp.split("\n");
                Model.counter = strLines.length;
                addedPeople.setText(addedPeople.getText() + addPersonBox.getText() + "\n");
                Model.counter++;
                Model.counterAdded++;
                Preference tempP = Preference.DEFAULT;
                switch (addPrefBox.getSelectedIndex()) {
                    case 0:
                        tempP = Preference.STRAIGHT_MALE;
                        break;
                    case 1:
                        tempP = Preference.STRAIGHT_FEMALE;
                        break;
                    case 2:
                        tempP = Preference.HOMOSEXUAL;
                        break;
                    case 3:
                        tempP = Preference.LESBIAN;
                        break;
                    case 4:
                        tempP = Preference.BISEXUAL;
                        break;
                }
                tempPeople.add(new Person(addPersonBox.getText(), false, false, tempP));
                addPersonBox.setText("Enter Name ...");
                addPrefBox.setSelectedIndex(0);
            }
        });
        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                for (Person p : tempPeople) {
                    Model.people.add(p);
                    i++;
                }
                Model.setPeopleAndAssignments();
                dispose();
                new RandomizedGUI("Secret Santa");
            }
        });
        // May re-add the below functionality later
//        importFileButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Model.tempDisplayString = addedPeople.getText();
//                    new ImportFileGUI("Secret Santa");
//                    dispose();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                    new ErrorGUI("Secret Santa Error", "An Error Occurred");
//                }
//            }
//        });
    }

//    public static void main(String[] args) {
//        new AddPeopleGUI("Secret Santa");
//    }
}
