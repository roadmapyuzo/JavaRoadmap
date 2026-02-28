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

    public void concurrencyOfThreads() {

        SecondRunnableClass runner  = new SecondRunnableClass();

        Thread newThread = new Thread(runner);
        Thread newThread2 = new Thread(runner);
        Thread newThread3= new Thread(runner);
        Thread newThread4= new Thread(runner);
        Thread newThread5= new Thread(runner);

        newThread.start();
        newThread2.start();
        newThread3.start();
        newThread4.start();
        newThread5.start();

    }

    public void concurrencyOfThreads2() {

        CopyOfSecondRunnerWithSynchronized runner  = new CopyOfSecondRunnerWithSynchronized();

        Thread newThread = new Thread(runner);
        Thread newThread2 = new Thread(runner);
        Thread newThread3= new Thread(runner);
        Thread newThread4= new Thread(runner);
        Thread newThread5= new Thread(runner);

        newThread.start();
        newThread2.start();
        newThread3.start();
        newThread4.start();
        newThread5.start();

    }

    /// synchronized on methods make it synchronized per instance of the object
    /// synchronized on class make it synchronized per jvm

    public static void synchronizedOnStaticResource() {

        synchronized (MultiThreading.class) {
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
        }

    }

    public void synchronizedPlusConcurrency() {

        SynchonizedPlusConcurrency runner  = new SynchonizedPlusConcurrency();

        Thread newThread = new Thread(runner);
        Thread newThread2 = new Thread(runner);
        Thread newThread3= new Thread(runner);
        Thread newThread4= new Thread(runner);
        Thread newThread5= new Thread(runner);

        System.out.println("Tabuada do 2 em ordem aleatoria");

        newThread.start();
        newThread2.start();
        newThread3.start();
        newThread4.start();
        newThread5.start();

    }

    ///  List is not thread safe, so its possible that some insertions fail. on this example: size expected -> 500, after running it for some attempts, i got 466
    public void synchronizedOnList() {

        SynchronizedOnlistRunner runner  = new SynchronizedOnlistRunner();

        Thread newThread = new Thread(runner);
        Thread newThread2 = new Thread(runner);
        Thread newThread3= new Thread(runner);
        Thread newThread4= new Thread(runner);
        Thread newThread5= new Thread(runner);

        newThread.start();
        newThread2.start();
        newThread3.start();
        newThread4.start();
        newThread5.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Main.list.size());


    }

    ///  same but with collections synchronized list
    public void synchronizedOnList2() {

        Thread newThread = new Thread(() -> {  for (int i = 0; i < 100; i++) {
            Main.list2.add("Hello");
        }});
        Thread newThread2 = new Thread(() -> {  for (int i = 0; i < 100; i++) {
            Main.list2.add("Hello");
        }});
        Thread newThread3= new Thread(() -> {  for (int i = 0; i < 100; i++) {
            Main.list2.add("Hello");
        }});
        Thread newThread4= new Thread(() -> {  for (int i = 0; i < 100; i++) {
            Main.list2.add("Hello");
        }});
        Thread newThread5= new Thread(() -> {  for (int i = 0; i < 100; i++) {
            Main.list2.add("Hello");
        }});

        newThread.start();
        newThread2.start();
        newThread3.start();
        newThread4.start();
        newThread5.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Main.list2.size());


    }

    ///  more examples of collections to work with multi threading -> concurrentHashMap -> copyOnWriteList (good when there is a lot of reading and almost never insertions)
    ///  LinkedBlockingQueue

}




