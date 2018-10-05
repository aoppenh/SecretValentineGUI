import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/05/2018
 */
public class DeletePeopleGUI extends JFrame {
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JLabel secretSantaLabel;
    private JTextField importFileBox;
    private JButton deleteButton;
    private JButton doneButton;
    private JLabel instructionsLabel;
    private JComboBox personList;
    private Container cPane;

    public DeletePeopleGUI(String title) {
        cPane = this.getContentPane();
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setLocation(663, 243);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cPane.add(formPanel);
        deleteButton.setPreferredSize(new Dimension(140, 70));
        doneButton.setPreferredSize(new Dimension(140, 70));

        for (Person p : Model.tempPeople) {
            personList.addItem(p.getName());
        }

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strTemp = "";
                for (Person p : Model.tempPeople) {
                    strTemp += p.getName() + "\n";
                }
                new AddPeopleGUI("Secret Valentine", strTemp);
                dispose();

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.tempPeople.remove(personList.getSelectedIndex());
                new DeletePeopleGUI("Secret Valentine");
                dispose();
            }
        });
    }
}
