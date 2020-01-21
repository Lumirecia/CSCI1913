import random
class Random:
    def __init__(self, seed):
        self.seed = seed
    def next(self):
        self.seed = ((pow(7,5)*self.seed % (pow(2,31) - 1)))
        return self.seed
    def choose(self, limit):
        return self.next() % limit
class Rule:
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.count = 1
    def __repr__(self):
        rules = ""
        for x in self.right:
            rules += " " + str(o)
        str = str(self.count) + " " + self.left + " -> " + rules
        return str
class Grammar:
    def __init__(self, seed):
        self.rand = Random(seed)
        self.dictionary = {}
    def rule(self, left, right):
        if left in self.dictionary:
            self.dictionary[left] += (Rule(left, right),)
        else:
            self.dictionary[left] = (Rule(left, right),)
    def generate(self):
        if 'Start' in self.dictionary:
            return self.generating(('Start',))
        else:
            raise RuntimeError
    def generating(self, strings):
        result = ""
        for x in strings:
            if x in self.dictionary:
                tuplex = self.select(x)
                string = self.generating(tuplex)
                result += string
            else:
                result += x + ' '
        return result
    def select(self, left):
        rules = self.dictionary[left]
        total = 0
        for x in rules:
            total += x.count
        index = self.rand.choose(total)
        for rule in rules:
            index -= rule.count
            rule.count += 1
            if index <= 0:
                chosen = rule
                rule.count -= 1
                index = total
        return chosen.right

G = Grammar(101)
G.rule('Noun',   ('cat',))                                #  01
G.rule('Noun',   ('boy',))                                #  02
G.rule('Noun',   ('dog',))                                #  03
G.rule('Noun',   ('girl',))                               #  04
G.rule('Verb',   ('bit',))                                #  05
G.rule('Verb',   ('chased',))                             #  06
G.rule('Verb',   ('kissed',))                             #  07
G.rule('Phrase', ('the', 'Noun', 'Verb', 'the', 'Noun'))  #  08
G.rule('Story',  ('Phrase',))                             #  09
G.rule('Story',  ('Phrase', 'and', 'Story'))              #  10
G.rule('Story',  ('Phrase', 'but', 'Story'))              #  11
G.rule('Start',  ('Story', '.'))                          #  12

# Output:
# >>> G.generate()
# 'the cat bit the boy . '
# >>> G.generate()
# 'the cat kissed the dog and the boy chased the boy . '
# >>> G.generate()
# 'the cat chased the dog and the girl bit the boy but the girl chased the cat . '
# >>> G.generate()
# 'the girl chased the dog . '
# >>> G.generate()
# 'the boy kissed the girl and the cat kissed the girl . '
# >>> G.generate()
# 'the cat kissed the girl but the boy chased the dog but the dog kissed the boy and the girl chased the boy . '
# >>> G.generate()
# 'the dog kissed the girl and the dog kissed the girl . '
# >>> G.generate()
# 'the girl bit the boy . '
# >>> G.generate()
# 'the cat bit the boy but the girl kissed the boy and the girl kissed the boy but the cat kissed the dog but the dog chased the cat and the dog bit the dog and the dog bit the cat but the cat chased the cat . '
# >>> G.generate()
# 'the dog chased the dog . '
