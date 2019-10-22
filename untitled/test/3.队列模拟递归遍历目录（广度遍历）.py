import collections
import os

def getAllDir(path):
    queue = collections.deque()
    queue.append(path)
    while len(queue) !=0:
        dirPath = queue.popleft()
        filesList = os.listdir(dirPath)
        for fileName in filesList:
            fileAbsPath = os.path.join(dirPath, fileName)
            if os.path.isdir(fileAbsPath):
                print("是一个目录", fileName)
                queue.append(fileAbsPath)
            else:
                print("普通文件", fileName)
getAllDir(r"E:\GOG Galaxy")