package core;

public class MechanicFactory {

	public GameMechanic getGameMechanic() throws GameException {
		return new SimpleGame();
	}
	
}
