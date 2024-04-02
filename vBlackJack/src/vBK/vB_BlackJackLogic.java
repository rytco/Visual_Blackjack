package vBK;

public class vB_BlackJackLogic {
	private int[] dealer;
	private int[] user;
	
	public static void main(String[] args) {
		
		/**
		 * Testing
		 */

		vBJ_Player player = new vBJ_Player();
		vBJ_House house = new vBJ_House();
		
		player.hit();
		house.hit();
		System.out.println(player.getCurrentHand());
		System.out.println(house.getCurrentHand());
		
		System.out.println(player.eval(player.getCurrentHand()));
	}
	
	/**
	 * Returns winner of the match
	 * @param player
	 * @param house
	 * @return winner, push
	 */
	public static String getWinner(vBJ_Player player, vBJ_House house) {
		int playerScore = player.eval(player.getCurrentHand());
		int houseScore = house.eval(house.getCurrentHand());
		if (playerScore == houseScore) {
			return "Push";
		}
		else if (playerScore > houseScore) {
			return "Player";
		}
		else {
			return "House";
		}
	}
	
	

}
