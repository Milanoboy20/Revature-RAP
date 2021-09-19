package week_3_excersice;

import java.util.Scanner;
import java.util.Random;

public class ExcersiceOneWeekThree {
	static Scanner input = new Scanner(System.in);
	static Random num = new Random();

	public static void main(String[] args) {
				
		System.out.println("Enter a number between 0 - 12(inclusive):");
		int n = input();
		int next = randomNum();
		check(n, next);
		playAgain();
										
//		System.out.println(n);
//		System.out.println(next);

	}
	
	//This method provides other methods with the user's guessed number
	public static int input() {
		int n = input.nextInt();
		return n;
	}
	
	//This method generates a random number between 0 - 12
	public static int randomNum() {		
		int next = num.nextInt(13);
		return next;
	}
	
	
	//This function checks if the user's guessed number matches the generated random number
	public static void check(int n, int next) {
		
		while(n != next) {

			if(n > next) {				
				System.out.println( n + " is too high. Try again!");				
			} 
			else if(n < next) {
				System.out.println(n + " is too low. Try again!");				
			}
			
			System.out.println("\nEnter your next Guess: ");
			n = input.nextInt();
		}
		
		if(n == next) {
		    System.out.println("Congratulations! You guessed right!");
		    System.out.println("");
		}
	}		
	
	//This method asks the user if they want to play again
	public static void playAgain() {
		System.out.println("Do you want to play again? \nEnter Y for Yes and N for No");
		String yes = input.next();
		
		if(yes.equalsIgnoreCase("Y")) {
			System.out.println("Enter a number between 0 - 12(inclusive):");
			int n = input();
			int next = randomNum();
			check(n, next);
			playAgain();
			
		} else if(yes.equalsIgnoreCase("N")){
			System.out.println("Thank you for playing. See you next time. Bye");
		}
	}

}
