#HUGHXIE
#a2q1.py
import random
#get random number between 1 and 100
number = (random.randint(1,100))
#TEST
print(str(number))
#initial guess
guess = input("Enter guess: ")

while True:
    #checks if input is valid
    if guess.isdigit()==True and int(guess)<101:
        if (int(guess) > number):
            guess = input("Guess is too high! Guess again: ")
        elif (int(guess) < number):
            guess = input("Guess is too low! Guess again: ")
        elif int(guess) == number:
            print("You guessed the number! It was " + str(number))
            break
    else:
        #invalid output
        print("Invalid input.")
        break
