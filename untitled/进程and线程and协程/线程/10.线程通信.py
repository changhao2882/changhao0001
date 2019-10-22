import threading
import os,time
#下载东西暂停????
def func():
    #事件对象
    event = threading.Event()
    def run():
        for i in range(5):
            # 阻塞，等待事件触发
            event.wait()
            #重置   阻塞??
            event.clear()
            print("aaaaa{}".format(i))
    t = threading.Thread(target=run).start()
    return event

if __name__ == "__main__":
    e = func()
    #触发事件
    for i in range(5):
        time.sleep(2)
        e.set()
