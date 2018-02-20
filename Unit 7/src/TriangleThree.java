//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		size = 0;
		letter = "a";
	}

	public void TriangleThree(int count, String let)
	{
		setTriangle(let, count);
		System.out.println(toString());
	}

	public void setTriangle( String let, int sz )
	{
		size = sz;
		letter = let;
	}

	public String getLetter()
	{
		return letter;
	}

	public String toString()
	{
		String output="";
		
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j<=size-i; j++) {
				output = output + " ";
			}
			for (int j = size-i; j<size; j++) {
				output = output + getLetter();
			}
			output = output + "\n";
		}
		
		return output+"\n";
	}
}