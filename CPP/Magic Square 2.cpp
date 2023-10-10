#include <iostream>
using namespace std;

int main() {
  int arr[4][4];          //4 by 4 2d array
  int sum = 0;            // intitialze int sum variable to 0

  // Prompt user to enter 16 values
  cout << "Enter 16 values to form a 4 by 4 array (Press Enter after entering each value):" << endl;                  //output the following string

  // Read in values and check that each number 1-16 is used exactly once
  bool used[17] = { false };                                                                                      // initialize all values in array to false
  for (int i = 0; i < 4; i++) {                                                           //for loop that goes through one of the rows
    for (int j = 0; j < 4; j++) {                                                         //for loop that goes through one of the columns
      cin >> arr[i][j];                                                                  //take 16 user input for the values of 2d array
      if (arr[i][j] < 1 || arr[i][j] > 16 || used[arr[i][j]]) {                           //check for magic square properties. if the values are less than 1 or greater than 16
        cout << "Invalid value entered! Please enter numbers between 1-16." << endl;            //output the following string
        return 0;                                                                                   //end code
      }
      used[arr[i][j]] = true;                                             //otherwise return true and continue
    }
  }

  // Check if the sums of rows, columns, and diagonals are equal
  for (int i = 0; i < 4; i++) {                                            //for loop that goes through one of the rows
    sum += arr[i][0];                                                     //sum variable plus the values of the array
  }
  // Check rows
  for (int i = 0; i < 4; i++) {                                      //for loop that goes through one of the rows
    int row_sum = 0;                                                //intitalize a new row sum int variable
    for (int j = 0; j < 4; j++) {                                   //for loop that goes through one of the columns
      row_sum += arr[i][j];                                             //row sum variable plus the values of the array
    }
    if (row_sum != sum) {                                                                 //if the row sum is not equal to the overall sum which should be 34 in this case then do the following
      cout << "The values entereed do not create a magic square." << endl;                  //output the following string
      return 0;                                                                           //end code
    }
  }
  // Check columns
  for (int j = 0; j < 4; j++) {                                         //for loop that goes through one of the rows
    int col_sum = 0;                                                             //intitalize a new column sum int variable                      
    for (int i = 0; i < 4; i++) {                                        //for loop that goes through one of the rows
      col_sum += arr[i][j];                                         //column sum variable plus the values of the array
    }
    if (col_sum != sum) {                                                        //if the column sum is not equal to the overall sum which should be 34 in this case then do the following
      cout << "The values entereed do not create a magic square." << endl;                    //output the following string
      return 0;                                                                             //end code
    } 
  }
  // Check diagonals
  int diagonal_sum1 = 0;                                                     //intitalize a new diagonal 1 sum int variable   
  int diagonal_sum2 = 0;                                                    //intitalize a new diagonal 2 sum int variable
  for (int i = 0; i < 4; i++) {                                              //for loop that goes through one of the rows
    diagonal_sum1 += arr[i][i];                                                //diagonal 1 sum variable plus the values of the array
    diagonal_sum2 += arr[i][3-i];                                              //diagonal 2 sum variable plus the values of the array
  }
  if (diagonal_sum1 != sum || diagonal_sum2 != sum) {                                             //if the diagonal 1 and 2 sum is not equal to the overall sum which should be 34 in this case then do the following
    cout << "The values entered do not create a magic square." << endl;                             //output the following string
    return 0;                                                                                     //end code
  }

  
  cout << "The values entered create a valid 4x4 magic square." << endl;                        // If all else passes and we make it this far in the code, then the array is a magic square
  return 0;                                                                               //end code
}
