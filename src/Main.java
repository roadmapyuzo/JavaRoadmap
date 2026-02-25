//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Annotations annotations = new Annotations();

        try {
            System.out.println(VerifierRunner.run(annotations, "print", "testaaaaaaaa"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}