//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count = new ArrayList<Integer>();
	private ArrayList<Character> letters = new ArrayList<Character>();
	private String fileName;

	public Histogram()
	{




	}

	public Histogram(char[] values, String fName)
	{
		fileName = fName;
		for(int i = 0; i<values.length; i++) {
			letters.add(values[i]);
		}
		



		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		Scanner file = new Scanner(new File(fileName));
		String temp="";
		while(file.hasNext()) {
			temp += file.next();
		}
		for(int i = 0; i<letters.size(); i++) {
			int c = 0;
			for(int j =0; j<temp.length(); j++) {
				if (letters.get(i) == temp.charAt(j))c++;
			}
			count.add(c);
		}
		file.close();
		System.out.println(count);

	}

	public char mostFrequent()
	{

		return letters.get(count.indexOf(Collections.max(count)));
	}

	public char leastFrequent()
	{


		return letters.get(count.indexOf(Collections.min(count)));
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}