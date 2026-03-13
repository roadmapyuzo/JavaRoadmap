import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CountDownLatchClass {

    private static CountDownLatch latch = new CountDownLatch(3);


    ///  count down latch is similar to cyclic barriers, the main differences are:
    /// - countdownlatch is not reusable
    /// - you have more flexibility due to separation of aweit and countdown functions, you can have one function decreasing the counter and another function waiting
    /// - you can have more than one function waiting

    public void run() {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        Runnable r1 = () -> {

            System.out.println("Printing");
            latch.countDown();

        };

        Runnable r2 = () -> {

            await();
            System.out.println("Function 1 after await");

        };

        Runnable r3 = () -> {

            await();
            System.out.println("Function 2 after await");

        };

        executor.scheduleAtFixedRate(r1, 0, 2, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(r2, 0, 2, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(r3, 0, 2, TimeUnit.SECONDS);


    }

    ///  if you want to create a loop you need to start another countdown at some point

    private static void await() {
       try {
           latch.await();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

}
