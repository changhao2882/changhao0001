import threading,time,queue,random

#线程条件变量
cond = threading.Condition()
def run1():
    with cond:
        for i in range(0,10,2):
            print(i,threading.current_thread().name)
            time.sleep(1)
            cond.wait()
            cond.notify()

def run2():
    with cond:
        for i in range(1,10,2):
            print(i,threading.current_thread().name)
            time.sleep(1)
            cond.notify()
            cond.wait()

if __name__ == "__main__":
    threading.Thread(target=run1).start()
    threading.Thread(target=run2).start()