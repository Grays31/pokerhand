import java.util.ArrayList;

import Constants.Type;
import Constants.Value;
import Entities.Card;
import Entities.Game;
import Entities.Hand;
import Entities.Player;

public class Test {

	public static void main(String[] args) {
		Player p = new Player(new Card(Value.FIVE, Type.DIAMOND), new Card(Value.EIGHT, Type.HEART));
		Game g = new Game();
		g.addPreflop(p);
	
		System.out.println("Cartes : " + p);
		System.out.println("\n\nGame : " + g);
		
		g.addFlop(new Card(Value.JACK, Type.CLUB), new Card(Value.QUEEN, Type.CLUB), new Card(Value.KING, Type.CLUB));
		System.out.println("\n\nGame : " + g);
	
		
		ArrayList<Card> c = new ArrayList<Card>();
		c.add(p.getCard1());
		c.add(p.getCard2());
		c.add(new Card(Value.JACK, Type.CLUB));
		c.add(new Card(Value.QUEEN, Type.CLUB));
		c.add(new Card(Value.KING, Type.CLUB));
		
		try {
			Hand d = new Hand(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
