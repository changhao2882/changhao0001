#win+r->regedit->HKEY_CURRENT_USER->Control Panel->Desktop->WallPaper
import win32api
import win32con
import win32gui

def setWallPaper(path):
    #打开注册表
    reg_key = win32api.RegOpenKey(win32con.HKEY_CURRENT_USER,"Control Panel\\Desktop",0,win32con.KEY_SET_VALUE)
    #2 拉伸 0 居中 6 适应 10 填充
    win32api.RegSetValueEx(reg_key,"WallpaperStyle",0,win32con.REG_SZ,"0")

    # win32api.RegSetValue(reg_key,)
    #win32api.RegSetValue(reg_key, "WallPaper")
    #win32con.SPIF_SENDWININICHANGE设置立即生效
    win32gui.SystemParametersInfo(win32con.SPI_SETDESKWALLPAPER,path,win32con.SPIF_SENDWININICHANGE)


path = r"D:\box\images\1.jpg"
setWallPaper(path)