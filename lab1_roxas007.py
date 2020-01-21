
# For tuples !!!!!
def left(e):
    return e[0]
def op(e):
    return e[1]
def right(e):
    return e[2]

def isInside(v, e):
    # check if e is a tuple
    # if it  is, check indiv elements of e (recursive)
    # base case -- else, it is a string (v = e)
    if type(e) == tuple:
        if isInside(v, left(e)) == True:
            return True
        elif isInside(v, right(e)) == True:
            return True
        else:
            return False
    else:
        if v == e:
            return True
        else:
            return False
# -- everything above is correct :)
def solve(v, q):
    if isInside(v, left(q)) == True:
        return solving(v,q)
    elif isInside(v, right(q)) == True:
        newq = (right(q), op(q), left(q))
        return solving(v,newq)
    else:
        return "solve error"



def solving(v, q):
    # check if q is a tuple
    # check indidv elements of q
    # base case -- else, it is a string (v=e)
    if isInside(v, q) == True:
        if type(left(q)) == tuple:
            if op(left(q)) == '+':
                return solvingAdd(v, q)
            elif op(left(q)) == '-':
                return solvingSubtract(v, q)
            elif op(left(q)) == '*':
                return solvingMultiply(v, q)
            elif op(left(q)) == '/':
                return solvingDivide(v, q)
            elif op(left(q)) == '=':
                return q
        else:
            return q

def solvingAdd(v, q):
    a = left(left(q))
    b = right(left(q))
    c = right(q)
    if isInside(v, a) == True:
        q = (a, '=', (c, '-', b))
        return solving(v, q)
    elif isInside(v, b) == True:
        q = (b, '=', (c, '-', a))
        return solving(v, q)
    else:
        return solving(v, q)
def solvingSubtract(v, q):
    a = left(left(q))
    b = right(left(q))
    c = right(q)
    if isInside(v, a) == True:
        q = (a, '=', (c, '+', b))
        return solving(v, q)
    elif isInside(v, b) == True:
        q = (b, '=', (a, '-', c))
        return solving(v, q)
    else:
        return solving(v, q)
def solvingMultiply(v, q):
    a = left(left(q))
    b = right(left(q))
    c = right(q)
    if isInside(v, a) == True:
        q = (a, '=', (c, '/', b))
        return solving(v, q)
    elif isInside(v, b) == True:
        q = (b, '=', (c, '/', a))
        return solving(v, q)
    else:
        return solving(v, q)

def solvingDivide(v, q):
    a = left(left(q))
    b = right(left(q))
    c = right(q)
    if isInside(v, a) == True:
        q = (a, '=', (c, '*', b))
        return solving(v, q)
    elif isInside(v, b) == True:
        q = (b, '=', (a, '/', c))
        return solving(v, q)
    else:
        return solving(v, q)




print(isInside('x', 'x'))                          #  True   1 point
print(isInside('x', 'y'))                          #  False  1 point
print(isInside('x', ('x', '+', 'y')))              #  True   2 points
print(isInside('x', ('a', '+', 'b')))              #  False  2 points
print(isInside('+', ('a', '+', 'b')))              #  False  2 points
print(isInside('x', (('m', '*', 'x'), '+', 'b')))  #  True   2 points

print(solve('x', (('a', '+', 'x'), '=', 'c')))
#  ('x', '=', ('c', '-', 'a'))  2 points
print(solve('x', (('x', '+', 'b'), '=', 'c')))
#  ('x', '=', ('c', '-', 'b'))  2 points
print(solve('x', (('a', '-', 'x'), '=', 'c')))
#  ('x', '=', ('a', '-', 'c'))  2 points
print(solve('x', (('x', '-', 'b'), '=', 'c')))
#  ('x', '=', ('c', '+', 'b'))  2 points
print(solve('x', (('a', '*', 'x'), '=', 'c')))
#  ('x', '=', ('c', '/', 'a'))  2 points
print(solve('x', (('x', '*', 'b'), '=', 'c')))
#  ('x', '=', ('c', '/', 'b'))  2 points
print(solve('x', (('a', '/', 'x'), '=', 'c')))
#  ('x', '=', ('a', '/', 'c'))  2 points
print(solve('x', (('x', '/', 'b'), '=', 'c')))
#  ('x', '=', ('c', '*', 'b'))  2 points
print(solve('y', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('y', '=', (('m', '*', 'x'), '+', 'b'))  2 points
print(solve('x', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('x', '=', (('y', '-', 'b'), '/', 'm'))  2 points
print(solve('a', (('b', '+', 'c'), '=', ('d', '*', (('a', '/', 'e'), '-', 'f')))))
# ('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))  5 points

# RESULTS
# True
# False
# True
# False
# False
# True
# ('x', '=', ('c', '-', 'a'))
# ('x', '=', ('c', '-', 'b'))
# ('x', '=', ('a', '-', 'c'))
# ('x', '=', ('c', '+', 'b'))
# ('x', '=', ('c', '/', 'a'))
# ('x', '=', ('c', '/', 'b'))
# ('x', '=', ('a', '/', 'c'))
# ('x', '=', ('c', '*', 'b'))
# ('y', '=', (('m', '*', 'x'), '+', 'b'))
# ('x', '=', (('y', '-', 'b'), '/', 'm'))
# ('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))
