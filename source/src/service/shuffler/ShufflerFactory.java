package service.shuffler;

import java.util.Random;

public class ShufflerFactory {

	public Shuffler getShufflerRandomly() {
		
		Random rnd = new Random();
		int number = rnd.nextInt();
		
		if (number % 2 == 0)
			return new Inverter();
		else
			return new Disorder();
		
	}
	
}
