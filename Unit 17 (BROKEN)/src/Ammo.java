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

public class Ammo extends MovingThing
{
	private int speed;
	private int vector;
	private boolean player;
	public Ammo()
	{
		this(0,0,0,0, true);
	}

	public Ammo(int x, int y)
	{
		this(x,y,0,0, true);
	}

	public Ammo(int x, int y, int s, int vector, boolean player)
	{
		super(x,y);
		setSpeed(s);
		setVector(vector);
		setPlayer(player);
	}
	public void setPlayer(boolean p) {
		player = p;
	}
	public boolean getPlayer() {
		return player;
	}
	public void setSpeed(int s)
	{
	   speed = s;
	}
	public void setVector(int v) {
		vector = v;
	}
	public int getVector() {
		return vector;
	}
	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.YELLOW);
		window.fillRect(getX(), getY(), 5, 5);

		if (getVector() == 0) {
			super.move("RIGHT");
		}
		else if (getVector() == 1) {
			setSpeed(speed/2);
			super.move("RIGHT");
			super.move("UP");
		}
		else if (getVector() == 2) {
			super.move("UP");
		}
		else if (getVector() == 3) {
			setSpeed(speed/2);
			super.move("LEFT");
			super.move("UP");
		}
		else if (getVector() == 4) {
			super.move("LEFT");
		}
		else if (getVector() == 5) {
			setSpeed(speed/2);
			super.move("LEFT");
			super.move("DOWN");
		}
		else if (getVector() == 6) {
			super.move("DOWN");
		}
		else if (getVector() == 7) {
			setSpeed(speed/2);
			super.move("RIGHT");
			super.move("DOWN");
		}

	}

	public String toString()
	{
		return "";
	}
}
