class Zillion:
    def __init__(self, digits):
        self.digitlist = []
        if type(digits) == str:
            if len(digits) == 0:
                raise RuntimeError
            counter = False
            for x in digits:
                if x.isdigit() == True:
                    counter = True
                else:
                    continue
            if counter == False:
                raise RuntimeError
            else:
                for x in digits:
                     if x.isdigit() == True:
                         self.digitlist.append(int(x))
                         continue
                     else:
                        if x == ' ':
                            continue
                        else:
                            if x == ',':
                                continue
                            else:
                                raise RuntimeError
        else:
            raise RuntimeError


        
    def increment(self):
        i = len(self.digitlist) - 1
        while i >= 0:
            if self.digitlist[i] == 9:
                self.digitlist[i] = 0
                if self.digitlist[i-1] != 9 and i-1 >= 0:
                    self.digitlist[i-1] = self.digitlist[i-1] + 1
                    i -= 2
                elif self.digitlist[i-1] == 9:
                    if i > 0:
                        i -= 1
                    elif i == 0:
                        break
            elif all(x==self.digitlist[0] for x in self.digitlist) == True:
                self.digitlist.insert(0,1)
                i -= 1
                break
            elif self.digitlist[len(self.digitlist)-1] != 9:
                self.digitlist[i] += 1
                break

                
                


    def isZero(self):
        i = 0
        while i < len(self.digitlist):
            if self.digitlist[i] != 0:
                return False
            elif self.digitlist[i] == 0:
                if i == len(self.digitlist)-1:
                    return True
                else:
                    i += 1

    def toString(self):
            dstring = ''
            for x in self.digitlist:
                dstring = dstring + str(x)

            return dstring

#
#  TESTS. Test the class Zillion for CSci 1913 Lab 2.
#
#    James Moen
#    18 Sep 17
#
#  Every test is followed by a comment which shows what must be printed if your
#  code works correctly. It also shows how many points the test is worth.
#

try:
  z = Zillion('')
except RuntimeError:
  print('Empty string')

# It must print 'Empty string' without apostrophes. 2 points.

try:
  z = Zillion(' , ')
except RuntimeError:
  print('No digits in the string')

# It must print 'No digits in the string' without apostrophes. 2 points.

try:
  z = Zillion('1+0')
except RuntimeError:
  print('Non-digit in the string')

# It must print 'Non-digit in the string' without apostrophes. 2 points.

try:
  z = Zillion('0')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000000000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000 000 000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('997')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing.  2 points.

print(z.isZero())    #  It must print False. 2 points.

print(z.toString())  #  It must print 997. 2 points.

z.increment()

print(z.toString())  #  It must print 998. 2 points.

z.increment()

print(z.toString())  #  It must print 999. 2 points.

z.increment()

print(z.toString())  #  It must print 1000. 2 points.

try:
  z = Zillion('0 9,9 9')
except:
  print('This must not be printed')

#  It must print nothing.  3 points.

z.increment()
print(z.toString())  #  It must print 1000. 2 points.





# Results
# Empty string
# No digits in the string
# Non-digit in the string
# True
# True
# True
# False
# 997
# 998
# 999
# 1000
# 1000

