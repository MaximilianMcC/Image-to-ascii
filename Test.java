import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) {
        
        String text = "Test 123\nthis is some testing text\ni love among us";
        addOutput(text);

    }

    static void addOutput(String text) {

        try {

            // Get the file
            String filePath = "output.txt";
            File file = new File(filePath);
            
            // Make a new file
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(text);
            writer.close();


        } catch(IOException e) {
            System.out.println("Error when handling file");
            e.printStackTrace();
        }

    }

}
