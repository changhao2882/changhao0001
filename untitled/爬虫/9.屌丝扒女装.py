import urllib.request
import ssl
import os
import random
import re

def imageCrawler(url,toPath):
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
    # with open(r"D:\box\爬虫\test002.html", "wb") as f:
    #     f.write(HTML)
    #print(HTML)
    pat = r'<img original="//(.*?)" />'
    re_image = re.compile(pat)
    imagelist = re_image.findall(HTML)
    num = 0
    for imageUrl in imagelist:
        path = os.path.join(toPath,imageUrl.split(".")[0]+str(num)+".jpg")
        #把图片下载到本地存储
        urllib.request.urlretrieve("http://"+imageUrl,filename=path)
        num += 1

url = r"http://search.yhd.com/c0-0/mbname-b/a-s1-v4-p1-price-d0-f0-m1-rt0-pid-mid0-color-size-k%E5%A5%B3%E8%A3%85/"
toPath = r"D:\box\爬虫\image"
imageCrawler(url,toPath)