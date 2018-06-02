#!/usr/bin/python3
looping = True
toMorse = True

def charToMorse(char):
	if(char == "a"):
		return ".-"
	elif(char == "b"):
		return "-..."
	elif(char == "c"):
		return "-.-."
	elif(char == "d"):
		return "-.."
	elif(char == "e"):
		return "."
	elif(char == "f"):
		return "..-."
	elif(char == "g"):
		return "--."
	elif(char == "h"):
		return "...."
	elif(char == "i"):
		return ".."
	elif(char == "j"):
		return "----"
	elif(char == "k"):
		return "-.-"
	elif(char == "l"):
		return ".-.."
	elif(char == "m"):
		return "--"
	elif(char == "n"):
		return "-."
	elif(char == "o"):
		return "---"
	elif(char == "p"):
		return ".--."
	elif(char == "q"):
		return "--.-"
	elif(char == "r"):
		return ".-."
	elif(char == "s"):
		return "..."
	elif(char == "t"):
		return "-"
	elif(char == "u"):
		return "..-"
	elif(char == "v"):
		return "...-"
	elif(char == "x"):
		return "-..-"
	elif(char == "y"):
		return "-.--"
	elif(char == "z"):
		return "--.."
	return "?"

def morseToChar(char):
	if char == " ":
		return ""
	elif(char == ".-"):
		return "a"
	elif(char == "-..."):
		return "b"
	elif(char == "-.-."):
		return "c"
	elif(char == "-.."):
		return "d"
	elif(char == "."):
		return "e"
	elif(char == "..-."):
		return "f"
	elif(char == "--."):
		return "g"
	elif(char == "...."):
		return "h"
	elif(char == ".."):
		return "i"
	elif(char == ".---"):
		return "j"
	elif(char == "-.-"):
		return "k"
	elif(char == ".-.."):
		return "l"
	elif(char == "--"):
		return "m"
	elif(char == "-."):
		return "n"
	elif(char == "---"):
		return "o"
	elif(char == ".--."):
		return "p"
	elif(char == "--.-"):
		return "q"
	elif(char == ".-."):
		return "r"
	elif(char == "..."):
		return "s"
	elif(char == "..-"):
		return "u"
	elif(char == "...-"):
		return "v"
	elif(char == ".--"):
		return "w"
	elif(char == "-..-"):
		return "x"
	elif(char == "-.--"):
		return "y"
	elif(char == "--.."):
		return "z"
	return "?"

def txtToMorse(langTxt):
	morseTxt = ""
	words = langTxt.split(" ")
	for word in words:
		for letter in word:
			morseTxt += charToMorse(letter)
			morseTxt += " "
		morseTxt += "   "

	return morseTxt

def morseToLang(morseTxt):
	langTxt = ""
	words = morseTxt.split("   ")
	chars = []
	for word in words:
		chars.append(word.split(" "))
	print(chars)
	for word in chars:
		for char in word:
			print(char)
			langTxt += morseToChar(char)
		morseTxt += " "
	return langTxt

def mainLoop():
	toMorse = True
	print("""
Insira switchMode para alterar o modo
de aplicação (Morse->Normal ou Normal->Morse):""")
	while looping:
		langTxt = input("Insira: ")
		if("switchMode" in langTxt or "switchmode" in langTxt):
			if(toMorse == True):
				toMorse = False
			else:
				toMorse = True
		if(toMorse):
			print(txtToMorse(langTxt))
		else:
			print(morseToLang(langTxt))

mainLoop()