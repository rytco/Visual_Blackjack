package vBK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
	public final static String fileDir =  "%USERPROFILE%\\git\\Visual_Blackjack\\vBlackJack\\src\\cards\\";
	
	static vBJ_Player egg = new vBJ_Player();
	static vBJ_House house = new vBJ_House();
	
	/**
	 * Launches the app :D
	 */
	public void start() {
		launch();
		
	}
	
	/**
	 * Screen shown when starting up the game for the first time
	 * Consisting of a start button and exit button and image that says stuff
	 * @throws FileNotFoundException 
	 */
	public static Scene startScreen(Stage in) throws FileNotFoundException { // Replace to return type Scene to get it to output something...
		// Creates the scene
		VBox layout = new VBox();
		Scene starto = new Scene(layout, 1280, 720);
		
		
		Button start = new Button("Start Game"); 
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(start);
		
		// Switches scene
		start.setOnAction(e -> in.setScene(gameScreen(in)));
		
		return starto;
	}
	
	/**
	 * It createa da image thigny -- Not sure why i wrote this...
	 * @param cardName
	 * @return ImageView to display on stuff or w/e
	 * @throws FileNotFoundException
	 */
	public static ImageView imageDisplayer(String cardName) throws FileNotFoundException {
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
	 * Primary method of displaing card
	 * @throws FileNotFoundException 
	 */
	public static ImageView showcard(String cardIn) throws FileNotFoundException {
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
	public static String card(String cardtype) {
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
			put("HIDDEN", "backwards_Card.png");
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
	 * Adds card into location hand on gui
	 * @param card - Card name
	 * @param location - where to display the card
	 * @throws FileNotFoundException 
	 */
	public static void addCard(String card, HBox location) throws FileNotFoundException {
		// Adds the card into the location
		location.getChildren().add(showcard(card));
	}
	
	/**
	 * Executes dealers turn
	 * @throws FileNotFoundException 
	 * @throws InterruptedException 
	 */
	public static void dealerTurn(HBox location, Stage in) throws FileNotFoundException, InterruptedException {
		while (house.getScore() <= 16) {
			addCard(house.hit(), location);
			//TimeUnit.SECONDS.sleep(5);
		}
		
		//TimeUnit.SECONDS.sleep(10);
		gameEndSequence(house.getScore(), egg.getScore(), in);
		
		
	}
	
	/**
	 * Varying on what happens determines the end stuff displayed
	 */
	public static void gameEndSequence(int dealScore, int uScore, Stage in) {
		String winner = vB_BlackJackLogic.getWinner(egg, house);
		VBox layout = new VBox();
		Scene endGame = new Scene(layout, 1280, 720);
		egg.nextRound();
		house.nextRound();
		
		Button contine = new Button("Continue");
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(contine);
		
		if (winner.equals("Player")) {
			//TODO Setup images and stuff or w/e
			
			in.setScene(endGame);
		} else if (winner.equals("House")) {
			in.setScene(endGame);
		} else {
			in.setScene(endGame);
		}
		
		contine.setOnAction(e -> {
			in.setScene(gameScreen(in));
		});
		
	}
	
	/**
	 * It shows the game screen and stuff
	 */
	public static Scene gameScreen(Stage in) {
		//Creating the outer area which the right sidebar will contain information & buttons
		BorderPane outer = new BorderPane();
		outer.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
		
		//Info & Action Panel
		VBox userPanel = new VBox();
		
		// Creating elements for the panel
		Label monei = new Label();
		monei.setText(String.format("Balance:%n%d", egg.getBalance()));
		Label betText = new Label(String.format("Bet: %d", egg.bet));
		Button bet = new Button("Bid + 50"); 
		Button hit = new Button("Hit"); 
		Button stando = new Button("Stand");

		// Adding elements into panel
		userPanel.setSpacing(30);
		userPanel.setAlignment(Pos.CENTER);
		userPanel.getChildren().addAll(monei, betText, bet, hit);
		
		// Setting its colors
		userPanel.setBackground(new Background(new BackgroundFill(Color.BROWN, null, null)));
		outer.setRight(userPanel);
		
		// Setting up gamescreen
		BorderPane gameSpace = new BorderPane();
		
		//DealerHand
		HBox dealerStuff = new HBox();
		dealerStuff.setAlignment(Pos.CENTER);
		
		//UserHand
		HBox userStuff = new HBox();
		userStuff.setAlignment(Pos.CENTER);
		
		//initial deal
		try {
			addCard(egg.hit(), userStuff);
			addCard(house.hit(), dealerStuff);
			addCard(egg.hit(), userStuff);
			addCard("HIDDEN", dealerStuff);
			house.hit();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Button Actions
		hit.setOnAction(e -> { //TODO replace with proper method
			try {
				// If its possible to hit runs hit and applies it to proper location
				if (egg.canHit()) {
					addCard(egg.hit(), userStuff);
				} else {
					try {
						dealerTurn(dealerStuff, in);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
		});
		
		bet.setOnAction((e) -> { //Does bet button
			if (egg.bet < egg.getBalance()) {
				egg.placeBet(egg.bet += 50);
				betText.setText(String.format("Bet: %d", egg.bet));
			}
		});
		
		stando.setOnAction(e -> {
			try {
				try {
					dealerTurn(dealerStuff, in);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
		});
		
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
		//Group blackjack = new Group();
		//startScreen(blackjack);
		//Scene temp = new Scene(blackjack, 1280, 720);
		//BorderPane setup = new BorderPane();
		
		// Utilize BorderPane format, right side being buttons, rest being the gamespace
		
		
		// Showing cards work :D
		//blackjack.getChildren().add(showcard("10_D"));
		
		gui.setTitle("Blackjack");
		gui.setScene(startScreen(gui));
		
		gui.show();
	}
	
}
