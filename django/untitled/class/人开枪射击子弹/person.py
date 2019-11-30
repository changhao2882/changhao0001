#人
class Person(object):
    def __init__(self,gun):
        self.gun = gun
    def fire(self):
        self.gun.shoot()
    def fireBullet(self,count):
        self.gun.bulletBox.bulletCount = count