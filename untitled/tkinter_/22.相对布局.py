import tkinter
from tkinter import ttk
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("600x470+200+0")
#窗口的变化对窗口的位置有影响 fill=tkinter.BOTH
#进入消息循环
lable1 = tkinter.Label(win,text = "good1",bg = "pink",)
lable1.pack(fill=tkinter.Y,side=tkinter.LEFT)
lable2 = tkinter.Label(win,text = "good1",bg = "red",)
lable2.pack(fill=tkinter.X,side=tkinter.TOP)
lable3 = tkinter.Label(win,text = "good1",bg = "blue",)
lable3.pack(fill=tkinter.Y,side=tkinter.RIGHT)




win.mainloop()