#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "ctype.h"

#include "student.h"
#include "employee.h"

//checks that all chars are valid for string input
int stringCheck(char *c) {
  int x;
  //loop through char array
  for (x = 0; x < strlen(c); x++) {
    //assign temporary check char variable indexed value of array
    char check = c[x];
    //check if char is within the range of possible characters
    if ((check >= 'a' && check <= 'z') || (check >= 'A' && check <= 'Z') || (check == '\n')) {
      continue;
    } else {
      //break and return 0 if check char is invalid
      return 0;
    }
  }
  //1 is the positive return value
  return 1;
}

//checks that values of the input are valid ints
int intCheck(char *c) {
  int x;
  //loops through char array
  for (x = 0; x < strlen(c); x++) {
    //temp char variable
    char check = c[x];
    //check if current char is within range of ints
    if (check >= '0' && check <= '9') {
      continue;
    } else {
      //invalid char
      return 0;
    }
  }
  //positive return
  return 1;
}



void summary(struct person p[], int length) {
  //counter for total records
  int totalRecords = 0;

  //student info
  int totalStudents = 0;
  int sumGpa = 0;
  int sumNumCourses = 0;
  int sumTuition = 0;

  //employee info
  int totalEmployees = 0;
  int minLevel = 15; //default to max value
  int maxLevel = 0; //default to min value
  int sumYearsService = 0;
  int sumSalary = 0;

  int i = 0;
  for (i = 0; i < length; i++) {
    //add to total records
    totalRecords++;
    //loop through persons
    if (p[i].emplyeeOrStudent == 0) { //check if employee
      //add to employee total
      totalEmployees++;
      //add to total years of service
      sumYearsService += p[i].data.emp.yearsService;
      //add to total salary
      sumSalary += p[i].data.emp.salary;
      //check if less than min
      if (p[i].data.emp.yearsService < minLevel) {
        minLevel = p[i].data.emp.yearsService;
      }
      //check if greater than max
      if (p[i].data.emp.yearsService > maxLevel) {
        maxLevel = p[i].data.emp.yearsService;
      }

    } else { //check if student
      //add to student total
      totalStudents++;
      //add to total GPA
      sumGpa += p[i].data.stu.gpa;
      //add to total courses
      sumNumCourses += p[i].data.stu.numCourses;
      //add to total tuitionFees
      sumTuition += p[i].data.stu.tuitionFees;
    }
  }

  /////////CALCULATE AVERAGES///////////


  ////student averages////
  //GPA
  float averageGPA = sumGpa / totalRecords;
  //courses
  float averageCourses = sumNumCourses / totalRecords;
  //tuition
  float averageTuition = sumTuition / totalRecords;


  ////employee averages////
  //yearsService
  float averageYearsService = sumYearsService / totalRecords;
  //salary
  float averageSalary = sumSalary / totalRecords;

  ////PRINT SUMMARY////
  printf("Total number of records: %d\n", totalRecords);
  printf("\n");
  //student info
	printf("Student Stats:\n");
	printf("Number of Students: %d\n", totalStudents);
	printf("Average GPA:  %.2f\n", averageGPA);
	printf("Average Number of courses:  %.2f\n", averageCourses);
	printf("Average Tutition Fees: %.2f\n", averageTuition);
  printf("\n");

  //employee info
	printf("Employee Stats:\n");
	printf("Number of Employees: %d\n", totalEmployees);
  printf("Min level: %d\n", minLevel);
  printf("Max level: %d\n", maxLevel);
	printf("Average Years of Service:  %.2f\n", averageYearsService);
	printf("Average Salary: %.2f\n", averageSalary);
  printf("\n");
}

void quitWarning() {
  //response char array
  char r[3];

  //variable for flow control
  int breaker = 1;

  printf("You are about to quit, would you like to proceed? (y/n): \n");
  //user input
  scanf("%s[^\n]\n", r);
  printf("\n");

  while (breaker == 1) {
    //check if response is a valid string
    if (stringCheck(r) == 1) {
      //if response is yes, exit program
      if ((strcmp(r, "yes") == 0) || (strcmp(r, "y") == 0))  {
        printf("Quitting program. \n");
        //program exit cleanly
        exit(0);
      }
      //if response is no, return to caller
      if ((strcmp(r, "no") == 0) || (strcmp(r, "n") == 0)) {
        breaker = 0;
      }
    } else {
      //error handle for invalid input
      printf("Invalid response \n");
    }
  }
}
