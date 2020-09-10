package BlackJack;

import java.util.List;
import java.util.Random;

public class Deck {
	Card[] cardDeck;
	int curCard;
	Deck(){
		this.curCard = 0;
		cardDeck = new Card[52];
		int i = 0; 
		for(FaceValue f : FaceValue.values()) {
			for(Suit s : Suit.values()) {
				Card cur = new Card(f, s);
				cardDeck[i++] = cur;
			}
		}
		this.shuffle();
	}
	private void shuffle() {
		Card[] input = this.cardDeck;
		curCard = 0;
		for(int i = 0; i <= 51; i++) {
			Random rand = new Random();
			int randomNum = rand.nextInt(52);
			swap(input, i, randomNum);
		}
		return;
	}
	private static void swap(Card[] input, int left, int right) {
		Card temp = input[left];
		input[left] = input[right];
		input[right] = temp;
	}
	public Card getCard() {
		return this.cardDeck[curCard++];
	}
	public int getSize() {
		return 52 - curCard;
	}
}
