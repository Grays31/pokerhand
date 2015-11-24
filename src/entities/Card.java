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
	    	result = this.value.equals(c.value) && this.type.equals(c.type);
	    }
		
		return result;
	}

	@Override
	public int hashCode() {
		return this.value.hashCode() + this.type.hashCode();
	}

	public String toString() {
		return this.value.toString() + " " + this.type.toString();
	}

	@Override
	public int compareTo(Card c) {
		int compare = this.value.compareTo(c.value);
		// If same value
		if (compare == 0) {
			compare = this.type.compareTo(c.type);
		}
		return compare;
	}

	public int hasSameValue(Card c) {
		return this.value.compareTo(c.value);
	}
}
