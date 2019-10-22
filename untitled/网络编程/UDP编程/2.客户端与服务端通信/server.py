#服务端：接受客户端的连接
import socket

#1.创建一个socket
#socket.AF_INET:指定协议（IPV4/6）（socket.AF_INET6）socket.SOCK_DGRAM:指定使用面向流的UDP协议
udpServer = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
#2.绑定IP端口   ("www.sina.com",80):是一个元组（要连接的服务器的IP地址，端口号）
udpServer.bind(("127.0.0.1",8080))
while True:
    data,address = udpServer.recvfrom(1024)
    print("客户端说："+data.decode("utf-8"))
    udpServer.sendto("吗卖批".encode("utf-8"), address)
