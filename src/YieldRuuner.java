public class YieldRuuner implements Runnable {

    public void run() {

        ///  yield makes a suggestion to the processor that the current thread can yield the cpu to another thread, but its not guaranteed
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            Thread.yield();
        }

    }

}
