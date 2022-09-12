import java.util.Stack;
import java.util.Collections;

class Deck{
	private Stack<Card> deck = new Stack<>();
	/*public class DeckEmpty{
	}*/
	
	public Deck(){ //Constructor should instance every card from 0U to 9A and push to stack (2 for loops)
		for (Suit suit : Suit.values()){
			for (int i = 0; i <= 9; i++){
				Rank rank = new Rank(i);
				Card card = new Card(rank, suit);
				deck.push(card);
				//System.out.println(card);
			}
		}
	}
	
	public void shuffle(){ 
		Collections.shuffle(deck);
	}
	
	public Card deal(){ //verify the deck is not empty, if it is, throw a DeckEmpty Exception
		if (deck.isEmpty())
			throw new IllegalArgumentException("Deck is Empty!");
		return deck.pop();
	}
	
	public boolean isEmpty(){ //is true if empty, otherwise false
		return deck.isEmpty();
	}
}
