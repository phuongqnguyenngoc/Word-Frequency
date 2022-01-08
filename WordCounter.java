import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.io.FileWriter;
import java.util.ArrayList;


public class WordCounter {
    private BSTMap<String, Integer> map;
    private int total;

    //constructor that makes an empty BSTMap and sets the total word count to zero.
    public WordCounter() {
        this.map = new BSTMap<String, Integer>(new StringAscending());
        this.total = 0;
    }

    //generates the word counts from a file of words
    public void analyze(String filename) {
        map.clear();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line = bufferReader.readLine();
    
            while (line != null) {
                
                String[] words = line.split("[^a-zA-Z0-9']");
                for (int i = 0; i < words.length; i++) {
                    String word = words[i].trim().toLowerCase();
                    if (word.length() != 0) {
                        Integer has = map.get(word);
                        if (has != null) {
                            map.put(word, has + 1);
                        } else {
                            map.put(word, 1);
                        }
                        this.total ++;
                    }
                   
                }
    
                line = bufferReader.readLine();
            }
            bufferReader.close();
            
            return;    
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file " + filename );
        }
        catch(IOException ex) {
            System.out.println("Error reading file " + filename);
        }
        return;
    }

    //returns the total word count
    public int getTotalWordCount() {
        return total;
    }


    //returns the number of unique words
    public int getUniqueWordCount() {
        return map.size();
    }

    //returns the frequency value associated with this word
    public int getCount(String word) {
        return map.get(word); 
    }


    //returns the value associated with this word divided by the total word count. 
    public double getFrequency( String word ) {
        double frequency = ((double)this.getCount(word)) / this.getTotalWordCount();
        return frequency;
    }

    //writes the contents of the BSTMap to a word count file.
    public void writeWordCounterFile(String filename) throws IOException {
        String report = "totalWordCount: " + this.total + "\n";
        ArrayList<KeyValuePair<String,Integer>> set = map.entrySet();        
        FileWriter writeCount = new FileWriter(filename);
        writeCount.write(report);
        for (KeyValuePair<String,Integer> kv: set) {
            writeCount.write(kv + "\n");
        }
        writeCount.close();
    }


    //reads the contents of a word count file and reconstructs the fields of the WordCount object, including the BSTMap
    public void readWordCountFile( String filename ) {
        map.clear();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line = bufferReader.readLine();
            //read first line separately
            String[] firstLine = line.split("[^a-zA-Z0-9']");
            this.total = Integer.parseInt(firstLine[2]);
            line = bufferReader.readLine();
            while (line != null ) { 
                String[] words = line.split("[^a-zA-Z0-9']");
                
                map.put(words[0], Integer.parseInt(words[2]));
                
                
                line = bufferReader.readLine();
            }
            bufferReader.close();
            return;    
        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file " + filename );
        }
        catch(IOException ex) {
            System.out.println("Error reading file " + filename);
        }
        return;
        
    }


    
    public static void main(String[] args) throws IOException {
        //those are my method tester lines. 
        // WordCounter count = new WordCounter();
        // count.analyze(args[0]);
        // System.out.println(count.getTotalWordCount());
        // System.out.println(count.getCount("it"));
        // System.out.println(count.getFrequency("it"));
        // count.writeWordCounterFile("wordcount.txt");
        // count.readWordCountFile("wordcount.txt");
        // System.out.println(count.map);

        for (int i = 0; i < args.length; i ++) {
            long timeStart = System.currentTimeMillis();
            WordCounter test = new WordCounter();
            test.analyze(args[i]);
            int x = i + 1;
            String fileName = "wordcount" + x + ".txt";
            test.writeWordCounterFile(fileName);
            // test.readWordCountFile(fileName);
            long timeEnd = System.currentTimeMillis();
            long time = timeEnd - timeStart;
            System.out.println("processing time for file " + x + ": " + time);
            test.map.getMax(10);
        }

       
    }

}