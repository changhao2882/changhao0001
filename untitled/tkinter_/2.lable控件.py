import tkinter

#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

#进入消息循环
#win：父窗体 text显示的文本内容 bg：背景色 fg:字体颜色,font:字体和大小wraplength:指定多宽进行换行justify:换行后的对齐方式
# anchor:位置n e s w(顺时针位置，可组合(ne东北))center居中
lable = tkinter.Label(win,
                      text = "dsgsd",
                      bg = "pink",
                      fg="red",
                      font=("黑体",20),
                      width=10,
                      height=4,
                      wraplength=150,
                      justify="left",
                      anchor="ne")
#显示出来
lable.pack()

win.mainloop()