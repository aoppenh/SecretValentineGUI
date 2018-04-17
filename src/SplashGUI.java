import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Andyo on 12/25/2016.
 */
public class SplashGUI extends JFrame {
    private JPanel formPanel;
    private JLabel imgLabel;
    private Container cPane;
    BufferedImage img = ImageIO.read(new File("C:\\Users\\Andyo\\SecretSantaGUI\\src\\SecretSantaGUI.jpg"));

    public SplashGUI(String title) throws IOException {
        this.setTitle(title);
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setResizable(false);
        cPane = this.getContentPane();
        cPane.add(formPanel);
        formPanel.setBackground(new Color(img.getRGB(428, 602), true));
        imgLabel.setIcon(new ImageIcon("C:\\Users\\Andyo\\SecretSantaGUI\\src\\SecretSantaGUI.jpg"));
    }
}
