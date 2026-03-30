import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static List<String> list =  new ArrayList<String>();
    public static List<String> list2 = Collections.synchronizedList(new ArrayList<String>());



    public static void main(String[] args) {

        Semaphores object =  new Semaphores();
        object.execute2();



    }
}