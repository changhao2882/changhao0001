import tkinter

def update():
    pass
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

#供用户通过拖拽指示器改变变量的值，可水平，可垂直
#进入消息循环from_起始值,to终点值HORIZONTAL水平VERTICAL竖直 tickinterval选择值为它的设定的倍数
#length水平时表示宽度，数值时表示高度
scale1 = tkinter.Scale(win,from_=0,to=100,orient=tkinter.HORIZONTAL,tickinterval=10,length=200)
scale1.pack()
#设置值
scale1.set(20)
#取值
def say1():
    print(scale1.get())
button = tkinter.Button(win,text = "按钮",command=say1)
button.pack()

win.mainloop()