#include <iostream>     //Required for cin, cout, cerr
#include <fstream>      //Required for ifstream, ofstream.
using namespace std;

int main() {
    ifstream inputFile("resistances.txt"); // open input file named resistance.txt (file needs to be in same folder)      
    if (!inputFile.is_open()) {         //if the file is not open
        cout << "Failed to open the input file." << endl;       //output the following string and end line
        return 1;       //error while executing code
    }

    double r1, r2, r3, r4, r5, r6;          //set all resistor values to double datatype
    while (inputFile >> r1 >> r2 >> r3 >> r4 >> r5 >> r6) {         //while loop to take the values for resistance from the file
        double lhs = (r1 + r2) * r4 * r6;           //use values from above for the leftside equation calculation
        double rhs = (r3 + r4) * r1 * r5;           //use values from above for the rightside equation calculation (assuming that the denominator part of the equation is sent to the right of the equation)
        if (lhs == 7.5 * rhs) {                 //if statement which is true when leftside is equal to rightside times 7.5
            cout << "Good Design:" << "     " << r1 << '\t' << r2 << '\t' << r3 << '\t'     //output the good design string, followed by the empty space, then all the resistance values with tab(space) after them
                 << r4 << '\t' << r5 << '\t' << r6 << endl;                 // output all the resistance values with tab(space) after them, then end the line
        } else {        //if statement is not true then do this
            cout << "Bad Design:" << "     "  << r1 << '\t' << r2 << '\t' << r3 << '\t'     //output the bad design string, followed by the empty space, then all the resistance values with tab(space) after them
                 << r4 << '\t' << r5 << '\t' << r6 << endl;                         // output all the resistance values with tab(space) after them, then end the line
        }
    }

    inputFile.close(); // close input file
    return 0; //end code
}
