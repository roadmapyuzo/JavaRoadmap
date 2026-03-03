public class RunnerForVolatile implements Runnable {

    public  int numberForVolatile = 0;
    public  boolean flag = false;

    public void run() {

        while (!flag) {

            Thread.yield();


        }

        if (numberForVolatile != 100) {

            System.out.println("This line is an error");

        }

    }

}
