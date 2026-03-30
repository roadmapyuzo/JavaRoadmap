import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Semaphores {

    Semaphore semaphore = new Semaphore(5);

    ///  Semaphores can be used to determine a limit of threads that can execute something at the same time,
    ///  every thread that wants to execute a function that has a semaphore, needs to acquire a slot on it
    ///  after the execution, it needs to release the slot for another thread to claim

    ///  if you use acquire, the thread will either execute the function if the semaphore has a open slot or wait on that line for a slot
    public void execute() {

        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {

            acquire();

            System.out.println(Thread.currentThread().getName()+" is running...");

        sleep();

        semaphore.release();

        };

        for (int i = 0; i < 100; i++) {

            executor.execute(r1);

        }

        executor.shutdown();

    }

    ///  if you use try acquire, it returns a boolean representing if it acquired a slot or not, if not, it can continue to do another line
    public void execute2() {



        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {

            boolean tried = tryAcquire();

            while (!tried) {

                tried = tryAcquire();

            }

            System.out.println(Thread.currentThread().getName()+" is running...");

            sleep();

            semaphore.release();

        };

        for (int i = 0; i < 100; i++) {

            executor.execute(r1);

        }

        executor.shutdown();

    }

    public void acquire() {

        try {

            semaphore.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean tryAcquire() {

        try {

            return semaphore.tryAcquire();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public void sleep() {

        try {

            Thread.sleep(new Random().nextInt(5) * 1000);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
