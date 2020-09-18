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

		//reading in the textFile and storing as a string
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

		
		//reconstructing the dictionary and adding encoded values into "codes" arraylist
		String currentCode = "";
		String previousCode = textFile.substring(0, textFile.indexOf(" "));
		codes.add(previousCode);
		String dictionaryEntry = "";
		int index = 256;
		while (textFile.indexOf(" ") > 0)
		{
			//removing previous code from textFile
			textFile = textFile.substring(textFile.indexOf(" ")+1);
			if (textFile.indexOf (" ")<0)
			{
				currentCode = textFile;
			}
			else
			{
				currentCode = textFile.substring(0, textFile.indexOf(" "));
			}
			codes.add(currentCode);
			//new dictionary entry = all of previous code + first letter of current code
			if (dictionary.get(currentCode)!=null)
			{
				dictionaryEntry = dictionary.get(previousCode) + dictionary.get(currentCode).charAt(0);
			}
			else
			{
				dictionaryEntry = dictionary.get(previousCode) + dictionary.get(previousCode).charAt(0);
			}
			dictionary.put(""+index, dictionaryEntry);
			previousCode = currentCode;
			index++;
		}

		//computer decoded text from dictionary, outputting to "decoded.txt"
		for (int counter = 0; counter < codes.size(); counter++)
		{
			printer.print(dictionary.get(codes.get(counter)));
		}

		printer.close();
		fr.close();
		reader.close();



	}
}
