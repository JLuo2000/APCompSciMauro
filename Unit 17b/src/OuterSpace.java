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
import java.io.IOException;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;

	private int score;
	private double multiplier;
	private int stage;
	private int bombs;
	
	private boolean doubleFire;
	private boolean invincible;
	private int invincibleTime;
	
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	private ArrayList<Ammo> enemyShots; 
	private ArrayList<Boost> drops;
	
	private Random rng;

	private AudioPlayer music;
	private AudioPlayer explosion;
	private AudioPlayer powerup;
	private AudioPlayer fire;
	private AudioPlayer damaged;
	
	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace() throws UnsupportedAudioFileException, IOException
	{
		setBackground(Color.black);
		music = new AudioPlayer("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17b\\src\\music.wav");
		explosion = new AudioPlayer("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17b\\src\\explosion.wav");
		powerup = new AudioPlayer("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17b\\src\\powerup.wav");
		fire = new AudioPlayer("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17b\\src\\hit.wav");
		damaged = new AudioPlayer("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17b\\src\\damaged.wav");
		keys = new boolean[5];

		ship = new Ship(400,300,5);
		alienOne = new Alien(0, 50, 4);
		alienTwo = new Alien(700, 50, 4);
		doubleFire = false;
		invincible = false;
		invincibleTime = 1000;
		score = 0;
		multiplier = 1;
		stage = 0;
		bombs = 3;
		
		rng = new Random();
		shots = new ArrayList<Ammo>();
		enemyShots = new ArrayList<Ammo>();
		aliens = new ArrayList<Alien>();
		drops = new ArrayList<Boost>();
		aliens.add(alienOne);
		aliens.add(alienTwo);
		this.addKeyListener(this);
		new Thread(this).start();
		music.playMusic();
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

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,1000);

		
		//add code to move stuff
		playerMove();
		shotsMove();
		alienTest(window);
		
		
		//firing
		playerFire();
		enemyFire();
		
		//add in collision detection
		hitDetect();
		invincibleTime--;
		if(invincibleTime <=0) {
			invincible = false;
		}
		graphToBack.setColor(Color.WHITE);
		if(ship.getHealth()>-1) {
			graphToBack.drawString("Shields: " + ship.getHealth() + " Bombs: " + bombs, 650, 50);
		}
		else {
			graphToBack.drawString("DESTROYED!", 700, 50);
		}
		if(invincible) {
			graphToBack.drawString("Invincible for:" + invincibleTime, 650, 100);
		}
		//scoring
		graphToBack.drawString("Score: " + score + "        Multiplier: " + multiplier, 50, 50);
		
		//respawn
		if(aliens.size() == 0) {
			spawn();
		}
		
		
		//redraw
		twoDGraph.drawImage(back, null, 0, 0);
		redraw(window);
	}
	
	public void redraw(Graphics window) {
		ship.draw(window);
		for(Ammo shot : shots) {
			shot.draw(window);
		}
		for(Ammo shot: enemyShots) {
			shot.draw(window);
		}
		for(Alien a : aliens) {
			a.draw(window);
		}
		for(Boost b : drops) {
			b.draw(window);
		}
	}
	
	public void cleanup() {
		clean:
		for(Ammo shot : shots) {
			if(shot.getX() <= 0 || shot.getY() <= 0 || shot.getX() >= 800 || shot.getY() >= 1000) {
				shots.remove(shot);
				break clean;
			}
		}
		clean:
		for(Ammo shot : enemyShots) {
		if(shot.getX() <= 0 || shot.getY() <= 0 || shot.getX() >= 800 || shot.getY() >= 1000) {
			enemyShots.remove(shot);
			break clean;
		}
	}
		shots.removeAll(Collections.singleton(null));
		aliens.removeAll(Collections.singleton(null));
	}
	
	public void hitDetect() {
		if(aliens.size()>0) {
			Hit:
			for (Alien a : aliens) {
				for(Ammo shot : shots) {
					if(shot.getX()>=a.getX() && shot.getX() <= a.getX()+40
						&& shot.getY() >= a.getY() && shot.getY() <= a.getY()+40) {
							shots.remove(shot);
							if(a.gethealth()==0) {
								drops.add(new Boost(a.getX(), a.getY(),rng.nextInt(100)));
								
								aliens.remove(a);
								explosion.play();
								
								System.out.println("Alien Destroyed");
								System.out.println(aliens);
								
								score+= 100*multiplier;
								multiplier += .5;
								
								break Hit;
								
							}
							fire.play();
							a.hit();
							score += 10*multiplier;
							System.out.println("Alien hit");
							System.out.println(a.gethealth());
							break Hit;
						}
					}
				}
		Damaged:
			for (Ammo shot : enemyShots) {
				if(shot.getX()>=ship.getX() && shot.getX() <= ship.getX()+20
						&& shot.getY() >= ship.getY() && shot.getY() <= ship.getY()+20 && !invincible) {
					ship.setHealth(ship.getHealth()-1);
					enemyShots.remove(shot);
					System.out.println("Player Hit");
					multiplier = 1;
					doubleFire = false;
					damaged.play();
					break Damaged;
				}
			}
		}
		if(drops.size()>0) {
			Boost:
			for(Boost b : drops) {
				if(b.getX()>=ship.getX() && b.getX() <= ship.getX()+20
						&& b.getY() >= ship.getY() && b.getY() <= ship.getY()+40) {
					powerup.play();
					if(b.getType()>=0 && b.getType()<10) {
						ship.setHealth(ship.getHealth()+1);
					}
					if(b.getType()>50 && b.getType()<=55) {
						bombs++;
					}
					if(b.getType()>=2 && b.getType()<=50) {
						score += 1000*multiplier;
					}
					if(b.getType()>=95 && b.getType()<99) {
						doubleFire = true;
					}
					if(b.getType()==99) {
						invincible = true;
						invincibleTime = 1000;
					}
					drops.remove(b);
					break Boost;
				}
			}
		}
	}
	
	public void spawn() {
		//testing
		//int wave = 18;
		boolean nextStage = false;
		for(int i = 0; i<stage/50 + 1; i++) {
			nextStage = true;
			int wave = rng.nextInt(10)+stage/2;
			if(wave == 0) {
				aliens.add(new Alien(380,100,3,20,3));
			}
			if(wave == 1) {
				aliens.add(new Alien(380,100,3,10,3));
			}
			if(wave == 1) {
				aliens.add(new Alien(660,100,3,20,3));
				aliens.add(new Alien(100,100,-3,20,3));
			}
			if(wave == 5||wave == 6) {
				aliens.add(new Alien(100,100,5));
				aliens.add(new Alien(200,100,5));
				aliens.add(new Alien(320,100,rng.nextInt(9)+1));
				aliens.add(new Alien(440,100,rng.nextInt(9)+1));
				aliens.add(new Alien(560,100,5));
				aliens.add(new Alien(660,100,5));
			}
			if (wave == 12) {
				int speed = rng.nextInt(2);
				aliens.add(new Alien(100,100,5+speed));
				aliens.add(new Alien(660,100,-(5+speed)));
				aliens.add(new Alien(150,150,5+speed));
				aliens.add(new Alien(610,150,-(5+speed)));
				aliens.add(new Alien(200,200,5+speed));
				aliens.add(new Alien(560,200,-(5+speed)));
			}
			if (wave == 13) {
				for(int x = 0; x<760; x+=110) {
					for(int y = 100; x<=300; x+=100) {
						
						aliens.add(new Alien(x,y,5));
					}
				}
			}
			if (wave == 14) {
				int speed = rng.nextInt(2);
				for(int x = 0; x<760; x+=110) {
					for(int y = 100; x<=300; x+=100) {
						
						aliens.add(new Alien(x,y,5+speed));
					}
				}
			}
			if (wave == 15) {
				for(int x = 0; x < 760; x += 100) {
					aliens.add(new Alien(x,100,5));
				}
				for(int x = 100; x < 760; x += 200) {
					aliens.add(new Alien(x,200,1));
				}
			}
			if (wave == 18) {
				aliens.add(new Alien(380,150,19,2,50));
				aliens.add(new Alien(380,150,-13,3,50));
			}
			if (wave == 19) {
				aliens.add(new Alien(380, 200, 20, 1, 50));
			}
			
		}
		if(stage<10 && nextStage) {
			stage++;
			nextStage = false;
		}
	}
	
	public void alienTest(Graphics window) {
		
		for(Alien a : aliens) {
			a.move("RIGHT");
			if(a.getX() >=760 || a.getX()<=0) {
				a.setSpeed(-a.getSpeed());
			}
		}
		
		
		
	}
	
	public void playerMove() {
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
		}
		if(keys[3] == true&& ship.getY()<=900)
		{
			ship.move("DOWN");
		}
		if(keys[4] == true) {
			bomb();
		}
	}

	public void playerFire() {
		if(ship.fire()) {
			if(doubleFire) {
				shots.add(new Ammo(ship.getX()+8, ship.getY()+10, 20));
				shots.add(new Ammo(ship.getX()+12, ship.getY()+10, 20));
			}
			else {
				shots.add(new Ammo(ship.getX()+10, ship.getY()+10, 20));
			}
			
		}
		
	}
	
	public void bomb() {
		if(bombs>0) {
		for(Alien a : aliens) {
			score+=100*multiplier;
			multiplier += .5;
		}
		aliens.clear();
		for(Ammo s : enemyShots) {
			score += 1*multiplier;
		}
		enemyShots.clear();
		bombs--;
		keys[4] = false;
		explosion.play();
		}
	}
	public void enemyFire() {
		int boost = stage/10;
		for(Alien a : aliens) {
			if(a.fire()) {
				enemyShots.add(new Ammo(a.getX()+20, a.getY()+40,10+boost));
			}
		}
	}
	public void shotsMove() {
		for(Ammo shot : shots) {
			shot.move("UP");
		}
		for(Ammo shot : enemyShots) {
			shot.move("DOWN");
		}
		for(Boost b : drops) {
			b.move("DOWN");
		}
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
		//repaint();
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
		//repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(ship.getHealth()>-1)
   		{
   		   Thread.currentThread().sleep(20);
            repaint();
         }
   		music.stop();
   		AudioPlayer oof = new AudioPlayer("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 17b\\src\\bombardment_explosion_02.wav");
   		oof.play();
      }
   	catch(Exception e)
      {
      }
  	}
}

