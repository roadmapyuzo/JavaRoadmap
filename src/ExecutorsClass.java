import java.util.concurrent.*;

public class ExecutorsClass {

    public static class task implements Runnable {

        public void run() {

            System.out.println(Thread.currentThread().getName());

        }

    }

    /// callable is a runner that returns something
    public static class taskCallable implements Callable<String> {

        public String call() {

            return Thread.currentThread().getName() + " This one is the callable return";

        }

    }

    public void execute() {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            executor.execute(new task());

            executor.awaitTermination(1, TimeUnit.SECONDS);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally { ///  finally guarantees that a instruction will be executed
            /// If you dont finish executors, it will continue running waiting for more instructions
            executor.shutdown();
        }


    }

    public void submit() {

        ExecutorService executor2 = Executors.newSingleThreadExecutor();

        try {

            ///  submit makes possible to get a return on some information
            Future<?> future = executor2.submit(new task());

            System.out.println(future.isDone());

            ///  if you submit a callable runner, you can get its return using get()
            Future<String> future2 = executor2.submit(new taskCallable());

            ///  shutdown makes the executor does not accept more instructions but it will wait the current instructions to finish
            executor2.shutdown();

            System.out.println(future2.get());


            /// await termination timeout can be used to not wait too much for a function, if there is for example an eternal loop due to miscoding
            /// the timeout will save the program
            executor2.awaitTermination(1, TimeUnit.SECONDS);

            ///  since shutdown was used, this print is guaranteed to be true
            System.out.println(future.isDone());



        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally { ///  finally guarantees that a instruction will be executed
        /// If you dont finish executors, it will continue running waiting for more instructions
            executor2.shutdownNow();
        }


    }



}
