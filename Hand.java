import java.util.*;

public class Hand{
  
  private Card[] hand;
  public final int CARDS_IN_HAND = 5;
  
  public Hand(Card[] hand){
    
    
    
  }
  
  public Card getCard(int index){
    
    
    
  }
  
  public void replace(int index, Card card){
    
    
    
  }
  
  public String toString(){
    
    
    
  }
  
  /**
   * Counts the number of cards with each value in the hand
   * @return tally array containing number of cards of each value from 2 to 14.
	 */
	public int[] getCounts() {
	  int[] counts = new int[Card.HIGHEST_VALUE+1];
		for (int i = 0; i < hand.length; i++) {
			counts[hand[i].getValue()]++;
		}
		return counts;
	}

	/**
	 * Creates a copy of the hand sorted first by value, then by suit
	 * @return copy of the hand sorted first by value, then by suit
	 */
	public Card[] getSortedHand() {
		Card[] sortedHand = Arrays.copyOf(hand, hand.length);
		Arrays.sort(sortedHand);
		return sortedHand;
	}

  
}