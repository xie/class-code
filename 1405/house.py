#HUGHXIE
#A1.1
#HOUSE WITH SimpleGraphics

from SimpleGraphics import *

#background color set
background("sky blue")

#house frame
setFill("wheat3")
rect(250,200,300,300)

#door
setFill("wheat4")
rect(375,420,50,80)

#doorknob
setFill("black")
ellipse(410,460,10,10)

#roof
setFill("red4")
polygon(200,200,600,200,400,50)

#left window
setFill("papaya whip")
rect(300,250,60,60)
line(330,250,330,310)
line(300,280,360,280)

#right window
setFill("papaya whip")
rect(440,250,60,60)
line(470,250,470,310)
line(440,280,500,280)

#chimney
setFill("black")
polygon(500,125,500,60,450,60,450,87.5)

#fence
#left side
setFill("saddle brown")
rect(0,370,250,100)

#lines for fence
line(10,370,10,470)
line(20,370,20,470)
line(30,370,30,470)
line(40,370,40,470)
line(50,370,50,470)
line(60,370,60,470)
line(70,370,70,470)
line(80,370,80,470)
line(90,370,90,470)
line(100,370,100,470)
line(110,370,110,470)
line(120,370,120,470)
line(130,370,130,470)
line(140,370,140,470)
line(150,370,150,470)
line(160,370,160,470)
line(170,370,170,470)
line(180,370,180,470)
line(190,370,190,470)
line(200,370,200,470)
line(210,370,210,470)
line(220,370,220,470)
line(230,370,230,470)
line(240,370,240,470)
line(250,370,250,470)

#x is shift value for the lines
x = 550

#right side
setFill("saddle brown")
rect(550,370,400,100)
line(10+x,370,10+x,470)
line(20+x,370,20+x,470)
line(30+x,370,30+x,470)
line(40+x,370,40+x,470)
line(50+x,370,50+x,470)
line(60+x,370,60+x,470)
line(70+x,370,70+x,470)
line(80+x,370,80+x,470)
line(90+x,370,90+x,470)
line(100+x,370,100+x,470)
line(110+x,370,110+x,470)
line(120+x,370,120+x,470)
line(130+x,370,130+x,470)
line(140+x,370,140+x,470)
line(150+x,370,150+x,470)
line(160+x,370,160+x,470)
line(170+x,370,170+x,470)
line(180+x,370,180+x,470)
line(190+x,370,190+x,470)
line(200+x,370,200+x,470)
line(210+x,370,210+x,470)
line(220+x,370,220+x,470)
line(230+x,370,230+x,470)
line(240+x,370,240+x,470)
line(250+x,370,250+x,470)


#sun
setFill("yellow")
ellipse(-50,50,100,100)

#grass
setFill("spring green")
polygon(0,470,250,470,250,500,550,500,550,470,800,470,800,700,0,700)
