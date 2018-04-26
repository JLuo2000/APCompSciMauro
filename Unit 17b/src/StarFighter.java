//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.Component;
import java.io.IOException;

public class StarFighter extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 1000;

	public StarFighter() throws UnsupportedAudioFileException, IOException
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] ) throws UnsupportedAudioFileException, IOException
	{
		StarFighter run = new StarFighter();
	}
}