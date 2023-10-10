// **********************************************************
//   Count.java
//
//   This program reads in strings (phrases) and counts the 
//   number of blank characters and certain other letters
//   in the phrase.
// **********************************************************


import java.util.Scanner;

public class Count {
    public static void main(String[] args) 
    {
        String phrase;    // a string of characters
        int countBlank;   // the number of blanks (spaces) in the phrase
        int length;
        char ch;

        Scanner scan = new Scanner(System.in);

        //new variables for loops
        int countA = 0;   // the number of 'a' characters in the phrase
        int countC = 0;   // the number of 'e' characters in the phrase
        int countE = 0;   // the number of 's' characters in the phrase
        int countG = 0;   // the number of 't' characters in the phrase
        

        while (true) {
            // Print a program header
            System.out.println();
            System.out.println("Character Counter");
            System.out.println();

            // Read in a string
            System.out.print("Enter a sentence or phrase: (Type 'quit' to end) ");
            phrase = scan.nextLine();

            // Check if the user wants to quit
            if (phrase.equalsIgnoreCase("quit")) {
                break; // Exit the program if the user enters "quit"
            }

            // Initialize counts
            countBlank = 0;
            countA = 0;
            countC = 0;
            countE = 0;
            countG = 0;

            // Loop through the string character by character
            for (int i = 0; i < phrase.length(); i++) {
                ch = phrase.charAt(i);
                switch (ch) {
                    case ' ':
                        countBlank++;
                        break;
                    case 'a':
                    case 'A':
                        countA++;
                        break;
                    case 'c':
                    case 'C':
                        countC++;
                        break;
                    case 'e':
                    case 'E':
                        countE++;
                        break;
                    case 'g':
                    case 'G':
                        countG++;
                        break;
                }
            }

            // Print the results for the current phrase
            System.out.println();
            System.out.println("Number of blank spaces: " + countBlank);
            System.out.println();
            System.out.println("Number of 'a' characters: " + countA);
            System.out.println("Number of 'c' characters: " + countC);
            System.out.println("Number of 'e' characters: " + countE);
            System.out.println("Number of 'g' characters: " + countG);
        }
    }
}
