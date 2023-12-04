import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class testdemo {
    public static void main(String[] args) {

                // Specify the path to your Java file
                String filePath = "C:\\Users\\Hemadri Reddy\\WTProject27-10-2023\\translatewebsitetest\\WTseleniumAutomationProject\\src\\test\\resources\\uploadResource\\stored_code.java";

                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    int lineNumber = 1;

                    // Loop through each line in the file
                    while ((line = br.readLine()) != null) {
                        // Store each line in a separate variable (you can use an array or list if you have many lines)
                        String variableName = "line" + lineNumber;
                        System.out.println(variableName + ": " + line);

                        // You can store each line in a separate variable or perform other actions
                        // For example, you can use an array or list to store all lines dynamically
                        // lines.add(line);

                        lineNumber++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

}
