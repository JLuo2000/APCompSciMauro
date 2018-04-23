//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Timer refresh;
	private Ship ship;
	private Alien testAlien;
	private Alien alienOne;
	private Alien alienTwo;
	
	private int fireInterval = 100;
	private int fireIntervalBase = 100;
	private int bulletSpeed = 2;
	private int bulletSpeedBase = 2;

	private int score;
	private int multiplier;

	private ArrayList<Alien> aliens = new ArrayList<Alien>();
	private ArrayList<Ammo> shots = new ArrayList<Ammo>();
	
	
	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);
		keys = new boolean[5];
		refresh = new Timer(100, null);
		ship = new Ship(300,600,1);
		//Testing
		aliens.add(new Alien(300, 200, 5,0));

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		ship.draw(window);
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,600,800);
		ship.draw(window);
		
		playerFire(ship, bulletSpeed, 2, window);
		//add code to move stuff
		playerMove();
		enemyMove(window);
		//add in collision detection
		moveShots(window);
		cleanup();
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void cleanup() {
		for(Ammo shot : shots) {
			if(shot.getX() <= 0 || shot.getY() <= 0 || shot.getX() >= 600 || shot.getY() >= 800) {
				shots.remove(shot);
			}
		}
	}
	
	public void moveShots(Graphics window) {
		for(Ammo shot : shots) {
			shot.draw(window);
		}
	}
	
	public void hitDetect() {
		
	}
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}
	
	private void playerFire(Ship ship, int speed, int vector, Graphics window) {
		if(fireInterval >0) {
			fireInterval--;
		}
		else {
			Ammo bullet = new Ammo(ship.getX()+20, ship.getY(), speed, vector, true);
			shots.add(bullet);
			bullet.draw(window);
			fireInterval = fireIntervalBase;
		}
	}
	
	private void playerMove() {
		if(keys[0] == true)
		{
			ship.move("LEFT");
			//System.out.println("moving left");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
			//System.out.println("moving up");
		}
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
	}
	
	private void enemyMove(Graphics window) {
		for (Alien a: aliens) {
			a.draw(window);
		}
	}
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   			refresh.setDelay(10);
   		   //Thread.currentThread().sleep(100);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

