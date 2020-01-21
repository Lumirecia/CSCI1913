# Return the largest element from T (integer)
def Maximum(T):
    if len(T) == 1:
        return T[0]
    else:
        if Maximum(T[1:]) > T[0]:
            return Maximum(T[1:])
        else:
            return T[0]

# Return a new tuple without the first appearance of E
def Remove(T, E):
    if len(T) == 0:
        return T
    elif T[0] == E:
        return T[1:]
    else:
        return (T[0],) + Remove(T[1:], E)

def Sort(T):
    if len(T) == 0:
        return T
    else:
        return (Sort(Remove(T, Maximum(T)))) + (Maximum(T),)







#
#  TESTS. Tests for CSci 1913 Lab 3.
#
#    James Moen
#    11 Feb 19
#
#  Each test is worth 2 points, for 40 points total. Comments show what must be
#  printed to receive credit. Note that your function SORT must work for tuples
#  with negative elements.
#

print(Maximum((1,)))                      #  1            works             2 pt.
print(Maximum((-2, -1)))                  # -1            works             2 pt.
print(Maximum((1, 1)))                    #  1            works             2 pt.
print(Maximum((1, 2, 3)))                 #  3            works             2 pt.

print(Remove((), 1))                      #  ()           works             2 pt.
print(Remove((1,), 1))                    #  ()           works             2 pt.
print(Remove((0, 1), 0))                  #  (1,)         works             2 pt.
print(Remove((0, 1, 2, 1, 3), 1))         #  (0, 2, 1, 3) works             2 pt.
print(Remove((0, 1, 2, 1, 3), 2))         #  (0, 1, 1, 3) works             2 pt.
print(Remove((1, 2, 3), 3))               #  (1, 2)       works             2 pt.

print(Sort(()))                           #  ()           works                2 pt.
print(Sort((0,)))                         #  (0,)         works                2 pt.
print(Sort((0, -1)))                      #  (-1, 0)      wrong                2 pt.
print(Sort((1, 0)))                       #  (0, 1)       wrong                2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)    missing 0              2 pt.
print(Sort((0, -1, 0)))                   #  (-1, 0, 0)   missing 0                2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)    missing 0                2 pt.

print(Sort((9, 8, 7, 6, 5, 4, 3, 2, 1)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt. 9 in right spot
print(Sort((1, 2, 3, 4, 5, 6, 7, 8, 9)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt. missing 1
print(Sort((1, 2, 1, 4, 2, 5, 4, 5, 3)))  #  (1, 1, 2, 2, 3, 4, 4, 5, 5)  2 pt. wrong

# Results
# 1
# -1
# 1
# 3
# ()
# ()
# (1,)
# (0, 2, 1, 3)
# (0, 1, 1, 3)
# (1, 2)
# ()
# (0,)
# (-1, 0)
# (0, 1)
# (0, 0, 1)
# (-1, 0, 0)
# (0, 0, 1)
# (1, 2, 3, 4, 5, 6, 7, 8, 9)
# (1, 2, 3, 4, 5, 6, 7, 8, 9)
# (1, 1, 2, 2, 3, 4, 4, 5, 5)
