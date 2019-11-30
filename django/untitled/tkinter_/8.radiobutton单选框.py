import tkinter

def update():
    text.delete(0.0, tkinter.END)  # 清除text中所有内容  0.0下标为0的第0行
    text.insert(tkinter.INSERT, r.get())
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

#进入消息循环
#创建单选框
#要绑定的变量
r = tkinter.IntVar()#StringVar()
r.set(2)#设置默认选中
radio1 = tkinter.Radiobutton(win,text="money1",command=update,value=1,variable=r)
radio1.pack()
radio2 = tkinter.Radiobutton(win,text="money2",command=update,value=2,variable=r)
radio2.pack()
radio3 = tkinter.Radiobutton(win,text="money3",command=update,value=3,variable=r)
radio3.pack()

text = tkinter.Text(win,height=5,width=50)
text.pack()

win.mainloop()