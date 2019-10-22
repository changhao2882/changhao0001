#客户端：创建TCP连接时，主动发起连接的叫做客户端
#服务端：接受客户端的连接
import socket

#1.创建一个socket
#socket.AF_INET:指定协议（IPV4/6）（socket.AF_INET6）socket.SOCK_STREAM:指定使用面向流的TCP协议
sk = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
#2.建立连接    ("www.sina.com",80):是一个元组（要连接的服务器的IP地址，端口号）
sk.connect(("www.sina.com.cn",80))
#3.              b:字节码
sk.send(b'GET / HTTP/1.1\r\nHost: www.sina.com.cn\r\nConnection: close\r\n\r\n')
#4..等待接收数据
data = []
while True:
    # 每次接收1k的数据
    tempData = sk.recv(1024)
    if tempData:
        data.append(tempData)
    else:
        break
dataStr = (b''.join(data)).decode("utf-8")
#断开连接
sk.close()
#print(dataStr)
headers ,HTML = dataStr.split('\r\n\r\n',1)    #,1切一次
print(headers)
print(HTML)