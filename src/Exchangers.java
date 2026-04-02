import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class Exchangers {

    private final Exchanger<String> exchanger = new Exchanger<>();


    /// exchanger permits a data exchange between 2 threads
    public void execute() {

        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {

            String msg = "Hello";
            String response = "";

            System.out.println(Thread.currentThread().getName() + " sent: " + msg);

            response = exchange(msg);

            System.out.println(Thread.currentThread().getName() + " received: " + response);

        };

        Runnable r2 = () -> {

            String msg = "Hello too";
            String response = "";

            System.out.println(Thread.currentThread().getName() + " sent: " + msg);

            response = exchange(msg);

            System.out.println(Thread.currentThread().getName() + " received: " + response);


        };

        executor.execute(r1);
        executor.execute(r2);

        executor.shutdown();


    }

    public String exchange(String msg) {

        try {
            return exchanger.exchange(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
