import telnetlib

def telnetDoSomething(IP,user,password,command):
    try:
        # 连接服务器
        telnet = telnetlib.Telnet(IP)
        # 设置调试级别
        telnet.set_debuglevel(2)
        # 读取到输入用户名信息
        rt = telnet.read_until("Login username:".encode("utf-8"))
        # 写入用户名  he  回车
        telnet.write((user + "\r\n").encode("utf-8"))
        # 读取到输入密码信息
        rt = telnet.read_until("Login password:".encode("utf-8"))
        # 写入密码  he  回车
        telnet.write((password + "\r\n").encode("utf-8"))
        # 读取到验证IP
        rt = telnet.read_until("Domain name:".encode("utf-8"))
        # 写入IP  he  回车
        telnet.write((IP + "\r\n").encode("utf-8"))
        # 读取到登陆成功，写指令
        rt = telnet.read_until(">".encode("utf-8"))
        # 写入用户名  he  回车
        telnet.write((command + "\r\n").encode("utf-8"))
        # 上面命令执行成功，会继续读到>   失败一般不会是>
        rt = telnet.read_until(">".encode("utf-8"))
        # 断开连接
        telnet.close()
        return True
    except:
        print("error")
        return False

if __name__ == "__main__":
    IP = ""
    user = ""
    password = ""
    command = "tasklist"
    print(telnetDoSomething(IP,user,password,command))