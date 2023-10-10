// We are tasked to write a C++ program to help the program chair with the
// review process. The chair will enter the scores of reviewers either from a
// file or from the standard input (your choice) and then the program return
// “Rejected”, “accepted”, or “borderline”. You can assume the score matrix
// is always 4x5

#include <iostream>
using namespace std;

int main() {
    // Initialize variables
    const int Reviewers = 4;
    const int Criteria = 5;
    int scores[Reviewers][Criteria];                                        // 2D array to store scores
    bool rejected = false;                                              // Paper is rejected flag
    bool borderline = false;                                                        // Paper is borderline flag
    double average_score = 0;                                           // Average score of all reviewers variable

    // Read in scores from standard input
    cout << "Enter the scores for each reviewer, one at a time:\n";         //output the following string
    for (int i = 0; i < Reviewers; i++) {                                           //for loop that loops for each reviewer (4 reviewers in total)
        cout << "Reviewer " << i+1 << ":\n";                                            //output review string with the number and :
        for (int j = 0; j < Criteria; j++) {                                            //for loop within the for loop of reviewers loops 5 timers per reviewer for the critieria score
            cout << "Criteria Score " << j+1 << ": ";                                       //output criteria score string with the number and :
            cin >> scores[i][j];                                                            // Read in score (take user input)
            if (scores[i][j] < 5) {                                                    //if statement that processds when scores are less than 5         
                rejected = true;                                                //If any score is less than 5, reject
            }
        }
    }

    // Calculate average score
    for (int i = 0; i < Reviewers; i++) {                                   //for loop that loops for each reviewer (4 reviewers in total)
        for (int j = 0; j < Criteria; j++) {                                    //for loop within the for loop of reviewers loops 5 timers per reviewer for the critieria score
            average_score += scores[i][j];                                          // Sum up all scores 
        }
    }
    average_score /= Reviewers * Criteria;                                  // Divide by total number of scores

    // Check acceptance rules
    if (rejected) {                                         //if the rejected condition above is met do the following
        cout << "Rejected" << endl;                                    // If any score is less than or equal to 5, output rejected
    } else if (average_score >= 7) {                                    //if the average score is greater than or equal to 7 do the following
        cout << "Accepted" << endl;                                    // Overall average score must be >= 7
    } else if (average_score >= 6) {                                //if the average score is greater than or equal to 6 do the following
        cout << "Borderline" << endl;                                 // Overall average score between 6 and 7, output borderline
    } else {                                                        //otherwise
        cout << "Rejected" << endl;                                 // Overall average score is less than 6, so output rejected
    }
    return 0;                                       //end code
}