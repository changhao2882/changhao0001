#客户端：创建TCP连接时，主动发起连接的叫做客户端
import socket

#1.创建一个socket
#socket.AF_INET:指定协议（IPV4/6）（socket.AF_INET6）socket.SOCK_STREAM:指定使用面向流的TCP协议
client = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
#2.建立连接    ("www.sina.com",80):是一个元组（要连接的服务器的IP地址，端口号）
client.connect(("127.0.0.1",8080))

#3..发送数据
count = 0
while True:
    count += 1
    data = input("请输入给服务器发送的数据：")
    client.send(data.encode("utf-8"))
    # 每次接收1k的数据
    info = client.recv(1024)
    print("服务器说：",info.decode("utf-8"))