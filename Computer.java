package cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Computer {

	ArrayList<Card> hand;	
	ArrayList<Card> opponentHand;
	
	ArrayList<Card> diamondsLost;
	ArrayList<Card> diamondsWon;
	
	int myScore;
	int opponentScore;

	HashMap<String, Integer> valueOfCard;  
	
	Computer() {
		hand = new ArrayList<Card>();
		opponentHand = new ArrayList<Card>();
		
		diamondsLost = new ArrayList<Card>();
		diamondsWon = new ArrayList<Card>();
		
		myScore = 0;
		opponentScore = 0;
		
		initValues();
	}
	

	public void initValues() {
		valueOfCard = new HashMap<String, Integer>();
		valueOfCard.put("2", 2);
		valueOfCard.put("3", 3);
		valueOfCard.put("4", 4);
		valueOfCard.put("5", 5);
		valueOfCard.put("6", 6);
		valueOfCard.put("7", 7);
		valueOfCard.put("8", 8);
		valueOfCard.put("9", 9);
		valueOfCard.put("10", 10);
		valueOfCard.put("J", 11);
		valueOfCard.put("Q", 12);
		valueOfCard.put("K", 13);
		valueOfCard.put("A", 14);
	}
	
	public void receiveCards(List<Card> list) {
		hand.addAll(list);
		opponentHand.addAll(list);
	}
		
	public Card strategy(Card c) {
		
		Card chosenOne;
		
		if("AJQK".contains(c.getName())){
			//bid the smallest card
			chosenOne = hand.get(0);
			hand.remove(0);
		}
		else{
			int cardNum = valueOfCard.get(c.getName()) + 2;
			chosenOne = hand.get(cardNum);
			hand.remove(cardNum);
		}		
		
		return chosenOne;
	}
	

	public Card getBid(Card bidOn) {
		
		return strategy(bidOn);		
		
	}
	
	public void result(Card bidOn, Card myBid, Card opponentBid, int result) {
		
		hand.remove(myBid);
		opponentHand.remove(opponentBid);
		
		if(result == 1) {
			diamondsWon.add(bidOn);
			myScore += valueOfCard.get(bidOn.getName());
		}
		else if(result == -1) {
			diamondsLost.add(bidOn);
			opponentScore += valueOfCard.get(bidOn.getName());
		}
		else {
			diamondsLost.add(bidOn);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
		Computer c1 = new Computer();
		Deck d = new Deck(1);
		c1.receiveCards(d.removeNCards(13));
		
		Card testing = c1.getBid(new Card("A", "Spade"));
		System.out.println(testing.getName());
	}
	
}
