import urllib.request

url = r"http://www.baidu.com"
#编码
newUrl2 = urllib.request.quote(url)
print(newUrl2)
#解码
newUrl = urllib.request.unquote(newUrl2)
print(newUrl)

#向指定的url地址发起请求，并返回服务器响应的数据（文件的对象）
response = urllib.request.urlopen(newUrl)
#读取网页的全部内容,会把读取到的数据赋值给一个字符串变量
# data = response.read()     #.decode("utf-8")
# print(data)

#读取一行
# data = response.readlin()

#读取网页的全部内容,会把读取到的数据赋值给一个列表变量
data = response.readlines()
print(data)
print(type(data))
# print(type(data[10].decode("utf-8")))

#将爬取到的网页写入文件
# with open(r"D:\box\爬虫\test001.html","wb") as f:
#     f.write(data)

#response 属性
#返回当前环境的有关信息
print(response.info())
#返回状态码   200代表成功/304有缓存
print(response.getcode())
# if response.getcode() == 200 or response.getcode() == 304:
#     #处理网页信息
#     pass
# 返回当前正在爬取的url地址
print(response.geturl())
#解码
url = r"https://www.google.com/search?q=%E5%B8%B8%E6%98%8A&oq=%E5%B8%B8%E6%98%8A&aqs=chrome..69i57j5l3j69i60l2.1909j0j8&sourceid=chrome&ie=UTF-8"
newUrl = urllib.request.unquote(url)
print(newUrl)
#编码
newUrl2 = urllib.request.quote(newUrl)
print(newUrl2)





