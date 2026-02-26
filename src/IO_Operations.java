import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.stream.Stream;

public class IO_Operations {

    ///  using java IO
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

    ///  using java NIO
    public void pathOperations() {

        Path root = Path.of(System.getProperty("user.dir"));
        Path filePath = root.resolve("file.txt");
        System.out.println(root);
        System.out.println(filePath);


        boolean exists = Files.exists(filePath);
        System.out.println(exists);

        try {
            FileTime lastModified = Files.getLastModifiedTime(filePath);
            System.out.println(lastModified);
        } catch (IOException ioException) {
            throw  new RuntimeException(ioException);
        }

        try {
            UserPrincipal owner = Files.getOwner(filePath);
            System.out.println(owner);
        } catch (IOException ioException) {
            throw  new RuntimeException(ioException);
        }

        try {
            Path newDir = Files.createDirectories(root.resolve("DirectoryCreatedByCommand"));

            boolean fileExists = Files.exists(newDir.resolve("FileCreatedByCommand"));
            if (!fileExists) {
                Path newFile = Files.createFile(newDir.resolve("FileCreatedByCommand"));
                Files.write(newFile, "test \n test \n third line".getBytes());
            }

        } catch (IOException ioException) {
            throw  new RuntimeException(ioException);
        }

        try {

            List<String> lines = Files.readAllLines(root.resolve("DirectoryCreatedByCommand/FileCreatedByCommand"));
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException ioException) {
            throw  new RuntimeException(ioException);
        }

        try (Stream<String> lines = Files.lines(root.resolve("DirectoryCreatedByCommand/FileCreatedByCommand"))) {

            lines.filter(l -> l.contains("test")).forEach(System.out::println);

        } catch (IOException ioException) {
            throw  new RuntimeException(ioException);
        }





    }



}
