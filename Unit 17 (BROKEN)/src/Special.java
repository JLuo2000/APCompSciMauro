import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Random ;
public class Special extends MovingThing{
	private int speed;
	private int type;

	public Special() {
		this(0,0,0);
	}
	
	public Special (int x, int y, int t) {
		super.setPos(x, y);
		setSpeed(5);
		setType(t);
	}
	
	public void setSpeed(int s) {
		speed = s;
		
	}
	
	public void setType(int t) {
		type = t;
	}

	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}
	
	

	public void draw(Graphics window) {
		super.move("DOWN");
		
	}
	
}
