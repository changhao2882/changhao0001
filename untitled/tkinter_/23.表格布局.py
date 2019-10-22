import tkinter
from tkinter import ttk
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("600x470+200+0")
#窗口的变化对窗口的位置没有影响
#进入消息循环
lable1 = tkinter.Label(win,text = "good1",bg = "pink",)
lable1.grid(row=0,column=0)
lable2 = tkinter.Label(win,text = "good1",bg = "red",)
lable2.grid(row=0,column=1)
lable3 = tkinter.Label(win,text = "good1",bg = "blue",)
lable3.grid(row=1,column=0)
lable4 = tkinter.Label(win,text = "good1",bg = "yellow",)
lable4.grid(row=1,column=1)



win.mainloop()