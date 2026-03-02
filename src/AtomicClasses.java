import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicClasses {

    ///  atomic classes are used to work with multi threading
    /// they use a method called CAS - Compare and Swap

    /// they are faster than synchronized because they dont block other threads, CAS uses volatile values to
    /// compare the memory value with an expected value, if it does now match it try again
    AtomicInteger myNumber = new AtomicInteger(1);

    ///  more examples of atomic classes
    AtomicLong example1 = new AtomicLong();
    AtomicBoolean example2 = new AtomicBoolean();

    ///  you can create an Atomic version of one of your own classes
    AtomicReference<Annotations> example3 = new AtomicReference<>(new Annotations());


    public void run() {

        Thread thread1 = new Thread(() -> {
            ///  what the method is doing is calculating the next number -> 2
            ///  and then creating CompareAndSet (1,2)
            ///  where 1 is the original expected value, and 2 is the value it is supposed to be updated to
            ///  if another thread changes de value, when the method is executed, it will check in the heap memory if the value is still 1
            ///  if dont, it will restart de process
            System.out.println(myNumber.incrementAndGet());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(myNumber.incrementAndGet());
        });
        Thread thread3 = new Thread(() -> {
            System.out.println(myNumber.incrementAndGet());
        });
        Thread thread4 = new Thread(() -> {
            System.out.println(myNumber.incrementAndGet());
        });
        Thread thread5 = new Thread(() -> {
            System.out.println(myNumber.incrementAndGet());
        });


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }



}
