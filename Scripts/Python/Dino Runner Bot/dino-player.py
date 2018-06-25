import pyautogui as pg
import time
import random
import PIL.ImageGrab as imgGrab

box = (355, 363, 517, 473)#10
over = (680, 340, 760, 410)
overp = (14, 11)
plant = (75, 84)
plant2 = (37, 74)
plant3 = (75, 97)
plant4 = (130, 79)
plant5 = (17, 90)
plant6 = (80, 64)
black = (83, 83, 83)
playing = True

def jump():
      pg.keyDown("space")
      time.sleep(0.05)
      pg.keyUp("space")
      print("Jumping")

while playing:
      try:
            mybox = imgGrab.grab(box)
            overbox = imgGrab.grab(over)
            p1 = mybox.getpixel(plant)
            p2 = mybox.getpixel(plant2)
            p3 = mybox.getpixel(plant3)
            p4 = mybox.getpixel(plant4)
            p5 = mybox.getpixel(plant5)
            p6 = mybox.getpixel(plant6)
            overpx = overbox.getpixel(overp)
            up = False
            if p1 == (83, 83, 83):
                  print("P1 -> Activated")
                  jump()
                  up = True
                  #time.sleep(0.05)
            if p2 == (83, 83, 83):
                  print("P2 -> Activated")
                  jump()
                  up = True
                  #time.sleep(0.05)
            if p3 == (83, 83, 83):
                  print("P3 -> Activated")
                  jump()
                  up = True
                  #time.sleep(0.05)
            elif p4 == (83, 83, 83):
                  print("P4 -> Activated")
                  jump()
                  up = True
                  #time.sleep(0.08)
            if p5 == (83, 83, 83):
                  print("P5 -> Activated")
                  jump()
                  up = True
                  #time.sleep(0.05)
            if p6 == (83, 83, 83):
                  print("P6 -> Activated")
                  jump()
                  up = True
                  #time.sleep(0.05)
            if up:
                  print("Waiting")
                  time.sleep(0.01)
            if overpx == black:
                  print("Game Over")
                  print("="*30)
                  print("Starting...")
                  pg.press("space")
      except Exception as e:
            play = False
            print(e)
