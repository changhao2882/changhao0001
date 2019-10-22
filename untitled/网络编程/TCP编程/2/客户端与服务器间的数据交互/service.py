#服务端：接受客户端的连接
import socket

#1.创建一个socket
#socket.AF_INET:指定协议（IPV4/6）（socket.AF_INET6）socket.SOCK_STREAM:指定使用面向流的TCP协议
server = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
#2.绑定IP端口   ("www.sina.com",80):是一个元组（要连接的服务器的IP地址，端口号）
server.bind(("127.0.0.1",8080))
#3.监听             5个
server.listen(5)
print("服务器启动成功。。。")
#4..等待客户端连接
#socket号   地址
clientSocket, clientAddress = server.accept()
print("{} -- {}连接成功".format(str(clientSocket),str(clientSocket)))
while True:
    #接收数据  每次接收1k的数据
    data = clientSocket.recv(1024)
    print("收到"+str(clientSocket)+"的数据"+data.decode("utf-8"))
    clientSocket.send("傻逼哦^_^".encode("utf-8"))








# while True:
#     # 4..等待客户端连接
#     # socket号   地址
#     clientSocket, clientAddress = server.accept()
#     print("{} -- {}连接成功".format(str(clientSocket), str(clientSocket)))
#     #启动一个线程，将当前连接的clientSocket交给线程
#
#
#
#
#
#     #接收数据  每次接收1k的数据
#     data = clientSocket.recv(1024)
#     print("收到"+str(clientSocket)+"的数据"+data.decode("utf-8"))
#     clientSocket.send("傻逼哦^_^".encode("utf-8"))
