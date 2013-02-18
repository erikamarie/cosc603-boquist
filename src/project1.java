
import java.util.*;
import java.io.*;
/**
 * @author Erika Boquist <eboquist@gmail.com>
 * @version 1.0
 * @since 2012-02-16
 * 
 * The project1 class contains the code for COSC603 project 1.
 * The code was derived from reverse engineering the Stutter.c
 * program. A text file is received and parsed to determine 
 * which lines have repeating words.
 */
public class project1 {
	static String inputFile;
	static String[] specialCharacter;
	static int[]index;
	static String lineString = "";
	
	/**
	 * The main method for project1 class
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File textFile;
		FileReader textReader;
		LineNumberReader lineNumber;
		
		try{
			textFile = new File("/Users/EMac2/Desktop/COSC603/603Project1/src/Project1_Test_File.txt");
			textReader = new FileReader(textFile);
			lineNumber = new LineNumberReader(textReader);
			while((lineString  = lineNumber.readLine()) != null){
				System.out.println("I'm on line: " + lineNumber.getLineNumber());
			}
			textReader.close();
			lineNumber.close();
		}catch (IOException e){
			System.out.println("Cannot open selected file");
		}
	}

}
