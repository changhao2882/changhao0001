import win32com
import win32com.client

def readWordFileToOtherFile(path,path2):
    #调用系统word功能，可以处理doc和docx两种文件
    mw = win32com.client.Dispatch("Word.Application")
    #打开文件
    doc = mw.Documents.Open(path)

    #将word数据写入另一个文件
    doc.SaveAs(path2,2)#2:txt文件

    # 关闭文件
    doc.Close()
    #退出word
    mw.Quit()

path = r"D:\box\word\16033204.docx"
path2 = r"D:\box\word\16033204.txt"
readWordFileToOtherFile(path,path2)