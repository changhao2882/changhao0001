import threading
import os,time

sem = threading.Semaphore(2)
def run():
    with sem:
        for i in range(10):
            print("{}-{}".format(i,threading.current_thread().name))
            time.sleep(1)
if __name__ == "__main__":
    for i in range(5):
        threading.Thread(target=run).start()