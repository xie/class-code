#HUGHXIE
#a2q4.py

x1 = input("Enter the first starting letter: ")
x2 = input("Enter the first ending letter: ")
y1 = input("Enter the starting digit: ")
y2 = input("Enter the ending digit: ")
z1 = input("Enter the second starting digit: ")
z2 = input("Enter the second ending digit: ")

x3 = (ord(x1.upper()))
x4 = (ord(x2.upper()))
y3 = (ord(y1.upper()))
y4 = (ord(y2.upper()))
z3 = (ord(z1.upper()))
z4 = (ord(z2.upper()))

total = 0

for x in range(x3 , x4 + 1):
    for y in range(y3 , y4 + 1):
        for z in range(z3 , z4 + 1):
            print( chr(x) + chr(y) + chr(z) )
            total += 1

print("There are " + str(total) + " possible codes.")
