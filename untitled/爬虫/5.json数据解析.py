import json
import urllib.request

jsonStr = '{"name":"changhao","age":18,"hobby":["money","power","english"],"parames":{"a":1,"b":2}}'
#将json格式的字符串转为python数据类型的对象
jsonData = json.loads(jsonStr)
print(jsonData)
print(type(jsonData))
print(jsonData["hobby"])

jsonStr2 = {"name":"changhao","age":18,"hobby":["money","power","english"],"parames":{"a":1,"b":2}}
#将python数据类型的对象转为json格式的字符串
jsonData2 = json.dumps(jsonStr2)
print(jsonData2)
print(type(jsonData2))

#读取本地的json文件
path1 = r"D:\box\json\json001.json"
with open(path1,"rb") as f:
    data = json.load(f)
    print(data)
    print(type(data))  #<class 'dict'>

#写本地的json文件
path2 = r"D:\box\json\json002.json"
jsonStr3 = {"name":"changhao","age":18,"hobby":["money","power","english"],"parames":{"a":1,"b":2}}
with open(path2,"w") as f2:
    json.dump(jsonStr3,f2)






