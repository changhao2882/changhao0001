import urllib.request
import ssl
import json
import random
import re

def ajaxCrawler(url):
    # 模拟请求头
    agnetslist = [
        "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)",
        "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)",
        "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Avant Browser)",
        "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)"
    ]
    agentStr = random.choice(agnetslist)
    # 设置一个请求体
    req = urllib.request.Request(url)
    # 向请求体里添加了user-agent
    req.add_header("user-agent", agentStr)
    # 使用ssl创建未验证的上下文
    context = ssl._create_unverified_context()
    # 发起请求
    response = urllib.request.urlopen(req,context=context)

    HTML = response.read().decode("utf-8")
    # print(HTML)
    pat = r'<p>(.*?)</p>'
    re_joke = re.compile(pat,flags=re.S)
    divlist = re_joke.findall(HTML)

    str = []
    for i in divlist:
        pat1 = r'[^\u3000\r\n\t]'
        re_joke1 = re.compile(pat1, flags=re.S)
        str.append("".join(re_joke1.findall(i)))
    print(str)
    # with open(r"D:\box\爬虫\test002.html", "w") as f:
    #     f.write(HTML)
    #jsonData = json.loads(HTML)
    return str

url = r"https://www.bidutuijian.com/books/ZheTian/0001.html"
info = ajaxCrawler(url)
print(info)
print(len(info))
# for i in range(2,11):
#     url = r"http://xiaohua.zol.com.cn/lengxiaohua/"+str(i)+".html"
#     info = ajaxCrawler(url)
#     print(info)