// myStats.cpp
/* The file consists of the following stats funcions:

 */

#include "stdio.h"
#include "stdlib.h"
 #include "string.h"
#include "struct.h"



/**************************************************************/
/* populates an employees

input

emp - an  emplyee record

output
emp - populated employee


*/
#define MAX_YEARS_SERVICE 63
#define MAX_SALARY 300000
#define MAX_LEVEL 15
#define NAME_SIZE 15

void populateEmployee(struct employee *emp)
{

	emp->salary = (rand() % MAX_SALARY) * 1.34f ;
	emp->yearsService = rand() % MAX_YEARS_SERVICE;
	emp->level = rand() % MAX_LEVEL;

}







/**************************************************************/
/* populate a student record

input
student - a student record

output
student - a student record


*/

#define MAX_GPA 10
#define MAX_TUITION 20000
#define MAX_COURSES 40
void populateStudent(struct student *student)
{

	student->tuitionFees = (rand() % MAX_TUITION) * 1.17f;
	student->gpa = rand() % MAX_GPA;
	student->numCourses = rand() % MAX_COURSES;


}







/**************************************************************/
/* populate an employee record

input
person - an array of persons
numPersons - number of person in the array

output
emp - array of employees

assumption:
numPersons is <= the size of the array person
*/
#define NUM_NAMES 7
void populateRecords(struct person *person, int numPersons)
{
	int i = 0;
	int j;
	char *fn[NUM_NAMES] = { "John", "Jane", "David", "Dina", "Justin","Jennifer", "Don" };
	char *sn[NUM_NAMES] = { "Smith", "Johnson", "Mart", "Carp", "Farmer","Ouster","Door" };

	while (i < numPersons) {
		j = rand() % NUM_NAMES;
		person->firstName[NAME_SIZE - 1] = '\0';
		strncpy(person->firstName, fn[j], NAME_SIZE - 1);
		j = rand() % NUM_NAMES;
		person->familyName[NAME_SIZE - 1] = '\0';
		strncpy(person->familyName, sn[j], sizeof(person->familyName) - 1);
		if (rand() % 2) {
			person->emplyeeOrStudent = 1;
			populateStudent(&person->data.stu);
		} else {
			populateEmployee(&person->data.emp);
			person->emplyeeOrStudent = 0;
		}
		person++;
		i++;
	}
}
