import tkinter
from tkinter import ttk
#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("600x470+200+0")

#进入消息循环
tree = ttk.Treeview(win)
tree.pack()
#tree.place(x=100,y=100) 绝对布局
#添加一级树支
treeF1=tree.insert("",0,"中国",text="中国Chi",values=("F1"))
treeF2=tree.insert("",1,"美国",text="美国Usa",values=("F2"))
treeF3=tree.insert("",2,"日本",text="日本Jep",values=("F3"))
#添加二级数支
treeF1_1=tree.insert(treeF1,0,"河北",text="河北HeBei",values=("F1_1"))
treeF1_2=tree.insert(treeF1,1,"河南",text="河南HeNan",values=("F1_2"))
treeF1_3=tree.insert(treeF1,2,"山东",text="山东ShanDong",values=("F1_3"))
#添加三级数支
treeF1_1_1=tree.insert(treeF1_1,0,"邢台",text="邢台XingTai",values=("treeF1_1_1"))
treeF1_1_2=tree.insert(treeF1_1,1,"石家庄",text="石家庄ShiJiaZhuang",values=("treeF1_1_2"))
treeF1_1_3=tree.insert(treeF1_1,2,"邯郸",text="邯郸HanDan",values=("treeF1_1_3"))

win.mainloop()