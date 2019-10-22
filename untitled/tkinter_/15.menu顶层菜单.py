import tkinter

#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

def func():
    print("***********")

#进入消息循环
#菜单条
menubar = tkinter.Menu(win)
win.config(menu=menubar)
#创建菜单选项  tearoff：TRUE多一条虚线
menu1=tkinter.Menu(menubar,tearoff=False)
#给菜单选项添加内容
for item in ["python","java","C#","C/C++","JS","PHP","汇编","shell","退出"]:
    if item=="退出":
        #添加分割线
        menu1.add_separator()
        menu1.add_command(label=item,command=win.quit)
    else:
        menu1.add_command(label=item,command=func)
#向菜单条上添加菜单选项
menubar.add_cascade(label="语言",menu=menu1)


win.mainloop()