from person import Person
from gun import Gun
from bulletbox import BullBox
#弹夹
bulletBox = BullBox(5)
#枪
gun = Gun(bulletBox)
#人
per = Person(gun)
per.fire()
per.fire()
per.fire()
per.fire()
per.fire()
per.fire()
per.fire()
per.fireBullet(2)
per.fire()
per.fire()
per.fire()