class person(object):
    def __init__(self,danjia):
        self.gun = danjia
    def sheji(self):
        self.gun.fire()
    def jiadan(self,count):
        self.gun.sehngyu.shumu=count
class gun(object):
    def __init__(self,zidan):
        self.sehngyu = zidan
    def fire(self):
        if self.sehngyu.shumu==0:
            print("没子弹了")
        else:
            self.sehngyu.shumu -=1
            print("剩余{}个子弹".format(self.sehngyu.shumu))
class zidan(object):
    def __init__(self,count):
        self.shumu = count
if __name__ == "__main__":
    zidan = zidan(5)
    gun = gun(zidan)
    person = person(gun)
    person.sheji()
    person.sheji()
    person.sheji()
    person.sheji()
    person.sheji()
    person.sheji()
    person.jiadan(2)
    person.sheji()
    person.sheji()
    person.sheji()