import socket

str="1_lbt4_10#32899#002481627512#0#0#0:20190920:用户名:主机:32:哈哈哈哈"
#1.创建一个socket
#socket.AF_INET:指定协议（IPV4/6）（socket.AF_INET6）socket.SOCK_DGRAM:指定使用面向流的UDP协议
udp = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
#2.建立连接    ("www.sina.com",80):是一个元组（要连接的服务器的IP地址，端口号）
udp.connect(("169.254.252.28",2425))
#3.
udp.send(str.encode("gbk"))



# for i in range(256):
#     ip = "169.254.252.%d"%i
#     print(ip)
#     # 1.创建一个socket
#     # socket.AF_INET:指定协议（IPV4/6）（socket.AF_INET6）socket.SOCK_DGRAM:指定使用面向流的UDP协议
#     udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
#     # 2.建立连接    ("www.sina.com",80):是一个元组（要连接的服务器的IP地址，端口号）
#     udp.connect(("169.254.252.28", 2425))
#     # 3.
#     udp.send(str.encode("gbk"))

