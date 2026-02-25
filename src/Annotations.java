import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;



public class Annotations {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Verifier {

        int max();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Argument2 {
        String value();
    }

    /// Java annotations are tipically used to: build-time instructions, compiler instructions, runtime instructions

    ///  built in java annotations

    ///  should not be used anymore and can lead to errors
    @Deprecated
    public String exampleMethod() {
        return "example";
    }

    ///  override methods in superclass
    @Override
    public String toString() {
        return "";
    }

    /// as name says, suppress the warnings
    @SuppressWarnings("rawtypes")
    public void  exampleMethod2() {

        List genericlist = new ArrayList();

    }

    ///  you can create your own annotation, but also will need to create the "engine" for it, in this case @Verifier receives an
    /// max size argument and verifies if the String is bigger than it

    @Verifier(max=10)
    public void print(String a) {

        System.out.println(a);

    };




}
