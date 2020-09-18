import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class DeCoder {
	public DeCoder ()
	{	
	}

	public void decode (String fileName) throws IOException
	{
		//reading in a text file and creating print writer
		FileReader fr = new FileReader (fileName);
		BufferedReader reader = new BufferedReader(fr);
		PrintWriter printer = new PrintWriter ("decoded.txt");
		String textFile = "";
		//create hash map to use as dictionary
		HashMap <String, String> dictionary = new HashMap <String,String>();
		//arraylist that stores each encoded value
		ArrayList <String> codes = new ArrayList <String> ();


		//reading in the textFile and storing the whole file as a string
		while (reader.ready())
		{
			char letter = (char)reader.read();
			textFile += letter;
		}
		
		//storing all of the ascii table into the dictionary
		for (int counter = 0; counter < 256; counter++)
		{
			dictionary.put (""+counter, ""+(char)counter);
		}

		
		//reconstructing the dictionary from encoded values and adding encoded values into "codes" arraylist
		String currentCode = "";
		//assign first encoded value to "previousCode"
		String previousCode = textFile.substring(0, textFile.indexOf(" "));
		codes.add(previousCode);
		String dictionaryEntry = "";
		int index = 256;
		
		//while there is still something to decode
		while (textFile.indexOf(" ") > 0)
		{
			//removing previous code from textFile
			textFile = textFile.substring(textFile.indexOf(" ")+1);
			
			//checking for edge case
			if (textFile.indexOf (" ")<0)
			{
				currentCode = textFile;
			}
			else
			{
				currentCode = textFile.substring(0, textFile.indexOf(" "));
			}
			
			codes.add(currentCode);
			
			//if the current encoded value is already in the dictionary
			if (dictionary.get(currentCode)!=null)
			{
				//then new dictionary entry = all of previous code + first letter of current code
				dictionaryEntry = dictionary.get(previousCode) + dictionary.get(currentCode).charAt(0);
			}
			else
			{
				//otherwise, new dictionary entry = all of previous code + first letter of previous code
				dictionaryEntry = dictionary.get(previousCode) + dictionary.get(previousCode).charAt(0);
			}
			
			//adding entry to dictionary hash map
			dictionary.put(""+index, dictionaryEntry);
			previousCode = currentCode;
			index++;
		}

		//compute decoded text from dictionary, output to "decoded.txt"
		for (int counter = 0; counter < codes.size(); counter++)
		{
			printer.print(dictionary.get(codes.get(counter)));
		}

		fr.close();
		printer.close();
		reader.close();



	}
}
