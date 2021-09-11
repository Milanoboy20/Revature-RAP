package weeklyexcersices;

public class ExcersiceOne {

	public static void main(String[] args) {
		//Starting value
		int x = 0;
		
		do {
			/*
			 * For my condition, I used the modulo to check if the current number divided by 2
			 * does not have a remainder equal to 0, then that number is odd. If that's the case
			 * I print out that value to the screen
			 */
			if(x % 2 != 0) {							
				System.out.print(x + " ");		
		}
			// I increase x to get the next number to be checked by both the 'if' and 'while' conditions
			x++;
			
		// This condition halts the program when x >= 10 .	
		} while(x < 10);
		
		
	}

}
