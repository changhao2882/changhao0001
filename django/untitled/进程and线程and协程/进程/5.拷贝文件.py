# from multiprocessing import Pool  #进程池
# import os,time,random
#
# def copyFile(rPath,wPath):
#     with open(rPath, "rb") as f:
#         with open(wPath, "wb") as f1:
#             f1.write(f.read())
#
# path = r"D:\box\file"
# toPath = r"D:\box\toFile"
#
# #读取path下的所有文件
# fileList = os.listdir(path)
# start = time.time()
# #启动for循环处理每一个文件
# for fileName in fileList:
#     copyFile(os.path.join(path,fileName),os.path.join(toPath,fileName))
# end = time.time()
# print("总耗时{:.2f}".format(end-start))  #0.30

from multiprocessing import Pool  #进程池
import os,time,random

def copyFile(rPath,wPath):
    with open(rPath, "rb") as f:
        with open(wPath, "wb") as f1:
            f1.write(f.read())

if __name__ == "__main__":
    path = r"D:\box\file"
    toPath = r"D:\box\toFile"

    # 读取path下的所有文件
    fileList = os.listdir(path)
    pp = Pool(4)

    start = time.time()
    # 启动for循环处理每一个文件
    for fileName in fileList:
        pp.apply_async(copyFile,args=(os.path.join(path, fileName), os.path.join(toPath, fileName)))
    pp.close()
    pp.join()
    end = time.time()
    print("总耗时{:.2f}".format(end - start))  #0.26





