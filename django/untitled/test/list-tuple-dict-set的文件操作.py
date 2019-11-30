import pickle
path = r"D:\aaa.txt"
mylist = [1, 2, 3, 4, 5, "asdfghjk"]#[],()
# f = open(path, "wb")
# pickle.dump(mylist, f)
# f.close()
# #读操作
# f1 = open(path, "rb")
# templist = pickle.load(f1)
# print(templist)
# f1.close()
with open(path, "wb") as f2:
    pickle.dump(mylist, f2)
with open(path, "rb") as f3:
    templist = pickle.load(f3)
    print(templist)


