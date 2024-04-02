package vBK;

import java.io.File;

import javax.swing.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 *  Goals:
 *  Display that is 2/3 game screen (blackjack table & cards) && 1/3 buttons (hit/ stand/ bet etc)
 *  	Top half of game screen == dealer && bottom half == user
 *  
 *  Animation to make cards move from cardstack to area
 */

public class vBGui extends Application{
	/**
	 * Launches the app :D
	 */
	public void start() {
		launch();
		
	}
	
	/**
	 *  Display card
	 */
	public void showcard() {
		// Gets a image of a card and in a animation moves it into ones hand
	}
	
	/**
	 * Displays certain card
	 * Utilizing a array of card image filepaths to choose the proper one.	
	 */
	public void card(String cardtype) {
		
	}
	
	/**
	 *  Shows dealers hand
	 */
	public void showDealer() {
		// In a flipping animation shows the dealers hand
	}
	
	/**
	 *  Moves item to location
	 *  
	 */
	public void mover(int x, int y) {
		
	}

	/**
	 * Creates stuff?
	 * Im not sure why this is here when theres another one abv?
	 */
	@Override
	public void start(Stage gui) throws Exception {
		//Stage gui = new Stage();
		Group blackjack = new Group();
		Scene startscreen = new Scene(blackjack, 1280, 720);
		
		gui.setTitle("Blackjack");
		gui.setScene(startscreen);
		gui.show();
	}
	
}
