#进程模块
import win32process
import win32con
import win32gui
import win32api
import ctypes
import time
PROCESS_ALL_ACCESS = (0x000F0000|0x00100000|0xFFF)
#找窗体
win = win32gui.FindWindow("MainWindow","Plants vs. Zombies")
#根据窗体找到进程号
hid,pid=win32process.GetWindowThreadProcessId(win)
#以最高权限打开进程
p=win32api.OpenProcess(PROCESS_ALL_ACCESS,False,pid)   #print(pid)
print(pid)
data = ctypes.c_long() #data可以理解为long
#加载内核模块 windll（window的库）
md = ctypes.windll.LoadLibrary(r"C:\Windows\System32\kernel32")
while True:
    # 读取内存(“4”表示占4个字节，types.byref(date)表示转递地址信息，写入的结果到date中)
    # int(phand)打开的进程编号   “244866760”需要读取的内存的地址
    md.ReadProcessMemory(int(p), 0x1F2C7FD8, ctypes.byref(data), 4, None)
    # 读内存 （可以获取内存中对应的数据）
    print(data.value)
    if data.value <10000:
        newdata = ctypes.c_long(10000) # 设定修改的数据
        # 修改
        md.WriteProcessMemory(int(p), 0x1F2C7FD8, ctypes.byref(newdata), 4, None)
    time.sleep(1)





















