import tkinter
from tkinter import ttk
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("600x470+200+0")

def say(event):
    print(event.char)
    print(event.keycode)#按键对应的ASCII值
#进入消息循环
label1 = tkinter.Label(win,text="leftmouse button")
#设置焦点
label1.focus_set()
label1.pack()
#bind给控件绑定事件 <Key>键盘  响应所有按键
label1.bind("<Key>",say)

win.mainloop()