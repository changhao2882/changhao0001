import tkinter
from tkinter import ttk
import os
class InfoWindow(tkinter.Frame):
    def __init__(self,master):
        self.frame = tkinter.Frame(master)
        self.frame.grid(row=0,column=1)

        self.e = tkinter.Variable()
        self.entry = tkinter.Entry(self.frame, textvariable=self.e)
        self.entry.pack()


        # 文本控件，显示多行文本
        self.text = tkinter.Text(self.frame, width=50, height=30)
        self.text.pack()

        # 创建滚动条
        self.scroll = tkinter.Scrollbar(self.frame)
        # side放到窗体的哪一侧fill填充Y轴
        self.scroll.pack(side=tkinter.RIGHT, fill=tkinter.Y)
        self.text.pack(side=tkinter.LEFT, fill=tkinter.Y)
        # 关联
        self.scroll.config(command=self.text.yview)
        self.text.config(yscrollcommand=self.scroll.set)




