from PIL import Image
im = Image.open(r"../images/tuuu.jpg")
print(im.format,im.size,im.mode)
#设置图片大小
im.thumbnail((150,100))
#保存成新图片
im.save("../images/temp.jpg","JPEG")