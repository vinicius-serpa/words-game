package test;

import static org.junit.Assert.*;
import org.junit.Test;

import repository.RepositoryException;
import repository.WordBank;

public class WordBankTest {

	@Test
	public void testGetWord() {
		
		WordBank b;
		
		try {
			b = new WordBank();
			String word = b.getWordRandomly();
			assertNotEquals(0, word.length());
		} catch (RepositoryException e) {
			fail(e.getMessage());
		}
		
	}

}
