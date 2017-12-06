#HUGHXIE
#queue.py


import os

maxSize = 10

queue = []

addList = []

#ADD
def enqueue(value):
    if ((len(queue)) >= maxSize):
        return False
    else:
        queue.append(value)
        return True
#REMOVE
def dequeue():
    if ((len(queue)) > 0):
        tempRemove = queue[0]
        queue.pop(0)
        return tempRemove
    else:
        return None

#PEEK
def peek():
    if ((len(queue)) > 0):
        tempPeek = queue[0]
        return tempPeek
    else:
        return None

#ISEMPTY
def isempty():
    if ((len(queue)) > 0):
        return False
    else:
        return True

#GETLIST
def getlist():
    return queue

#MULTIENQUEUE
def multienqueue(addList):
    queueSpace = maxSize - len(queue)

    ###ADDCOUNT
    if (queueSpace > len(addList)):
        addCount = (queueSpace - (queueSpace - len(addList)))
    else:
        addCount = len(addList)

    if ((addCount + len(queue)) > 10):
        addCount = 10 - len(queue)
    ###ADDCOUNT

    for i in range(addCount):
        queue.append(addList[i])

    return addCount

#MULTIDEQUEUE
def multidequeue(N):
    queueSpace = maxSize - len(queue)
    newList = []

    ###REMOVECOUNT
    if (int(N) > len(queue)):
        removeCount = (int(N) - (int(N) - len(queue)))
    elif (int(N) > 10):
        removeCount = 10
    else:
        removeCount = int(N)
    ###REMOVECOUNT

    for i in range(removeCount):
        newList.append(queue[0])
        queue.pop(0)

    return newList


'''
while True:
    command = (input("\n ---COMMAND LIST---\n ""\n 1. Add\n 2. Quit\n 3. Remove\n 4. Peek\n 5. Isempty\n 6. Getlist\n 7. Multienqueue\n 8. Multidequeue\n ""\n Enter Command: ")).upper()

    #clearing screen for cleaner ui
    os.system('cls' if os.name == 'nt' else 'clear')

    #ADD
    if (command == "ADD") or (command == "1") :
        addValue = input("Enter value to add to queue: ")
        print(enqueue(addValue))

    #REMOVE
    elif command == "REMOVE" or (command == "3"):
        print(dequeue())

    #PEEK
    elif command == "PEEK" or (command == "4"):
        print(peek())

    #ISEMPTY
    elif command == "ISEMPTY" or (command == "5"):
        print(isempty())

    #GETLIST
    elif command == "GETLIST" or (command == "6"):
        print(getlist())

    #MULTIENQUEUE
    elif command == "MULTIENQUEUE" or (command == "7"):
        print(multienqueue(addList))

    #MULTIDEQUEUE
    elif command == "MULTIDEQUEUE" or (command == "8"):
        N = input("Enter an integer value of items to remove from the list: ")
        while True:
            if N.isdigit()==False:
                N = input("Invalid Input. Please enter a different value: ")
            else:
                break
        print(multidequeue(N))


    #QUIT
    elif command == "QUIT" or (command == "2"):
        break

    #INVALID INPUT CHECK
    else:
        print("THE COMMAND: " + command +" IS NOT SUPPORTED.")
'''
