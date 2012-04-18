import java.util.*;
public class Deck{
  
  public static final int CARDS_IN_DECK = 52;
  public static final int SHUFFLE_SWAP = 1000;
  private Card[] deck;
  private int nextcard;
  private int seed;
  
  public Deck(int seed){
    
    this.seed = seed;
    this.deck = new Card[CARDS_IN_DECK];
    for(int i=Card.LOWEST_VALUE;i<=Card.HIGHEST_VALUE;i++){
      
      for(int j=0;j<4;j++){
        
        if(j==0){
          deck[4*(i-2)+j] = new Card(i,'c');
        }
        if(j==1){
          deck[4*(i-2)+j] = new Card(i,'d');
        }
        if(j==2){
          deck[4*(i-2)+j] = new Card(i,'s');
        }
        if(j==3){
          deck[4*(i-2)+j] = new Card(i,'h');
        }
        
      }
      
    }
    
  }
  
  public void shuffle(){
    Random rand = null;
      if(this.seed<0){
        rand = new Random();
      }
      else{
        rand = new Random(this.seed);
      }
    for(int i=0;i<SHUFFLE_SWAP;i++){
      int randint1 = rand.nextInt(52);
      int randint2 = rand.nextInt(52);
      Card placeholder1 = this.deck[randint1];
      Card placeholder2 = this.deck[randint2];
      this.deck[randint1] = placeholder2;
      this.deck[randint2] = placeholder1;
    }
  }
  
  public Card nextCard(){
    
    return this.deck[0];
    
  }
  
  public String toString(){
    
    String cards = "";
    for(int i = 0;i<52;i++){
      cards = cards + deck[i]+" ";
    }
    return cards;
    
  }
  
  public static void main(String[] args){
    
    Deck you = new Deck(-1);
    System.out.println(you.toString());
    you.shuffle();
    System.out.println(you.toString());
    
  }
  
}