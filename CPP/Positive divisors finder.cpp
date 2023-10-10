#include <iostream>         //Required for cin, cout, cerr
using namespace std;        

int main() {
    char response;          //set response as a character datatype
    do {            //do loop that works with the while loop at the end
        int n;          //setting n as the integer datatype
        cout << "This program is designed to exhibit the positive divisors\n"
             << "of positive integers supplied by you. The program will\n"      //output the following paragraph string
             << "repeatedly prompt you to enter a positive integer. Each\n"
             << "time you enter a positive integer, the program will print\n"
             << "all the divisors of your integer in a column and in\n"
             << "decreasing order.\n\n"
             << "Please enter a positive integer: ";
        cin >> n;       //take user input for n
        if (n <= 0) {       //if condition which works when n is less than or equal to 0
            cout << "\n" << n << " is not a positive integer.\n";       //output to user for n input value followed by the specific string
            continue;               // loop to the next iteration
        }
        for (int i{ n }; i >= 1; i--){          //for loop for i = n, when i is greater than or equal to 1, minus 1, loop again
			if (n % i == 0){                //if statement which is true when the modulous is equal to 0
                cout << i << "\n";          // output i value then end line
		}
        }
    
        cout << "\nWould you like to see the divisors of another integer (Y/N)? ";      //output the following string
        cin >> response;                                               //user input for the response character datatype
        while (response != 'Y' && response != 'y' && response != 'N' && response != 'n') {          //while loop which only goes further if the input is NOT y, Y, n, N
            cout << "Please respond with Y (or y) for yes and N (or n) for no.\n"                   //output the following string and end line
                 << "Would you like to see the divisors of another integer (Y/N)? ";                //output the following string
            cin >> response;                //take user input again for the response character datatype
        }
        cout << "\n";               //output empty line
    } while (response == 'Y' || response == 'y');           //while loop that connects to do, and sends to start of do only when response input is y or Y
    return 0;           //end code
}
