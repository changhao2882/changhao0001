import threading
import os,time

bar = threading.Barrier(4)
def run():
    print("start-{}".format(threading.current_thread().name))
    time.sleep(1)
    bar.wait()
    print("end-{}".format(threading.current_thread().name))
if __name__ == "__main__":
    for i in range(5):
        threading.Thread(target=run).start()