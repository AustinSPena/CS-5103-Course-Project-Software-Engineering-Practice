import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import java.io.*;

public class WordStatisticsTest extends TestCase{
 protected WordStatistics wsTest;
 protected File sampleFile = new File("sample.txt");
    
    public void setUp(){
        wsTest = new WordStatistics();
    }
    
    @Test
    public void testFrequencyMap(){
     wsTest.file = sampleFile;
     wsTest.scanFile();
        assertEquals("Size of frequency map with sample input", wsTest.frequencyMap.size(), 12);
    }
    
    @Test
    public void testLineCount(){
     wsTest.file = sampleFile;
     wsTest.scanFile();
        assertEquals("Line count with sample input", wsTest.lineCount, 5);
    }
    
    @Test
    public void testCharCount(){
     wsTest.file = sampleFile;
     wsTest.scanFile();
        assertEquals("Character count with sample input", wsTest.charCount, 45);
    }    
    
    @Test
    public void testWordReplacement(){
     wsTest.file = sampleFile;
     wsTest.replacedWord = "Mario";
     wsTest.newWord = "M";     
     wsTest.scanFile();
        assertEquals("Character count with changed input", wsTest.charCount, 37);
    }

}