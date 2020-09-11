
import java.util.*;
import java.io.*;

public class EnCoder
{
	public static void main ( String [] args )
	{
		// HashMap for Dictionary
		HashMap < String, Integer > dictionary = new HashMap < String, Integer > ();
		
		// String for Previous String
		String previous;
		
		//String for Current String
		String current;
		
		// Counter for New Strings in Dictionary
		int counter = 256;
		
		// Initial Strings
		String line = null;
		String encoded = "";
		String combination = "";
		
		try
		{
			// New File Reader for Text File
			FileReader fr = new FileReader ( "text.txt" );
			
			// New Buffered Reader to Read Text File
			BufferedReader br = new BufferedReader ( fr );
			
			// Initialization of String Previous with No Text
			previous = "";
				
			int a;
			
			// While Loop for All the Strings in the Text File
			while ( ( a = br.read() ) != -1 )
			{
				// Initialization of String Current with String in Text File
				current = String.valueOf ( ( char ) a );
				
				// Initialization of String Combination
				combination = previous + current;
				
				// If the length of the string is one, then it must already be in the dictionary
				if ( combination.length () == 1 )
				{
					previous = combination;
				}
				
				// If the string exists in the dictionary, then previous becomes combination
				else if (dictionary.containsKey ( combination ) )
				{
					previous = combination;
				}

				// If the string is new, then put it in the dictionary
				else
				{
					// Put Combination in the Next Available Position Given by Counter, as long as counter <= 100000 (table limit)
					if (counter <= 100000){
						dictionary.put( (combination), counter );
					}
					
					// Add for Next Counter
					counter++;
					
					//Add the previous String to the encoded String
					//Each number in the code is delimited by a space
					if ( previous.length () == 1 )
					{
						encoded += ( int )( previous.charAt ( 0 ) ) + " ";
					}
					else
					{
						encoded += dictionary.get ( previous ) + " ";
					}
					//Set the previous String to the current String
					previous = current;
					
				}
					
				
			}
			//encode the last segment of text
			if (previous.length() == 1){
				encoded += (int)(previous.charAt(0));
			}
			else{
				encoded += dictionary.get(previous);
			}
			
			//this code prints the dictionary...you're welcome
			//for (String key : dictionary.keySet()){
				//System.out.println(key + ": " + dictionary.get(key));
			//}

			br.close ();
			fr.close ();
		}
				
		catch ( Exception e ){
			System.out.println ( "Error Occured" );
		}
		try {
			//write the encoded string to the encoded file
			FileWriter fw = new FileWriter(new File("encoded.txt"));
			BufferedWriter buffer = new BufferedWriter(fw);
			buffer.write(encoded);
			buffer.close();
		}
		catch (Exception e) {
			System.out.println("Error Occured in Writing.");
		}
	}
}
