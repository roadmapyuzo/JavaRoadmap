public class MethodChaining {

    private String stringToVisualizeConstructorReturningObjectReference = "hello";
    private int a;

    ///  to use method chaining, every method needs to return an object that has the next method

    ///  example -> method1() returns object TESTm, objest TEST has method nextMethod() so method1().nextMethod() is possible

    ///  constructor does not hold any return type, but they are still returning the object reference, so, it can be used in method chaining
    public MethodChaining() {
        System.out.println("this is returning the current object reference");
    }

    public MethodChaining settingA(int number) {
        this.a = number;
        return this;
    }

    public MethodChaining adding10ToNumber() {
        this.a = a + 10;
        return this;
    }

    ///  this method makes possible to end a chaining with toString() ->  String result = new MethodChaing().settingA(10).adding10ThenReturningInt().toString();
    public Integer adding10ThenReturningInt() {
        return a + 10;
    }

    ///  if a method returns another class object, the chaining can end in the new object method; MethodChaining2 has method finalPrint()
    /// so MethodChaning test = new MethodChaining();  test.settingA().printResult().finalPrint() is possible
    public MethodChaining2 printResult() {

        System.out.println("Your number is: "+ a);

        return new MethodChaining2();

    }

    public MethodChaining printAuxiliarString() {

        System.out.println(this.stringToVisualizeConstructorReturningObjectReference);
        return this;

    }



}
class MethodChaining2 {

    public void finalPrint() {

        System.out.println("this is finalPrint after method chaining");

    }

}