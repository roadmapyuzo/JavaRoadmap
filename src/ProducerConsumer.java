import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ProducerConsumer {

    private final List<Integer> list = new ArrayList<>(5);
    private boolean producing = true;
    private boolean consuming = true;

    ///  race condition + deadlock example
    public void execute() {

        Thread producer = new Thread(() -> {

            while (true) {
                delaySimulation();

                if (producing) {

                    System.out.println("Producing");
                    int number = new Random().nextInt(10);
                    list.add(number);

                    if (list.size() == 5) {
                        System.out.println("Stopping producer");
                        producing = false;
                    }
                    if (list.size() == 1) {
                        System.out.println("Starting consumer");
                        consuming = true;
                    }

                } else {

                    System.out.println("Producer sleepíng");

                }
            }

        });

        Thread consumer = new Thread(() -> {

            while (true) {
                delaySimulation();

                if (consuming) {

                    System.out.println("Consuming");

                    Optional<Integer> numberOptional = list.stream().findFirst();
                    numberOptional.ifPresent(System.out::println);
                    numberOptional.ifPresent(n -> {

                        list.remove(n);

                    });

                    if (list.size() == 0) {
                        System.out.println("Stopping consumer");
                        consuming = false;
                    }
                    if (list.size() == 4) {
                        System.out.println("Starting producer");
                        producing = true;
                    }

                } else {

                    System.out.println("Consumer sleeping");

                }
            }

        });

        producer.start();
        consumer.start();


    }

    public void delaySimulation() {

        try {
            Thread.sleep(new Random().nextInt(10) * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
