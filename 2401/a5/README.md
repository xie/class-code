### Name: Hugh Xie  
### Student Number: 101036694  
##### Purpose: COMP2401 Assignment 2  
* isPrime: Program that determines if a number is prime or not.
* singlePrime: Program that reads from a binary file the first unsigned integer and then morphs itself to the isPrime program.
* singleSpawn: This program spawns a child process. The child process will morph itself into the isPrime program.
* multiSpawn: Creates a process for each each number in the binary file and indicates if the number is prime.
* multiSpawnSignal: Creates a process for each each number in the binary file and indicates if the number is prime. The program keeps track of the remaining processes.   


| Source Files |
| ------ |
| createBinary.c |
| isPrime.c |
| multiSpawn.c |
| multiSpawn.h |
| singleSpawn.c |
| singlePrime.c |
| singlePrime.h |
| multiSpawnSignal.c |
| multiSpawnSignal.h |
| MakeFile |
| MakeFile2 |
| MakeFile3 |
| MakeFile4 |

 #### Compilation Instructions:  
 ##### isPrime.c :  
&nbsp;
```sh
$ make isPrime
$ ./isPrime [filename]
```
the program will return (without indication if the first number in the file is prime or not)
example input:
```sh
$ ./isPrime prime.bin
```

&nbsp;
##### singlePrime.c:
&nbsp;
this program creates a process of isPrime through the morph method
```sh
$ make singlePrime
$ ./singlePrime [filename]
```
the program will return -1 if the morph failed.
example input:
```sh
$ ./singlePrime prime.bin
```

&nbsp;
##### singleSpawn.c:
&nbsp;
this program takes the first number in a binary file, spawns a child process that morphs into the isPrime program
```sh
$ make singleSpawn
$ ./singleSpawn [filename]
```

example input:
```sh
$ ./singleSpawn prime.bin
```
example output:
```sh
> File exists.
> read binary file success
> The number 35788631
> is a prime number.
```

&nbsp;
##### multiSpawn.c:
&nbsp;
this program goes through a file, spawns a child process for each number and morphs into the isPrime program.
```sh
$ make multiSpawn
$ ./multiSpawn [filename]
```

example input:
```sh
$ ./multiSpawn prime.bin
```

this program outputs process data and only the numbers in the file that are prime
example output:
```sh
> Number of lines on file: 12
>  1 Process id: 85327
>  2 Process id: 85328
>  3 Process id: 85329
>  4 Process id: 85330
>  5 Process id: 85331
>  6 Process id: 85332
>  7 Process id: 85333
>  8 Process id: 85334
>  9 Process id: 85335
>  10 Process id: 85336
>  11 Process id: 85337
>  12 Process id: 85338
> Prime >  35788631
> Prime >  961751257
> Prime >  13417
> Prime >  200003627
> Prime >  299905657
> Prime >  199905059
> Prime >  299902243
```

&nbsp;
##### multiSpawnSignal.c:
&nbsp;
this program goes through a file, spawns a child process for each number and morphs into the isPrime program. It will also keep track of processes and pending processes.
```sh
$ make multiSpawnSignal
$ ./multiSpawnSignal [filename]
```

example input:
```sh
$ ./multiSpawnSignal prime.bin
```
example output:
```sh
> Number of lines on file: 12
>  1 Process id: 85366
>  2 Process id: 85367
>  3 Process id: 85368
>  4 Process id: 85369
>  5 Process id: 85370
>  6 Process id: 85371
>  7 Process id: 85372
>  8 Process id: 85373
>  9 Process id: 85374
>  10 Process id: 85375
>  11 Process id: 85376
>  12 Process id: 85377
> Total processes invoked:  12 Total processes working: 11
> Total processes invoked:  12 Total processes working: 10
> Total processes invoked:  12 Total processes working: 9
> Total processes invoked:  12 Total processes working: 8
> Total processes invoked:  12 Total processes working: 7
> Total processes invoked:  12 Total processes working: 6
> Total processes invoked:  12 Total processes working: 5
> Total processes invoked:  12 Total processes working: 4
> Total processes invoked:  12 Total processes working: 3
> Total processes invoked:  12 Total processes working: 2
> Total processes invoked:  12 Total processes working: 1
> Total processes invoked:  12 Total processes working: 0
> Prime >  35788631
> Prime >  961751257
> Prime >  13417
> Prime >  200003627
> Prime >  299905657
> Prime >  199905059
> Prime >  299902243
```

&nbsp;
##### createBinary.c:
&nbsp;
takes a filename and values to create a binary file with the given numbers
```sh
$ make createBinary
$ ./createBinary example.bin 1 2 3 4 5
```

example input:
```sh
$ ./createBinary test.bin 1 2 3 4
```
this program has no output. 
