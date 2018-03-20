package d18;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}

	public int compareTo( Word rhs )
	{
		if (word.length() < rhs.word.length()) {
			return -1;
		}
		else if (word.length() > rhs.word.length()) {
			return 1;
		}
		else if (word.length() == rhs.word.length()) {
			return word.compareTo(rhs.word);
		}
		
		return 0;
	}

	public String toString()
	{
		return word;
	}
}