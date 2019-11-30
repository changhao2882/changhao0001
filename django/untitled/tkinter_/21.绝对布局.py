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
lable1.place(x=10,y=10)
lable2 = tkinter.Label(win,text = "good1",bg = "red",)
lable2.place(x=50,y=50)
lable3 = tkinter.Label(win,text = "good1",bg = "blue",)
lable3.place(x=100,y=100)




win.mainloop()