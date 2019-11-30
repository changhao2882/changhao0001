import os
def getAllDir(path):
    stack = []
    stack.append(path)
    #处理栈，栈为空结束循环
    while len(stack) !=0:
        #从栈里取出数据
        dirPath = stack.pop()
        # 目录下所有文件
        filesList = os.listdir(dirPath)
        for fileName in filesList:
            fileAbsPath = os.path.join(dirPath, fileName)
            if os.path.isdir(fileAbsPath):
                print("是一个目录", fileName)
                stack.append(fileAbsPath)
            else:
                print("普通文件", fileName)

getAllDir(r"E:\GOG Galaxy")