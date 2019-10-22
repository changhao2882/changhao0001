import win32con  # 定义
import win32gui  # 界面
import time  # 时间
import random
QQ= win32gui.FindWindow("TXGuiFoundation","QQ")
#1.控制的窗体2.大致方位HWND_TOPMOST(上方)3.位置的X4.位置的Y5.长度6.宽度7.显示
while True:
    x = random.randrange(900)
    y = random.randrange(600)
    win32gui.SetWindowPos(QQ,win32con.HWND_TOPMOST,x,y,300,300,win32con.SWP_SHOWWINDOW)











