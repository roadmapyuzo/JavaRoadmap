public class MultiThreading {

    public void checkCurrent() {

        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + " " + currentThread.getId());

    }

    public void creatingNewThread() {

        /// if using run, it will not force the creation of a new thread
        Thread newThread = new Thread(new RunnableClassForThread());
        newThread.run();

        /// when using start, it will instruct the jvm to run the thread as soon as possible, if its possible to create a new thread to run it faster it will
        newThread.start();

        /// you can pass a lambda expressions as a runnable
        Thread newThread2 = new Thread(() ->
        {
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
            System.out.println("Runnable as lambda");
        });

        newThread2.start();

        /// using method that will use thread main again
        checkCurrent();



    }

    public void sameInstanceOfRunnableInDifferentThreads() {

        Thread newThread = new Thread(new RunnableClassForThread());
        Thread newThread2 = new Thread(new RunnableClassForThread());
        Thread newThread3= new Thread(new RunnableClassForThread());

        newThread.start();
        newThread2.start();
        newThread3.start();

    }

}
