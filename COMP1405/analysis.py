#HUGHXIE
#a4q2.py


def load(filename):
    global data
    data = []
    global letterdata
    letterdata = []
    file = open(filename,'r')
    for i in file:
        for letter in i:
            letterdata.append(letter)
        for word in i.split():
            data.append(word)


def commonword(listname):
    wordmax = 0
    wordmaxcount = 0
    words = dict()

    if (len(listname)==0):
        return None
    for i in data:
        if i in listname:
            words[i] = words.get(i,0)+1
    for x, y in list(words.items()):
        if y > wordmaxcount:
            wordmax = x
            wordmaxcount = y
    if wordmax == 0:
        return None
    return(wordmax)

def commonletter(listname):
    lettermax = 0
    lettermaxcount = 0
    letters = dict()

    if (len(listname)==0):
        return None
    for i in letterdata:
        if i in listname:
            letters[i] = letters.get(i,0) + 1
    for x, y in list(letters.items()):
        if y > lettermaxcount:
            lettermax = x
            lettermaxcount = y
    if lettermax == 0:
        return None
    return(lettermax)

def commonpair(str_input):
    pairmax = 0
    pairmaxcount = 0
    pair = dict()

    for i in range(len(data)-1):
        if (data[i] == str_input):
            pairtemp = data[i+1]
            pair[pairtemp] = pair.get(pairtemp,0) + 1
    for x, y in (pair.items()):
        if y > pairmaxcount:
            pairmax = x
            pairmaxcount = y
    if pairmax == 0:
        return None

    return(pairmax,pairmaxcount)

def countall():
    wordcount = len(data)
    return wordcount

def countunique():
    word_set = set()
    for i in data:
        word_set.add(i)
    return len(word_set)
