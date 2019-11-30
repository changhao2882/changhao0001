import tkinter

def update():
    pass
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

#进入消息循环
#绑定变量
lbv = tkinter.StringVar()
#创建列表框  SINGLE与VBORWSE相似，但是不支持鼠标按下后移动选中
listbox = tkinter.Listbox(win,selectmode=tkinter.SINGLE,listvariable=lbv)
listbox.pack()
for item in ["money1","money2","money3","money4"]:
    listbox.insert(tkinter.END,item)#按顺序添加ACTIVE前面添加
#打印当前列表中的选项
print(lbv.get())
#设置选项
lbv.set(("1","2","3","4","5"))
#绑定事件 双击-按钮-鼠标左键
def say(event):
    print(listbox.delete(listbox.curselection()))
listbox.bind("<Double-Button-1>",say)

def say1():
    print(listbox.delete(listbox.curselection()))
button = tkinter.Button(win,text = "按钮",command=say1,width = 10,height = 10)
button.pack()
win.mainloop()