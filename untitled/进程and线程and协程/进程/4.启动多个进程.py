from multiprocessing import Pool  #进程池
import os,time,random

def run(name):
    print("子进程{}开始--{}".format(name,os.getpid()))
    start = time.time()
    time.sleep(random.choice([1,2,3]))
    end = time.time()
    print("子进程{}结束--{}--耗时：{:.2f}".format(name,os.getpid(),end-start))

if __name__ == "__main__":
    print("父进程开始")
    #创建多个进程
    #创建进程池    默认大小是cpu核心数        4个
    pp = Pool(4)
    for i in range(5):
        # 创建进程放入进程池统一管理
        pp.apply_async(run,args=(i,))
    # 在调用join时先调用close，之后就不能再添加新的进程了
    pp.close()
    pp.join()
    print("父进程结束")