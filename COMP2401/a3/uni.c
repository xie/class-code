

#include "stdio.h"
#include "stdlib.h"
#include "struct.h"
#include "populateRecords.h"
#include "struct.h"
#include "menu.h"
#include "controller.c"

#define NUM_RECORDS 20


int main(int argc, char const *argv[]) {

  //define array of structs with size NUM_RECORDS
  struct person p[NUM_RECORDS];

  //populate p array
  populateRecords(p, NUM_RECORDS);

  //stores value of menu choice
  int choice;

  //program body
  //loops until user exits
  do {
    //get valid int for menu options
    choice = menu();

    //switch to act on user input menu selection
    switch (choice) {
      case 1:
        //print all employees
        printEmployeeList(p, NUM_RECORDS);
        break;

      case 2:
        //print all students
        printStudentList(p, NUM_RECORDS);
        break;

      case 3:
        //search student by family name
        findStudentByFamilyName(p, NUM_RECORDS);
        break;

      case 4:
        //summary of persons
        summary(p, NUM_RECORDS);
        break;

      case 0:
        //quitting
        quitWarning();
        choice = 1;
        break;
    }

  } while(choice != 0);

  return 0;
}
