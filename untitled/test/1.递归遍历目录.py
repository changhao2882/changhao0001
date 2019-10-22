import os
def getAllDir(path,sp = ""):
    filesList = os.listdir(path)
    # print(filesList)
    sp += "   "
    for fileName in filesList:
        fileAbsPath = os.path.join(path,fileName)
        if os.path.isdir(fileAbsPath):
            print(sp+"是一个目录",fileName)
            getAllDir(fileAbsPath,sp)
        else:
            print(sp+"普通文件",fileName)

getAllDir(r"E:\GOG Galaxy")