import threading
import time

number = 100
def run(n):
    print("子线程{}开始".format(threading.current_thread().name))
    global number
    for i in range(10000000):
        number += n
        number -= n
    print("子线程{}结束".format(threading.current_thread().name))

if __name__ == "__main__":
    #任何进程就会默认启动一个线程，成为主线程，主线程可以启动新的子线程
    print("主线程{}启动".format(threading.current_thread().name))    # 当前线程的名称     current_thread返回当前线程的实例（对象）
    #创建子线程
    t = threading.Thread(target=run,name="runThread",args=(6,))  #name子线程的名称
    t2 = threading.Thread(target=run, name="runThread1", args=(6,))
    t.start()
    t2.start()
    t.join()
    t2.join()
    print(number)
    print("主线程{}结束".format(threading.current_thread().name))