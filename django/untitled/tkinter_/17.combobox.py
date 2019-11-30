import tkinter
from tkinter import ttk
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")



#进入消息循环
com = ttk.Combobox(win)
com.pack()
#设置下拉数据
com["value"]=("邢台","石家庄","邯郸")
#设置默认值
com.current(0)
#绑定事件
def func(event):
    print(com.get())
com.bind("<<ComboboxSelected>>",func)

win.mainloop()