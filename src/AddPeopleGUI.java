import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andyo on 12/25/2016.
 */
public class AddPeopleGUI extends JFrame {
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JTextArea addedPeople;
    private JButton addPersonButton;
    private JTextField addPersonBox;
    private JButton exitButton;
    private JButton randomizeButton;
    private JButton removePersonButton;
    private JPanel middlePanel;
    private JLabel imgLabel2;
    private JLabel imgLabel1;
    private Container cPane;

    public AddPeopleGUI(String title) {
        Model.counter = 0;
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
        bottomPanel.remove(removePersonButton);
        removePersonButton.setPreferredSize(new Dimension(140, 70));
        exitButton.setPreferredSize(new Dimension(140, 70));
        randomizeButton.setPreferredSize(new Dimension(140, 70));
        addPersonButton.setPreferredSize(new Dimension(140, 70));
        imgLabel1.setIcon(new ImageIcon("src\\santa-160903__340.png"));
        imgLabel2.setIcon(new ImageIcon("src\\santa-160903__340.png"));
        addPersonBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPersonBox.setText("");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        removePersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addedPeople.setEnabled(true);
            }
        });
        addPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(Model.counterAdded == 13)) {
                    if (Model.counter == 0) {
                        addedPeople.setText(addedPeople.getText() + addPersonBox.getText());
                    } else {
                        addedPeople.setText(addedPeople.getText() + "\n" + addPersonBox.getText());
                    }
                    Model.counter++;
                    Model.counterAdded++;
                    addPersonBox.setText("Enter Name ...");
                } else {
                    new ErrorGUI("Secret Santa Error", "Maximum Capacity Reached");
                }
            }
        });
        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] temp = addedPeople.getText().split("\n");
                int j = 0;
                for (String str : temp) {
                    Model.people.add(new Person(str, false, false));
                    j++;
                }
                Model.setPeopleAndAssignments();
                dispose();
                new RandomizedGUI("Secret Santa");
            }
        });
    }

    public static void main(String[] args) {
        new AddPeopleGUI("Secret Santa");
    }
}
