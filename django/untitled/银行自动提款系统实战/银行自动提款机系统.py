import time
from admin import Admin
from atm import Atm
import pickle
import os

def main1():
    admin = Admin()
    #-1 true 0 false
    admin.printAdminView()
    if admin.login():
        return -1

    path = os.path.join(os.getcwd(), "allusers.txt")

    f1 = open(path, "rb")
    allUsers = pickle.load(f1)
    print(allUsers)
    # 提款机对象
    atm = Atm(allUsers)

    while True:
        admin.printSysFunctionView()
        option = input("请输入您的的操作：")
        if option == "1":
            #开户
            atm.kaihu()
        elif option == "2":
            #查询
            atm.chaxun()
        elif option == "3":
            #取款
            atm.qukuan()
        elif option == "4":
            #存款
            pass
        elif option == "5":
            #转账
            pass
        elif option == "6":
            #改密
            pass
        elif option == "7":
            #锁定
            atm.suoding()
        elif option == "8":
            #解锁
            atm.jiesuo()
        elif option == "9":
            #补卡
            pass
        elif option == "0":
            #销户
            pass
        elif option == "t":
            #退出
            if not admin.login():
                print(path)
                with open(path, "wb") as f:
                    pickle.dump(atm.allUsers, f)
                return -1
        time.sleep(2)
if __name__ == '__main__':
    main1()

# path = r"D:\aaa.txt"
# mylist = [1, 2, 3, 4, 5, "asdfghjk"]#[],()
# with open(path, "wb") as f2:
#     pickle.dump(mylist, f2)