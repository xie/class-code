#HUGHXIE
#a1q1

#user input for marks
a = float(input("Enter assignment mark: "))
m = float(input("Enter midterm mark: "))
t = float(input("Enter tutorial mark: "))
f = float(input("Enter final exam mark: "))

#weighted mark calculations
x = ((a * 0.4) + (m * 0.2) + (t * 0.1) + (f * 0.3))

#check final mark and exam mark
if ((x > 60) and (f > 50)):
    #output
    print ("Final mark: " + str(x))
    print ("You have passed the course!")
else:
    #output
    print ("Final mark: " + str(x))
    print ("You have failed the course")
