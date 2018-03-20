	//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;

	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for(int i =0; i<word.length();i++) {
			for(int j = 0; j<vowels.length(); j++) {
				if(word.charAt(i) == vowels.charAt(j)) vowelCount ++;
				
			}
		}





		return vowelCount;
	}

	public int compareTo(Word rhs)
	{
		if (numVowels() < rhs.numVowels()) {
			return -1;
		}
		else if (numVowels() > rhs.numVowels()) {
			return 1;
		}
		else if (numVowels() == rhs.numVowels()) {
			return word.compareTo(rhs.word);
		}
		
		return 0;

	}

	public String toString()
	{
		return word;
	}
}