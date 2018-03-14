//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	private double[] grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList)
	{
		Scanner scan = new Scanner(gradeList);
		grades = new double[scan.nextInt()];
		scan.next();
		for(int i = 0; i<grades.length; i++) {

			if (scan.hasNextDouble()) grades[i] = scan.nextDouble();
			else if (scan.hasNextInt()) grades[i] = scan.nextInt();
		}
		
		
		scan.close();
		


	}
	
	public void setGrade(int spot, double grade)
	{
		grades[spot] = grade;


	}
	
	public double getSum()
	{
		double sum=0.0;
		for (double i : grades) {
			sum+=i;
		}



		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;
		for (double i : grades) {
			if ( i < low) low = i;
		}



		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;

		for (double i : grades) {
			if ( i > high) high = i;
		}



		return high;
	}
	
	public int getNumGrades()
	{
		return grades.length;
	}
	
	public String toString()
	{
		String output="";
		for(double d : grades) {
			output = output+ d + " ";
		}




		return output;
	}	
}