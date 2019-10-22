import tkinter
from tkinter import ttk
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+200+0")

#进入消息循环
frame = tkinter.Frame(win)
frame.pack(side=tkinter.RIGHT)
#left
frame_l = tkinter.Frame(frame)#(win)
tkinter.Label(frame_l,text="左上",bg="pink").pack(side=tkinter.TOP)
tkinter.Label(frame_l,text="左下",bg="pink").pack(side=tkinter.TOP)
frame_l.pack(side=tkinter.LEFT)
#right
frame_r = tkinter.Frame(frame)#(win)
tkinter.Label(frame_r,text="右上",bg="red").pack(side=tkinter.TOP)
tkinter.Label(frame_r,text="右下",bg="red").pack(side=tkinter.TOP)
frame_r.pack(side=tkinter.RIGHT)

win.mainloop()