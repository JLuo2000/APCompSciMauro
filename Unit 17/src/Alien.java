//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;
	private String imageName;
	private int imgSize;

	public Alien()
	{
		this(0,0,0,0);
	}

	public Alien(int x, int y)
	{
		this(x,y,0, 0);
	}

	public Alien(int x, int y, int s, int type)
	{
		super(x, y);
		speed=s;
		if(type == 0) {
			setImage("alien.JPG");
			imgSize = 80;
		}
		else if (type == 1) {
			setImage("Lancer1.png");
			imgSize = 80;
		}
		else if (type == 2) {
			setImage("Micro.png");
			imgSize = 40;
		}
		else if (type == 3) {
			setImage("Pulse.png");
			imgSize = 60;
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	
	public String getName() {
		return imageName;
	}
	
	private void setImage(String file) {
		imageName = file;
		try
		{
			image = ImageIO.read(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17\\src\\" + file));
		}
		catch(Exception e)
		{
			System.out.println("Alien Image not found.");
		}
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),imgSize,imgSize,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
