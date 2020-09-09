
import java.util.*;
import java.io.*;

public class EnCoder
{
	public static void main(String [] args)
	{
		HashMap < String, Integer > dictionary = new HashMap < String, Integer > ();
			// HashMap Dictionary for Strings and Integers
		
		String previous;
			// String for Previous
		
		String current;
			// String for Current
		
		String combination;
			// String for Previous + Current
		
		int counter = 256;
			// String for 
		
		String encoded;

		FileReader fr = new FileReader ( "message.txt");
		BufferedReader br = new BufferedReader ( fr );

		previous = "";

		while ( br.ready () )
		{
			current = "" + br.read ();
			combination = previous + current;

			if ( dictionary.containsKey ( combination ) )
			{
				previous = combination;
			}
			else if ( combination.length () == 1 )
			{
				dictionary.put ( combination, 256 + counter );
			}
			else
			{
				dictionary.put((previous + current), counter);
				counter++;
				encoded += " " + dictionary.get(previous);
				previous = current;
			}

			br.close ();
			fr.close ();
		}

		catch ( Exception e )
		{
			System.out.println ( "Error Occured" );
		}

		try
		{
			FileWriter fw = new FileWriter(new File("encoded.txt"));
			BufferedWriter buffer = new BufferedWriter(fw);
			buffer.write(encoded);
			buffer.close();
		}

		catch ( Exception e )
		{
			System.out.println("Error Occured in Writing.");
		}
	}
}