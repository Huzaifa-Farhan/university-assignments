import java.util.Stack;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the character sequence: ");
        String userInput = scanner.nextLine();

        String correctedOutput = correctInput(userInput);
        
        System.out.println("Corrected Output: " + correctedOutput);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
    
    public static String correctInput(String input) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : input.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        
        // Convert the stack to a string
        StringBuilder correctedOutput = new StringBuilder();
        for (char ch : stack) {
            correctedOutput.append(ch);
        }
        
        return correctedOutput.toString();
    }


}
