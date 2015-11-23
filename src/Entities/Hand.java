package entities;

import java.util.ArrayList;
import java.util.Collections;

import constants.Type;
import constants.Value;

public class Hand {

		ArrayList<Card> cards;
		
		public Hand(ArrayList<Card> _cards) throws Exception {
			if(_cards.size() >= 5 && _cards.size() <= 7) {
				cards = new ArrayList<Card>();
				
				for(Card c : _cards)
					cards.add(c);
				
				Collections.sort(cards);
				this.evaluate();
			} else {
				System.out.println(_cards.size());
				throw new Exception("Nombre de cartes invalide pour créer une main");
			}
		}
		
		public void evaluate() {
			Integer[] values = new Integer[13];
			for(int i = 0; i < 13; i++)
				values[i] = 0;
			
			Integer[] types = new Integer[4];
			for(int i = 0; i < 4; i++)
				types[i] = 0;
				
			for(Card c : cards) {
				values[c.getValue().ordinal()]++;
				types[c.getType().ordinal()]++;
			}
			
			//test affichage
			System.out.println("values");
			for(Value v : Value.values()) {
				System.out.println("\t"+v.toString()+" - "+values[v.ordinal()]);
			}
			System.out.println("types");
			for(Type t : Type.values()) {
				System.out.println("\t"+t.toString()+" - "+types[t.ordinal()]);
			}
		}
		
}
