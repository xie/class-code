#include "stdio.h"
#include "string.h"
#include "math.h"
#include "stdlib.h"

#include "employee.h"


void printEmployee(struct person p) {
  char *first = p.firstName;
	char *last = p.familyName;
	int years = p.data.emp.yearsService;
	int level = p.data.emp.level;
	float salary = p.data.emp.salary;
	salary = roundf(salary * 100) / 100;

  printf("----------------------------------------------------------------------------------- \n");
  printf("%s %s 	Years: %d		Level: %d		Salary: %.2f \n", first, last, years, level, salary);
}

void printEmployeeList(struct person p[], int length) {
  int s;
  for (s = 0; s < length; s++) {
    //check emplyeeOrStudent if person is employee
    if (p[s].emplyeeOrStudent == 0) {
      printEmployee(p[s]);
    }
  }
  printf("----------------------------------------------------------------------------------- \n");
}
