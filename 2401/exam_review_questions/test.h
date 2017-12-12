struct model {
  unsigned short numCars : 4;
  unsigned short numAssemblyLines : 4;
  unsigned short numFactories : 8;
};

struct supplier {
  unsigned long numFactories : 2;
  unsigned long numWarehouses : 2;
  unsigned long numParts : 4;
  unsigned long numTrucks : 5;
};

union u {
  struct model carModel;
  struct supplier source;
};

struct unionStruct {
  union {
    struct model carModel;
    struct supplier source;
  };
  char modelOrSupplier;
};

void pointers();
void unsigned_chars();
void double_pointers();
void pointer_array();

void ten();
void foo(int *p);

int g(int *x, int y);
int f(int x, int *y);
void one();

int decimalToBinary(int n);

void structSize();
