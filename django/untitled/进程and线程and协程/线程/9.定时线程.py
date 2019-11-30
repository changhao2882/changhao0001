import threading
import os,time

def run():
    print("start-{}".format(threading.current_thread().name))

if __name__ == "__main__":
    #延时执行线程
    t = threading.Timer(5,run)
    t.start()
    t.join()
    print("主线程结束")