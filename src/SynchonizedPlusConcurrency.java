public class SynchonizedPlusConcurrency implements Runnable {

    int i = 1;

    public void run() {

        int j;

        synchronized (this) {

            i++;
            j = i;

        }

        System.out.println("2 * "+ j + " = "+ 2 * j);

    }

}
