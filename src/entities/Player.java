package entities;

public class Player {

	private Card card1;
	private Card card2;
	
	public Player(Card _card1, Card _card2) {
		this.card1 = _card1;
		this.card2 = _card2;
	}
	
	public Card getCard1() { return this.card1; }
	
	public Card getCard2() { return this.card2; }
	
	public String toString() {
		return card1.toString() + " - " + card2.toString();
	}
}
