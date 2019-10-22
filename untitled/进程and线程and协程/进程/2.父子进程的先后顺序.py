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
    time.sleep(3)
    print("子进程结束")

if __name__ == "__main__":
    print("{}主进程启动".format(os.getpid()))
    #创建子进程  target:执行哪个  args:传数据
    p = Process(target=run,args=("123",))
    #启动进程
    p.start()
    #父进程的结束不影响子进程，让父进程等待子进程结束再执行父进程
    p.join()    #
    print("主进程结束")
