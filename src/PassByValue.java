public class PassByValue {

    ///  when passing variables as arguments in a method in java, the method will create a copy of them (pass by value)
    ///  primitive types in java store the actual value in them, so, passing them in a function creates another variable
    ///  when you create an object of a class, it will be stored in heap memory, different from primitive types that are stored in stack memory
    ///  so, what you are actually using when working with objects is a reference of them

    public void PassByValueStudy() {

        /// creating primitive value
        int a = 1;

        System.out.println("your variable a contains: " + a);

        ///  calling modify
        modify(a);

        ///  modify created a copy of a -> a2 = 1, and modified it a2 = 5, but a is still 1]

        System.out.println("your variable a contains: " + a);

        /// but with objects it works a little different

        ///  creating an object
        testobject object = new testobject("first value");

        System.out.println("your variable object contains: " + object.randomValue);

        /// calling modify
        modifyObject(object);

        /// since you are working with the reference for the real object, java creates a copy of it     REF object -> real object <- copy of REF object
        /// the two references target the same real object, so when you change the value in it, both will be affected

        System.out.println("your variable object contains: " + object.randomValue);





    }

    public static void modify(int number) {

        number = 5;

        System.out.println("your variable number that is being modified in the method contains: " + number);

    }

    public static void modifyObject(testobject object) {

        object.randomValue = "new value";

        System.out.println("your variable object was affected even in the modify method and now contains: " + object.randomValue);

    }

    class testobject {

        public String randomValue;

        public testobject(String randomValue) {
            this.randomValue = randomValue;
        }

    }


}
