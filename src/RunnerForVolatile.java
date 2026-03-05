public class RunnerForVolatile implements Runnable {

    ///  volatile guarantees that the thread will see the most recently value

    public  volatile int numberForVolatile = 0;
    public  volatile boolean flag = false;

    public void run() {

        while (!flag) {

            Thread.yield();


        }

        if (numberForVolatile != 100) {

            System.out.println("This line is an error");

        }

    }

}
