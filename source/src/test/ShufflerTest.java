package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import service.shuffler.Shuffler;
import service.shuffler.ShufflerFactory;

public class ShufflerTest {

	Shuffler s;
	String word;
	String shuffled;
	ShufflerFactory f;
	
	@Before
	public void testInit() {
		s = null;
		word = "brasil";
		shuffled = "";
		f = new ShufflerFactory();
	}
	
	@Test
	public void testInverter() {
				
		while (s == null || !s.getClass().toString().equals("class service.shuffler.Inverter")) 
			s = f.getShufflerRandomly();
					
		shuffled = s.shuffling(word);
		
		assertEquals("lisarb", shuffled);		
	}
	
	@Test
	public void testDisorder() {
		
		while (s == null || !s.getClass().toString().equals("class service.shuffler.Disorder")) 
			s = f.getShufflerRandomly();
					
		shuffled = s.shuffling(word);
		
		assertNotEquals("brasil", shuffled);
		assertEquals(6, shuffled.length());
		assertNotEquals(-1, shuffled.indexOf("b"));
		assertNotEquals(-1, shuffled.indexOf("r"));
		assertNotEquals(-1, shuffled.indexOf("a"));
		assertNotEquals(-1, shuffled.indexOf("s"));
		assertNotEquals(-1, shuffled.indexOf("i"));
		assertNotEquals(-1, shuffled.indexOf("l"));
	}

}
