#HUGHXIE
#count.py

import random
def countsort(start_list):
    values = dict()
    results = dict()
    newlist = []
    for i in start_list:
        values[i] = values.get(i,0) + 1
    for j in sorted(values.keys()):
        results[j] = values.get(j)

    for x, y in results.items():
        for z in range(int(y)):
            newlist.append(x)
    return newlist
