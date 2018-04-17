import java.io.IOException;

/**
 * Created by Andyo on 12/28/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        SplashGUI splg = new SplashGUI("Secret Santa");
        Thread.sleep(5000);
        splg.dispose();
        new MenuGUI("Secret Santa");
    }
}
