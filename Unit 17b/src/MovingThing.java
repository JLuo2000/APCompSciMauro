//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Locatable
{
	private int xPos;
	private int yPos;

	public MovingThing()
	{
		setX(0);
		setY(0);
		setSpeed(0);
	}

	public MovingThing(int x, int y)
	{
		setPos(x,y);
	}

	public void setPos( int x, int y)
	{
		setX(x);
		setY(y);
	}


	public void setX(int x)
	{
		xPos = x;
	}


	public void setY(int y)
	{
		yPos = y;
	}

	public int getX()
	{
		return xPos;
	}


	public int getY()
	{
		return yPos;
	}

	public abstract void setSpeed( int s );
	public abstract int getSpeed();
	public abstract void draw(Graphics window);

	public void move(String direction)
	{
		if(direction.equals("LEFT") && getX()>=getSpeed()-100)
	      setX(getX()-getSpeed());
		if(direction.equals("RIGHT") && getX()<=800-getSpeed())
		      setX(getX()+getSpeed());
		if(direction.equals("DOWN") && getY()<=1000-getSpeed())
		      setY(getY()+getSpeed());
		if(direction.equals("UP") && getY()>=getSpeed()-50)
		      setY(getY()-getSpeed());
	}

	public String toString()
	{
		return xPos + " " + yPos + " ";
	}
}