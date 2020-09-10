package BlackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJackGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackJackGame bj = new BlackJackGame();
		Player p1 = new Player(100);
		while(p1.chips > 0) {
			bj.blackJack(p1);
			Character decision = bj.nextRound();
			if(decision == 'q') {
				System.out.println("Thank you for Playing");
				break;
			}
		}
		System.out.println("You Dont have enough chips");
	}
	private void blackJack(Player p1) {
		Dealer dealer = new Dealer();
		Deck curDeck = new Deck();
		System.out.println("You have " + p1.chips + " chips");
		int bet = placeBet();
		if(bet > p1.chips) {
			System.out.println("You don't have enough chips for the bet");
			return;
		}
		p1.chips -= bet;
		int round = 1;
		dealer.hand.add(curDeck.getCard());
		p1.hand.add(curDeck.getCard());
		dealer.hand.add(curDeck.getCard());
		p1.hand.add(curDeck.getCard());
		System.out.println("Your Cards are:" + p1.showHand() + p1.curPoints());
		System.out.println("Dealer's Cards are:" + dealer.foldHand());
		if(p1.gotBlackJack()) {
			p1.chips += 2 * bet + 1;
			System.out.println("You got BlackJack, you won: " + bet + " chips");
			p1.clearHand();
			return;
		}else if(dealer.gotBlackJack()) {
			System.out.println("Dealer's Cards are:" + dealer.showHand() + p1.points);
			System.out.println("Dealer got BlackJack, you lost: " + bet + " chips");
			p1.clearHand();
			return;
		}
		Character decision = QuickOrHitOrStand();
		while(decision == 'h') {
			p1.hand.add(curDeck.getCard());
			System.out.println("Your Cards are:" + p1.showHand() + p1.curPoints());
			if(p1.points.get(0) > 21) {
				System.out.println("You Busted. Lost: " + bet + " chips");
				p1.clearHand();
				break;
			}
			decision = QuickOrHitOrStand();
		}
		if(decision == 's') {
			while(dealer.curPoints().get(0) < 16) {
				dealer.hand.add(curDeck.getCard());
			}
			if(gameResult(p1, dealer)) {
				System.out.println("Dealer's Cards are:" + dealer.showHand() + p1.points);
				System.out.println("You won: " + bet + " chips");
				p1.chips += 2 * bet;
				p1.clearHand();
				return;
			}else {
				System.out.println("Dealer's Cards are:" + dealer.showHand() + p1.points);
				System.out.println("You Lost: " + bet + " chips");
				p1.clearHand();
				return;
			}
		}
	}
	private boolean gameResult(Player p, Dealer dealer) {
		boolean result = false;
		p.curPoints();
		dealer.curPoints();
		if(p.hand.size() == 0) {
			return true;
		}
		if(p.gotBlackJack()) {
			return true;
		}else if(dealer.gotBlackJack()){
			return false;
		}else if(p.points.get(0) > 21) {
			return false;
		}else if(p.points.get(0) > 21){
			return true;
		}else {
			for(Integer e : p.points) {
				for(Integer d : p.points) {
					if(e <= 21 && d <= 21) {
						result = result || e >= d;
					}
				}
			}
		}
		return result;
	}
	private int placeBet() {
		String bet = null;
		try {
			InputStreamReader re = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(re);
			System.out.println("Please Enter Your Bet:");
			bet = br.readLine();
			System.out.println("Your Bet This Round is:" + bet);
		}
		catch(IOException ioe){
			System.out.println("IO Exception");
		}
		return Integer.parseInt(bet);
	}
	private Character QuickOrHitOrStand() {
		Character decision = null;
		try {
			InputStreamReader re = new InputStreamReader(System.in);
			System.out.println("Enter Characters, 'h' for Hit, 's' for Stand");
			Character c = (char)re.read();
			if(c == 'h') {
				decision = 'h';
			}
			if(c == 's') {
				decision = 's';
			}
		}
		catch(IOException ioe){
			System.out.println("IO Exception");
		}
		return decision;
	}
	private Character nextRound() {
		Character decision = null;
		try {
			InputStreamReader re = new InputStreamReader(System.in);
			System.out.println("Another Round? 'y' for yes, 'q' for quit");
			Character c = (char)re.read();
			if(c == 'y') {
				decision = 'y';
			}
			if(c == 'q') {
				decision = 'q';
			}
		}
		catch(IOException ioe){
			System.out.println("IO Exception");
		}
		return decision;
	}
	
}
