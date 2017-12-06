#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "unistd.h"

#include "singlePrime.h"

//PROTYPES
void instructions();
int morph(char *number);

//main
int main(int argc, char* argv[]) {
  //process status int
  int process_status;
  //process output int
  int process_output;
  //store first int in bin file
  char buffer[30];

  //check if file was given
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

        //store value of num in buffer
        sprintf(buffer,"%d\n", num);
      }
    } else {
    printf("%s\n", "file not readable");
    }
  } else {
    printf("%s\n", "no file");
  }


    //define processId
    pid_t process = fork();

    //check if child process
    if (0 == process) {
      morph(buffer);

      //error check
    } else if (0 > process) {

      printf("%s\n", "exit failure");
      exit(EXIT_FAILURE);

      //parent process
    } else {

      while (wait(&process_status) != process) {
        //child process not complete
      }

      //give process_output var
      process_output = WEXITSTATUS(process_status);
      //evaluate process output
      if (process_output == 1) {

        //prime
        // printf("The number %s is a prime number.\n",buffer);
      } else if (process_output == 0) {
        //not prime
        // printf("The number %s is not a prime number.\n",buffer);
      } else {
        //error
        // printf("There was an error");
      }

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


  return 1;


}
