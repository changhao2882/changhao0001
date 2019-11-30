import sys
import importlib
importlib.reload(sys)

from pdfminer.pdfparser import PDFParser,PDFDocument
from pdfminer.pdfinterp import PDFResourceManager,PDFPageInterpreter
from pdfminer.converter import PDFPageAggregator
from pdfminer.layout import LTTextBoxHorizontal,LAParams
from pdfminer.pdfinterp import PDFTextExtractionNotAllowed

def readPDF(path, toPath):
    f = open(path,"rb")
    #创建pdf文档分析器
    parser = PDFParser(f)
    #创建一个pdf文档
    pdfFile = PDFDocument()
    #连接分析器与文档对象
    parser.set_document(pdfFile)
    pdfFile.set_parser(parser)
    #提供初始化密码
    pdfFile.initialize()
    #检测文档是否提供txt转换
    if not pdfFile.is_extractable:
        raise PDFTextExtractionNotAllowed
    else:
        #解析数据
        #数据管理器
        manager = PDFResourceManager()
        #创建pdf设备的对象
        laparams = LAParams()
        device = PDFPageAggregator(manager, laparams=laparams)
        #解释器对象
        interpreter = PDFPageInterpreter(manager,device)
        #开始循环处理，每次处理一页 pdfFile.get_pages():pdf页数
        for page in pdfFile.get_pages():
            #解释page这一页
            interpreter.process_page(page)
            #循环处理图层
            layout = device.get_result()
            for x in layout:
                if(isinstance(x, LTTextBoxHorizontal)):
                    with open(toPath, "a") as f:
                        str = x.get_text()
                        print(str)
                        f.write(str+"\n")

path = r"D:\box\aaa.pdf"
toPath = r"D:\box\aaa.txt"
readPDF(path,toPath)