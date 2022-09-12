import java.util.Stack;
import java.util.Collections.shuffle;

class Deck{
	private Stack<Card> deck = new Stack<>();
	/*public class DeckEmpty{
	}*/
	
	public Deck(){ //Constructor should instance every card from 0U to 9A and push to stack (2 for loops)
		for (
	}
	
	public shuffle(){ 
		Collections.shuffle(deck);
	}
	
	public Card deal(){
		//verify the deck is not empty, if it is, throw a DeckEmpty Exception
	}
	
	public boolean isEmpty(){ //is true if empty, otherwise false
	}
}
