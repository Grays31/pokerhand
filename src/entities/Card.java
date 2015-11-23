package entities;

import constants.Type;
import constants.Value;

public class Card implements Comparable<Card>{
	
	private Value value;
	private Type type;
	
	public Card(Value _value, Type _type) {
		this.value = _value;
		this.type = _type;
	}

	public Value getValue() { return value; }
	
	public Type getType() { return type; }

	@Override
	public boolean equals(Object _card) {
		boolean result;
	
		if((_card == null) || (getClass() != _card.getClass())){
	        result = false;
	    } else {
	    	Card c = (Card)_card;
	    	result = this.getValue().name().equals(c.getValue().name()) && this.getType().name().equals(c.getType().name());
	    }
		
		return result;
	}
	
	public String toString() {
		return this.value.name() + " " + this.type.name();
	}

	@Override
	public int compareTo(Card c) {
		return this.value.compareTo(c.value);
	}
}
