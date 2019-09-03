#! /usr/bin/python
#! -*- encoding: utf-8 -*-
import click

def findAnagrams(word):
    if len(word) <=1:
        return word
    else:
        tmp = []
        for perm in findAnagrams(word[1:]):
            for i in range(len(word)):
                tmp.append(perm[:i] + word[0:1] + perm[i:])
        return tmp

def findAnagramsPrefix(word, prefix):
	if len(word) <=1:
		if word == prefix:
			return word
		else:
			return list()
	else:
		tmp = list()
		for perm in findAnagrams(word[1:]):
			for i in range(len(word)):
				anagram = perm[:i] + word[0:1] + perm[i:]
				if anagram[:len(prefix)] == prefix:
					tmp.append(anagram)
		return tmp

@click.group()
def main():
	pass

@main.command()
@click.argument('word')
@click.argument('prefix')
@click.option('--inline', default=False, help="If True, it will return the anagrams in a inline way")
def get_prefix(word, prefix, inline):
	anagrams = findAnagramsPrefix(word, prefix)
	click.echo('Anagrams of {} that starts with {}:'.format(word, prefix))
	if inline:
		txt = ', '.join(anagrams)
		click.echo(txt)
	else:
		for anagram in anagrams:
			click.echo(anagram)
		click.echo('{} anagrams that starts with {}'.format(len(anagrams), prefix))

@main.command()
@click.argument('word')
@click.option('--inline', default=False, help="If True, it will return the anagrams in a inline way")
def get_all(word, inline):
	anagrams = findAnagrams(word)
	click.echo('Anagrams of {}:'.format(word))
	if inline:
		txt = ', '.join(anagrams)
		click.echo(txt)
	else:
		for anagram in anagrams:
			click.echo(anagram)
	click.echo('{} anagrams'.format(len(anagrams)))

if __name__ == '__main__':
	main()