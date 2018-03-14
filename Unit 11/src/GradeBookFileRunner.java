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
		Class c = new Class(file.nextLine(), Integer.parseInt(file.nextLine()));
		int length = 0;
		System.out.println(c);
		while(file.hasNextLine()) {
			String name = file.nextLine();
			String grades = file.nextLine();
			c.addStudent(length, new Student(name, grades));
			out.println(c.getStudentName(length) + " = " + grades + "	" + c.getStudentAverage(name));
			length++;
		}
		out.println();
		out.println("Failure List = " + c.getFailureList(70));	
		out.println("Highest Average = " + c.getStudentWithHighestAverage());
		out.println("Lowest Average = " + c.getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",c.getClassAverage()));








file.close();

	}		
}