public class Volatile {

    RunnerForVolatile runner =  new RunnerForVolatile();

    public void runErrorExample() {

        while (true) {

            Thread newThread =  new Thread(runner);
            Thread newThread2 =  new Thread(runner);
            Thread newThread3 =  new Thread(runner);
            Thread newThread4 =  new Thread(runner);
            Thread newThread5 =  new Thread(runner);
            Thread newThread6 =  new Thread(runner);
            Thread newThread7 =  new Thread(runner);
            Thread newThread8 =  new Thread(runner);
            Thread newThread9 =  new Thread(runner);


            newThread.start();
            newThread2.start();
            newThread3.start();
            newThread4.start();
            newThread5.start();
            newThread6.start();
            newThread7.start();
            newThread8.start();
            newThread9.start();



            runner.numberForVolatile= 100;
            runner.flag = true;

            while (newThread.getState() != Thread.State.TERMINATED ||
                    newThread2.getState() != Thread.State.TERMINATED ||
                    newThread3.getState() != Thread.State.TERMINATED ||
                    newThread4.getState() != Thread.State.TERMINATED ||
                    newThread5.getState() != Thread.State.TERMINATED ||
                    newThread6.getState() != Thread.State.TERMINATED ||
                    newThread7.getState() != Thread.State.TERMINATED ||
                    newThread8.getState() != Thread.State.TERMINATED ||
                    newThread9.getState() != Thread.State.TERMINATED ){

            }

            runner.numberForVolatile= 0;
            runner.flag = false;


        }

    }



}

