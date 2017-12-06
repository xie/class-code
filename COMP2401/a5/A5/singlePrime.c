#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "unistd.h"

//PROTYPES
void instructions();
int morph(char *number);

//main
int main(int argc, char* argv[]) {

  //check if user input filename is not null



  if (argv[1] != NULL) {

    FILE * file;

    //define file
    file = fopen(argv[1], "r");
    //check if file exists and can be opened
    if (file) {
      //confirmation output
      printf("%s\n", "File exists.");
      //send filename to moprh method
      morph(argv[1]);
      fclose(file);
    } else {
      //error message
      printf("%s, %s, %s \n", "Error: file ", argv[1], " does not exist.");
    }
    //if file is null show program usage
  } else {
    instructions();
  }
  return 0;
}


//displays usage of program
void instructions() {
  printf("%s\n", "Usage: singlePrime [filename]");
}


int morph(char *number) {

  char *name = "./isPrime";
  char *params[3] = {"isPrime", number};
  int r = execvp(name,params);

  printf("%s, %d\n","result: ", r);

  return 1;


}
