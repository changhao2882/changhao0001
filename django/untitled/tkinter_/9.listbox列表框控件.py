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
#创建列表框
listbox = tkinter.Listbox(win,selectmode=tkinter.BROWSE)
listbox.pack()
for item in ["money1","money2","money3","money4"]:
    listbox.insert(tkinter.END,item)#按顺序添加ACTIVE前面添加
listbox.insert(tkinter.ACTIVE,"lihaile")
listbox.insert(tkinter.END,["money5","money6"])#将列表当成一个元素添加
#listbox.delete(1,3)#删除开始的索引，结束的索引（不指定则删除第一个索引内的内容）
#选中 选中开始的索引，结束的索引（不指定则选中第一个索引内的内容）
listbox.select_set(2,4)
#取消选中  取消选中开始的索引，结束的索引（不指定则取消选中第一个索引内的内容）
listbox.select_clear(3)
#获取到列表中的元素个数
print(listbox.size())
#获取值   获取选中开始的索引，结束的索引（不指定则获取选中第一个索引内的内容）
print(listbox.get(2,4))
#返回当前的索引项，不是item元素
print(listbox.curselection())
#判断一个选项是否被选中
print(listbox.selection_includes(1))
print(listbox.selection_includes(2))
win.mainloop()