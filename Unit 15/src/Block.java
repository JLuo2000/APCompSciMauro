//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{


	}
	public Block (int x, int y) {
		setX(x);
		setY(y);
	}
	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y, int wid, int hei) {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(hei);
	}
	
	public Block(int x, int y, int wid, int hei, Color col) {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(hei);
		setColor(col);
	}
	public void setX (int x){
		xPos = x;
	}
	public void setY (int y) {
		yPos = y;
	}
	public void setWidth (int wid) {
		width = wid;
	}
	public void setHeight (int hei) {
		height = hei;
	}
	
	
	
	
	
   //add the other set methods
   

   public void setColor(Color col)
   {
	   color = col;

   }

   public void draw(Graphics window)
   {
   	
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {


   }
   
	public boolean equals(Object obj)
	{
		Block other = (Block) obj;
		return (xPos == other.xPos && yPos == other.yPos && height == other.height && width == other.width && color == other.color);
	}

	@Override
	public void setPos(int x, int y) {
		setX(x);
		setY(y);
		
	}

	@Override
	public int getX() {
		
		return xPos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}   
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
   //add the other get methods
    public Color getColor() {
    	return color;
    }

   //add a toString() method  - x , y , width, height, color
	public String toString() {
		String output = "";
		output = getX() + " " + getY() + " "+	 getWidth() + " " + getHeight() + " " + getColor();
		
		return output;
	}
	
}