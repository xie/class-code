#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "unistd.h"
#include "signal.h"

#include "multiSpawnSignal.h"

#include <sys/stat.h>
//global counter for number of responses
int count_responses;
int count_sent;


void my_handler(int signum) {
  int r = 0;
  r = (count_sent - count_responses);
  if (signum == SIGUSR1) {
    printf("Total processes invoked:  %d Total processes working: %d\n", count_sent, r);
  }
}



int main(int argc, char* argv[]) {


  signal(SIGUSR1, my_handler);

  if (argv[1] != NULL) {

    //define file and open
    FILE * file = fopen(argv[1], "rb");

    //store number of lines in file
    int numberOfLines = getFileSize(argv[1]);

    printf("Number of lines on file: %d\n", numberOfLines);

    //create array with size of number of numbers in file
    int nums[numberOfLines];

    //add binary file numbers to array
    fread(nums, sizeof(int), numberOfLines, file);



    // printArr(nums, numberOfLines);

    spawn(nums, numberOfLines);

    //multiprocess(nums, numberOfLines);

  }

  return 0;
}


//return the number of lines in a file by dividing total size by size of elements
int getFileSize(char *name) {

  int result = 0;
  int file_size;

  //get total size of file
  struct stat buf;
  if (0 == stat(name, &buf)) {
    file_size = buf.st_size;
    printf("Filesize: %d\n", file_size);
    //exit if file is empty
    if (file_size == 0) {
      return file_size;
    }
  }
  //divide by size of data
  result = (file_size / (sizeof(unsigned int)));

  return result;
}

//testing function for visualizing array
void printArr(int arr[], int len) {
  printf("%s", "Values in file: ");
  for (int i = 0; i < len; i++) {
    printf("%d", arr[i]);
  }
}

void spawn(int arr[], int len) {
  //initialize each time we try to multi spawn
  count_responses = 0;
  count_sent = 0;


  //array to store porcess ids
  pid_t process_ids[len];

  //array to store process response values
  int process_response[len];

  //declare working process id
  pid_t process_id;

  //status variable to store process id status
  int status;

  //counter
  int n = 0;



  for (int i = 0; i < len; i++) {
    if ((process_ids[i] = fork()) < 0) {
      //parent
    } else if (process_ids[i] == 0) {
      char buffer[30];
      sprintf(buffer, "%d \n", arr[i]);
      morph(buffer);
    }
    count_sent++;
  }


  int count = 1;
  for (int i = 0; i < len; i++) {
    printf(" %d Process id: %d\n",count ,(int) process_ids[i]);
    count++;
  }

  //loop until all values have been accounted for
  while (n < len) {

    //clean status to avoid error
    status = 0;

    //get the process id from the finished child process
    process_id = waitpid(-1, &status, 0);

    //printf("process_id %d\n", process_id);

    //process output checks for errors
    int process_output = WIFSIGNALED(status);

    //error check
    if (process_output != 0) {
      perror("Error: ");
      return;
    } else {
      //verifies that response is not error and add to counter
      count_responses++;
    }

    kill(getpid(), SIGUSR1);

    //printf("status: %d\n", status);

    //printf("process_output %d\n", process_output);

    //printf("Child with id %ld exited with status %d.\n", (long)process_id, process_output);

    //loop through value
    for (int x = 0; x < len; x++) {
      //if process id matches in array and process output not an error
      if (process_id == process_ids[x] && process_output == 0) {
        //add status to same index that holds process ids
        process_response[x] = status;
        // printf("################# %d\n", arr[x]);
      }
    }
    //increment
    n++;
  }

  //if response value is 256 print corresponding value to process id
  for (int i = 0; i < len; i++) {
    if (process_response[i] == 256) {
      printf("Prime ################>  %d\n", arr[i]);
    }
  }

}





//morph function to morph data from current file to target program
int morph(char *number) {

  //printf("%s\n", "program hit morph");

  //target name for next program
  char *name = "./isPrime";
  //method target and param
  char *params[3] = {"isPrime", number};
  //execute program within process id, pass program name and params
  int r = execvp(name, params);

  //printf("test val: %d\n", r);

  return 1;


}
