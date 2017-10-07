#HUGHXIE
#a2q2.py
number = input("Enter number: ")
x = 0
while True:
    if number.isdigit()==True and number != 0:
        x = int(number) - 1
        break
    else:
        number = input("Enter number: ")

while (x >= 1):
    number = int(number) * x
    x -= 1
if int(number) > 0:
    print(str(number))
else:
    print("Invalid.")
