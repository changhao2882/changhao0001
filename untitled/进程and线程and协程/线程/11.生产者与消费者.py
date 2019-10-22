import threading,time,queue,random

#生产者
def product(i,q):
    while True:
        num = random.randint(0,10000)
        q.put(num)
        print("生产者{}生产了{}放入了队列".format(i,num))
        time.sleep(3)
    #任务完成
    q.tast_done()

#消费者
def customer(i,q):
    while True:
        item = q.get()
        if item is None:
            break
        print("消费者{}消费了{}".format(i,item))
        time.sleep(2)
    # 任务完成
    q.tast_done()

if __name__ == "__main__":
    # 消息队列
    q = queue.Queue()
    # 启动生产者
    for i in range(4):
        threading.Thread(target=product,args=(i,q)).start()
    # 启动消费者
    for i in range(3):
        threading.Thread(target=customer,args=(i,q)).start()