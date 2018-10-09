import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/09/2018
 */
public class AddPeopleGUI extends JFrame {
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
        imgLabel3.setIcon(new ImageIcon("src\\4_filled_hearts.png"));
        imgLabel4.setIcon(new ImageIcon("src\\4_filled_hearts.png"));
        addPersonBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPersonBox.setText("");
            }
        });
        addPrefBox.addItem("Straight - Male");
        addPrefBox.addItem("Straight - Female");
        addPrefBox.addItem("Gay");
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
                        tempP = Preference.GAY;
                        break;
                    case 3:
                        tempP = Preference.LESBIAN;
                        break;
                    case 4:
                        tempP = Preference.BISEXUAL;
                        break;
                }
                Model.tempPeople.add(new Person(addPersonBox.getText(), false, false, tempP));
                addPersonBox.setText("Enter Name ...");
                addPrefBox.setSelectedIndex(0);
            }
        });
        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Model.tempPeople.size() > 1) {
                    int i = 0;
                    for (Person p : Model.tempPeople) {
                        Model.people.add(p);
                        i++;
                    }
                    Model.setPeopleAndAssignments();
                    dispose();
                    new RandomizedGUI("Secret Santa");
                } else {
                    new ErrorGUI("Secret Valentine Error", "Not enough people.");
                }
            }
        });
        deletePersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DeletePeopleGUI("Secret Valentine");
            }
        });
    }
}
