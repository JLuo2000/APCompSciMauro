//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{
		wordRay = sentence.split(" ");
		System.out.println(wordRay);
	}

	public String toString()
	{
		String output="";
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i<wordRay.length; i++) {
			if (max < wordRay[i].length()) max = wordRay[i].length();
		}
		
		
		
		return output+"\n\n";
	}
}