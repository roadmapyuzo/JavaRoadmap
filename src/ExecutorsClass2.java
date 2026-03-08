import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsClass2 {

    public static class task implements Runnable {

        public void run() {

            System.out.println(Thread.currentThread().getName() + " esta é a execução: ");


        }

    }

    public static class taskCallable implements Callable<String> {

        public String call() {

            return Thread.currentThread().getName() + " This one is the callable return";

        }

    }

    /// you can assign a number of available threads to an executor using fixed thread pool
    public void fixedThreadPool() {

        ExecutorService executor = null;

        try {

            executor = Executors.newFixedThreadPool(4);
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());

            executor.awaitTermination(1, TimeUnit.SECONDS);


            executor.shutdown();



        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            if (executor != null) {
                executor.shutdownNow();
            }

        }

    }

    /// cached thread pool will manage the creation of threads as it deems necessary
    /// its not recommended to use it when you have a large number of tasks because it can end up creating too many threads
    public void cachedThreadPool() {

        ExecutorService executor = null;

        try {

            executor = Executors.newCachedThreadPool();
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());
            executor.submit(new task());

            executor.awaitTermination(1, TimeUnit.SECONDS);
            executor.shutdown();

        }  catch (Exception e) {
            throw new RuntimeException(e);
        }  finally {
            if (executor != null) {
                executor.shutdownNow();
            }
        }

    }

    public void invokeAll() {

        ExecutorService executor = null;

        try {

            executor = Executors.newCachedThreadPool();
            List<taskCallable> listOfTasks = new ArrayList<taskCallable>();

            for (int i = 0; i < 10; i++) {
                taskCallable task = new taskCallable();
                listOfTasks.add(task);
            }

            ///  can be used with a list of callable
            List<Future<String>> res = executor.invokeAll(listOfTasks);

            executor.awaitTermination(1, TimeUnit.SECONDS);

            for (Future<String> future : res) {

                System.out.println(future.get());

            }
            executor.shutdown();

        }  catch (Exception e) {
            throw new RuntimeException(e);
        }  finally {
            if (executor != null) {
                executor.shutdownNow();
            }
        }

    }

}
