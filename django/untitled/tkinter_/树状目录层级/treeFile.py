import tkinter
from tkinter import ttk
from treeWindows import TreeWindows
from infoWindow import InfoWindow
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("900x440+200+50")

#进入消息循环
path = r"D:\下载\nativePC"
infoWin = InfoWindow(win)
treeWin = TreeWindows(win,path,infoWin)


win.mainloop()