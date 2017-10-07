#a1q2c.py
#HUGHXIE

#input for color and time from light
color = input("What color is the light? (G/Y/R) :")
speed = float(input("Enter speed of car in m/s: "))
distance = float(input("Enter distance from light in meters: "))
time = (distance / speed)

#checks if color is red and time is greater than 2 or color is yellow and time is less than or equal to 5
if (color == "R" and time <= 2) or (color == "Y" and time <= 5) or (color == "G"):
    #output
    print("Go")
else:
    #output
    print("Stop")
