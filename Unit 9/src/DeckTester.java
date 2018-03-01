/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"Jack", "Queen", "King", "Ace"};
		String[] suits = {"Hearts","Diamonds","Spades","Clubs"};
		int[] points = {11,12,13,1};
		Deck cards = new Deck(ranks, suits, points);
		System.out.println(cards.deal());
	}
}
