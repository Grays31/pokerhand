package constants;

public enum Value {
	TWO, 
	THREE, 
	FOUR, 
	FIVE, 
	SIX, 
	SEVEN, 
	EIGHT, 
	NINE, 
	TEN, 
	JACK, 
	QUEEN, 
	KING,
	AS;

	@Override
	public String toString() {
		if (this.compareTo(JACK) >= 0) {
			return "" + this.name().charAt(0);
		} else {
			return "" + (this.ordinal() + 2);
		}
	}
}
