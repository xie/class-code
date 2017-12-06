#a1q2b.py
#HUGHXIE

color = input("What color is the light? (G/Y/R) :")
speed = float(input("Enter speed of car in m/s: "))
distance = float(input("Enter distance from light in meters: "))
time = (distance / speed)
#checks if color is yellow and if time is greater than 5
if color == "Y" and time > 5:
    #output
    print("Stop")
elif color == "Y" and time <= 5: #checks elif color is yellow and time is less than or equal to 5
    #output
    print("Go")
elif color == "R" and time > 2: #checks if color is red and time is greater than 2
    #output
    print("Stop")
else:
    #output
    print("Go")
