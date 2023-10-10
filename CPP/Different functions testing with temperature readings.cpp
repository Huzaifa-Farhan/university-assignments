#include <iostream>
#include <fstream>
using namespace std;

const int Array_Size = 22;          //setting array size to 22 as I know the file has 22 values

// function prototypes for all the functions created after int main
double sum(double[], int);
double average(double[], int);
double min(double[], int);
double max(double[], int);
void bsort(double[], int);
void reverse(double[], int);
int bsearch(double[], int, double);
void display(double[], int);
void reset_array(double[], double[], int);

int main() {
    double temps[Array_Size];       //creating a temps array with the size decided above
    double temp2[Array_Size];       //creating a temps2 array with the size decided above
    int Array_Num = 0;              //int variable for function parameters

    ifstream inFile("temprature.txt");      //check for file
    if (!inFile) {                  //if file not found
        cerr << "Error opening file." << endl;          //give the following error string 
        return 1;                       // continue code
    }
    while (Array_Num < Array_Size && inFile >> temps[Array_Num]) {              //read the values from the file and store into the temps array
        Array_Num++;                            //add count to this variable each time a value is read from the file
    }
    inFile.close();         //close the file

    double tempsSum = sum(temps, Array_Num);                    //creating a double variable that runs the sum function created later in the code
    cout << "Temperatures Sum: " << tempsSum << endl;           //output the string and the temperature sum value calculated through the functions below

    double tempsAvg = average(temps, Array_Num);                //creating a double variable that runs the average function created later in the code
    cout << "Temperatures Average: " << tempsAvg << endl;       //output the string and the average temp value calculated through the functions below

    double minTemp = min(temps, Array_Num);                     //creating a double variable that runs the minimum temperature function created later in the code
    cout << "Temperature Min: " << minTemp << endl;             //output the string and the minimum temp value calculated through the functions below

    double maxTemp = max(temps, Array_Num);                     //creating a double variable that runs the minimum temperature function created later in the code
    cout << "Temperature Max: " << maxTemp << endl;             //output the string and the minimum temp value calculated through the functions below
    
    reset_array(temps, temp2, Array_Num);                   //running the function that resets the temp2 array values back to the original file 

    bsort(temp2, Array_Num);                                //running the sorting temperature function created later in the code
    cout << "Sorted Temperatures: ";                            //output the following string
    display(temp2, Array_Num);                              //use the display function to show the new array that was created from bsort

    reset_array(temps, temp2, Array_Num);                   //running the function that resets the temp2 array values back to the original file 

    reverse(temp2, Array_Num);                                  //running the reverse temperature function created later in the code
    cout << "Reversed Temperatures: ";                              //output the following string
    display(temp2, Array_Num);                                  //use the display function to show the new array that was created from reverse

    reset_array(temps, temp2, Array_Num);                       //running the function that resets the temp2 array values back to the original file 

    double target;                                              //creating a double variable for the temperature target value we are looking for in the array
    cout << "Insert Temperature to find its index" << endl;         //output the following string
    cin >> target;                                                  //take user input for the following target variable
    int searchIndex = bsearch(temp2, Array_Num, target);                // creating a int serach variable
    if (searchIndex != -1) {                                                //if the variable is not equal to -1 do the following
        cout << "Temperature " << target << " found at index " << searchIndex << endl;                      //output the following strings and the different variables
    } else {        
        cout << "Temperature " << target << " not found in array." << endl;             //otherwise output the following strings and the different variables
    }

    cout << "Elements of default array: " << endl;                      //output the following string
    display(temps, Array_Num);                                          //use the display function to show the original array

return 0;                   //end code

}

//function to sum all the values in the array
double sum(double arr[], int size) {            //sum function with the double array and int size variable parameters
    double total = 0;                           //double total variable
    for (int i = 0; i < size; i++) {               //for loop to go through all values of array
        total += arr[i];                            //add values into total
    }
    return total;                               //return total value
}

// function to find the average of an array
double average(double arr[], int size) {                    //average function with the double array and int size variable parameters
    double total = sum(arr, size);                          //use the sum function above and store value into variable
    return total / size;                                    // return the average by dividing the sum by the size
}

// function to find the min of an array
double min(double arr[], int size) {                        //minimum function with the double array and int size variable parameters
    double minVal = arr[0];                                 //creating a double variable to hold a value of the array
    for (int i = 1; i < size; i++) {                        // for loop that goes through all values of array
        if (arr[i] < minVal) {                                      // check if the array value is less than the min value
            minVal = arr[i];                                        //if it is than make that array value the min value
        }
    }
    return minVal;                                              //return min value
}

// function to find the max of an array
double max(double arr[], int size) {                        //maximum function with the double array and int size variable parameters
    double maxVal = arr[0];                                 //creating a double variable to hold a value of the array
    for (int i = 1; i < size; i++) {                        // for loop that goes through all values of array
        if (arr[i] > maxVal) {                              // check if the array value is greater than the max value
            maxVal = arr[i];                                    //if it is than make that array value the max value
        }
    }
    return maxVal;                                                  //return min value
}

// function to sort the order of an array
void bsort(double arr[], int size) {                        //sorting function with the double array and int size variable parameters
    for (int i = 0; i < size - 1; i++) {                        // for loop that execute as long as i is less than size - 1
        for (int j = 0; j < size - i - 1; j++) {                // for loop that execute as long as j is less than size - i - 1
            if (arr[j] > arr[j + 1]) {                          //if the array j is greater than array j+1
                double temp = arr[j];                               //store array j value into double temp variable
                arr[j] = arr[j + 1];                                //array j equals to array j + 1
                arr[j + 1] = temp;                                  // store the value from above in the temp array
            }
        }
    }
}

// function to reverse the order of an array
void reverse(double arr[], int size) {                      //reverse function with the double array and int size variable parameters
    for (int i = 0; i < size / 2; i++) {                    // iterate over first half of array
        int j = size - 1 - i;                                  // index of corresponding element in second half of array
        // swap elements at indices i and j
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;                                      //store the new values into the temp array
    }
}

// function to perform binary search on an array and return index of target element
int bsearch(double arr[], int size, double target) {                    //search function with the double array and int size variable parameters       
    for (int i = 0; i < size; i++) {                                    // for loop that goes through all values of array
        if (arr[i] == target) {                                         // look for the taget value through all values in the array
            return i;                                                   //return the index value for when the values are equal
        }
    }
    return -1; // target not found
}

// function to display elements of an array using range-based for loop
void display(double arr[], int size) {                          //display function with the double array and int size variable parameters 
    for (int i = 0; i < size; i++) {                            // for loop that goes through all values of array
        cout << arr[i] << " ";                                  //output each array value with space string in the middle
    }
    cout << endl;                                       //output empty lines
}

// function to reset the array back to the original file order
void reset_array(double temps[], double temp2[], int size){                         //reset function with the double array, different double array, and int size variable parameters 
    for (int i = 0; i < size; i++) {                                                // for loop that goes through all values of array
        temp2[i] = temps[i];                                                        //make temp2 array equal to temp1 values
    }
}