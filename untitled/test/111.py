# !/user/bin/env python

# -*- coding:utf-8 -*-

__author__ = 'DF'

import requests

import re

# 第一章网址上的数字

base_num = 4446

# 打算爬多少章，手动修改

page = 20

for i in range(page):

    # 根据每章网址可知该数字每次加2

    num = base_num + i * 2

    # 拼接网址

    url = 'http://www.biqugew.com/book/9/%s' % (num) + '.html'

    # 使用requests的get方法获取response对象

    response = requests.get(url)

    # 转换编码格式，不然显示文字格式不对

    response.encoding = 'gbk'

    # 获取网页源码

    str_url = response.text

    # 将小说文字提取出来,

    str_novel = ''

    str_novel = str_novel + re.findall('<div id="content">([^(][\s\S]+?)</div>', str_url)[0]

    # 将小说此章标题提取出来

    str_title = ''

    str_title = re.findall('<h1>([^(][\s\S]+?)</h1>', str_url)[0]

    # 此时的str_novel中还有&nbsp和<br />等不需要的字符，继续剔除

    str_novel = str_novel.replace('&nbsp;', ' ')

    str_novel = str_novel.replace('<br />', '')

    # 然后将其保存进文件

    with open(str_title+".txt", "w", encoding='utf-8')as f:

        f.write(str_novel)