//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		sentence = " ";
		lookFor = ' ';
	}

	public void LetterRemover(String s, char rem) {
		setRemover(s, rem);
		System.out.println(toString());
		System.out.println();
	}
	
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned=sentence;
		for (int i = 0; i < cleaned.length(); i++) {
			if (cleaned.charAt(i) == lookFor) {
				cleaned = cleaned.substring(0, i) + cleaned.substring(i+1);
			}
		}




		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters();
	}
}