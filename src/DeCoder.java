
/*
* Praise be to Ms. Kaufman and Computer Science A teachers.
* They spoke the truth when they spoke of handwritten code and BlueJ. 
* */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class DeCoder{
	public DeCoder(){
	}

	/**
	 * reads in text file of codes reconstructs the original dictionary using a hashmap with
	 * characters as keys and corresponding codes as values decodes the text file using the newly
	 * reconstructed directionary prints decoded text!
	 */
	public void decode(String fileName) throws IOException{
		// reading in a text file and creating print writer
		FileReader fr = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(fr);
		PrintWriter printer = new PrintWriter("decoded.txt");
		String textFile = "";
		// create hash map to use as dictionary
		HashMap<String, String> dictionary = new HashMap<String, String>();
		// arraylist that stores each encoded value
		ArrayList<String> codes = new ArrayList<String>();

		// reading in the textFile and storing as a string
		while (reader.ready()){
			char letter = (char) reader.read();
			textFile += letter;
		}

		// storing all of the ascii table into the dictionary
		for(int counter = 0; counter < 256; counter++){
			dictionary.put("" + counter, "" + (char) counter);
		}

		// reconstructing the dictionary and adding encoded values into "codes" arraylist
		String currentCode = "";
		String previousCode = "";
		String dictionaryEntry = "";
		int index = 256;
		previousCode = textFile.substring(0, textFile.indexOf(" "));
		codes.add(previousCode);
		for(int counter = 0; counter < textFile.length(); counter++){
			// removing previous code from textFile
			textFile = textFile.substring(textFile.indexOf(" ") + 1);
			currentCode = textFile.substring(0, textFile.indexOf(" "));
			codes.add(currentCode);
			// new dictionary entry = all of previous code + first letter of current code
			dictionaryEntry = dictionary.get(previousCode) + dictionary.get(currentCode).charAt(0);
			dictionary.put("" + index, dictionaryEntry);
			previousCode = currentCode;
			index++;
		}

		// computer decoded text from dictionary, outputting to "decoded.txt"
		for(int counter = 0; counter < codes.size(); counter++){
			printer.print(dictionary.get(codes.get(counter)));
		}

		fr.close();
		printer.close();
		reader.close();

	}
}
