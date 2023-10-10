// b) Write a function which flips the values of an n x n along its diagonal. The diagonal is
// defined as the elements with the same index on both axis (i.e., 0,0 or 1,1 and so on).
// Elements that lie on the diagonal are not changed while other elements are swapped
// with the opposite position (i.e., element in [1] [3] switched with [3] [1]). Ensure that a
// valid matrix is provided.


#include <iostream>
using namespace std;

void magicsquare_flip(int arr[][50], int n) {             //function that flips the array by the diagonal
    for (int i = 0; i < n; i++) {                       //for loop that goes through all rows
        for (int j = i+1; j < n; j++) {                 //for loop that goes through all columns
            // Swap elements that are not on the diagonal
            if (i != j) {
                int temp = arr[i][j];           //assign array values to int temp variable
                arr[i][j] = arr[j][i];          //swap the j values with i 
                arr[j][i] = temp;               //store the swapped values array as temp
            }
        }
    }
}

int main() {
    int arr[50][50];                  //intialize an int array with 50x50 size
    int array_size;                                  //initialize an n int variable for the array size input
    cout << "Enter the size of the matrix: (Max 50) ";                 //output the following string
    cin >> array_size;                                           //take sure input for the value of array size
    cout << "Enter the values to go into the magic square: " << endl;                    // output the following string
    for (int i = 0; i < array_size; i++) {                          //for loop that goes through all rows
        for (int j = 0; j < array_size; j++) {                      //for loop that goes through all columns
            cin >> arr[i][j];                           //take user input for the array values
        }
    }
    magicsquare_flip(arr, array_size);                  //run the function with the array value and array size variables as parameters
    cout << "The matrix after flipping along the diagonal:" << endl;            //output the following string
    for (int i = 0; i < array_size; i++) {                                  //for loop that goes through all rows
        for (int j = 0; j < array_size; j++) {                              //for loop that goes through all columns
            cout << arr[i][j] << " ";                                       //output the flipped values of array with space afterwards
        }
        cout << endl;                   //end line
    }
    return 0;           //end code
}
