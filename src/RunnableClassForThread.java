public class RunnableClassForThread implements Runnable {

    public void run() {

        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());

    }

}
