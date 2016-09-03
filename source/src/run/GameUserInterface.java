package run;

import java.util.Scanner;

import core.GameException;
import core.GameMechanic;
import core.MechanicFactory;

public class GameUserInterface {

	private static Scanner userInput = new Scanner(System.in);
	
	private static String readUserInput() {
		return userInput.nextLine().trim();
	}
	
	private static void print(String message) {
		System.out.println("## Game info: " + message);
	}
	
	public static void main(String[] args) {
										
		print("Initializing the game!");
		GameMechanic game;
		
		try {
			game = new MechanicFactory().getGameMechanic();
			
			print("The inverted word is: " + game.shuffledWord());
			
			while (!game.endGame()) {
				print("You have " + game.timesRemain() + " attempt(s)!");
				print("Please digit the word");
				String userWord = readUserInput();
				
				if (game.match(userWord)) {
					print("You win!");				
				} else {
					print("Incorret word!");
				}			
			}		
			
			print("Your pontuation is: " + game.points());
			print("End Game!");
			
		} catch (GameException e) {
			print("Erro ao carregar jogo: " + e.getMessage());
		}
		
		
	}	
}
