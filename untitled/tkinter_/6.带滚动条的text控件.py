import tkinter

#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
#win.geometry("494x470+200+0")

#进入消息循环
#创建滚动条
scroll = tkinter.Scrollbar(win)
#文本控件，显示多行文本
text = tkinter.Text(win,width=30,height=4)
#side放到窗体的哪一侧fill填充Y轴
scroll.pack(side = tkinter.RIGHT,fill=tkinter.Y)
text.pack(side = tkinter.LEFT,fill=tkinter.Y)
#关联
scroll.config(command=text.yview)
text.config(yscrollcommand=scroll.set)
str = '''Chinese President Xi Jinping sent a congratulatory letter to the 
fourth China-Arab States Expo that opened Thursday in northwest
 China's Ningxia Hui Autonomous Region.'''
text.insert(tkinter.INSERT,str)

win.mainloop()