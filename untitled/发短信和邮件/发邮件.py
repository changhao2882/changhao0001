#发邮件的库
import smtplib
#邮件文本
from email.mime.text import MIMEText
#SMTP服务器
SMTPServer = "smtp.163.com"
#发邮件的地址
sender = "changhao2882@163.com"
#发送者邮箱的密码
passwd = "ch123456"

#设置发送的内容
message = "你好吗？"
#转换成邮件文本
msg = MIMEText(message)
#标题
msg["Subject"] = "来自你爸爸的问候"
#发送者
msg["From"] = sender

#创建SMTP服务器 25为端口号
mailServer = smtplib.SMTP(SMTPServer,25)
#登录邮箱
mailServer.login(sender,passwd)
#发送邮件 发件邮箱和接收邮箱 邮件形式字符串
mailServer.sendmail(sender,["changhao2882@163.com"],msg.as_string())
#推出邮箱
mailServer.quit()
