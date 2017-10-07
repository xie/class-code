#HUGHXIE
#factorial.py


cache = dict()
def factorial(x):
    if x < 2:
        return x
    else:
        x *= factorial(x-1)
    return x

def cachedfactorial(x):
    global cache
    if x < 2:
        cache[x] = 1
    if x > len(cache):
        cache[x] = x*cachedfactorial(x-1)
    return(cache.get(x))
