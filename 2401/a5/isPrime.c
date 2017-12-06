/*
File is isPrime.c

Purpose:
a program that checks if a given number is a prime number

input:
number - a positive int  entered via the command line parameters.  For example isPrime 1234

output:
0 - if the input number is not a prime number
1 - if the input number is a prime number
2 - if the command line parameter is not correct

Assumption:
the program does not check if the number is a positive integer

*/

/**************************************************************/
// INCLUDE FILES
//
#include "stdio.h"
#include "stdlib.h"
#include <unistd.h>


/*************************************************************/
// PROTYPES
//
int isPrime(unsigned int number);


/*************************************************************/


int main(int argc, char *argv[])

{

	if (argv[1] != NULL) {
		char *p;
		//converts string to int, params define pointer and base 10
		int n = strtol(argv[1], &p, 10);

		if (n > 0) {
			int r = isPrime(n);
<<<<<<< HEAD
<<<<<<< HEAD
			//printf("The number %d is: %d\n", n, r);
=======
			// printf("The number %d is: %d\n", n, r);
>>>>>>> 5e1e56b4c0696776700f0276ee80870080c00093
=======
			// printf("The number %d is: %d\n", n, r);
>>>>>>> 5e1e56b4c0696776700f0276ee80870080c00093
			return r;
		} else {
			return 2;
		}


	}

		return 0;
}


/*************************************************************/
/*
Purpose: check if the input number is a prime number
input:
number - the number to be checked

return:
0 - if the number is not a prime number
1 - if the number is a prime number
*/

int isPrime(unsigned int number)
{
	int i;
	for(i = 2; i*i <= number; i++) {
		usleep(100);
		if (number % i == 0) {
<<<<<<< HEAD
<<<<<<< HEAD
			//printf("%d is not a prime number\n",number);
			return(0);
		}
	}
    //printf("%d is a prime number\n",number);
=======
			// printf("%d is not a prime number\n",number);
			return(0);
		}
	}
    // printf("%d is a prime number\n",number);
>>>>>>> 5e1e56b4c0696776700f0276ee80870080c00093
=======
			// printf("%d is not a prime number\n",number);
			return(0);
		}
	}
    // printf("%d is a prime number\n",number);
>>>>>>> 5e1e56b4c0696776700f0276ee80870080c00093
	return(1);
}
