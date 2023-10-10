#include <iostream>
using namespace std;

const char *onesletters[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};           //assign constant character datatype of ones to the following. This is a char array
const char *teensletters[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};            //assign constart character datatype of teens to the following. This is a char array
const char *tensletters[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};                 //assign constart character datatype of tens to the following. This is a char array

void convert_currencyamount_to_string(double currencyamount) {          //function for amount conversion
    int millions = currencyamount / 1000000;                            //int variable for millions, takes value inserted and divide by million
    int thousands = (currencyamount - millions * 1000000) / 1000;               //int variable for thousands, takes value inserted subtracts million variable times 1M all divide by 1 thousand
    int dollars = currencyamount - millions * 1000000 - thousands * 1000;           //int variable for dollars, takes value inserted subtracts million variable times 1M subtract thousand variable times 1000 (technically all divided by 1)
    int cents = (currencyamount - dollars - thousands * 1000 - millions * 1000000) * 100;               
//int variable for cents, takes value inserted subtracts million variable times 1M subtract thousand variable times 1000 subtract dollar variable amount all divided by 100

    if (millions > 0) {                 //if the value of millions is more than 0
        if (millions >= 1000) {            //if the value of millions is more than or equal to 1000
            cout << onesletters[millions / 1000] << " thousand ";           //output the ones letter for the value that corresponds with millions/1000 "one to nice", all followed by a thousand string
            millions %= 1000;                       //millions is equal to millions modolus 1000
        }
        cout << onesletters[millions] << " million ";       //output the ones letters that corresponds to the million variable value "one to nine" all followed by the million string
    }

    if (thousands > 0) {             //if the value of thousands is more than 0
        if (thousands >= 100) {         //if the value of thousands is more than or equal to 100
            cout << onesletters[thousands / 100] << " hundred ";        //output the ones letter for the value that corresponds with thousands/100 "one to nine", all followed by a hundred string
            thousands %= 100;           //thousands is equal to thousands modolus 1000
        }

        if (thousands >= 10) {                   //if the value of thousands is more than or equal to 10
            if (thousands >= 10 && thousands < 20) {                    //if the value of thousands is more than or equal to 10 and less than or equal to 20
                cout << teensletters[thousands % 10] << " ";            //output the corresponding teens letter for the thousands "ten to nineteen" followed by empty string
            } else {                        //othwise
                cout << tensletters[thousands / 10] << " ";         //output the corresponding tens letter for the thousands "tweenty to ninety" followed by empty string
            }
            thousands %= 10;            //thousands is equal to thousands modolus 10
        }

        if (thousands >= 1) {                               //if the thousands value is greater than or equal to 1
            cout << onesletters[thousands] << " thousand ";         //output the ones letter for the value that corresponds with thousands "one to nice", all followed by a thousand string
        }
    }

    if (dollars > 0) {                                      //if the dollar value is greater than 0
        if (dollars >= 100) {                                           //if the value of dollars is more than or equal to 100
            cout << onesletters[dollars / 100] << " hundred ";              //output the ones letter for the value that corresponds with dollar/100 "one to nine", all followed by a hundred string
            dollars %= 100;                             //dollar is equal to dollar modolus 100
        }

        if (dollars >= 10) {                                    //if the dollar value is greater than or equal to 10
            if (dollars >= 10 && dollars < 20) {                    //if the value of dollar is more than or equal to 10 and less than 20
                cout << teensletters[dollars % 10] << " ";          //output the corresponding teens letter for the dollar%10 "ten to nineteen" followed by empty string
            } else {
                cout << tensletters[dollars / 10] << " ";                   //output the corresponding tens letter for the dollar divided by 10 "tweenty to ninety" followed by empty string
            }
            dollars %= 10;                                                        //dollar is equal to dollar modolus 10
        }

        if (dollars >= 1) {                                 //if the dollar value is greater than or equal to 1
            cout << onesletters[dollars] << " ";            //output the ones letter for the value that corresponds with dollar "one to nine", all followed by an empty string
        }
    } else if (millions == 0 && thousands == 0) {           //else if the million value and the thousands value are both equal to 0
        cout << "zero ";                                    //output zero
    }

    cout << "dollars and ";             //output the following string

    if (cents >= 10) {                                    //if the cents value is greater than or equal to 10
        if (cents >= 10 && cents < 20) {                    //if the value of cents is more than or equal to 10 and less than 20
            cout << teensletters[cents % 10] << " ";            //output the corresponding teens letter for the cents % 10 "ten to nineteen" followed by empty string
        } else {
            cout << tensletters[cents / 10] << " ";              //output the corresponding tens letter for the cents divided by 10 "tweenty to ninety" followed by empty string
        }
        cents %= 10;                     //dollar is equal to cents modolus 10
    }

    if (cents >= 1) {                               //if the cents value is greater than or equal to 1
        cout << onesletters[cents] << " ";           //output the ones letter for the value that corresponds with cents "one to nine", all followed by an empty string
    }       

    cout << "cents" << endl;                //output cents
}

int main() {                                //main code
    double currencyamount;                      //assign currency amount as a double variable
    cout << "Enter a currency amount value: ";              //output the following string
    cin >> currencyamount;                               //take user input for the currency amount
    convert_currencyamount_to_string(currencyamount);           //run the currency conversion function created above with the user input value that we just recieved
    return 0;               //end code
}