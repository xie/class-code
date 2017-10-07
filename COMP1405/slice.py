#HUGHXIE
#slice.py

#ORIGINAL LIST
source = ["A","B","C","D","E","F","G","H","I","J"]

#SLICE FUNCTION
def slicelist(mylist,x,y):
    newlist = []
    while True:
        #CHECKS IF VALUE IS ACCEPTABLE IN LIST
        if (x < 0) or ( x > (len(mylist))-1 ):
            break
        #CHECK IF VALUE IS ACCEPTABLE IN LIST
        if (y < 0) or ( y > (len(mylist))-1 ):
            break
        #FOR LOOP ADDS ITEMS IN RANGE TO newList from original list
        for i in range(x, y+1):
            newlist.append(mylist[i])
        break
    #return newList
    return newlist

#ERROR CHECK FOR STARTING VALUE
start = input("Enter starting index: ")
while True:
    if start.isdigit()==False:
        start = input("Invalid Input. Please enter an integer: ")
    else:
        break

#ERROR CHECK FOR ENDING VALUE
end = input("Enter ending index: ")
while True:
    if end.isdigit()==False:
        end = input("Invalid Input. Please enter an integer: ")
    else:
        break

#PRINT THE SLICED LIST WITH STARTING AND ENDING VALUES
print(slicelist(source,int(start),int(end)))
