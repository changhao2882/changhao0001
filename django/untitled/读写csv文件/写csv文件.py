import csv
#newline="" 解决空行问题
def writeCsv(path,data):
    with open(path, "w", encoding="UTF-8", newline="",errors="ignore") as f:
        write = csv.writer(f)
        for rowData in data:
            write.writerow(rowData)
path = r"D:\box\Records001.csv"
info = writeCsv(path,[["1","2","3","4"],["11","22","33","44"],["111","222","333","444"]])