//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



import java.util.Arrays;
import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{

		Scanner file = new Scanner(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 12\\src\\lab18e.dat"));

		int size = file.nextInt();
		file.nextLine();
		
		Word w = new Word(file.nextLine());
		ArrayList<Word> words = new ArrayList();
		words.add(w);
		
		while(file.hasNextLine()) {
			w = new Word(file.nextLine());
			for(int i = 0; i<words.size(); i++) {
				if (w.compareTo(words.get(i)) <=0) {
					words.add(i, w);
					break;
				}
				
				}
			if(! words.contains(w))words.add(w);
			
		}
		System.out.println(words);
		for(Word x : words) {
			System.out.println(x.toString());
		}










	}
}