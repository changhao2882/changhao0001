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
#绑定变量
e = tkinter.Variable()
#创建输入控件
#win：父窗体show:自定义显示
entry = tkinter.Entry(win,show ="*",textvariable = e)
#显示出来
entry.pack()
#e就代表输入框这个对象
#设置值
e.set("45454555")
#取值entry.get()也行
print(e.get())
win.mainloop()