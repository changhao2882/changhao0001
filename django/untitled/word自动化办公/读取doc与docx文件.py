import win32com
import win32com.client

def readWordFile(path):
    #调用系统word功能，可以处理doc和docx两种文件
    mw = win32com.client.Dispatch("Word.Application")
    #打开文件
    doc = mw.Documents.Open(path)
    for par in doc.Paragraphs:
        line = par.Range.Text
        print(line)
    # 关闭文件
    doc.Close()
    #退出word
    mw.Quit()

path = r"D:\box\word\16033204.docx"
readWordFile(path)