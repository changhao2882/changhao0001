import doctest   #doctest:可以提取注释中的代码去执行   doctest:严格按照python交互模式的输入提取
def mySum(x,y):
    '''

    :param x:
    :param y:
    :return:

    examptle:
    >>> print(mySum(1,2))
    3
    '''
    return x+y+1
print(mySum(1,2))

#进行文档测试
doctest.testmod()


