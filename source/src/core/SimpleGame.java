package core;

import repository.RepositoryException;
import repository.WordBank;
import service.shuffler.ShufflerFactory;

class SimpleGame implements GameMechanic {

	private String selectedWord;
	private String shuffledWord;
	private int times;
	private int points;
	private int maxTimes;
	private boolean endGame;
	
	public SimpleGame() throws GameException {
		this(3);
	}
	
	public SimpleGame(int maxTimes) throws GameException {				
		
		WordBank wordBank;
		
		try {
			wordBank = new WordBank();
			
			ShufflerFactory shufflerFactory = new ShufflerFactory();
			
			this.selectedWord = wordBank.getWordRandomly();
			this.shuffledWord = shufflerFactory.getShufflerRandomly().shuffling(this.selectedWord);
			this.times = 0;
			this.points = 0;
			this.maxTimes = maxTimes;
			
		} catch (RepositoryException e) {
			throw new GameException(e.getMessage());
		}
				
	}
	
	@Override
	public int timesRemain() {		
		return this.maxTimes - this.times;
	}

	@Override
	public boolean match(String userWord) {
		
		if (this.times < this.maxTimes)
			this.times++;
		else
			return false;
		
		if (this.selectedWord.equals(userWord.trim())) {
			this.points = 13 - (this.times * 3);
			this.endGame = true;
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean endGame() {
		if (this.endGame || this.times == this.maxTimes)
			return true;
		else
			return false;
	}

	@Override
	public int points() {
		
		if (this.times == 0)
			return 0;
		else
			return this.points;
	}

	@Override
	public String shuffledWord() {
		return this.shuffledWord;
	}
	
}
