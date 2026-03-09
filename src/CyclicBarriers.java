import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class CyclicBarriers {

    /// CyclicBarrier is a synchronization utility that allows multiple threads
    /// to wait for each other at a common barrier point.

    /// in this example, we have 3 threads doing different calculations, and a function that will sum all the values
    /// if you run 4 different threads at the same time, there is a chance that the finalization function runs before the others


    LinkedBlockingQueue<Double> queue = new LinkedBlockingQueue<>();

    public void runWithoutBarrierToSeeError() {

        Runnable finalization = () -> {

            Double result = 0.0;

            result += queue.poll();
            result += queue.poll();
            result += queue.poll();

            System.out.println("Your result is: "+result);

        };



        Runnable r1 = () -> {

            queue.add(100d * 5d);

        };

        Runnable r2 = () -> {

            queue.add(1000d * 10d);

        };

        Runnable r3 = () -> {

            queue.add(20000d / 2d);

        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(finalization);
        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

    /// when you use cyclic barrier, you can create a wait point with a certain number of "participants", where it will wait
    /// for the specified number of participants to signal that they are waiting, after that, it will allow them to continue their process
    /// or execute a final step that you can also inform, in this case, we are informing the finalization function as the last step

    public void run2() {

        Runnable finalization = () -> {

            Double result = 0.0;

            result += queue.poll();
            result += queue.poll();
            result += queue.poll();

            System.out.println("Your result is: "+result);

        };

        CyclicBarrier barrier = new CyclicBarrier(3,  finalization);

        Runnable r1 = () -> {

            queue.add(100d * 5d);
            System.out.println("I will reach the barrier and wait");
            await(barrier);
            System.out.println("I was released");

        };

        Runnable r2 = () -> {

            queue.add(1000d * 10d);
            System.out.println("I will reach the barrier and wait");
            await(barrier);
            System.out.println("I was released");

        };

        Runnable r3 = () -> {

            queue.add(20000d / 2d);
            System.out.println("I will reach the barrier and wait");
            await(barrier);
            System.out.println("I was released");

        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();



    }


    public static void await(CyclicBarrier barrier) {

        try {
            barrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
