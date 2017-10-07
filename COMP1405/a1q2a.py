#HUGHXIE
#a1q2a

color = input("What color is the light? (G/Y/R) :")
speed = float(input("Enter speed of car in m/s: "))
distance = float(input("Enter distance from light in meters: "))
time = (distance / speed)

#checks if color is yellow
if color == "Y":
    if time > 5:
        #output
        print("Stop")
    else:
        #output
        print("Go")
else:
    #checks if color is red
    if color == "R":
        #checks if time is less than or equal to 2
        if time <= 2:
            #output
            print("Go")
        else:
            #output
            print("Stop")
    else:
        #output
        print("Go")
