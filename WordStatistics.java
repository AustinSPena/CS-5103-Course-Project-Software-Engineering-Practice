import java.util.*;
import java.io.*;

// This class reads a file and outputs the frequency of each unique word
public class WordStatistics {
    public static void main (String args[]) {
      
      // Initialize the Scanner and the HashMap of word frequencies
      Scanner SCNR = new Scanner(System.in);
      Map <String, Integer> frequencyMap = new HashMap <String, Integer>();
      
      // Create a File variable based on user's input
      System.out.println("Please enter a file name:");
      String fileName = SCNR.next();      
      File file = new File (fileName);
      
      // If the file exists, scan each unique word and update the HashMap
      try {
        SCNR = new Scanner(file);
        
        while (SCNR.hasNext()) {
          String word = SCNR.next();
          
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
      }
      
      // Print the contents of the HashMap
      for (String key : frequencyMap.keySet()) {
        int frequency = frequencyMap.get(key);
        System.out.printf("%s %d\n", key, frequency);
      }
    }
}