#include "stdio.h"
#include "string.h"
#include "math.h"
#include "stdlib.h"

#include "student.h"

int stringCheck(char *c);

void printStudent(struct person p) {
  //store values locally
  char *first = p.firstName;
  char *last = p.familyName;
  int g = p.data.stu.gpa; //reference through union
  int c = p.data.stu.numCourses;
  float t = p.data.stu.tuitionFees;

  //print with formatting
  printf("----------------------------------------------------------------------------------- \n");
  printf("%s %s 	GPA: %d		Courses: %d		Tuition: %.2f \n", first, last, g, c, t);
}

void printStudentList(struct person p[], int length) {
  int s;
  //loop through persons, if emplyeeOrStudent is student, print
  for (s = 0; s < length; s++) {
    //check emplyeeOrStudent if person is student
    if (p[s].emplyeeOrStudent == 1) {
      //send to printStudent method
      printStudent(p[s]);
    }
  }
  printf("----------------------------------------------------------------------------------- \n");
}

//arithmetic traversal to check if 2 char arrays are equal
int compareString(char *a, char *b) {
  while (*a == *b) {
    if (*a == '\0' || *b == '\0') {
      break;
    }
    a++;
    b++;
    }
    if (*a == '\0' && *b == '\0') {
      return 0;
    } else {
      return -1;
    }
}

void findStudentByFamilyName(struct person p[], int length) {
  //breaker variable for while loop control flow
  int breaker = 1;

  //loop until breaker != 1
  while (breaker == 1) {
    //user prompt

    printf("Enter the family name to search for: ");

    //input as char array
    //max length of family name is 15 chars, 15x\0
    char search[16];

    //get user input
    scanf("%s[^\n]\n", search);

    printf("\n");

    //check if user input is a valid string
    if ((stringCheck(search)) == 1) {
      int x;
      for (x = 0; x < length; x++) {
        //check emplyeeOrStudent to check if student
        //check if user search and last name are equal
        if (p[x].emplyeeOrStudent == 1) { //outer loop for faster average case
          if (compareString(search, p[x].familyName) == 0) {
            //print
            printStudent(p[x]);
          }
        }
      }
      printf("----------------------------------------------------------------------------------- \n");
      //breaks out of loop when done printing
      breaker = 0;
    } else {
      //error message
      printf("No results found, use only characters for search.");
    }
  }

}
