public class Card implements Comparable{

	public static final char CLUBS = 'c';
	public static final char DIAMONDS = 'd';
	public static final char SPADES = 's';
	public static final char HEARTS = 'h';
	public static final int LOWEST_VALUE = 2;
	public static final int HIGHEST_VALUE = 14;
	private int value;
	private char suit;

	public Card(int value, char suit){
		this.value = value;
		if(value>HIGHEST_VALUE || value<LOWEST_VALUE){
			throw new IllegalArgumentException("A value was invalid.");
		}
		this.suit = suit;
		if(suit != 'c' && suit != 'd' && suit != 's' && suit != 'h'){
			throw new IllegalArgumentException("A suit was invalid.");
		}
	}

	public char getSuit(){
		return suit;
	}

	public int getValue(){
		return value;
	}

	public String toString(){
		return ""+suit+value;
	}

 /**
   * Used for sorting the cards in a player's hand in a game of Poker.
   * Cards are sorted first by value, then by suit.
   * @param o The Card object to which this Card is being compared.
   * @return negative value, if this Card should be before the other Card,
   *         positive value, if this Card should be after the other Card,
   *         0, if this Card has the same suit and value as the other Card,
   *         1, if the object is not a Card
   */
	public int compareTo(Object o) {
		if(o instanceof Card) {
			Card other = (Card)o;
			if (value != other.value) {
        			return value - other.value;
      			}
      			else {
        			return suit - other.suit;
      			}
    		}
    		return 1; //Should not reach here.
  	}

  	public static void main(String[] args){

		Card fourofspade = new Card(4,'s');
		System.out.println(fourofspade.toString());
	}

}
