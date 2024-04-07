package vBK;

import java.util.ArrayList;

public class vBJ_House extends vB_Deck{

	private ArrayList<String> hand = new ArrayList<>();
	private int score;

	/**
	 * Returns the House's cards
	 */
	@Override
	public ArrayList<String> getCurrentHand() {
		return hand;
	}

	
	/**
	 * Retrieves card from deck, gives it to house
	 * Updates score simultaneously
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


	@Override
	int getScore() {
		return score;
	}


}
