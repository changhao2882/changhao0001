import collections
import os
def work(path):
    resPath=r"E:\新建文件夹 (2)\res"
    with open(path, "r", encoding="UTF-8", errors="ignore") as f:
        while True:
            lineInfo = f.readline()
            if not lineInfo:
                break
            mainStr = lineInfo.split("----")[0]
            fileType = mainStr.split("@")[1].split(".")[0]
            dirStr = os.path.join(resPath,fileType)
            if not os.path.exists(dirStr):
                os.mkdir(dirStr)
            newPath=os.path.join(dirStr,fileType+".txt")
            with open(newPath, "a", encoding="UTF-8", errors="ignore") as f1:
                f1.write(mainStr+"\n")
def getAllDir(path):
    queue = collections.deque()
    queue.append(path)
    while len(queue) !=0:
        dirPath = queue.popleft()
        filesList = os.listdir(dirPath)
        for fileName in filesList:
            fileAbsPath = os.path.join(dirPath, fileName)
            if os.path.isdir(fileAbsPath):
                queue.append(fileAbsPath)
            else:
                work(fileAbsPath)
getAllDir(r"E:\GOG Galaxy")