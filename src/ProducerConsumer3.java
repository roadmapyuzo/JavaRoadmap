import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer3 {

    private final BlockingQueue<Integer> list = new LinkedBlockingQueue<>(5);

    ///  Using right tools to resolve racing condition on producer consumer examples
    public void execute() {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        Runnable producer = () -> {

            delaySimulation();
            System.out.println("Producing");
            int number = new Random().nextInt(10);
            try {
                list.put(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        };

        Runnable consumer = () -> {

            delaySimulation();
            System.out.println("Consuming");
            try {
                Integer take = list.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        };

        executor.scheduleWithFixedDelay(producer, 0, 1, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(consumer, 0, 1, TimeUnit.SECONDS);


    }

    public void delaySimulation() {

        try {
            Thread.sleep(new Random().nextInt(10) * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
