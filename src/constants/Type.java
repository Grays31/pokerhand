package constants;

public enum Type {
	SPADE, 
	HEART, 
	DIAMOND, 
	CLUB;

	@Override
	public String toString() {
		switch(this.name()) {
			case "SPADE":
				return "♠";
			case "HEART":
				return "♥";
			case "DIAMOND":
				return "♦";
			case "CLUB":
				return "♣";
			default:
				return "N/A";
		}
	}
}
