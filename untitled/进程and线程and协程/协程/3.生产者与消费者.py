def produce(c):
    c.send(None)
    for i in range(5):
        print("消费者生产了{}".format(i))
        r = c.send(str(i))
        print("消费者消费了数据{}".format(r))
    c.close()
def consumer():
    data = ""
    while True:
        n = yield data
        if not n:
            return
        print("消费者消费了{}".format(n))
        data = "200"
c = consumer()
produce(c)