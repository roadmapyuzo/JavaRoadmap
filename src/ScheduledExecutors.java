import java.time.LocalTime;
import java.util.concurrent.*;

public class ScheduledExecutors {

    public static class taskCallable implements Callable<String> {

        public String call() {

            return Thread.currentThread().getName() + " This one is the callable return";

        }

    }

    public static class task implements Runnable {

        public void run() {

            try {
                Thread.sleep(1000);

                System.out.println(LocalTime.now());

                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void execute() {

        try {

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

            ScheduledFuture<String> future = executor.schedule(new taskCallable(), 2, TimeUnit.SECONDS);

            System.out.println(future.get());

            executor.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void executeFixedRate() {

        try {

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

            ///  fixed rate will schedule the executor to run the task continuously, the second argument is the first time it will run
            ///  the second argument is the delay between executions
            executor.scheduleAtFixedRate(new task(), 0, 1,TimeUnit.SECONDS);

            ///  if the task is faster than the delay time, it will wait until it reaches the limit
            /// but if the task takes longer than the delay, it will start the next task right after it finishes, but does not make
            /// two tasks at the same time


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void executeFixedDelay() {

        try {

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

            ///  fixed delay puts a delay between the executions, meaning that it will wait a fixed time after completing a task
            executor.scheduleWithFixedDelay(new task(), 0, 1,TimeUnit.SECONDS);

            ///  in this execution you can see the timer every 2 seconds, 1 second for the task, and 1 second of delay


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
