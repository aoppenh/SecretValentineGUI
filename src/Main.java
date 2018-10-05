import java.io.IOException;

/**
 * Created by Andrew Oppenheimer on 12/28/2016.
 * Version 10/04/2018
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        SplashGUI splg = new SplashGUI("Secret Valentine");
        Thread.sleep(5000);
        splg.dispose();
        new MenuGUI("Secret Valentine");
    }
}
