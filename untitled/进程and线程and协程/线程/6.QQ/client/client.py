import tkinter
import socket
import threading

#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ")
#设置大小和位置
win.geometry("494x470+600+300")

ck = None
def getInfo():
    while True:
        # 每次接收1k的数据
        data = ck.recv(1024)
        text.insert(tkinter.INSERT,"\n"+data.decode("utf-8"))
def connectServer():
    global ck
    ipStr = eip.get()
    portStr = eport.get()
    userStr = euser.get()
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect((ipStr, int(portStr)))
    client.send(userStr.encode("utf-8"))
    ck = client
    #等待接收数据
    t = threading.Thread(target=getInfo)
    t.start()
def sendMail():
    friend = efriend.get()
    sendStr = esend.get()
    sendStr = friend + ":" + sendStr
    ck.send(sendStr.encode("utf-8"))
#绑定变量
euser = tkinter.Variable()
eip = tkinter.Variable()
eport = tkinter.Variable()
esend = tkinter.Variable()
efriend = tkinter.Variable()
#进入消息循环
lableUser = tkinter.Label(win,text = "userName").grid(row=0,column=0)
lableIp = tkinter.Label(win,text = "IP").grid(row=1,column=0)
lablePort = tkinter.Label(win,text = "port").grid(row=2,column=0)
entryUser = tkinter.Entry(win,textvariable = euser).grid(row=0,column=1)
entryIp = tkinter.Entry(win,textvariable = eip).grid(row=1,column=1)
entryPort = tkinter.Entry(win,textvariable = eport).grid(row=2,column=1)
button1 = tkinter.Button(win,text = "连接",command=connectServer).grid(row=3,column=1)
text = tkinter.Text(win,width=30,height=10)
text.grid(row=4,column=1)
neirong = tkinter.Label(win,text = "send").grid(row=5,column=0)
entrySend = tkinter.Entry(win,textvariable = esend).grid(row=5,column=1)
jieshouzhe = tkinter.Label(win,text = "friend").grid(row=6,column=0)
entryFriend = tkinter.Entry(win,textvariable = efriend).grid(row=6,column=1)
button2 = tkinter.Button(win,text = "发送",command=sendMail).grid(row=7,column=1)
win.mainloop()