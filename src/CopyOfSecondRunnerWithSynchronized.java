public class CopyOfSecondRunnerWithSynchronized implements Runnable {

    int x = 0;
    int j = 0;

    static final Object lock = new Object();
    static final Object lock2 = new Object();

    @Override
    public void run() {

        synchronized (lock) {
            x++;
            System.out.println(Thread.currentThread().getName() + ": x = " + x);
        }
         synchronized (lock2) {
             j++;
             System.out.println(Thread.currentThread().getName() + ": j = " + j);
         }

    }


}
