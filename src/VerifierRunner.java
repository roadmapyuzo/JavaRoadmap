import java.lang.reflect.Method;

public class VerifierRunner {

    public static boolean run(Object obj, String metodo, String valor) throws Exception {

        Method method = obj.getClass().getMethod(metodo, String.class);

        if (method.isAnnotationPresent(Annotations.Verifier.class)) {

            Annotations.Verifier v = method.getAnnotation(Annotations.Verifier.class);

            return valor.length() > v.max();

        }

        throw new Exception();

    }

}
