package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordBank {

	private List<String> words;
	private String fileName = "src/repository/resources/words-list.txt";
	
	public WordBank() throws RepositoryException {
		
		Scanner sc = null;
		words = new ArrayList<String>();
		
		try {
			sc = new Scanner(new File(fileName));
			
			if (!sc.hasNextLine())
				throw new RepositoryException("Arquivo de palavras vazio!");
			
			while (sc.hasNextLine()) {				
				String word = sc.nextLine();												
				words.add(word);
			}
			
		} catch (FileNotFoundException e) {
			throw new RepositoryException("Arquivo de palavras não encontrado!");
		} finally {
			if (sc != null)
				sc.close();
		}			
	}
	
	public String getWordRandomly() {
		Random gen = new Random();
		int index = gen.nextInt(words.size());
		return words.get(index);
	}
	
}
