import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 */
public class ErrorGUI extends JFrame {
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JLabel centerLabel;
    private JLabel secretSantaLabel;
    private JButton OKButton;
    private Container cPane;

    public static void main(String[] args) {
        new ErrorGUI("Secret Santa Error", "TESTING ERROR MESSAGE");
    }

    public ErrorGUI(String title, String message) {
        cPane = this.getContentPane();
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(600, 400);
        this.setLocation(663, 343);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cPane.setLocation(this.getHeight(), this.getWidth());
        cPane.add(formPanel);
        centerLabel.setText(message);
        OKButton.setPreferredSize(new Dimension(140, 70));
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
