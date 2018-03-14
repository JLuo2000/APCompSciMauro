//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;

public class GradeBookFileRunner{
	
   public static void main( String args[] ) throws Exception
   {
		out.println("Welcome to the Class Stats program!");
		
		Scanner file = new Scanner(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 11\\src\\gradebook.dat"));
		file.nextLine();
		String siz = file.nextLine();
		Class c = new Class(siz, file.nextInt()	);
		System.out.println(c);
		int i = 0;
		
		int size = Integer.parseInt(siz);
		while(file.hasNextLine()) {
			c.addStudent(i, new Student(file.nextLine(), file.nextLine()));
			i++;
		}
		for(int ind = 0; i<size; i++) {
			System.out.println(c.getStudentName(ind) + " = " + c);
		}












	}		
}