package vBK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 *  Goals:
 *  Display that is 2/3 game screen (blackjack table & cards) && 1/3 buttons (hit/ stand/ bet etc)
 *  	Top half of game screen == dealer && bottom half == user
 *  
 *  Animation to make cards move from cardstack to area
 */

public class vBGui extends Application{
	// Replace with personal file location because the thing is kinda janky due to PATHs being weird
	// Ignore the fact its called cards but it holds all assets :D
	public final String fileDir =  "C:\\Users\\rtSch\\git\\Visual_Blackjack\\vBlackJack\\src\\vBK\\cards\\";
	
	
	/**
	 * Launches the app :D
	 */
	public void start() {
		launch();
		
	}
	
	/**
	 * Its the win/lose screen
	 * @param Inputs 1-3 and determines what text is displayed when you win
	 */
	public Scene endScreen(int status) {
		return null;
	}
	
	/**
	 * Screen shown when starting up the game for the first time
	 * Consisting of a start button and exit button and image that says stuff
	 * @throws FileNotFoundException 
	 */
	public void startScreen(Group main) throws FileNotFoundException { // Replace to return type Scene to get it to output something...
		// Creates the scene
		//tarto = new Scene(main, 1280, 720);
		
		// Adds to main or smth idk
		main.getChildren().add(imageDisplayer("startScreen.webp"));
		
		// Returns? WAAH
		//return main;
	}
	
	/**
	 * It createa da image thigny
	 * @param cardName
	 * @return ImageView to display on stuff or w/e
	 * @throws FileNotFoundException
	 */
	public ImageView imageDisplayer(String cardName) throws FileNotFoundException {
		// Initializing parts of it or smth
		
		//Unsure why paths dont work
		//FileInputStream stream = new FileInputStream("\\vBK\\src\\vBK\\cards\\" + card(cardIn));
		FileInputStream stream = new FileInputStream(fileDir + cardName);
		Image card = new Image(stream);
		
		// Creating & setting image view
		ImageView imgview = new ImageView(card);
		imgview.setImage(card);
		
		// Returning it
		return imgview;
	}
	
	/**
	 *  Display card
	 * @throws FileNotFoundException 
	 */
	public ImageView showcard(String cardIn) throws FileNotFoundException {
		ImageView imgview = imageDisplayer(card(cardIn));
		
		// Setting size parameters
		// Setting image ratio
		imgview.setFitWidth(80);
		imgview.setFitHeight(80);
		
		return imgview;
	}
	
	/**
	 * Displays certain card
	 * Utilizing a array of card image filepaths to choose the proper one.	
	 * @param takes input card type and corrolates it to hashmap
	 * @return returns respective filepath
	 */
	public String card(String cardtype) {
		// Creating a linked hashmap of the card to corresponding filelocation
		LinkedHashMap<String, String> allCards = new LinkedHashMap<String, String>(){{
			put("ACE_C",  "ace_of_clubs.png");
			put("2_C",    "2_of_clubs.png");
			put("3_C",    "3_of_clubs.png");
			put("4_C",    "4_of_clubs.png");
			put("5_C",    "5_of_clubs.png");
			put("6_C",    "6_of_clubs.png");
			put("7_C",    "7_of_clubs.png");
			put("8_C",    "8_of_clubs.png");
			put("9_C",    "9_of_clubs.png");
			put("10_C",   "10_of_clubs.png");
			put("Queen_C","queen_of_clubs.png");
			put("King_C", "king_of_clubs.png");
			put("Jack_C", "jack_of_clubs.png");
			
			put("ACE_H",  "ace_of_hearts.png");
			put("2_H",    "2_of_hearts.png");
			put("3_H",    "3_of_hearts.png");
			put("4_H",    "4_of_hearts.png");
			put("5_H",    "5_of_hearts.png");
			put("6_H",    "6_of_hearts.png");
			put("7_H",    "7_of_hearts.png");
			put("8_H",    "8_of_hearts.png");
			put("9_H",    "9_of_hearts.png");
			put("10_H",   "10_of_hearts.png");
			put("Queen_H","queen_of_hearts.png");
			put("King_H", "king_of_hearts.png");
			put("Jack_H", "jack_of_hearts.png");
			
			put("ACE_D",  "ace_of_diamonds.png");
			put("2_D",    "2_of_diamonds.png");
			put("3_D",    "3_of_diamonds.png");
			put("4_D",    "4_of_diamonds.png");
			put("5_D",    "5_of_diamonds.png");
			put("6_D",    "6_of_diamonds.png");
			put("7_D",    "7_of_diamonds.png");
			put("8_D",    "8_of_diamonds.png");
			put("9_D",    "9_of_diamonds.png");
			put("10_D",   "10_of_diamonds.png");
			put("Queen_D","queen_of_diamonds.png");
			put("King_D", "king_of_diamonds.png");
			put("Jack_D", "jack_of_diamonds.png");
			
			put("ACE_S",  "ace_of_spades.png");
			put("2_S",    "2_of_spades.png");
			put("3_S",    "3_of_spades.png");
			put("4_S",    "4_of_spades.png");
			put("5_S",    "5_of_spades.png");
			put("6_S",    "6_of_spades.png");
			put("7_S",    "7_of_spades.png");
			put("8_S",    "8_of_spades.png");
			put("9_S",    "9_of_spades.png");
			put("10_S",   "10_of_spades.png");
			put("Queen_S","queen_of_spades.png");
			put("King_S", "king_of_spades.png");
			put("King_S", "king_of_spades.png");
			put("Jack_S", "jack_of_spades.png");
		}};
		
		//System.out.println("works");
		
		return allCards.get(cardtype);
		
	}
	
	/**
	 *  Moving animation of a item to a location
	 *  
	 */
	public void mover(int x, int y) {
		
	}

	/**
	 * Adds card into dealers hand on gui
	 * @param card - Card name
	 */
	public void addDealerCard(String card) {
		
	}
	
	/**
	 * Adds card into users hand on gui
	 * @param card - Card name
	 */
	public void addUserCard(String card) {
		
	}
	
	/**
	 * It shows the game screen and stuff
	 */
	public Scene gameScreen() {
		Group test = new Group();
		
		//Creating the outer area which the right sidebar will contain information & buttons
		BorderPane outer = new BorderPane();
		outer.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
		
		//Info & Action Panel
		VBox userPanel = new VBox();
		
		// Creating elements for the panel
		Label monei = new Label();
		monei.setText("Lol lmao pull and insert anthonys method here");
		//monei.setPadding(30);
		Label currentBet = new Label();
		currentBet.setText("Insert Anthonys Method Here");
		Label currentBid = new Label();
		currentBid.setText("Insert Anthonys Method Here");
		Button up10 = new Button("Bid +10");
		Button stand = new Button("Stand"); //TODO add this
		Button fold = new Button("Fold"); // TODO add this
		
		// Button Actions
		up10.setOnAction(e -> System.out.println("Insert increase bid element")); // Move it into the increase bid method
		
		// Adding elements into panel
		userPanel.setSpacing(30);
		userPanel.setAlignment(Pos.CENTER);
		userPanel.getChildren().addAll(monei, currentBet, currentBid, up10);
		
		// Setting its colors
		userPanel.setBackground(new Background(new BackgroundFill(Color.BROWN, null, null)));
		outer.setRight(userPanel);
		
		// Setting up gamescreen
		BorderPane gameSpace = new BorderPane();
		
		//DealerHand
		HBox dealerStuff = new HBox();
		
		
		
		//UserHand
		HBox userStuff = new HBox();
		
		
		// Inserting it (⁄ ⁄•⁄ω⁄•⁄ ⁄)⁄ 
		gameSpace.setTop(dealerStuff);
		gameSpace.setBottom(userStuff);
		outer.setCenter(gameSpace);
		
		Scene gameScreen = new Scene(outer, 1280, 720);
		return gameScreen;
	}
	
	/**
	 * Creates stuff?
	 * Im not sure why this is here when theres another one abv?
	 */
	@Override
	public void start(Stage gui) throws Exception {
		// Hiarchy
		// Group <- Scene <- Pane type
		
		//Stage gui = new Stage();
		Group blackjack = new Group();
		//startScreen(blackjack);
		Scene temp = new Scene(blackjack, 1280, 720);
		BorderPane setup = new BorderPane();
		
		// Utilize BorderPane format, right side being buttons, rest being the gamespace
		
		
		// Showing cards work :D
		//blackjack.getChildren().add(showcard("10_D"));
		
		gui.setTitle("Blackjack");
		gui.setScene(gameScreen());
		gui.show();
	}
	
}
