package vBK;

import javafx.stage.Stage;

public class vB_Main {

	/**
	 * Used to initalize and run the files
	 * @param args
	 */
	public static void main(String[] args) {
		vBGui gui = new vBGui();
		vB_BlackJackLogic logic = new vB_BlackJackLogic();
		
		try {
			gui.start();
			gui.card("2_C");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
