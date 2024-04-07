package vBK;

import java.util.ArrayList;

public class vBJ_Player extends vB_Deck{
	
	private ArrayList<String> hand = new ArrayList<>();
	public int bet;
	public int balance = 1000;
	private int score;

	
	/**
	 * Returns Player's hand
	 */
	@Override
	public ArrayList<String> getCurrentHand() {
		return hand;
	}
	
	/**
	 * Retrieves card from deck, gives it to player
	 */
	@Override
	public void hit() {
		String card = deal();
		hand.add(card);
		score = eval(hand);
	}
	
	/**
	 * Resets hand, gets ready for next round
	 */
	public void nextRound() {
		hand.clear();
	}
	
	/**
	 * Place Bet
	 */
	public void placeBet(int bet) {
		this.bet = bet;
	}
	
	public void doubleDown() {
		this.bet *= 2;
	}
	
	@Override
	int getScore() {
		return score;
	}
	
	public boolean canHit() {
		if (this.getScore() < 21) {
			return true;
		}
		return false;
	}
	
	


}
