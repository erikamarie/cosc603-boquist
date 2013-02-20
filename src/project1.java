
import java.util.*;
import java.io.*;
/**
 * @author Erika Boquist <eboquist@gmail.com>
 * @version 1.4
 * @since 2012-02-16
 * 
 * The project1 class contains the code for COSC603 project 1.
 * The code was derived from reverse engineering the Stutter.c
 * program. A text file is received and parsed to determine 
 * which lines have repeating words.
 */
public class project1 {
	static String inputFile;
	static String[] formattedLineString;
	static int[]index;
	static String lineString = "";
	
	/**
	 * The main method for project1 class.
	 * 
	 * Main method replicates Stutter.c program to check for
	 * repeated words in the document
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		File textFile;
		FileReader textReader;
		LineNumberReader lineNumber;
		Map<String, Integer> wordMap;
		String wordString;
		
		try{
			//textFile is retrieved on OSX
			textFile = new File("/Users/EMac2/Desktop/COSC603/603Project1/src/Project1_Test_File.txt");
			textReader = new FileReader(textFile);
			lineNumber = new LineNumberReader(textReader);
			//traverse the lines in the textFile
			while((lineString  = lineNumber.readLine()) != null){
				//format the lines so we can do something with it
                formattedLineString = lineString.replaceAll("[\\n]", " ").replaceAll("[!.,?!:;/()]","").split(" ");
                //create the new map for storing the words
                wordMap = new LinkedHashMap<String,Integer>();
                for(int i =0; i< formattedLineString.length; i+=1){
                    String tempString = formattedLineString[i];
                    //check if map has the word, if it doesn't, add it, or increase the count
                    if(wordMap.get(tempString) == null){
                    	wordMap.put(tempString, 1);
                    }else{
                    	wordMap.put(tempString, wordMap.get(tempString) +1);
                    }
                }
                Set<String> words = wordMap.keySet();
                for(String word:words){
                	//print if the word is repeated
                	if(wordMap.get(word) > 1){
                		wordString = word;
                		for(int i = 0; i<wordMap.get(word)-1; i +=1){
                			wordString += " " + word;
                		}
                		
                		System.out.println("Repeated word on line " + lineNumber.getLineNumber() + " : " + wordString);
                	}
                }
			}
			textReader.close();
			lineNumber.close();
		}catch (IOException e){
			System.out.println("Cannot open selected file");
		}
	}

}
