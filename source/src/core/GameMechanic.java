package core;

public interface GameMechanic {

	int timesRemain();
	boolean match(String word);
	boolean endGame();
	int points();
	String shuffledWord();	
}
