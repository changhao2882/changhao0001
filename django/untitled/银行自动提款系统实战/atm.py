from card import Card
from user import User
import random
class Atm(object):
    def __init__(self,allUsers):
        self.allUsers = allUsers
    def kaihu(self):
        #卡号-用户
        name = input("请输入姓名：")
        idCard = input("请输入身份证号：")
        phone = input("请输入电话号码：")
        yucunkuan = (float)(input("请输入预存款金额："))
        if yucunkuan < 0:
            print("预存款输入有误！开户失败。。。")
            return -1
        cardPasswd1 =input("请设置密码：")
        if not self.yanzhengmima(cardPasswd1):
            print("密码输入错误！开户失败。。。")
            return -1
        cardId = self.kahao()
        card = Card(cardId,cardPasswd1,yucunkuan)
        user = User(name,idCard,phone,card)
        self.allUsers[cardId] = user
        print("开户成功，请牢记卡号。。。({})".format(cardId))
    def chaxun(self):
        cardNum = input("请输入您的卡号")
        user = self.allUsers.get(cardNum)
        if not user:
            print("该卡号不存在。。。")
            return -1
        if user.card.cardLock:
            print("该卡已被锁定！请解锁后再进行其他操作。。。")
            return -1
        if not self.yanzhengmima(user.card.cardPasswd):
            print("密码输入错误！该卡已被锁定！请解锁后再进行其他操作。。。")
            user.card.cardLock = True
            return -1
        print("账号：{}  余额：{}".format(user.card.cardId,user.card.cardMoney))
    def qukuan(self):
        cardNum = input("请输入您的卡号")
        user = self.allUsers.get(cardNum)
        if not user:
            print("该卡号不存在，取款失败。。。")
            return -1
        if user.card.cardLock:
            print("该卡已被锁定！请解锁后再进行其他操作。。。")
            return -1
        if not self.yanzhengmima(user.card.cardPasswd):
            print("密码输入错误！该卡已被锁定！请解锁后再进行其他操作。。。")
            user.card.cardLock = True
            return -1
        money = (float)(input("请输入取款金额："))
        if money > user.card.cardMoney:
            print("余额不足，取款失败。。。")
            return -1
        if money <= 0:
            print("输入错误，取款失败。。。")
            return -1
        user.card.cardMoney -= money
        print("取款成功，余额：{}".format(user.card.cardMoney))
    def cunkuan(self):
        pass
    def zhuanzhang(self):
        pass
    def gaimi(self):
        pass
    def suoding(self):
        cardNum = input("请输入您的卡号：")
        user = self.allUsers.get(cardNum)
        if not user:
            print("该卡号不存在，锁定失败。。。")
            return -1
        if user.card.cardLock:
            print("该卡已被锁定，请解锁后再使用其他功能。。。")
            return -1
        if not self.yanzhengmima(user.card.cardPasswd):
            print("密码输入错误！锁定失败。。。")
            return -1
        tempIdCard = input("请输入您的身份证号：")
        if tempIdCard != user.idCard:
            print("身份证号码错误！锁定失败。。。")
            return -1
        user.card.cardLock = True
        print("锁定成功。。。")

    def jiesuo(self):
        cardNum = input("请输入您的卡号：")
        user = self.allUsers.get(cardNum)
        if not user:
            print("该卡号不存在，解锁失败。。。")
            return -1
        if not user.card.cardLock:
            print("该卡未被锁定，无需解锁。。。")
            return -1
        if not self.yanzhengmima(user.card.cardPasswd):
            print("密码输入错误！解锁失败。。。")
            return -1
        tempIdCard = input("请输入您的身份证号：")
        if tempIdCard != user.idCard:
            print("身份证号码错误！解锁失败。。。")
            return -1
        user.card.cardLock = False
        print("解锁成功。。。")
    def buka(self):
        pass
    def xiaohu(self):
        pass
    #验证密码
    def yanzhengmima(self,cardPasswd1):
        for i in range(3):
            cardPasswd2 = input("请输入密码：")
            if cardPasswd1 == cardPasswd2:
                return True
        return False

    # 生成卡号
    def kahao(self):
        while True:#避免卡号重复
            str =""
            for i in range(6):
            #ord() 函数是 chr() 函数（对于8位的ASCII字符串）或 unichr() 函数（对于Unicode对象）的配对函数，
            # 它以一个字符（长度为1的字符串）作为参数，返回对应的 ASCII 数值，或者 Unicode 数值，
            # 如果所给的 Unicode 字符超出了你的 Python 定义范围，则会引发一个 TypeError 的异常。
                ty = chr(random.randrange(ord('0'), ord('9')+1))
                str +=ty
            if not self.allUsers.get(str):
                return str