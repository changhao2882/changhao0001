import win32com
import win32com.client

def makePPT(path):
    # 调用系统word功能，可以处理doc和docx两种文件
    ppt = win32com.client.Dispatch("PowerPoint.Application")
    # 让文档可见
    ppt.Visible = True
    # 创建文件
    pptFile = ppt.Presentations.Add()
    # 写内容
    # 创建页
    page1 = pptFile.Slides.Add(1,1)  #参数1为页数，从1开始  参数2为类型
    #第一个文本框  内容   写文字的位置
    t1 = page1.Shapes[0].TextFrame.TextRange
    t1.Text = "changhao"
    # 第二个文本框  内容   写文字的位置
    t2 = page1.Shapes[1].TextFrame.TextRange
    t2.Text = "changhaochanghaochanghaochanghaochanghao"

    # 创建页
    page2 = pptFile.Slides.Add(2, 1) #参数1为页数，从1开始  参数2为类型（主题）
    # 第一个文本框  内容   写文字的位置
    t3 = page2.Shapes[0].TextFrame.TextRange
    t3.Text = "changhao1"
    # 第二个文本框  内容   写文字的位置
    t4 = page2.Shapes[1].TextFrame.TextRange
    t4.Text = "changhaochanghaochanghaochanghaochanghao1"

    # 存储文件
    pptFile.SaveAs(path)

    # 关闭文件
    pptFile.Close()
    # 退出word
    ppt.Quit()


path = r"D:\box\ppt\a.ppt"
makePPT(path)