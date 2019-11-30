import urllib.request
import urllib.parse  #对参数进行打包
import random

url = r"http://laptop-m8fqlcv8:8080/changhao001/"
#将要发送的数据合成一个字典
data = {
    "ui.permission":"管理员",
    "ui.username":"aaa",
    "ui.password":"111",
    "checkCode":"6inx"
}
#对要发送的数据进行打包,记住编码
postData = urllib.parse.urlencode(data).encode("gbk")
#设置一个请求体
req = urllib.request.Request(url,postData)
#发起请求
agnetslist = [
    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)",
    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)",
    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Avant Browser)",
    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)"
]
agentStr = random.choice(agnetslist)
req.add_header("user-agent",agentStr)
response = urllib.request.urlopen(req)

data1 = response.read().decode("gbk")
print(data1)