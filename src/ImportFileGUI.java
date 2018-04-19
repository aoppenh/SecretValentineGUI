import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 4/19/2018
 */
public class ImportFileGUI extends JFrame {
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JLabel secretSantaLabel;
    private JTextField importFileBox;
    private JButton importButton;
    private JButton exitButton;
    private JLabel instructionsLabel;
    private Container cPane;

    public ImportFileGUI(String title) {
        cPane = this.getContentPane();
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setLocation(663, 243);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cPane.add(formPanel);
        importButton.setPreferredSize(new Dimension(140, 70));
        exitButton.setPreferredSize(new Dimension(140, 70));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddPeopleGUI("Secret Santa", "");
            }
        });
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.importFileName = importFileBox.getText() + ".txt";
                try {
                    Model.importFile();
                    new AddPeopleGUI("Secret Santa", Model.importDisplayString);
                    dispose();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    new ErrorGUI("Secret Santa Error", "File Not Found");
                }
            }
        });
    }
}
