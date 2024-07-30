//Huzaifa Farhan (100741975)
//Data Structures Assignment 2 Q2
import java.util.Scanner;

public class Hashing {
    
	//the main method of this java file, which contains all strings and outputs
	//this methods reads two integers, numberOfAssociations and numberOfFiles, using a Scanner. 
	//numberOfAssociations represents the number of MIME type associations provided
	//numberOfFiles is the number of filenames for which the MIME type needs to be determined.
	//Two arrays, extensions and mimeTypes, are then initialized to store file extensions and their corresponding MIME types
	//Their sizes are set to numberOfAssociations since each association includes one extension and its MIME type.
	//The method then enters a loop to read each MIME type association. 
	//It reads a file extension and its MIME type from each line, 
	//converts the extension to lowercase 
	//stores them in the extensions and mimeTypes arrays.
	//The method processes each filename to determine its MIME type. It reads the filename, 
	//uses the getMimeType method to find its MIME type and prints the result.
	
    public static void main(String[] args) {
        // Create a scanner to read input from standard input
        Scanner inputScanner = new Scanner(System.in);

        // Prompt the user for the number of MIME type associations
        System.out.println("Enter the number of MIME type elements which make up the association table: ");
        int numberOfAssociations = inputScanner.nextInt();

        // Prompt the user for the number of files to analyze
        System.out.println("Enter the number of files to be analyzed: ");
        int numberOfFiles = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume the remaining newline character

        // Arrays to store file extensions and their corresponding MIME types
        String[] extensions = new String[numberOfAssociations];
        String[] mimeTypes = new String[numberOfAssociations];

        // Inform the user to enter MIME type associations
        System.out.println("Enter the MIME type associations (example format: html text/html):");

        // Read and store MIME type associations
        for (int i = 0; i < numberOfAssociations; i++) {
            // Read the file extension, convert it to lowercase for case-insensitive comparison
            extensions[i] = inputScanner.next().toLowerCase();
            // Read the corresponding MIME type
            mimeTypes[i] = inputScanner.next();
            inputScanner.nextLine(); // Move to the next line
        }

        // Prompt the user to enter file names
        System.out.println("Enter the file names to be analyzed: ");

        // Process each file name to determine its MIME type
        for (int i = 0; i < numberOfFiles; i++) {
            String fileName = inputScanner.nextLine();
            String mimeType = getMimeType(fileName, extensions, mimeTypes);
            System.out.println("MIME type for \"" + fileName + "\": " + mimeType); // Output the determined MIME type
        }
        
     // Close the scanner to prevent resource leak
        inputScanner.close(); 
    }


    //This method is determines the MIME type of a given file based on its extension. 
    //starts by assuming an "UNKNOWN" MIME type (kind of like a base case). 
    //It locates the last dot (.) in the filename to find the extension. 
    //If there is no dot or  there's no extension, the method will return "UNKNOWN". 
    //If an extension is found, the method extracts it and converts it to lowercase to ensure case-insensitivity. 
    //then the method iterates through the extensions array to find a matching extension. 
    //If a match is found, it sets the result to the corresponding MIME type from the mimeTypes array. 
    //The MIME type is returned. Again; If no matching extension is found in the array, the method returns "UNKNOWN".
    
    private static String getMimeType(String fileName, String[] extensions, String[] mimeTypes) {
        String result = "UNKNOWN"; // Default MIME type if none is found
        int dotIndex = fileName.lastIndexOf("."); // Find the last occurrence of '.'

        // Check if the file has an extension
        if (dotIndex != -1 && dotIndex != fileName.length() - 1) {
            // Extract the file extension and convert it to lowercase
            String fileExtension = fileName.substring(dotIndex + 1).toLowerCase();

            // Search for the extension in the array of known extensions
            for (int i = 0; i < extensions.length; i++) {
                // If a match is found, set the result to the corresponding MIME type
                if (fileExtension.equals(extensions[i])) {
                    result = mimeTypes[i];
                    break; // Stop searching once a match is found
                }
            }
        }

        return result; // Return the determined MIME type or "UNKNOWN"
    }
}
