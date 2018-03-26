	//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;

	public Maze()
	{
		maze = new int[0][0];

	}

	public Maze(int size, String line)
	{
		maze = new int [size][size];
		int i = 0;
		for (int r = 0; r<maze.length; r++) {
			for (int c = 0; c < maze.length; c++) {
				maze [r][c] = Integer.parseInt(line.substring(i, i+1));
				i+=2;
			}
		}
	}

	public boolean hasExitPath(int r, int c)
	{
		int[][] temp = maze.clone();
		if (temp[r][c] == 1) {
			if (c == maze.length-1) {
				temp[r][c] = 2;
				return true;
			}
			temp[r][c] = 2;
			if (hasExitPath(r,c+1)) return true;
			if (r!= 0 && hasExitPath(r-1,c)) return true;
			if (r!= maze.length-1 && hasExitPath(r+1,c)) return true;
		}
		return false;
	}

	public String toString()
	{
		boolean path = false;
		String output="";
		for (int[] r : maze) {
			for (int c : r) {
				output += c + " ";
				}
			output += "\n";
			for(int i = 0; i<maze.length; i++) {
				if (hasExitPath(i,0)) {
					path = true;
					break;
				}
				
			}
			
		}
		if (path) {
			output += "exit found";
			return output;
		}
		output += "exit not found";
		return output;
	}
}