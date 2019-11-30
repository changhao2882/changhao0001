import pygame
import time
import win32api
import win32con
import win32gui
import threading  #线程模块

def setWallPaper(path):
    # 打开注册表
    reg_key = win32api.RegOpenKey(win32con.HKEY_CURRENT_USER, "Control Panel\\Desktop", 0,
                                          win32con.KEY_SET_VALUE)
    # 2 拉伸 0 居中 6 适应 10 填充
    win32api.RegSetValueEx(reg_key, "WallpaperStyle", 0, win32con.REG_SZ, "0")
    # win32con.SPIF_SENDWININICHANGE设置立即生效
    win32gui.SystemParametersInfo(win32con.SPI_SETDESKWALLPAPER, path, win32con.SPIF_SENDWININICHANGE)

def go():
    # 初始化
    pygame.mixer.init()
    while True:
        for i in range(1,3):
            filePath = r"D:\box\mp3"+"\\"+str(i)+".mp3"
            #加载音乐
            track = pygame.mixer.music.load(filePath)
            # 播放
            pygame.mixer.music.play()
            # 暂停pygame.mixer.music.pause()
            time.sleep(249)
if __name__ =="__main__":
    th = threading.Thread(target=go,name="LoopThread")
    th.start()
    while True:
        for i in range(1,4):
            path = r"D:\box\images" + "\\" + str(i) + ".jpg"
            print(path)
            setWallPaper(path)
            time.sleep(2)