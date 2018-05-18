package pixLab.classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.nio.charset.StandardCharsets;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void encode(Picture messagePict)
  {
	  Pixel[][] messagePixels = messagePict.getPixels2D();
	  Pixel[][] currPixels = this.getPixels2D();
	  Pixel currPixel = null;
	  Pixel messagePixel = null;
	  int count = 0;
	  for (int row = 0; row < this.getHeight(); row++)
	  		{
		  		for (int col = 0; col < this.getWidth(); col++)
		  			{
		  				// if the current pixel red is odd make it even
		  			currPixel = currPixels[row][col];
		  			if (currPixel.getRed() % 2 == 1)
		  				currPixel.setRed(currPixel.getRed() - 1);
		  			messagePixel = messagePixels[row][col];
		  			if (messagePixel.colorDistance(Color.BLACK) < 50)
		  			{
		  				currPixel.setRed(currPixel.getRed() + 1);
		  				count++;
		  			}
	  			}
	  		}
	  System.out.println(count);
  	}
  /**
  * Method to decode a message hidden in the
  * red value of the current picture
  * @return the picture with the hidden message
  */
  public Picture decode()
  {
  Pixel[][] pixels = this.getPixels2D();
  int height = this.getHeight();
  int width = this.getWidth();
  Pixel currPixel = null;

  Pixel messagePixel = null;
  Picture messagePicture = new Picture(height,width);
  Pixel[][] messagePixels = messagePicture.getPixels2D();
  int count = 0;
  for (int row = 0; row < this.getHeight(); row++)
  {
  for (int col = 0; col < this.getWidth(); col++)
  {
  currPixel = pixels[row][col];
  messagePixel = messagePixels[row][col];
  if (currPixel.getRed() % 2 == 1)
  {
  messagePixel.setColor(Color.BLACK);
  count++;
  }
  }
  }
  System.out.println(count);
  return messagePicture;
  }
  
  public void encodePic(Picture pic) {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel[][] toEncode = pic.getPixels2D();
	  for(Pixel[] row : pixels) {
		  for(Pixel pix : row) {
			  if(pix.getBlue()%2 == 1) {
				  pix.setBlue(pix.getBlue()-1);
			  }
		  }
	  }
	  
	  boolean black = false;
	  
	  for (int row = 0; row < toEncode.length; row++) {
		  black = toEncode[row][0].getBlue() == 0;
		  if(black) toEncode[row][0].setBlue(toEncode[row][0].getBlue()+1);
		  for(int i = 1; i<toEncode[row].length; i++) {
			  if(black) {
				  if(toEncode[row][i].getBlue()!=0) {
					  black = !black;
					  pixels[row][i].setBlue(pixels[row][i].getBlue()+1);
					  System.out.println("Encoding White");
				  }
			  }
			  if(!black) {
				  if(toEncode[row][i].getBlue()==0) {
					  black = !black;
					  pixels[row][i].setBlue(pixels[row][i].getBlue()+1);
					  System.out.println("Encoding Black");
				  }
			  }
		  }
	  }
  }
  
  public Picture decodePic() {
	Pixel[][] pixels = this.getPixels2D();
	int height = this.getHeight();
	int width = this.getWidth();
	Pixel currPixel = null;	
	Pixel messagePixel = null;
	
	Picture decoded = new Picture(height, width);
	Pixel[][] decoPix = decoded.getPixels2D();
	
	for(int row = 0; row < height; row++) {
		boolean black = false;
		for(int col = 0; col < width; col++) {
			currPixel = pixels[row][col];
			if(currPixel.getBlue()%2 == 1) {
				black = !black;
			}
			if(black) {
				decoPix[row][col].setBlue(0);
				decoPix[row][col].setGreen(0);
				decoPix[row][col].setRed(0);
			}
		}
	}
	return decoded;
  }
  
  public void encodeMess(String message) {
	  Pixel[][] pixels = this.getPixels2D();
	  int[] toEncode = new int[message.length()];
	  
	  for(int i = 0; i <toEncode.length; i++) {
		  toEncode[i] = (int) message.charAt(i);
	  }
	  
	  for(Pixel[] row : pixels) {
		  for(Pixel pix : row) {
			  if(pix.getGreen()%2 == 1) {
				  pix.setGreen(pix.getGreen()-1);
			  }
		  }
	  }
	  pixels[0][message.length()-1].setGreen(pixels[0][message.length()-1].getGreen()+1);
	  for(int i = 1; i <=toEncode.length; i++) {
		  for(int j = 0; j < 255; j++) {
			  if(toEncode[i-1] == j) {
				  pixels[i][j].setGreen(pixels[i][j].getGreen()+1);
			  }
		  }
	  }
	  
  }
  
  public void decodeMess() {
	  Pixel[][] pixels = this.getPixels2D();
	  String output = "";
	  int length = 0;
	  while(length < pixels[0].length) {
		  length++;
		  if(pixels[0][length].getGreen()%2 == 1) break;
	  }
	  
	  
	  for(int i = 1; i <= length+1; i++) {
		  for(int asc = 0; asc<256; asc++) {
			  if(pixels[i][asc].getGreen()%2 == 1) {
				  output += Character.toString((char) asc);
			  }
		  }
	  }
	  System.out.println(output);
  }
  
  public void encodePic() {
	  Pixel[][] pixels = this.getPixels2D();
  }
  public void keepOnlyBlue() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(0);
	        pixelObj.setGreen(0);
	      }
	    }
  }
  public void keepOnlyGreen() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(0);
	        pixelObj.setBlue(0);
	      }
	    }
  }
  public void keepOnlyRed() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setBlue(0);
	        pixelObj.setGreen(0);
	      }
	    }
  }
  public void negate() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(255-pixelObj.getRed());
	        pixelObj.setGreen(255-pixelObj.getGreen());
	        pixelObj.setBlue(255-pixelObj.getBlue());
	      }
	    }
  }
  
  public void grayscale() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  int gray = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue())/3;
	        pixelObj.setRed(gray);
	        pixelObj.setGreen(gray);
	        pixelObj.setBlue(gray);
	      }
	    }
  }
  
  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  
	          pixelObj.setRed(pixelObj.getRed()*3);
	          pixelObj.setGreen(pixelObj.getGreen());
	          pixelObj.setBlue(pixelObj.getBlue());
	      }
	    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width / 2; col < width; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel botPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++) {
		  for (int col = 0; col<width; col++) {
			  topPixel = pixels[row][col];
			  botPixel = pixels[pixels.length - 1 - row][col];
			  botPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  public void mirrorHorizontalBotToTop() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel botPixel = null;
	  int width = pixels[0].length;
	  for (int row = pixels.length/2; row < pixels.length; row++) {
		  for (int col = 0; col<width; col++) {
			  topPixel = pixels[row][col];
			  botPixel = pixels[pixels.length - 1 - row][col];
			  botPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorArms() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel leftPixel1 = null;
	  Pixel rightPixel1 = null;
	  int width = pixels[0].length;
	  for (int row = 152; row < 197; row++)
	    {
	      // loop from 13 to just before the mirror point
	      for (int col = 100; col < 170; col++)
	      {
	        
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row+50][width +10 - col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    }
	  for (int row = 152; row < 205; row++)
	    {
	      for (int col = 236; col < 305; col++)
	      {
	        rightPixel1 = pixels[row][col];    
	        leftPixel1 = pixels[row+50][width-col];  
	        leftPixel1.setColor(rightPixel1.getColor());
	      }
	    }
  }
  
  public void mirrorGull() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int mirror = 349;
	  for (int row = 233; row < 320; row++)
	    {
	      // loop from 13 to just before the mirror point
	      for (int col = 228; col < mirror; col++)
	      {
	        
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row]                       
	                         [mirror - col + mirror];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    }
  }
  
  
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  public void copy(Picture fromPic, int toRow, int toCol, int startRow, int startCol, int endRow, int endCol) {
	    Pixel fromPixel = null;
	    Pixel toPixel = null;
	    Pixel[][] toPixels = this.getPixels2D();
	    Pixel[][] fromPixels = fromPic.getPixels2D();
	    for(int row = startRow; row<endRow; row++) {
	    	for (int col = startCol; col<endCol; col++) {
	    		fromPixel = fromPixels[row][col];
	    		toPixel = toPixels[toRow + row][toCol+col];
	    		toPixel.setColor(fromPixel.getColor());
	    	}
	    }
	    
  }
  
  public void myCollage() {
	  Picture punisher = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\597_512.jpg");
	  Picture robot = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\robot.jpg");
	  Picture flower1 = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\flower1.jpg");
	  
	  punisher.zeroBlue();
	  this.copy(punisher, 0, 0);
	  robot.keepOnlyBlue();
	  this.copy(robot,0, 560);
	  flower1.mirrorHorizontalBotToTop();
	  this.copy(flower1, 200, 560);
	  this.mirrorVerticalRightToLeft();
  }
  
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\flower1.jpg");
    Picture flower2 = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row+1][col];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void sharpen(int x, int y, int w, int h) {
	  Pixel L = null;
	  Pixel R = null;
	  Pixel[][] pixels = this.getPixels2D();

	  for (int row = x; row<x+w; row++) {
		  for (int col = y; col < y+h; col++) {
			  R = pixels[row][col];
			  L = pixels[row-1][col-1];	
			  int Red = R.getRed()+(R.getRed()-L.getRed())/2;
			  int Green = R.getGreen()+(R.getGreen()-L.getGreen())/2;
			  int Blue = R.getBlue()+(R.getBlue()-L.getBlue())/2;
			  if(Red < 0) {
				  Red = 0;
			  }
			  if(Red > 255) {
				  Red = 255;
			  }
			  if(Green < 0) {
				  Green = 0;
			  }
			  if(Green > 255) {
				  Green = 255;
			  }
			  if(Blue < 0) {
				  Blue = 0;
			  }
			  if(Blue > 255) {
				  Blue = 255;
			  }
			  R.setGreen(Green);
			  R.setBlue(Blue);
			  R.setRed(Red);
			  
		  }
	}
	  System.out.println("Jim Luo");
	  System.out.println("Period 1");
	  System.out.println("4-24-18");
	  System.out.println("F101-24");
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
