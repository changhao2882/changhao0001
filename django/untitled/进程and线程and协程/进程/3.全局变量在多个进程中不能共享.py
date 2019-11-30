'''
multiprocessing库
跨平台版本的多进程模块   process类来代表一个进程对象
'''
from multiprocessing import Process
import time
import os

num = 100
def run(str):
    #os.getpid()当前进程id号,os.getppid()父进程的id号
    print("{}--{}子进程启动".format(os.getpid(),os.getppid()))
    global num   #global使用的是全局变量   num=100
    num += 1
    print(num)
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

    # 创建子进程  target:执行哪个  args:传数据
    p2 = Process(target=run, args=("123",))
    # 启动进程
    p2.start()
    # 父进程的结束不影响子进程，让父进程等待子进程结束再执行父进程
    p2.join()  #

    print("主进程结束{}".format(num)) #(在子进程中修改全局变量对父进程中的全局变量没有影响)因为在创建子进程时对全局变量做了备份，
    #父进程中的与子进程中的num是完全不同的两个变量
