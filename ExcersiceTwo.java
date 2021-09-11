package weeklyexcersices;

public class ExcersiceTwo {

	// I used the main method for testing.
	public static void main(String[] args) {	
		System.out.println(getAlphabetArray());
		
	}
	
	public static char[] getAlphabetArray() {
		// Array letters[] is initialized to 26 since there are 26 alphabets.
				char[] letters = new char[26];
				
				/*
				 * I Initialized (char start = 'a';) as a start origin
				 * and by increasing 'start++' I am able to  get all the letters beginning at 'a' and ending
				 * at 'z'
				 */				 				
				char start = 'a';
				int i      = 0;
				 do {
					 letters[i++] = start;
					 start++;		 
				/*
				 * For my condition, if the last character of the array letters[] is 'z' and 
				 *  when 'i = 25' the program stops. Since there are 26 alphabets, I initialized i = 0
				 *  and increases to 25. Counting from index letters[0] to letters[25], 
				 *  you will have all 26 letters.
				 */
						 
				 } while((letters[letters.length - 1] != 'z') && i < 26);
				 
//				 System.out.println(letters);

		// This will return the letters[] with all the alphabets from 'a' to 'z' when called.
		return letters;
	}

}
