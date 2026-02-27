public class SecondRunnableClass implements Runnable {

    int i = 0;

    @Override
    public void run() {

        i++;
        System.out.println(Thread.currentThread().getName() + ": " + i);

    }
}
