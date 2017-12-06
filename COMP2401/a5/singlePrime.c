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

      //var for int from file
      unsigned int num;
      //read from binary file and check if successful
      if (fread(&num, sizeof(int), 1, file) != 1) {
        printf("%s\n", "failed to read from binary file.");
      } else {
        printf("%s\n", "read binary file success");

        //char array to hold number as string
        char buffer[30];
        //store value of num in buffer
        sprintf(buffer,"%d\n", num);


        printf("%s\n", "sending to morph");
        //send filename to moprh method
        morph(buffer);
      }
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

//morph function to morph data from current file to target program
int morph(char *number) {

  //target name for next program
  char *name = "./isPrime";
  //method target and param
  char *params[3] = {"isPrime", number};
  //execute program within process id, pass program name and params
  int r = execvp(name, params);
  
  printf("%d\n",r);

  return 1;


}
