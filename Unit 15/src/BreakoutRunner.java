//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class BreakoutRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public BreakoutRunner()
	{
		super("Breakthrough");
		setSize(WIDTH,HEIGHT);
		
		Breakout game = new Breakout();
		((Component)game).setFocusable(true);
		getContentPane().add(game);
						
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		BreakoutRunner run = new BreakoutRunner();
	}
}