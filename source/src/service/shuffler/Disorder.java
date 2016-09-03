package service.shuffler;

import java.util.Random;

class Disorder implements Shuffler {

	@Override
	public String shuffling(String word) {
		
		int usedPositions = 0;
		int len = word.length();
		
		char[] charArray = new char[len];
		char[] charArrayTmp = new char[len];
		int[] usedPositionArray = new int[len];
		
		for (int i = 0; i < len; i++) {
			usedPositionArray[i] = 0;
		}
		
		for (int i = 0; i < len; i++) {																
			charArray[i] = word.charAt(i);
		}
		
		for (int i = 0; i < len; i++) {
			
			if (usedPositions < len) {
				
				Random rnd = new Random();
				int position = rnd.nextInt(len);
				
				while (usedPositionArray[position] == 1) {
					if (position == len - 1)
						position = 0;
					else
						position++;
				}				
				
				usedPositionArray[position] = 1;
				usedPositions++;
				charArrayTmp[i] = charArray[position];
			}
			
		}
			
		return new String(charArrayTmp);
	}

}
