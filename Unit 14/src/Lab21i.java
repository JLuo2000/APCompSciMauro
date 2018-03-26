//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner (new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 14\\src\\lab21i.dat"));
		
		Maze maze = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
		out.println(maze);
		maze = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
		out.println(maze);
		maze = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
		out.println(maze);
		maze = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
		out.println(maze);
		maze = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
		out.println(maze);
		maze = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
		out.println(maze);
	

	}
}