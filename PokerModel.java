public class PokerModel{
 
  public static final int RANDOM_GAME = -1;
  public static final int CARDS_IN_HAND = 5;
  public static final int STARTING_POINTS = 100; 
  public static final int POINTS_FOR_NEW_GAME = 10; 
  public static final int ROYAL_FLUSH  = 100;
  public static final int STRAIGHT_FLUSH = 60;
  public static final int FOUR_OF_A_KIND = 50;
  public static final int FULL_HOUSE  = 40;
  public static final int FLUSH = 30;
  public static final int STRAIGHT = 25;
  public static final int THREE_OF_A_KIND = 15;
  public static final int TWO_PAIRS = 10;
  public static final int ONE_PAIR = 7;
  private Deck deck;
  private Hand hand;
  private int points;
  
  public PokerModel(int seed){
    
    points = STARTING_POINTS;
    deck = new Deck(seed);
    
  }
  
  public int getPoints(){
    
    return points;
    
  }
  
  public String getCardFileName(int index){
    
    return "cards/"+hand.getCard(index)+".gif";
    
  }
  
  public Card getCard(int index){
    
    return hand.getCard(index);
    
  }
  
  public void newGame(){
    
    points = points - POINTS_FOR_NEW_GAME;
    deck.shuffle();
    
  }
  
  public void replaceCard(int index){
    
    
    
  }
  
  public String scoreHand(){
    
    if(hand.isRoyalFlush()){
      points = points + ROYAL_FLUSH;
      return "Royal Flush";
      
    }
    else if(hand.isStraightFlush()){
      points = points + STRAIGHT_FLUSH;
      return "Straight Flush";
      
    }
    else if(hand.hasFourOfAKind()){
      points = points + FOUR_OF_A_KIND;
      return "Four of a Kind";
     
    }
    else if(hand.isFullHouse()){
      points = points + FULL_HOUSE;
      return "Full House";
      
    }
    else if(hand.isFlush()){
      points = points + FLUSH;
      return "Flush";
      
    }
    else if(hand.isStraight()){
      points = points + STRAIGHT;
      return "Straight";
      
    }
    else if(hand.hasThreeOfAKind()){
      points = points + THREE_OF_A_KIND;
      return "Three of a Kind";
      
    }
    else if(hand.hasTwoPairs()){
      points = points + TWO_PAIRS;
      return "Two Pairs";
      
    }
    else if(hand.hasOnePair()){
      points = points + ONE_PAIR;
      return "One Pair";
      
    }
    else{
      return "No Pair";
    }   
    
    
  }
  public static void main(String[] args){
    
  }
}