import java.util.ArrayList;
import java.util.List;

public class SynchronizedOnlistRunner implements Runnable {



    public void run() {

        for (int i = 0; i < 100; i++) {
            Main.list.add("Hello");
        }

    }

}
