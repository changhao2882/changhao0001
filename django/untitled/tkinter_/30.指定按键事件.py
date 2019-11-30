import tkinter
from tkinter import ttk
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("600x470+200+0")

#进入消息循环
def say(event):
    print(event.char)
    print(event.keycode)#按键对应的ASCII值
#bind给控件绑定事件
win.bind("a",say)

win.mainloop()