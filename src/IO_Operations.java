import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO_Operations {

    public void createTXT() {

        String text = "Hello World \ntest";

        try (FileWriter fileWriter = new FileWriter("file.txt")){

            fileWriter.write(text);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter fileWriter = new FileWriter("file2.txt")){

            fileWriter.write(text, 0,5);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (FileReader fileReader = new FileReader("file.txt")) {

            ///  returns the code of the char
            int c = fileReader.read();
            System.out.println((char) c);

            /// fills array and returns the number of elements read
            char[] test = new char[4];
            int c2 =  fileReader.read(test);
            String s = new String(test, 0, c2);
            System.out.println(s);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
