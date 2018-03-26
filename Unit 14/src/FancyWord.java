//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{
		mat = null;
	}

   public FancyWord(String s)
	{
	   mat = new char [s.length()][s.length()];
	   
	   for (int i = 0; i<s.length(); i++) {
		   mat[0][i] = s.charAt(i);
	   }
	   for (int i = 0; i<s.length()/2 + 1; i++) {
		   int opp = mat.length-(1+i);
		   mat[i][i] = s.charAt(i);
		   mat[opp][i] = s.charAt(i);
		   mat[i][opp] = s.charAt(opp);
		   mat[opp][opp] = s.charAt(opp);
	   }
	   for (int i = 0; i<s.length(); i++) {
		   mat[s.length()-1][i] = s.charAt(i);
	   }



	}

	public String toString()
	{
		String output="";
		for (char[]r : mat) {
			for(char c : r) {
				output +=c;
			}
			output += "\n";
		}




		return output+"\n\n";
	}
}