import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 4/19/2018
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
    private JButton importFileButton;
    private JLabel imgLabel2;
    private JLabel imgLabel1;
    private Container cPane;
    private Color customColor = new Color(72,187,47);

    public AddPeopleGUI(String title, String list) {
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
        addedPeople.setEnabled(true);
        addedPeople.setText(list);
        addedPeople.setDisabledTextColor(customColor);
        exitButton.setPreferredSize(new Dimension(140, 70));
        randomizeButton.setPreferredSize(new Dimension(140, 70));
        addPersonButton.setPreferredSize(new Dimension(140, 70));
        importFileButton.setPreferredSize(new Dimension(140, 70));
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
                if (Model.counter == 0) {
                    addedPeople.setText(addedPeople.getText() + addPersonBox.getText());
                } else {
                    addedPeople.setText(addedPeople.getText() + "\n" + addPersonBox.getText());
                }
                Model.counter++;
                Model.counterAdded++;
                addPersonBox.setText("Enter Name ...");
            }
        });
        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] temp = addedPeople.getText().split("\n");
                for (String str : temp) {
                    Model.people.add(new Person(str, false, false));
                }
                Model.setPeopleAndAssignments();
                dispose();
                new RandomizedGUI("Secret Santa");
            }
        });
        importFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Model.tempDisplayString = addedPeople.getText();
                    new ImportFileGUI("Secret Santa");
                    dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    new ErrorGUI("Secret Santa Error", "An Error Occurred");
                }
            }
        });
    }

//    public static void main(String[] args) {
//        new AddPeopleGUI("Secret Santa");
//    }
}
