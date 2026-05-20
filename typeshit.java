import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class typeshit {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Hello, World!\n");
            writer.write("This is a sample text file.\n");
            for (String name : names) {
                writer.write(name + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

