import tkinter
from tkinter import ttk
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("600x470+200+0")

def say(event):
    print(event.x,event.y)
#进入消息循环
label1 = tkinter.Label(win,text="leftmouse button")
label1.pack()
#bind给控件绑定事件
#label1.bind("<Enter>",say)   进入
label1.bind("<Leave>",say)   #离开

win.mainloop()