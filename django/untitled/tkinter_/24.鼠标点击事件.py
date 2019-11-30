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
button1 = tkinter.Button(win,text="leftmouse button")
button1.pack()
#bind给控件绑定事件
button1.bind("<Button-1>",say)


win.mainloop()