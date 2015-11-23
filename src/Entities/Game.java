package Entities;
import java.util.ArrayList;

import Constants.State;
import Constants.Type;
import Constants.Value;

public class Game {

	private State state;
	
	private Card flop1;
	private Card flop2;
	private Card flop3;
	
	private Card turn;
	
	private Card river;
	
	private ArrayList<Card> cards;
	
	public Game() {
		this.state = State.INIT;
		this.flop1 = null;
		this.flop2 = null;
		this.flop3 = null;
		this.turn = null;
		this.river = null;
		
		cards = new ArrayList<Card>();
		for(Type t : Type.values())
			for(Value v : Value.values())
				cards.add(new Card(v, t));
	}
	
	public void addPreflop(Player _hand) {
		this.state = State.PREFLOP;
		
		try {
			if(!(cards.remove(_hand.getCard1()) && cards.remove(_hand.getCard2())))
				throw new Exception("Erreur dans la liste des cartes");
		} catch(Exception e) {
			System.out.println("marche pas");
			System.exit(1);
		}
	}
	
	public void addFlop(Card _flop1, Card _flop2, Card _flop3) {
		this.state = State.FLOP;
		
		this.flop1 = _flop1;
		this.flop2 = _flop2;
		this.flop3 = _flop3;
		
		try {
			if(cards.contains(_flop1) && cards.contains(_flop2) && cards.contains(_flop3)) {
				cards.remove(_flop1);
				cards.remove(_flop2);
				cards.remove(_flop3);
			} else
				throw new Exception("Erreur dans la liste des cartes");
		} catch(Exception e) {
			System.exit(1);
		}
	}
	
	public void addTurn(Card _turn) {
		this.state = State.TURN;
		
		this.flop1 = _turn;
		
		try {
			if(cards.contains(_turn)) {
				cards.remove(_turn);
			} else
				throw new Exception("Erreur dans la liste des cartes");
		} catch(Exception e) {
			System.exit(1);
		}
	}
	
	public void addRiver(Card _river) {
		this.state = State.RIVER;
		
		this.flop1 = _river;
		
		try {
			if(cards.contains(_river)) {
				cards.remove(_river);
			} else
				throw new Exception("Erreur dans la liste des cartes");
		} catch(Exception e) {
			System.exit(1);
		}
	}
	
	public State getState() { return this.state; }
	
	public String toString() {
		String toString = this.state.name() + "\n";
		
		for(Card c : cards) {
			toString += "\t" + c.getValue().name() + " " + c.getType().name() + "\n";
		}
		toString += cards.size() + " cartes";
		return toString;
	}
}
