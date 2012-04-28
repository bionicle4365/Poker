import java.util.*;

public class Hand{
  
  private Card[] hand;
  public final int CARDS_IN_HAND = 5;
  
  public Hand(Card[] hand){
    
    this.hand = hand;
    
  }
  
  public Card getCard(int index){
    
    if(index<0 || index>4){
     throw new IllegalArgumentException();
    }
    return this.hand[index];
    
  }
  
  public void replace(int index, Card card){
    
    hand[index] = card;
    
  }
  
  public String toString(){
    
    String cards = "";
    for(int i = 0;i<CARDS_IN_HAND;i++){
      cards = cards + hand[i].toString()+" ";
    }
    return cards;
    
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

 public boolean isFlush(){
   int i =0;
   boolean a = false;
   do{
     if(hand[i].getSuit() == hand[i+1].getSuit()){
       a=true;
       i++;
     }
     else{
       a=false;
       break;
     }
   }
   while(i<4 && a);
   return a;
 }

 public boolean isStraight(){
   int i =0;
   boolean a = false;
   do{
     if(hand[i].getValue() == hand[i+1].getValue()-1){
       a=true;
       i++;
     }
     else{
       a=false;
       break;
     }
   }
   while(i<4 && a);
   return a;
 }

 public boolean isStraightFlush(){
   boolean a = false;
   if(isStraight() && isFlush()){
       a = true;
   }
   return a;
 }

 public boolean isRoyalFlush(){
   boolean a = false;
   if(isStraight() && isFlush()){
     if(hand[0].getValue() == 10){
       a = true;
     }
   }
   return a;
 }

 public boolean hasFourOfAKind(){
   boolean a = false;
   for(int i = 0;i<CARDS_IN_HAND;i++){
     int b =0;
     for(int j = 0;j<CARDS_IN_HAND;j++){
       if(hand[i].getValue() == hand[j].getValue()){
         b++;
       }
     }
     if(b ==4){
       a = true;
       break;
     }
   }
   return a;
 }

 public boolean hasThreeOfAKind(){
   boolean a = false;
   for(int i = 0;i<CARDS_IN_HAND;i++){
     int b =0;
     for(int j = 0;j<CARDS_IN_HAND;j++){
       if(hand[i].getValue() == hand[j].getValue()){
         b++;
       }
     }
     if(b ==3){
       a = true;
       break;
     }
   }
   return a;
 }

 public boolean hasTwoPairs(){
   boolean a = false;
   int c = 0;
   for(int i = 0;i<CARDS_IN_HAND;i++){
     int b =0;
     for(int j = 0;j<CARDS_IN_HAND;j++){
       if(hand[i].getValue() == hand[j].getValue()){
         b++;
       }
     }
     if(b ==2){
       c++;
     }
     if(c==4){
       a=true;
       break;
     }
   }
   return a;
 }

 public boolean hasOnePair(){
   boolean a = false;
   int c = 0;
   for(int i = 0;i<CARDS_IN_HAND;i++){
     int b =0;
     for(int j = 0;j<CARDS_IN_HAND;j++){
       if(hand[i].getValue() == hand[j].getValue()){
         b++;
       }
     }
     if(b ==2){
       c++;
     }
   }
   if(c==2){
       a=true;
     }
   return a;
 }
   
 public boolean isFullHouse(){
   boolean a = false;
   if(hasOnePair() && hasThreeOfAKind()){
     a = true;
   }
   return a;
 }
   
 public static void main(String[] args){
   
   Card[] hand = new Card[5];
   Card a = new Card(14,'c');
   Card b = new Card(10,'c');
   Card c = new Card(11,'c');
   Card d = new Card(12,'c');
   Card e = new Card(13,'c');
   hand[0] = a;
   hand[1] = b;
   hand[2] = c;
   hand[3] = d;
   hand[4] = e;
   
   Hand you = new Hand(hand);
   System.out.println(you.toString());
   Hand your = new Hand(you.getSortedHand());
   System.out.println(your.toString());
   System.out.println(your.isFlush());
   System.out.println(your.isStraight());
   System.out.println(your.isStraightFlush());
   System.out.println(your.isRoyalFlush());
   
   b = new Card(14,'c');
   c = new Card(14,'c');
   d = new Card(14,'c'); 
   hand[1] = b;
   hand[2] = c;
   hand[3] = d;
   your = new Hand(you.getSortedHand());
   System.out.println(your.toString());
   System.out.println(your.hasFourOfAKind());
   
   d = new Card(13,'c');
   hand[3] = d;
   your = new Hand(you.getSortedHand());
   System.out.println(your.toString());
   System.out.println(your.hasThreeOfAKind());
   
   a = new Card(12,'c');
   b = new Card(12,'c');
   c = new Card(13,'c');
   d = new Card(13,'c');
   e = new Card(14,'c');
   hand[0] = a;
   hand[1] = b;
   hand[2] = c;
   hand[3] = d;
   hand[4] = e;
   your = new Hand(you.getSortedHand());
   System.out.println(your.toString());
   System.out.println(your.hasTwoPairs());
   System.out.println(your.hasOnePair());
   
   a = new Card(12,'c');
   b = new Card(12,'c');
   c = new Card(13,'c');
   d = new Card(11,'c');
   e = new Card(14,'c');
   hand[0] = a;
   hand[1] = b;
   hand[2] = c;
   hand[3] = d;
   hand[4] = e;
   your = new Hand(you.getSortedHand());
   System.out.println(your.toString());
   System.out.println(your.hasTwoPairs());
   System.out.println(your.hasOnePair());
   
   a = new Card(12,'c');
   b = new Card(12,'c');
   c = new Card(13,'c');
   d = new Card(13,'c');
   e = new Card(13,'c');
   hand[0] = a;
   hand[1] = b;
   hand[2] = c;
   hand[3] = d;
   hand[4] = e;
   your = new Hand(you.getSortedHand());
   System.out.println(your.toString());
   System.out.println(your.hasTwoPairs());
   System.out.println(your.hasOnePair());
   System.out.println(your.hasThreeOfAKind());
   System.out.println(your.isFullHouse());
 }
  
}