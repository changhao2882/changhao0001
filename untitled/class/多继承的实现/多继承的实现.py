from child import Child
def main():
    c = Child(300,100)
    print(c.money,c.faceValue)
    c.play()
    c.eat()
    c.func()
if __name__ =="__main__":
    main()