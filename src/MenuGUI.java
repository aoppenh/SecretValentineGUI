import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/04/2018
 */
public class MenuGUI extends JFrame {
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton addButton;
    private JButton exitButton;
    private JLabel secretSantaLabel;
    private JPanel middlePanel;
    private JLabel imgLabel;
    private JLabel imgLabel1;
    private JLabel imgLabel2;
    private JLabel imgLabel3;
    private JLabel imgLabel4;
    private JLabel imgLabel5;
    private JLabel imgLabel6;
    private JLabel imgLabel7;
    private JLabel imgLabel8;
    private Container cPane;

    public MenuGUI(String title) {
        cPane = this.getContentPane();
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cPane.add(formPanel);
        addButton.setPreferredSize(new Dimension(70, 70));
        exitButton.setPreferredSize(new Dimension(70, 70));
        imgLabel.setIcon(new ImageIcon("src\\4_filled_hearts.png"));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddPeopleGUI("Secret Santa", "");
            }
        });
    }
}
