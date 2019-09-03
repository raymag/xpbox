#! /usr/bin/python
# -*- encoding: utf-8 -*-

import random, math, click

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
	anagrams.append('\n'+str(anagramQnt)+" anagramas")
	return anagrams

@click.command()
@click.argument('word')
@click.option('--inline', default=False, help='It returns the anagrams with a inline look')
def main(word, inline):
	''' Prints all anagrams of a given word '''
	anagramas = anagram(word)
	
	if inline:
		txt = ""
		for i in anagramas:
			txt+= i+', '
		txt = txt[:-2]
		click.echo('Anagrams of {}:'.format(word))
		click.echo(txt)
	else:
		click.echo('Anagrams of {}:'.format(word))
		for i in anagramas:
			click.echo(i)

if __name__ == '__main__':
	main()