import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Locks {

    private Lock lock = new ReentrantLock();

    private ReadWriteLock lock2 = new ReentrantReadWriteLock();

    private int number = 0;

    private int number2 = 0;

    ///  a lock is similar to using synchronized, it will make only one thread being able to access a certain resource,
    ///  the difference is that locks are more flexible, you can start the lock and then unlock it in different blocks

    /// reetrant lock permits you to start locks inside locks

    /// in this first execute, if you imagine that each number represents a bank account, its a scenery where reentrant locks makes sense
    /// if its a bank transaction, first you lock the origin account, then in sequence, locks the target account, after the transaction is complete you
    /// unlock the 2 accounts
    public void execute() {

        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {

            lock.lock();

            number++;
            System.out.println("your variable number is " + number);

            lock.lock();

            number2++;
            System.out.println("your variable number is " + number2);

            lock.unlock();


            lock.unlock();

        };

        for (int i = 0; i < 10; i++) {

            executor.execute(r1);

        }


    }

    ///  read write lock creates the possibility to use paralelism on reading and synchronism on writing
    ///  when you use a write lock, other threads will not be able to use neither write nor read locks
    ///  but when you use a read lock, other locks can also acquire more read locks, but while a read lock is
    ///  running, no other threads will be able to acquire a write lock
    public void execute2() {

        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {

            Lock wlock = lock2.writeLock();

            wlock.lock();

            System.out.println("writing on " + number);

            number++;

            System.out.println("new number: " + number);

            wlock.unlock();

        };

        Runnable r2 = () -> {

            Lock rlock = lock2.readLock();

            rlock.lock();

            System.out.println("reading " + number);
            System.out.println("the number read was " + number);

            rlock.unlock();

        };

        for (int i = 0; i < 10; i++) {

            executor.execute(r1);
            executor.execute(r2);

        }


    }


}
