from cat import Cat
from mouse import Mouse
from person import Person
tom = Cat("tom")
jerry = Mouse("jerry")
tom.eat()
jerry.eat()
per = Person()
per.feedAnimal(tom)
per.feedAnimal(jerry)