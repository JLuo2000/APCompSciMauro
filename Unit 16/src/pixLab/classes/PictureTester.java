package pixLab.classes;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  public static void testKeepOnlyGreen()
  {
    Picture beach = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyGreen();
    beach.explore();
  }
  public static void testKeepOnlyReed()
  {
    Picture beach = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyRed();
    beach.explore();
  }
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  public static void testNegate() {
	  Picture beach = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\beach.jpg");
	    beach.explore();
	    beach.negate();
	    beach.explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  public static void testGrayscale() {
	  Picture caterpillar = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.grayscale();
	  caterpillar.explore();
  }
  public static void testFixUnderwater() {
	  Picture caterpillar = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\water.jpg");
	  caterpillar.explore();
	  caterpillar.fixUnderwater();
	  caterpillar.explore();
  }
  public static void testMirrorVerticalRL()
  {
    Picture caterpillar = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  public static void testMirrorHorizontal() {
	  Picture flower = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\flower1.jpg");
	    flower.explore();
	    flower.mirrorHorizontal();
	    flower.explore();
  }
  public static void testMirrorHorizontalBotToTop() {
	  Picture flower = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\flower2.jpg");
	    flower.explore();
	    flower.mirrorHorizontalBotToTop();
	    flower.explore();
  }
  public static void testMirrorArms() {
	  Picture snowman = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArms();
	  snowman.explore();
  }
  public static void testMirrorGull() {
	  Picture snowman = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\seagull.jpg");
	  snowman.explore();
	  snowman.mirrorGull();
	  snowman.explore();
  }
  public static void testMyCollage()
  {
    Picture canvas = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  public static void testSharpen() {
	  Picture redMoto = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\redMotorcycle.jpg");
	  redMoto.explore();
	  redMoto.sharpen(50,50,500,400);
	  redMoto.explore();

  }
  public static void testEncode() {
	  Picture redMoto = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\redMotorcycle.jpg");
	  redMoto.explore();
	  redMoto.encode(new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\crybytes-apple_icon.jpg"));
	  redMoto.explore();
	  redMoto = redMoto.decode();
	  redMoto.explore();
  }
  
  public static void testMessage() {
	  Picture redMoto = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\redMotorcycle.jpg");
	  redMoto.explore();
	  redMoto.encodeMess("Did you ever hear the tragedy of Darth Plagueis 'The Wise'?");
	  redMoto.explore();
	  redMoto.decodeMess();
  }
  
  public static void testPicEncode() {
	  Picture redMoto = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\redMotorcycle.jpg");
	  redMoto.explore();
	  redMoto.encodePic(new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\msg.jpg"));
	  redMoto.explore();
	  redMoto = redMoto.decodePic();
	  redMoto.explore();
	  redMoto = new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\redMotorcycle.jpg");
	  redMoto.encodePic(new Picture("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 16\\src\\pixLab\\images\\crybytes-apple_icon.jpg"));
	  redMoto.explore();
	  redMoto = redMoto.decodePic();
	  redMoto.explore();  
  }
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorVerticalRL();
	//testMirrorHorizontal();
	//testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
	//testMyCollage();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	//testSharpen();
	  testPicEncode();
  }
}