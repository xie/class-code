#HUGHXIE
#a2q3.py

max = 0
min = 0
total = 0
count = 0

while True:
    num = input("Enter a number: ")
    if num.isdigit()==False:
        break
    try:
        x = float(num)
        total = total + x
        count += 1
    except:
        print("Invalid input.")
        continue
    if x > max:
        max = x
    if x < min or min==0:
        min = x

average = total/count
print("The max input was: "+str(max))
print("The min input was: "+str(min))
print("The sum is: " + str(total))
print("The average is: "+str(average))
