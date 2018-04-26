import java.awt.Color;
import java.awt.Graphics;

public class Boost extends MovingThing{

	private int speed;
	private int type;
	
	public Boost(int x, int y,int t) {
		super(x,y);
		setSpeed(3);
		setType(t);
	}
	
	public void setType(int t) {
		type = t;
	}
	public void setSpeed(int s) {
		speed = s;
		
	}

	public int getSpeed() {
		return speed;
	}
	
	public int getType() {
		return type;
	}

	@Override
	public void draw(Graphics window) {
		if(type >=0 && type<10) {
			window.setColor(Color.CYAN);
			window.fillRect(getX()-5, getY()-4, 9, 9);
		}
		else if(type >50 && type<=55) {
			window.setColor(Color.RED);
			window.fillRect(getX()-5, getY()-4, 9, 9);
		}
		else if(type >=10 && type <=50) {
			window.setColor(Color.WHITE);
			window.fillRect(getX()-5, getY()-4, 9, 9);
		}
		else if(type >=95 && type <99) {
			window.setColor(Color.GREEN);
			window.fillRect(getX()-5, getY()-4, 9, 9);
		}
		else if(type == 99) {
			window.setColor(Color.MAGENTA);
			window.fillRect(getX()-1, getY()-1, 10, 10);
		}
		
	}
	
	
}
