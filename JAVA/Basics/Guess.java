// ****************************************************************
//   Guess.java
//
//   Play a game where the user guesses a number from 1 to 10
//          
// ****************************************************************
import java.util.Scanner;
import java.util.Random;

public class Guess
{
    public static void main(String[] args)
    {
        int numToGuess;       //Number the user tries to guess
        int guess;            //The user's guess

		Scanner scan = new Scanner (System.in);
		Random generator = new Random();
	

		//randomly generate the  number to guess
		numToGuess = generator.nextInt(10)+1;


		//print message asking user to enter a guess
		System.out.println("Please enter a guess");
		guess = scan.nextInt();

	
		//read in guess
		//variables for the while loop
		int numofguess = 0; 
		int toohigh = 0;
		int toolow = 0;

		while (guess != numToGuess) { //keep going as long as the guess is wrong
			System.out.println("Wrong Guess! Please enter another guess: ");
			guess = scan.nextInt();
			if (guess > numToGuess) {
				System.out.println("Guess was too high!");
				toohigh++;
				numofguess++;
				
			}
			else if (guess < numToGuess) {
				System.out.println("Guess was too low!");
				toolow++;
				numofguess++;
			}
		}

		//print message saying guess is right
		numofguess = numofguess + 2;
		System.out.println("Your guess was right!");
		System.out.println("Number of guesses  took: " + numofguess);
	
    }
	
}