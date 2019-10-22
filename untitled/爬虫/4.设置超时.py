import urllib.request

url = r"https://boxnovel.baidu.com/boxnovel/content?gid=4308080279&data=%7B%22fromaction%22%3A%22dushu%22%7D&cid=20118446"
#如果网页长时间未响应，系统判断超时，无法爬取
for i in range(1,100):
    try:
        response = urllib.request.urlopen(url, timeout=0.5)  # timeout超过设定时间，进行下一个爬取
        print(len(response.read().decode("utf-8")))
    except:
        print("请求超时，继续下一个爬取")