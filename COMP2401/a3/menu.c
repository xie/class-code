#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "menu.h"

int intCheck(char *c);

int menu() {
  char input[5];
  int result;

  //used for control flow of while loop, when a valid input is given, breaker will stop loop
  int breaker = 1;

  // holds menu option range LOW
  int lowerBound = 0;

  //hold menu option range HIGH
  int upperBound = 4;

  while (breaker == 1) {
    printf("-----MENU----- \n");
    printf("1 -> Print all employees\n");
    printf("2 -> Print all students\n");
    printf("3 -> Search students using family name\n");
    printf("4 -> Summary of data\n");
    printf("0 -> Quit\n");
    printf("\n");

    printf("Enter selection: ");
    scanf("%s[^\n]\n", input);
    printf("\n");

    //send input to intCheck to verify valid int input
    if (intCheck(input) == 1) {
      //sscanf takes formatted input and turns it into a valid int input
      //points to result memory location
      sscanf(input, "%d", &result);
      //check if input is within menu options
      if (result >= lowerBound && result <= upperBound) {
        breaker = 0;
        break;
      } else {
        //handles inputs not in range of the menu
        printf("Not an option on the menu!");
        printf("\n");
      }
    } else {
      //handles inputs that are not valid int
      printf("The input is invalid, enter an integer as the menu options \n");
    }

  }
  //return user input
  return result;
}
