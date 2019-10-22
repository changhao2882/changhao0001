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
#bind给控件绑定事件 <Shift_L>左侧shift F(1 2 3 4) BackSpace Return(回车) 响应特殊按键
label1.bind("<Return>",say)

win.mainloop()