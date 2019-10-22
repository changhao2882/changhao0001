import win32con  # 定义
import win32gui  # 界面
import time  # 时间


QQ= win32gui.FindWindow("TXGuiFoundation","QQ")
for num in range(120):
    time.sleep(1)
    if num%2 == 0:
        win32gui.ShowWindow(QQ, win32con.SW_HIDE)  # 设置隐藏
    else:
        win32gui.ShowWindow(QQ,win32con.SW_SHOW)   # 设置显示














































