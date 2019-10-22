from multiprocessing import Process
import os,time

class ChanghaoProcess(Process):
    def __init__(self,name):
        Process.__init__(self)
        self.name = name
    def run(self):
        print("子进程{}-{}启动".format(self.name,os.getpid()))
        time.sleep(3)
        print("子进程{}-{}结束".format(self.name, os.getpid()))