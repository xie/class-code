
#ifndef _struct_h
#define _struct_h

struct student {
  unsigned int numCourses:6;
  unsigned int gpa:4;
  float tuitionFees;
};

struct employee {
  float salary;
  unsigned int yearsService:7;
  unsigned int level:4;
};

union shared {
  struct student stu;
  struct employee emp;
};

struct person {
  char firstName[15];
  char familyName[15];
  char telephone[10];
  
  unsigned int emplyeeOrStudent:1;
  // 0 : employee
  // 1 : student

  union shared data;
};


#endif
