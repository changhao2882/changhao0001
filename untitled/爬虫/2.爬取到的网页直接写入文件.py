import urllib.request

url = r"http://www.baidu.com"
fileName = r"D:\box\爬虫\test001.html"
urllib.request.urlretrieve(url,filename=fileName)

#urlretrieve在执行过程当中会产生一些缓存
#清除缓存
urllib.request.urlcleanup()