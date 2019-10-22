#客户端：创建TCP连接时，主动发起连接的叫做客户端
import socket

#1.创建一个socket
#socket.AF_INET:指定协议（IPV4/6）（socket.AF_INET6）socket.SOCK_DGRAM:指定使用面向流的UDP协议
udpClient = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

#3..发送数据
while True:
    data = input("请输入给服务器发送的数据：")
    udpClient.sendto(data.encode("utf-8"), ("127.0.0.1",8080))
    # 每次接收1k的数据
    info = udpClient.recv(1024)
    print("服务器说：",info.decode("utf-8"))