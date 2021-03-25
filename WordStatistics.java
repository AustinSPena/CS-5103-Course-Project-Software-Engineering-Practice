import java.util.*;
import java.io.*;

// This class reads a file and outputs the frequency of each unique word
public class WordStatistics {
    public static void main (String args[]) {
      
      // Initialize the Scanner and the HashMap of word frequencies
      Scanner SCNR = new Scanner(System.in);
      Map <String, Integer> frequencyMap = new HashMap <String, Integer>();
      int lineCount = 0;
      int charCount = 0;
      
      // Create a File variable based on user's input
      System.out.println("Please enter a file name:");
      String fileName = SCNR.next();
      File file = new File (fileName);
      
      // If the file exists, count every scan each unique word and update the HashMap
      try {
        SCNR = new Scanner(file);
        
        while (SCNR.hasNext()) {
          lineCount++;
          SCNR.nextLine();
        } 
        
        SCNR = new Scanner(file);
        
        while (SCNR.hasNext()) {
          
          String word = SCNR.next();
          charCount += word.length();
          
          if (frequencyMap.containsKey(word)) {
            int frequency = frequencyMap.get(word) + 1;
            frequencyMap.put(word, frequency);
          }
          else {
            frequencyMap.put(word, 1);
          }
        }
        SCNR.close();
      }
      catch (Exception e) {
        System.out.println("Error: file not found");
        SCNR.close();
        System.exit(1);
      }
      
      System.out.printf("The line count is: %d\n", lineCount);
      System.out.printf("The character count is: %d\n", charCount);
      
      // Print the contents of the HashMap
      for (String key : frequencyMap.keySet()) {
        int frequency = frequencyMap.get(key);
        System.out.printf("%s %d\n", key, frequency);
      }
    }
}