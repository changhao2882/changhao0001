import csv
def readCsv(path):
    infoList = []
    with open(path, "r", encoding="UTF-8", errors="ignore") as f:
        allFileInfo = csv.reader(f)
        for row in allFileInfo:
            infoList.append(row)
    return infoList
path = r"D:\box\Records.csv"
info = readCsv(path)