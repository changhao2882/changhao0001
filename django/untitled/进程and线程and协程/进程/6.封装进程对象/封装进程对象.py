from changhaoProcess import ChanghaoProcess

if __name__ == "__main__":
    print("父进程开始")
    #创建子进程
    p = ChanghaoProcess("test")
    #自动调用p进程对象的run方法
    p.start()
    p.join()
    print("父进程结束")