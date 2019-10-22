import tkinter
from tkinter import ttk
import os
class TreeWindows(tkinter.Frame):
    def __init__(self,master,path,otherWin):
        self.otherWin = otherWin

        self.frame = tkinter.Frame(master)
        self.frame.grid(row=0,column=0)

        self.tree= ttk.Treeview(self.frame)
        #self.tree.pack()
        self.root = self.tree.insert("", "end", text=self.getLastPath(path), open = True,values=(path,))
        self.loadTree(self.root,path)

        # 创建滚动条
        self.scroll = tkinter.Scrollbar(self.frame)
        # side放到窗体的哪一侧fill填充Y轴
        self.scroll.pack(side=tkinter.RIGHT, fill=tkinter.Y)
        self.tree.pack(side=tkinter.LEFT, fill=tkinter.Y)
        # 关联
        self.scroll.config(command=self.tree.yview)
        self.tree.config(yscrollcommand=self.scroll.set)

        #tree绑定事件
        self.tree.bind("<<TreeviewSelect>>", self.say)

    def say(self,event):
        self.v = event.widget.selection()
        for sv in self.v:
            file = self.tree.item(sv)["text"]
            self.otherWin.e.set(file)
            apath = self.tree.item(sv)["values"][0]
            if apath.split(".")[-1]=="txt":
                self.otherWin.text.delete(0.0, tkinter.END)
                with open(apath, "r", encoding="UTF-8", errors="ignore") as f:
                    self.otherWin.text.insert(tkinter.INSERT, f.read())

    def loadTree(self,parent,parentPath):
        filesList = os.listdir(parentPath)
        for fileName in filesList:
            absPath = os.path.join(parentPath, fileName)
            treey = self.tree.insert(parent, "end", text=self.getLastPath(absPath),values=(absPath,))
            if os.path.isdir(absPath):
                self.loadTree(treey,absPath)

    def getLastPath(self,path):
        pathList = os.path.split(path)
        return pathList[-1]