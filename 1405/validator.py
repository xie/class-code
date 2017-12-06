#HUGHXIE
#a4q1b.py

import stack

def isvalid(s):
    opposite = {'(':')','{':'}','[':']'}
    tempstack = []
    for i in s:
        if i in opposite.keys():
            stack.push(i)
            tempstack = stack.getlist()
        if i in opposite.values():
            if stack.isempty()==True:
                return(False)
            else:
                t = stack.pop()
                tempstack = stack.getlist()
                if opposite[t] != i:
                    return(False)

    if stack.isempty()!=True:
        return(False)
    else:
        return(True)
