import tkinter

def update():
    pass
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
#win.geometry("494x470+200+0")

#进入消息循环
#EXTENDED可以使listbox支持shift和ctrl
listbox = tkinter.Listbox(win,selectmode=tkinter.EXTENDED)
listbox.pack()
for item in ["money1","money2","money3","money4","money5","money7","money8","money9",
             "money10", "money11", "money12", "money13"]:
    listbox.insert(tkinter.END,item)#按顺序添加ACTIVE前面添加
#滚动条
scroll = tkinter.Scrollbar(win)
scroll.pack(side = tkinter.RIGHT,fill=tkinter.Y)
listbox.configure(yscrollcommand=scroll.set)

listbox.pack(side = tkinter.LEFT,fill=tkinter.BOTH)
#额外给属性赋值
#scroll['command'] = listbox.yview
scroll.config(command=listbox.yview)#（等价于上）

win.mainloop()