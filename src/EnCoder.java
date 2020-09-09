
import java.util.*;
import java.io.*;

public class EnCoder
{
	HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
	
	Scanner keyboard = new Scanner ( System.in );
	
	String message;
	String previous;
	String current;
	String combination;

	FileReader fr = new FileReader ( "message.txt");
	BufferedReader br = new BufferedReader ( fr );
	
	previous = null;
	
	while ( br.ready () )
	{
		current = "" + br.read ();
		combination = previous + current;
		
		if ( dictionary.containsKey ( combination ) )
		{
		}
		else
		{
					
		}
				
			}
			
		}
}

/*
{

		message = message + "" + br.read ();
	}
	
	br.close ();
	fr.close ();
}
catch ( Exception e )
{
	System.out.println ( "Error Occured" );
}
*/