import threading

num = 0
#创建一个全局的ThreadLocal对象，可以让每个线程有独立的存储空间，每个线程对ThreadLocal对象都可以读写，但是互不影响
local = threading.local()

def run(x,n):
    x += n
    x -= n
    return x
def func(n):
    local.x = num
    for i in range(1000000):
        local.x = run(local.x,n)
    print("{}-{}".format(threading.current_thread().name,local.x))

    '''
    global num
    num += 1
    print(num)
    
    local.x = num
    local.x += 1
    print(local.x)
    '''

if __name__ == "__main__":
    #任何进程就会默认启动一个线程，成为主线程，主线程可以启动新的子线程
    print("主线程{}启动".format(threading.current_thread().name))    # 当前线程的名称     current_thread返回当前线程的实例（对象）
    #创建子线程
    t = threading.Thread(target=func,name="runThread",args=(6,))  #name子线程的名称
    t2 = threading.Thread(target=func, name="runThread1", args=(6,))
    t.start()
    t2.start()
    t.join()
    t2.join()
    print("主线程{}结束".format(threading.current_thread().name))