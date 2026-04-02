import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;

public class SynchronousQueues {

    private final SynchronousQueue<String> queue = new SynchronousQueue<>();

    ///  Synchronous queue creates a queue where to an action to be executed, its needed 2 threads, one
    ///  putting something, and one taking something
    public void execute() {

        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {

            put();
            System.out.println("Item 1 was put in the list");

        };

        Runnable r2 = () -> {

            String msg = take();
            System.out.println("An item was received: " + msg);

        };

        executor.execute(r1);
        executor.execute(r2);

        executor.shutdown();


    }

    public void put() {

        try {
            queue.put("Item 1");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String take() {

        try {
            return queue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
