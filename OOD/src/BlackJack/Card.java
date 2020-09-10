package BlackJack;

public class Card {
	final Suit suit;
	final FaceValue faceValue;
	Card(FaceValue faceValue, Suit suit){
		this.faceValue = faceValue;
		this.suit = suit;
	}
	public int getFV() {
		return this.faceValue.value;
	}
	public String showCard() {
		return "<" + this.faceValue + " "+ this.suit + ">";
	}
}
