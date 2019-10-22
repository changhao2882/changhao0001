import threading
import time

#锁对象
lock = threading.Lock()
number = 100
def run(n):
    print("子线程{}开始".format(threading.current_thread().name))
    global number
    for i in range(10000000):
        '''
        try:
            # 上锁  确保了这段代码只能有一个线程从头到尾的完整执行，阻止了多线程的并发执行，包含所得这段代码实际上只能以单线程模式执行，所以效率大大降低
            #由于可以存在多个锁，不同线程持有不同的锁，并试图获取其他的锁，这样锁来锁去可能造成死锁，导致多个线程挂起。只能靠操作系统强制终止
            lock.acquire()
            number += n
            number -= n
        finally:
            # 修改完一定要释放锁
            lock.release()
        '''
        #与上面代码功能相同，可以自动上锁和解锁
        with lock:
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