### Name: Hugh Xie  
### Student Number: 101036694  
##### Purpose: COMP2401 Assignment 2  
* Transmit: Outputs messagee represented as short intergers that have been encoded and randomly subjected to errors.
* Receive: Takes the encoded message with errors and corrects the potentially flipped bits by implenting the Hamming Code. The program then outputs the original and corrected messages.

| Source Files |
| ------ |
| bit_manipulation.c |
| bit_manipulation.h |
| transmit.c |
| receive.c |

#### Compilation Instructions:  
##### transmit.c :  
&nbsp;
```sh
$ gcc -o tran transmit.c bit_manipulation.c
$ ./tran
```
the user will then be prompted to enter a message..
example input:
```sh
$ Hello World
```
example output:
```sh
> 2432 2136 3264 3136 3324 1796 2668 1276 3634 3264 3094
```
