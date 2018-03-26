//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = null;

	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		int i = 0;
		for(int r = 0; r<3; r++) {
			for (int c = 0; c<3; c++) {
				mat[r][c] = game.charAt(i);
						i++;
			}
		}



	}

	public String getWinner()
	{
		for(char[] r : mat) {
			if (r[0] == r[1] && r[1] == r[2]) {
				return r[0] + " wins horizonally!";
			}
		}
		if ((mat[1][1] == mat[0][0] && mat[1][1] == mat[2][2]) 
				|| (mat[2][0] == mat[1][1] && mat[1][1] == mat[0][2])) {
			return mat[1][1] + " wins diagonally!";
		}
		
		for(int c = 0; c<3; c++) {
			if(mat[1][c] == mat[0][c] && mat[1][c] == mat[2][c]) return mat[0][c]+ " wins vertically!";
		}










		return "A Tie!";
	}

	public String toString()
	{
		String output="";
		for (char[] r : mat) {
			for (char c : r) {
				output += c + " ";
			}
			output += "\n";
		}
		output += getWinner();



		return output+"\n\n";
	}
}