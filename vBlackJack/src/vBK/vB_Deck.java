package vBK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Creating the framework for creating people who deal / play
 */
abstract class vB_Deck implements vBI_Actions{
	public static List<String> CardsInPlay = Arrays.asList(
			"ACE_C", "2_C", "3_C", "4_C", "5_C", "6_C", "7_C", "8_C", "9_C", "10_C", "Joker_C", "Queen_C", "King_C", // Clovers
			"ACE_H", "2_H", "3_H", "4_H", "5_H", "6_H", "7_H", "8_H", "9_C", "10_H", "Joker_H", "Queen_H", "King_H", // Hearts
			"ACE_D", "2_D", "3_D", "4_D", "5_D", "6_D", "7_D", "8_D", "9_D", "10_D", "Joker_D", "Queen_D", "King_D", // Diamonds
			"ACE_S", "2_S", "3_S", "4_S", "5_S", "6_S", "7_S", "8_S", "9_S", "10_S", "Joker_S", "Queen_S", "King_S");// Spades
	public static int playerCash = 1000;
	public static int currentBet;
	
	/**
	 * Gets current hand
	 * @return current hand
	 */
	public abstract String getCurrentHand();
	
	
	
}
