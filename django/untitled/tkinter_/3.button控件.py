import tkinter

def say():
    print("你好！")
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

#进入消息循环
#创建按钮
#win：父窗体 text显示的文本内容 command:执行的操作（lambda匿名函数，win.quit退出）
button = tkinter.Button(win,text = "按钮",command=say,width = 10,height = 10)
button2 = tkinter.Button(win,text = "按钮1",command=win.quit)
#显示出来
button.pack()
button2.pack()
win.mainloop()