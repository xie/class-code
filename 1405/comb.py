#HUGHXIE
#a4q2.py


import math

def combsort(inp):
    gap = len(inp)
    div = 1.3
    complete = False
    while complete == False:
        gap = math.floor(gap/div)
        if gap>1:
            complete = False
        else:
            gap = 1
            complete = True
        for i in range(len(inp)-gap):
            if di(inp,i) > di(inp,i+gap):
                inp = swap(inp,i,i+gap)
                complete = False

def di(list,index):
    x = list[index][0]
    y = list[index][1]
    eq = math.sqrt((x*x + y*y))
    return eq

def swap(swaplist,i,j):
    temp = [swaplist[i][0],swaplist[i][1]]
    swaplist[i] = [swaplist[j][0],swaplist[j][1]]
    swaplist[j] = temp
    return swaplist
