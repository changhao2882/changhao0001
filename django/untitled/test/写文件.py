path = r"D:\aaa.txt"
# with open(path, "a", encoding="UTF-8", errors="ignore") as f:
#     f.write("\n你好啊！")
with open(path, "wb",) as f1:
    f1.write("\n11111".encode("UTF-8"))
with open(path, "rb",) as f2:
    print(f2.read().decode("UTF-8"))