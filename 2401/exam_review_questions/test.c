#include "stdio.h"
#include <stdlib.h>
#include "test.h"

int main(int argc, char const *argv[]) {

  structSize();

  return 0;
}


void structSize() {
  struct unionStruct x;
  printf("sizeof(struct supplier) = %d sizeof(struct model) = %d\n", sizeof(struct supplier), sizeof(struct model));
}

int decimalToBinary(int n) {
    int remainder;
 int binary = 0, i = 1;

    while (n != 0) {
        remainder = n%2;
        n = n/2;
        binary = binary + (remainder*i);
        i = i*10;
    }
    printf("%d\n", binary);
    return binary;
}


void one() {
  int x = 2, y = 5;
  printf("%d ", f(x, &y));
  printf("%d ", g(&x, y));
  printf("%d %d\n", x, y);
}

int f(int x, int *y) {
  x+=3;
  *y+=2;
  return x + *y;
}

int g(int *x, int y) {
  (*x)--;
  y = *x;
  return *x + y;
}

void pointers() {

  int *p1;
  int *p2;
  int x1 = 1;
  int x2 = 2;
  p1 = &x1;
  p2 = &x2;

  printf("x1: %d\n", x1);
  printf("&x1: %d\n", &x1);
  printf("p1: %d\n", p1);
  printf("&p1: %d\n", &p1);
  printf("*p1: %d\n", *p1);

}

void unsigned_chars() {
  signed char sc;
  unsigned char uc;
  sc = uc = -114;

  printf("%d\n", sc);
  printf("%d\n", uc);
}

void double_pointers() {
  int x = 100;
  int *p1;
  int **p2;

  p1 = &x;
  p2 = &p1;

  printf("p1: %d\n", *p1);
  printf("&p1: %d\n", &p1);
  printf("p2: %d\n", p2);
  printf("p2: %d\n", **p2);

  }


  void pointer_array()  {

  int x = 100;

  int **arr = (int**)malloc(x * sizeof(int*));
  int count = 0;

  for (int b = 0; b < 10; b++) {
    *(arr + b) = (int*)malloc(sizeof(int));
  }

  for (int a = 0; a < 10; a++) {
    for (int b = 0; b < 10; b++) {
      *(*(arr + a) + b) = count;
      count++;
    }
  }

  for (int a = 0; a < 10; a++) {
    for (int b = 0; b < 10; b++) {
      printf("%d\n", *(*(arr + a) + b));
    }
  }
}



void ten() {

  int * x = NULL;
  foo(x);
  printf("%d\n", *x);

}


void foo(int *p) {
  p = (int*)malloc(sizeof(int));
  *p = 20;
  free(p);
}
