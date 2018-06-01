import random
import math

def permut(num):
	n = num
	result = 1
	while(n>1):
		result *= n
		n-=1
	return result

def anagram(word):
	anagramQnt = 0
	chars = []
	subst = []
	for l in word:
		chars.append(l)
		subst.append(l)
	anagrams = []
	while(anagramQnt<permut(len(word))):
		anagram = ""
		for i in range(len(word)):
			choosen = random.randint(0, len(chars)-1)
			anagram+= chars[choosen]
			chars.remove(chars[choosen])
		equal = False
		for i in anagrams:
			if(anagram==i):
				equal = True
		if(equal==False):
			anagrams.append(anagram)
		anagramQnt+=1
		for j in subst:
			chars.append(j)
	anagrams.append(str(anagramQnt)+" anagramas")
	return anagrams

word = input("Palavra alvo: ")
anagramas = anagram(word)


for i in anagramas:
	print(i)

