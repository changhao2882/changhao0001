import tkinter

def say1():
    print(v.get())
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

#绑定变量
v = tkinter.StringVar()
#进入消息循环 increment：步长，默认为1 成increment增加
#values不要与from_=0,to=100  increment同时使用
spinbox = tkinter.Spinbox(win,from_=0,to=100,increment=1,textvariable=v,command=say1)#command只要值改变就会执行对应的方法
# spinbox = tkinter.Spinbox(win,values=(0,2,4,6,8))
spinbox.pack()
#设置值
v.set(20)
#取值
# print(v.get())

win.mainloop()