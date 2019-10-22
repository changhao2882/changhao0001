import tkinter
import socket
import threading

#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("QQ服务器")
#设置大小和位置
win.geometry("494x470+600+300")

users = {}
def run(cs,ca):
    print("**************")
    userName = cs.recv(1024)
    users[userName.decode("utf-8")] = cs
    printStr = "\n"+userName.decode("utf-8") + "连接"
    text.insert(tkinter.INSERT,printStr)
    while True:
        rData = cs.recv(1024)
        dataStr = rData.decode("utf-8")
        infolist = dataStr.split(":")
        users[infolist[0]].send((userName.decode("utf-8")+"说："+infolist[1]).encode("utf-8"))
def start():
    ipStr = eip.get()
    portStr = eport.get()
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((ipStr, int(portStr)))
    server.listen(10)
    printStr = "服务器启动成功。。。"
    text.insert(tkinter.INSERT, printStr)
    while True:
        cs, ca = server.accept()
        t = threading.Thread(target=run, args=(cs, ca))
        t.start()
def startServer():
    s = threading.Thread(target=start, name="runThread")
    s.start()


#绑定变量
eip = tkinter.Variable()
eport = tkinter.Variable()
#进入消息循环
lableIp = tkinter.Label(win,text = "IP").grid(row=0,column=0)
lablePort = tkinter.Label(win,text = "port").grid(row=1,column=0)
entryIp = tkinter.Entry(win,textvariable = eip).grid(row=0,column=1)
entryPort = tkinter.Entry(win,textvariable = eport).grid(row=1,column=1)
button1 = tkinter.Button(win,text = "启动",command=startServer).grid(row=2,column=0)
button2 = tkinter.Button(win,text = "退出",command=win.quit).grid(row=2,column=1)
text = tkinter.Text(win,width=30,height=10)
text.grid(row=3,column=0)

win.mainloop()