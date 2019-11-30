import urllib.request
import ssl
import os
import random
import re
from collections import deque

def writeFileBytes(htmlBytes,toPath):
    with open(toPath, "wb") as f:
        f.write(htmlBytes)
def writeFileStr(htmlBytes,toPath):
    with open(toPath, "w",encoding="utf-8") as f:
        f.write(htmlBytes.decode("utf-8"))
def getHtmlBytes(url):
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
    response = urllib.request.urlopen(req, context=context)
    return response.read()
def qqCrawler(url,toPath):
    htmlByets = str(getHtmlBytes(url))
    # writeFileBytes(htmlByets,r"D:\box\爬虫\qqFile1.html")
    # writeFileStr(htmlByets,r"D:\box\爬虫\qqFile2.txt")

    pat = r'[1-9]\d{4,9}'
    re_qq = re.compile(pat)
    qqlist = re_qq.findall(htmlByets)
    #去重
    qqlist = list(set(qqlist))
    for qqStr in qqlist:
        with open(toPath, "a") as f:
            f.write(qqStr+"\n")

    pat = r'(((http|ftp|https)://)(([a-zA-Z0-9\._-]+\.[a-zA-Z]{2,6})|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\&%_\./-~-]*)?)'
    re_url = re.compile(pat)
    urllist = re_url.findall(htmlByets)
    #去重
    urllist = list(set(urllist))

    return urllist

def zhongyang(url,toPath):
    queue = deque()
    queue.append(url)
    while len(queue) != 0:
        targetUrl = queue.popleft()
        urlList = qqCrawler(targetUrl,toPath)
        for item in urlList:
            tempUrl = item[0]
            queue.append(tempUrl)

url = r"https://www.douban.com/group/topic/17785101/?start=0"
toPath = r"D:\box\爬虫\qqFile.txt"
# qqCrawler(url,toPath)
zhongyang(url,toPath)