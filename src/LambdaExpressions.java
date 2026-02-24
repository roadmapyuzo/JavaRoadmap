public class LambdaExpressions {

    private final ExampleClassThatUsesLambda exampleClass = new ExampleClassThatUsesLambda();

    public void run() {

        ///  lamba expressions are used to implement interfaces with only 1 abstract method (functional interface)

        ///  example 1:
        LambdaInterface testing = (
                (s) -> {
                    return s;
                });

        System.out.println(testing.test("testing"));;

        ///  example 2: can be written in a single line

        LambdaInterface testing2 = ( (s) -> {return s;} );

        System.out.println(testing2.test("testing"));;

        ///  note: you dont need to declare the argument type, java will automatically know which type it should be

        ///  example 3 - if it has only one argument you dont need () on the arguments

        LambdaInterface testing3 = s -> {return s;};

        System.out.println(testing3.test("testing"));;

        ///  example 4 - if your implementation is only one expression, java will treat it as your return

        LambdaInterface testing4 = s -> "wow" + s;

        System.out.println(testing4.test("testing"));;

        ///  example 5 - it can be used as an argument if a function has its interface as an argument

        exampleClass.test(testing4);



    }
}
