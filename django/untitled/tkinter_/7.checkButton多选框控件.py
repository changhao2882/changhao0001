import tkinter

def update():
    message=""
    if hobby1.get()==True:
        message+="money1\n"
    if hobby2.get() == True:
        message += "money2\n"
    if hobby3.get() == True:
        message += "money3\n"
    text.delete(0.0,tkinter.END) #清除text中所有内容  0.0下标为0的第0行
    text.insert(tkinter.INSERT,message)
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

#进入消息循环
#创建多选框
#要绑定的变量
hobby1 = tkinter.BooleanVar()
hobby1.set(True)#设置默认选中
checkButton1 = tkinter.Checkbutton(win,text="money1",command=update,variable=hobby1)
hobby2 = tkinter.BooleanVar()
checkButton2 = tkinter.Checkbutton(win,text="money2",command=update,variable=hobby2)
hobby3 = tkinter.BooleanVar()
checkButton3 = tkinter.Checkbutton(win,text="money3",command=update,variable=hobby3)
checkButton1.pack()
checkButton2.pack()
checkButton3.pack()
text = tkinter.Text(win,height=5,width=50)
text.pack()

win.mainloop()