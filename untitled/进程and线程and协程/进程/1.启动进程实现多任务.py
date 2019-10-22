'''
multiprocessing库
跨平台版本的多进程模块   process类来代表一个进程对象
'''
from multiprocessing import Process
import time
import os

def run(str):
    #os.getpid()当前进程id号,os.getppid()父进程的id号
    print("{}--{}子进程启动".format(os.getpid(),os.getppid()))
    while True:
        print("nihao"+str)
        time.sleep(1.2)

if __name__ == "__main__":
    print("{}主进程启动".format(os.getpid()))
    #创建子进程  target:执行哪个  args:传数据
    p = Process(target=run,args=("123",))
    #启动进程
    p.start()
    while True:
        print("changhao")
        time.sleep(1)
