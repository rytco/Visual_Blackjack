package vBK;
import java.util.Scanner;

public class vB_BlackJackLogic {
	private int[] dealer;
	private int[] user;
	
	public static void main(String[] args) {
		
		/**
		 * Testing
		 */

		vBJ_Player player = new vBJ_Player();
		vBJ_House house = new vBJ_House();
		Scanner input = new Scanner(System.in);
		
		dealStartingCards(player, house);
		
		System.out.println("Player hand/score:");
		System.out.println(player.getCurrentHand());
		System.out.println(player.getScore());
		System.out.println("Dealer hand/score:");
		System.out.println(house.getCurrentHand());
		System.out.println(house.getScore());
		
		while (player.canHit()) {
			System.out.println("enter 'hit' to hit or anything else to stand: ");
			String move = input.next();
			if (move.equals("hit")) {
				player.hit();
				System.out.printf("Drew %s%n", player.getCurrentHand().get(player.getCurrentHand().size() - 1));
				System.out.printf("Score: %s%n", player.getScore());
			}
			else {
				break;
			}
		}
		
		dealerTurn(house);
		
		
		if (getWinner(player, house).equals("Push")) {
			System.out.println("Push (you both got the same amount)");
		}
		else {
			System.out.printf("%s wins!%n", getWinner(player, house));
		}
	}
	
	/**
	 * Returns winner of the match
	 * @param player
	 * @param house
	 * @return winner, push
	 */
	public static String getWinner(vBJ_Player player, vBJ_House house) {
		//Look into implementing this with Compare interface
		//Could also use <? extends Deck> as a return type
		//this would allow us to return the Player or House objects?
		int playerScore = player.getScore();
		int houseScore = house.getScore();
		
		//Player wins if closer to 21 or dealer busts
		if (((playerScore > houseScore || houseScore > 21) && playerScore <= 21) || houseScore > 21) {
			return "Player";
		}
		else if ((houseScore > playerScore || playerScore > 21) && houseScore <= 21) {
			return "House";
		}
		else {
			return "Push";
		}
		
	}
	
	/**
	 * At the beginning of the round, draw initial cards
	 * @param player
	 * @param house
	 */
	public static void dealStartingCards(vBJ_Player player, vBJ_House house) {
		player.hit();
		house.hit();
		player.hit();
		house.hit();
	}
	
	/**
	 * Dealer must draw to 16
	 * Stand on 17
	 * @param house
	 */
	public static void dealerTurn(vBJ_House house) {
		while (house.getScore() <= 16) {
			house.hit();
			System.out.printf("Dealer drew %s%n", house.getCurrentHand().get(house.getCurrentHand().size() - 1));
		}
	}

}
