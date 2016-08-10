package cards;

import java.util.ArrayList;
import java.util.List;

public class Human {
	
	ArrayList<Card> hand;
	
	Human() {
		hand = new ArrayList<Card>();
	}
	
	public void receiveCards(List<Card> list) {
		hand.addAll(list);
	}
	
	public Card getBid(Card bidOn) {
		int r = (int) (Math.random() * hand.size());
//		System.out.println(r);
		Card c = hand.get(r);
		hand.remove(r);
		return c;
	}
	
	public void result(Card bidOn, Card myBid, Card opponentBid, int result) {
		
	}
	
	public static void main(String[] args) {
		Human h = new Human();
		
		Deck d = new Deck(1);
		
		h.receiveCards(d.removeNCards(13));
		
		Card x = h.getBid(new Card("A","Spade"));
		System.out.println(x.getName());
		
	}

}