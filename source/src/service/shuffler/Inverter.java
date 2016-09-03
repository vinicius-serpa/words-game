package service.shuffler;

class Inverter implements Shuffler {

	@Override
	public String shuffling(String word) {
		
		char[] charArray = new char[word.length()];
		
		for (int i = 0; i < word.length(); i++) {
			charArray[i] = word.charAt(word.length() - 1 - i);
		}
		
		return new String(charArray);
	}

}
