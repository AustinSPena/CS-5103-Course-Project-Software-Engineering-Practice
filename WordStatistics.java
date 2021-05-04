import java.util.*;
import java.io.*;

// This class reads a file and analyzes the words within
public class WordStatistics {

 int lineCount = 0;
    int charCount = 0;
    String replacedWord = "";
    String newWord = "";
    File file = new File("");
    Map <String, Integer> frequencyMap = new HashMap <String, Integer>();
    Scanner SCNR = new Scanner(System.in);

    // Create a File variable based on user's input
    void requestFile() {
     
     System.out.println("Please enter a file name:");
  file = new File (SCNR.next()); 
    }

 // Prompt the user if a word should be replaced
    void requestReplacement() {
     
        System.out.println("Would you like to replace a word in the file? (Y/N)");
        String response = "";
        
        while (!response.equals("Y") && !response.equals("N")) {
         response = SCNR.next().toUpperCase();
        }
        
        // If requested, prompt the user for replacement words
        if (response.equals("Y")) {
         System.out.println("What word would you like to replace?");
         replacedWord = SCNR.next();
         System.out.println("What word should be placed in?");
         newWord = SCNR.next();
        }
    }
    
    // If the file exists, count each unique word and update the HashMap
    // Also count the lines and characters
    // If needed, replace the requested word
    void scanFile() {
     
        try {
            SCNR = new Scanner(file);
            
            while (SCNR.hasNext()) {
              lineCount++;
              SCNR.nextLine();
            }
            
            SCNR = new Scanner(file);
            
            while (SCNR.hasNext()) {
             
                String word = SCNR.next();
                
                if (word.equals(replacedWord) && !replacedWord.equals("")) {
                 word = newWord;
                }
                
                charCount += word.length();
                
                if (frequencyMap.containsKey(word)) {
                    int frequency = 1 + frequencyMap.get(word);
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
    }
    
    // Print the lineCount, charCount, and contents of the HashMap
    void printOutcomes() {
     
        System.out.printf("The line count is: %d\n", lineCount);
        System.out.printf("The character count is: %d\n", charCount);

        for (String key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            System.out.printf("%s %d\n", key, frequency);
        }
    }
 
    public static void main (String args[]) {
     
     WordStatistics ws = new WordStatistics();
     ws.requestFile();
     ws.requestReplacement();
     ws.scanFile();
     ws.printOutcomes();
  
    }
}