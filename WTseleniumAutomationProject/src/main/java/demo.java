import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    private static int countWords(String string) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(string);
        int wordCount = 0;
        while (matcher.find()) {
            System.out.println(matcher);
            wordCount++;
        }
        return wordCount;
    }
    public static void main(String[] args) throws IOException {

            // Enter the URL of the website you want to count the word count of
//            String url = "https://site2.reachabilty.com/";
//
//            // Create a URL object
//            URL urlObject = new URL(url);
//
//            // Open a connection to the website
//            BufferedReader reader = new BufferedReader(new InputStreamReader(urlObject.openStream()));
//
//            // Read the contents of the website
//            String websiteContent = "";
//            String line;
//            while ((line = reader.readLine()) != null) {
//                websiteContent += line;
//            }
//
//            // Close the connection to the website
//            reader.close();
//
//            // Count the number of words in the website's contents
//            int wordCount = countWords(websiteContent);

            // Display the word count to the user
//            System.out.println("The word count of the website is:"+ wordCount);
        String teluguText1 = "తెలుగు";
        String teluguText2 = "తెలుగు";

        // Check if teluguText1 contains teluguText2
        if (teluguText1.contains(teluguText2)) {
            System.out.println("teluguText1 contains teluguText2!");
        } else {
            System.out.println("teluguText1 does not contain teluguText2.");
        }

    }
}