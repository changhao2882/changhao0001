import tkinter

def say():
    print(entry.get())
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

#进入消息循环
entry = tkinter.Entry(win)
button = tkinter.Button(win,text="按钮",command=say)

entry.pack()
button.pack()
win.mainloop()