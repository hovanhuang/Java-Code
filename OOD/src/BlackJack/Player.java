package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	String name;
	List<Card> hand;
	int chips;
	List<Integer> points;
	Player(int chips){
		this.points = new ArrayList<>();
		this.chips = chips;
		this.hand = new ArrayList<>();
	}
	public String showHand() {
		int size = this.hand.size();
		StringBuilder sb = new StringBuilder();
		for(Card c : this.hand) {
			sb.append(c.showCard());
			sb.append(",");
		}
		return sb.toString();
	}
	public List<Integer> curPoints() {
		boolean aceFlag = false;
		int point = 0;
		if(hand.size() == 0) {
			return points;
		}else {
			StringBuilder sb = new StringBuilder();
			for(Card c : hand) {
				if(c.faceValue == FaceValue.A) {
					aceFlag = true;
				}
				point += c.faceValue.value;
			}
			if(points.size() == 0) {
				points.add(point);
				if(aceFlag) {
					points.add(point + 10);
				}
			}else {
				points.set(0, point);
				if(points.size() == 2) {
					points.set(1, point + 10);
				}
			}
		}
		return points;
	}
	public boolean gotBlackJack() {
		int size = this.points.size();
		if(size == 2 && this.hand.size() == 2 && (this.points.get(0) == 21 || this.points.get(1) == 21)) {
			return true;
		}else {
			return false;
		}
	}
	public List<Integer> getPoint(){
		this.curPoints();
		return this.points;
	}
	void clearHand() {
		hand.removeAll(hand);
		return;
	}
	
}
class Dealer extends Player{
	public Dealer(){
		super(Integer.MAX_VALUE);
	}
	
	public String foldHand() {
		int size = this.hand.size();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			if(i == 0 ) {
				sb.append("<FOLDCARD>");
				continue;
			}
			sb.append(this.hand.get(i).showCard());
			sb.append(",");
		}
		return sb.toString();
	}	
}
