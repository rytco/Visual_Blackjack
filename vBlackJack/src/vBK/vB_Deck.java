package vBK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *  Creating the framework for creating people who deal / play
 */
abstract class vB_Deck {
	//this has to stay public static so
	//player and dealer objects can draw from (same) deck
	public static List<String> CardsInPlay = Arrays.asList(
			"ACE_C", "2_C", "3_C", "4_C", "5_C", "6_C", "7_C", "8_C", "9_C", "10_C", "Jack_C", "Queen_C", "King_C", // Clovers
			"ACE_H", "2_H", "3_H", "4_H", "5_H", "6_H", "7_H", "8_H", "9_C", "10_H", "Jack_H", "Queen_H", "King_H", // Hearts
			"ACE_D", "2_D", "3_D", "4_D", "5_D", "6_D", "7_D", "8_D", "9_D", "10_D", "Jack_D", "Queen_D", "King_D", // Diamonds
			"ACE_S", "2_S", "3_S", "4_S", "5_S", "6_S", "7_S", "8_S", "9_S", "10_S", "Jack_S", "Queen_S", "King_S");// Spades
	public static int playerCash = 1000;
	public static int currentBet;
	
	
	/**
	 * Gets current hand
	 * @return current hand
	 */
	public abstract ArrayList<String> getCurrentHand();
	
	/**
	 * Adds a random card to the users deck and then removes it from cards in play
	 */
	public void deal(ArrayList<String> inputDeck) {
		
	}
	
	//evaluate the value of an ace
	public int evalAce(int score) {
		if (score <= 10) {
			return 11;
		} 
		else {
			return 1;
		}
	}
	public int eval(ArrayList<String> hand) {
		int numOfAces = 0;
		int score = 0;
	 
		for (int k = 0; k < hand.size(); k++) {
			if (hand.get(k).contains("ACE")) {
				numOfAces++;
			}
			else if (hand.get(k).contains("Queen") || hand.get(k).contains("King") || hand.get(k).contains("Jack")) {
				score += 10;
			}
			else {
				score += Integer.parseInt(hand.get(k).split("_")[0]);
			}
		}
		for (int j = 0; j < numOfAces; j++) {
			score += evalAce(score);
		}
		return score;
	}
	
	public boolean fold() {
		return false; 
	}

	public String deal() {
		Random r = new Random(System.currentTimeMillis());
		int randomCardIndex = r.nextInt(CardsInPlay.size());
		String card = CardsInPlay.get(randomCardIndex);
		CardsInPlay.remove(randomCardIndex);
		return card;
	}

	
}
