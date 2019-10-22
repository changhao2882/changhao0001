import urllib.request
import ssl
import json

def ajaxCrawler(url):
    # 模拟请求头
    headers = {
        "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36"
    }
    # 设置一个请求体
    req = urllib.request.Request(url, headers=headers)
    #使用ssl创建未验证的上下文
    context = ssl._create_unverified_context()
    # 发起请求
    response = urllib.request.urlopen(req,context=context)
    jsonStr = response.read().decode("utf-8")
    jsonData = json.loads(jsonStr)
    return jsonData

for i in range(1,11):
    url = r"https://movie.douban.com/j/chart/top_list?type=11&interval_id=100%3A90&action=&start="+str(i*20)+"&limit=20"
    info = ajaxCrawler(url)
    print(info)