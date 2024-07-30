import java.util.Scanner;

public class MaxPairDifference {

//main method that calculates the max pair difference

    public static int maxPairDifference(int[] arr) {
//checks if the array is less than 2, if so then there are not enough elements to find run the method
        if (arr.length < 2) {
            return -1;
        }
//otherwise the following is done:
        
//instantiate minNum at index 0 of array
        int minNum = arr[0];
        
// set maxdiff to -1 to begin with
        int maxDiff = -1;

//for loop that loops through the whole array
//the if statement checks if the current index element of the array is less than minNum
//if so then, change value of minNum to the value of the element at that specific index
//this is to ensure that the minNum is always holding the smallest values
//otherwise the else statement assumes that we have basically found the right pair       
//the max difference calculation is done recursively and the calculated value is returned
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minNum) {
                minNum = arr[i];
            } else {
                maxDiff = Math.max(maxDiff, arr[i] - minNum);
            }
        }

        return maxDiff;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
//user inputs open for taking array size
//then taking each element of the array through the for loop
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

//run the maxPairDifference method, if the return value is -1 that means no pair was found
//else print the string and the maxPairDifference value that was found
        int result = maxPairDifference(arr);
        if (result == -1) {
            System.out.println("No pair found that satisfies the required condition.");
        } else {
            System.out.println("Maximum difference of the pair that satisfies the condition is " + result);
        }
        scanner.close();
    }
}